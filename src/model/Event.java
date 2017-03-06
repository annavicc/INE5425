package model;
import java.text.DecimalFormat;

import controller.EventsController;

public class Event {

	public String type;
	protected double time;
	protected Message message;
	protected Distribution distribution;
	protected ValuesConfiguration valuesConfiguration;
	protected Statistics statistics;
	
	public Event(double time, Message event, String type) {
		this.time = time;
		this.message = event;
		this.type = type;
		valuesConfiguration = ValuesConfiguration.getInstance();
		distribution = new Distribution();
		statistics = Statistics.getInstance();
	}
	
	public double getTime() {
		return this.time;
	}
	
	public Message getMessage() {
		return this.message;
	}
	
	public void setMessage(Message m) {
		this.message = m;
	}

	public int getDirectionProbability() {
		/* 1 - LL, 2 LR, 3- RL, 4 - RR */
		double[] prob = valuesConfiguration.getTraffic();
		return distribution.monteCarlo(prob[0], prob[1], prob[2], prob[3]);
	}

	
	public String toString() {
		return "Evento do tipo '" + type + "' da mensagem " + message.getId() + " com direção '" + message.getDirection() + "' no tempo: " + new DecimalFormat("#.##").format(getTime()) + "\n";
	}
	
	public void run() {
		
	}
	
	public boolean isExpired() {
		if ( EventsController.clock - this.message.getArrivalTime() > message.getLimitTime()) {
			ExitEvent e = new ExitEvent(this.time, message, "Mensagem Expirada");
			FutureEventsList list = FutureEventsList.getInstance();
			list.addEvent(e);
			return true;
		}
		return false;
	}
	
}
