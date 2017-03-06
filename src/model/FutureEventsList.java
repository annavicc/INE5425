package model;
import java.util.ArrayList;

public class FutureEventsList {
	
	private static FutureEventsList futureEventsList;
	private ArrayList<Event> events;
	
	private FutureEventsList() {
		events = new ArrayList<Event>();
	}
	
	public static FutureEventsList getInstance() {
		if (futureEventsList == null) {
			futureEventsList = new FutureEventsList();
		}
		return futureEventsList;
	}
	
	public ArrayList<Event> getList() {
		return events;
	}
	
	public Event getEventAt(int index) {
		if (index >=0 && index < events.size()) {
			return events.get(index);
		}
		return null;
	}
	
	public void addEvent(Event event) {
		if (events.isEmpty()) {
			events.add(event);
		} else {
			double eventTime = event.getTime();
			int i = 0;
			for (Event e: events) {
				if (e.getTime() > eventTime) {
					events.add(i, event);
					break;
				} else if (i == events.size()-1) {
					events.add(event);
					break;
				}
				i++;
			}
		}
	}
	
	public void deleteEventAt(int index) {
		if (events.size() != 0 && index >=0 && index < events.size()) {
			events.remove(index);
		}
	}
	
	public String toString() {
		String print = "";
		for (Event e : events) {
			print += e.toString();
		}
		return print;
	}
	
	
	
	

}
