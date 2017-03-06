package model;

public class ArrivalEvent extends Event {

	
	public ArrivalEvent(double time, int messageID, String descr) {
		super(time, null, descr);
		int nextDirection = getDirectionProbability();
		this.message = new Message(nextDirection, calculateTec(nextDirection), messageID);
	}
	
	public ArrivalEvent(double time, Message m, String desc) {
		super(time, m, desc);
		this.message = m;
		
	}
	
	public double calculateTec(int dir) {
		double[] tec = valuesConfiguration.getTecs();
		if (dir < 3)
			return distribution.calculateExponential(tec[0]) * 0.01;
		else 
			return distribution.calculateExponential(tec[1]) * 0.01;
	}
	
	
	public void run() {
		if (this.type.equals("Chegada no Sistema")) {
			this.message.updateStatusStats();
			statistics.updateIssuedMessages();
			statistics.updateInTraffic();
			processReception();
		} else if (this.type.equals("Chegada Centro de Serviço Local")) {
			processLocalCenter();
		} else if (this.type.equals("Chegada Centro de Serviço Remoto")){
			processRemoteCenter();
		}
	}
	
	public void processReception() {
		FutureEventsList futureEventsList = FutureEventsList.getInstance();
		ReceptionService r = ReceptionService.getInstance();
		int newDir = getDirectionProbability();
		double newTec = calculateTec(newDir);
		double nextArrival = this.time +  newTec;
		Message nextMessage = new Message(newDir, nextArrival, message.getId() + 1);
		futureEventsList.addEvent(new ArrivalEvent(nextArrival, nextMessage, "Chegada no Sistema"));
		r.process(this);
	}
	
	public void processLocalCenter() {
		LocalService l = LocalService.getInstance();
		l.process(this);
	}
	
	public void processRemoteCenter() {
		RemoteService r = RemoteService.getInstance();
		r.process(this);
	}

}
