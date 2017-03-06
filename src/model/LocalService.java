package model;
import java.util.ArrayList;

import controller.EventsController;

public class LocalService {
	
	private Statistics statistics;
	private static LocalService localService;
	private int servers;
	private int totalServers;
	private ArrayList<Event> queue;
	
	private LocalService() {
		queue = new ArrayList<Event>();
		servers = ValuesConfiguration.getInstance().getServerLocal();
		totalServers = servers;
		statistics = Statistics.getInstance();
	}
	
	public static LocalService getInstance() {
		if (localService == null) {
			localService = new LocalService();
		}
		return localService;
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public int getTotalServers() {
		return totalServers;
	}
	
	public ArrayList<Event> getQueue() {
		return this.queue;
	}
	
	public void setServerBusy () {
		servers--;
	}
	
	public void setServerFree() {
		servers++;
		if (queue.size() > 0) {
			FutureEventsList futureEventsList = FutureEventsList.getInstance();
			Event e = queue.remove(0);
			Message m = e.getMessage();
			statistics.removeLocalQueueMessage(m);
			/*Total time in the queue*/
			ExitEvent exit = new ExitEvent(EventsController.clock, m, "Saída Fila local");
			futureEventsList.addEvent(exit);
			process(e);
		}
	}
	
	public int getFreeServers() {
		return servers;
	}
	
	public void process(Event event) {
		FutureEventsList futureEventsList = FutureEventsList.getInstance();
		Message current = event.getMessage();
		statistics.removeSystemMessage(current);
		if (servers <= 0) {
			statistics.addLocalQueueMessage(current);
			ArrivalEvent qArrival = new ArrivalEvent(event.getTime() + 0.01, current, "Chegada na fila local");
			futureEventsList.addEvent(qArrival);
			queue.add(event);
			return;
		}

		statistics.addSystemMessage(current);
		Statistics.processingLocal++;
		Statistics.updateRateLocalCenter();
		setServerBusy();

		ExitEvent exit;
		exit = new ExitEvent(event.getTime() + event.getMessage().getServiceTime(), current, "Saída do Centro Local");
		futureEventsList.addEvent(exit);
		
	}	

}
