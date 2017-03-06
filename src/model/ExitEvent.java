package model;
import controller.EventsController;

public class ExitEvent extends Event {
	
	public ExitEvent(double time, Message message, String type) {
		super(time, message, type);		
	} 
	
	public void run() {
		if (this.type.equals("Saída da Recepção")) {
			processExitReception();
		} else if (this.type.equals("Saída do Centro Local")) {
			processExitCenterLocal();
		} else if (this.type.equals("Saída do Centro Remoto")) {
			processExitCenterRemote();
		} else if (this.type.equals("Mensagem adiada")){
			processExpiredMessage();
		} else if (this.type.equals("Saída do Sistema")){
			statistics.updateInTraffic();
			processExitSystem();
		}
	}
	
	public void processExitReception() {
		if (this.isExpired()) {
			return;
		}
		statistics.removeSystemMessage(this.getMessage());
		this.getMessage().outReception();
		FutureEventsList list = FutureEventsList.getInstance();
		this.getMessage().outReception();
		ArrivalEvent centerArrival;
		if(this.getMessage().getReceiver().equals("Local")) {
			centerArrival = new ArrivalEvent(this.getTime()  + 0.01, this.getMessage(), "Chegada Centro de Serviço Local");
		} else {
			centerArrival = new ArrivalEvent(this.getTime() + 0.01, this.getMessage(), "Chegada Centro de Serviço Remoto");
		}
		list.addEvent(centerArrival);
	}
	
	public void processExitCenterLocal() {
		LocalService local = LocalService.getInstance();
		Statistics.processingLocal--;
		Statistics.updateRateLocalCenter();
		local.setServerFree();
		if (this.isExpired()) {
			return;
		}
		FutureEventsList l = FutureEventsList.getInstance();
		if (this.getMessage().getMessageStatus().equals("Postpone")) {
			Event e = new Event(time, message, "Mensagem adiada");
			l.addEvent(e);
			message.setMessageStatus();
			message.setServiceTime();
			local.process(this);
		} else {
			ExitEvent event = new ExitEvent(this.getTime() + 0.01, this.getMessage(), "Saída do Sistema");
			l.addEvent(event);
		}
	}
	
	public void processExitCenterRemote() {
		RemoteService remote = RemoteService.getInstance();
		Statistics.processingRemote--;
		Statistics.updateRateRemoteCenter();
		remote.setServerFree();
		FutureEventsList l = FutureEventsList.getInstance();
		if (this.isExpired()) {
			return;
		}
		if (this.getMessage().getMessageStatus().equals("Postpone")) {
			message.setMessageStatus();
			message.setServiceTime();
			Event e = new Event(time, message, "Mensagem adiada");
			l.addEvent(e);
			remote.process(this);
		} else {
			ExitEvent event = new ExitEvent(this.getTime() + 0.01, this.getMessage(), "Saída do Sistema");
			l.addEvent(event);
		}
	}
	
	public void processExitSystem() {
		if (this.isExpired()) {
			return;
		}
	
		message.setTotalTime(EventsController.clock);
		statistics.removeSystemMessage(this.getMessage());
		statistics.writeCompleted(this.message);
		statistics.updateTrafficTime(this);
		this.getMessage().setCompleted();
	}
	
	public void processExpiredMessage() {
		statistics.removeSystemMessage(this.getMessage());
		message.setTotalTime(EventsController.clock);
		statistics.updateTrafficTime(this);
		this.getMessage().setCompleted();
	}
	
}
