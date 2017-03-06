package controller;
import java.util.ArrayList;

import model.Event;
import model.FutureEventsList;
import model.Statistics;
import view.UserInterface;


public class EventsController {

	private FutureEventsList eventsList;
	Statistics statistics;
	public static double clock;
	private ArrayList<Event> allEvents;
	
	public EventsController() {
		allEvents = new ArrayList<Event>();
		eventsList = FutureEventsList.getInstance();
		clock = 0;
		statistics = Statistics.getInstance();
	}
	
	public void advance() {
		Event event = eventsList.getEventAt(0);
		allEvents.add(event);
		if (event != null) {
			eventsList.deleteEventAt(0);
			clock = event.getTime();
			statistics.updateAverageMessages();
			event.run();
		}

		printAll();
	}
	
	
	
	public void printAll() {
		String s = "Iniciando a simulação.\n\n";
		for (Event e : allEvents) {
			s += e.toString();
		}
		UserInterface.futureEventsListTextPane.setText(s);
		
	}
}
