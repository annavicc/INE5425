package model;
public class ReceptionService {
	
	private static ReceptionService recService;
	private double processingTime;
	private Statistics statistics;
	
	private ReceptionService() {
		processingTime = ValuesConfiguration.getInstance().getReception();
		statistics = Statistics.getInstance();
	}
	
	public static ReceptionService getInstance() {
		if(recService == null) {
			recService = new ReceptionService();
		}
		return recService;
	}
	
	public double getProcessingTime() {
		return this.processingTime;
	}
	
	public void process(Event event) {
		FutureEventsList list = FutureEventsList.getInstance();
		statistics.addSystemMessage(event.getMessage());
		ExitEvent receptionExit = new ExitEvent(event.getTime() + processingTime, event.getMessage(), "Saída da Recepção");
		list.addEvent(receptionExit);
		
	}
	
	
	
}
