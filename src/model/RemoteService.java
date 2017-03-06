package model;
import java.util.ArrayList;

public class RemoteService {
	
	private static RemoteService remService;
	private int servers;
	private int totalServers;
	private Statistics statistics;
	ArrayList<Event> queue;
	
	private RemoteService() {
		queue = new ArrayList<Event>();
		servers = ValuesConfiguration.getInstance().getServerRemote();
		totalServers = servers;
		statistics = Statistics.getInstance();
	}
	
	public static RemoteService getInstance() {
		if (remService == null) {
			remService = new RemoteService();
		}
		return remService;
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public ArrayList<Event> getQueue() {
		return this.queue;
	}
	
	public int getTotalServers() {
		return this.totalServers;
	}
	
	public int getFreeServers() {
		return servers;
	}
	
	public void setServerBusy () {
		servers--;
	}
	
	public void setServerFree() {
		servers++;
		if (queue.size() > 0) {
			FutureEventsList futureEventsList = FutureEventsList.getInstance();
			Event e = queue.remove(0);
			statistics.removeRemoteQueueMessage(e.getMessage());
			ExitEvent exit = new ExitEvent(e.getTime() + 0.01, e.getMessage(), "Saída Fila Remoto");
			futureEventsList.addEvent(exit);
			process(e);
			
		}
		
	}
	
	
	public void process(Event event) {
		FutureEventsList futureEventsList = FutureEventsList.getInstance();
		Message current = event.getMessage();
		statistics.removeSystemMessage(current);
		if (servers <= 0) {
			ArrivalEvent qArrival = new ArrivalEvent(event.getTime() + 0.1, current, "Chegada na fila remota");
			statistics.addRemoteQueueMessage(current);
			futureEventsList.addEvent(qArrival);
			queue.add(event);
			return;
		}
		
		Statistics.processingRemote++;
		statistics.addSystemMessage(current);
				
		Statistics.updateRateRemoteCenter();
		setServerBusy();
		
		ExitEvent exit = new ExitEvent(event.getTime() + event.getMessage().getServiceTime(), current, "Saída do Centro Remoto");
		futureEventsList.addEvent(exit);
		
	}	

	
	

}
