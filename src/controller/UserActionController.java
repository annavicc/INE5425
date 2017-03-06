package controller;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JOptionPane;

import model.ArrivalEvent;
import model.FutureEventsList;
import model.Statistics;
import model.ValuesConfiguration;

public class UserActionController {
	
	private boolean isPaused = false;
	public ValuesConfiguration rc;
	private Thread thread;
	
	public UserActionController() {
		this.rc = ValuesConfiguration.getInstance();
	}
	
	public boolean isPaused() {
		return this.isPaused;
	}
	
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	public void onStartSimulationClicked() {
		ArrivalEvent firstMessage = new ArrivalEvent(0, 0, "Chegada no Sistema");
		FutureEventsList l = FutureEventsList.getInstance();
		l.addEvent(firstMessage);
		
		thread = new Thread(new Runnable() {
			public void run() {
				EventsController ec = new EventsController();
				while(true) {
					if (isPaused) {
						synchronized(thread) {
							try {
								thread.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					try {
						ValuesConfiguration r = ValuesConfiguration.getInstance();
						Thread.sleep((long)r.getRunSpeed());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ec.advance();
					double maxTime = rc.getMaxTime();
					if (ec.clock >= maxTime && maxTime > 0) {
						JOptionPane.showMessageDialog(null, "Simulação finalizada! Relátorio salvo no local do executável do programa.");
						onTerminateSimulationClicked();
						return;
					}
				
				}
			}
		});
		thread.start();
	}
	
	public void onPauseSimulationClicked() {
		if (isPaused) {
			isPaused = false;
			synchronized(thread) {
				thread.notify();
			}
		} else {
			isPaused = true;
		}
	}
	
	public void onTerminateSimulationClicked() {
		thread.stop();
		Formatter arq;
		try {
			arq = new Formatter("RelatorioDaSimulacao.txt");
			arq.format(Statistics.getInstance().report());
			arq.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	


}
