package model;
import java.text.DecimalFormat;
import java.util.ArrayList;

import controller.EventsController;
import view.UserInterface;

public class Statistics {

	private static Statistics stats;
	
	public static int LLS;
	public static int LLF;
	public static int LLA;
	public static int LRS;
	public static int LRF;
	public static int LRA;
	public static int RLS;
	public static int RLF;
	public static int RLA;
	public static int RRS;
	public static int RRF;
	public static int RRA;

	public static ArrayList<Message> currentMessages;
	public static ArrayList<Message> completedMessages;
	public static ArrayList<Message> localQueue;
	public static ArrayList<Message> remoteQueue;

	private static double totalMessagesCount;
	private static double currentMinMessagesCount;
	private static double currentMaxMessagesCount;
	private double beforeMessage;
	private static double beforeServerLocal;
	private static double beforeServerRemote;
	private int issuedMessages;
	private double averageMessage;
	public static double processingLocal;
	public static double processingRemote;
	
	private int maxLocalQueue = 0;
	private int minLocalQueue = 100000;
	private int maxRemoteQueue = 0;
	private int minRemoteQueue = 0;
	private double totalTrafficSum;
	private double minTrafficTime = 100000;
	private double avgTrafficTime = 0;
	private double maxTrafficTime = 0;
	private static double localServersSum;
	private static double remoteServersSum;

	
	private Statistics() {
		beforeMessage = 0;
		beforeServerLocal = 0;
		beforeServerRemote = 0;
		remoteServersSum = 0;
		localServersSum = 0;
		currentMessages = new ArrayList<Message>();
		completedMessages = new ArrayList<Message>();
		localQueue = new ArrayList<Message>();
		remoteQueue = new ArrayList<Message>();
		processingLocal = 0;
		processingRemote = 0;
		totalMessagesCount = 0;
		currentMinMessagesCount = 0;
		currentMaxMessagesCount = 0;
		issuedMessages = 0;
		averageMessage = 0;
		LLF = LLS = LLA = LRS = LRA = LRF = RLA = RLS = RLF = RRS = RRF = RRA = 0;
		
		}

	public static Statistics getInstance() {
		if (stats == null) {
			stats = new Statistics();
		}
		return stats;
	}
	
	public int getTotalMessages() {
		return completedMessages.size() + currentMessages.size() + localQueue.size() + remoteQueue.size();
	}
	
	public int getCurrentMessages() {
		return currentMessages.size() + localQueue.size() + remoteQueue.size();
	}

	
	public void updateAverageMessages() {		
		double clock = EventsController.clock;
		double sum = (localQueue.size() + remoteQueue.size() + currentMessages.size());
		totalMessagesCount  +=  sum * (clock - beforeMessage);
		beforeMessage = clock;
		this.averageMessage = totalMessagesCount / clock;
		if (sum > currentMaxMessagesCount) {
			currentMaxMessagesCount = sum;
		}
		if (sum < currentMinMessagesCount || currentMinMessagesCount == 0) {
			currentMinMessagesCount = sum;
		}
		
		UserInterface.avgMsg.setText(new DecimalFormat("#.##").format(averageMessage));
		UserInterface.minMsg.setText(Integer.toString((int)currentMinMessagesCount));
		UserInterface.maxMsg.setText(Integer.toString((int)currentMaxMessagesCount));

	}
	
	public void updateIssuedMessages() {
		this.issuedMessages++;
		UserInterface.totalDespachadas.setText(Integer.toString(issuedMessages));
	}
	
	public static void updateTypeCount() {
		UserInterface.contLLS.setText(Integer.toString(LLS));
		UserInterface.contLLF.setText(Integer.toString(LLF));
		UserInterface.contLLA.setText(Integer.toString(LLA));
		UserInterface.contLRS.setText(Integer.toString(LRS));
		UserInterface.contLRF.setText(Integer.toString(LRF));
		UserInterface.contLRA.setText(Integer.toString(LRA));
		UserInterface.contRLS.setText(Integer.toString(RLS));
		UserInterface.contRLF.setText(Integer.toString(RLF));
		UserInterface.contRLA.setText(Integer.toString(RLA));
		UserInterface.contRRS.setText(Integer.toString(RRS));
		UserInterface.contRRF.setText(Integer.toString(RRF));
		UserInterface.contRRA.setText(Integer.toString(RRA));
	}
	
	public static void updateRateLocalCenter() {
		double clock = EventsController.clock;
		LocalService l = LocalService.getInstance();
		int totalServers = l.getTotalServers();
		int occupiedServers = totalServers - l.getFreeServers();
		
		localServersSum += ((clock - beforeServerLocal) * (((double)occupiedServers / (double)totalServers)));
		beforeServerLocal = clock;
		processingLocal = localServersSum / clock;
		UserInterface.ocupacaoLoc.setText((new DecimalFormat("#.##").format(processingLocal*100)));
	}
	
	public static void updateRateRemoteCenter() {
		double clock = EventsController.clock;
		RemoteService r = RemoteService.getInstance();
		int totalServers = r.getTotalServers();
		int occupiedServers = totalServers - r.getFreeServers();
		
		remoteServersSum += ((clock - beforeServerRemote) * ((double)occupiedServers / (double)totalServers));
		beforeServerRemote = clock;
		processingRemote= remoteServersSum / clock;
		UserInterface.ocupacaoRem.setText(new DecimalFormat("#.##").format(processingRemote*100));
	}
	
	public void updateTrafficTime(Event e) {
		double clock = EventsController.clock;
		double totalTime = clock - e.getMessage().getArrivalTime();
		if (totalTime < minTrafficTime) {
			minTrafficTime = totalTime;
		}
		if (totalTime > maxTrafficTime) {
			maxTrafficTime = totalTime;
		}
		this.avgTrafficTime = totalTrafficSum / completedMessages.size();
		UserInterface.transitoAvg.setText(new DecimalFormat("#.##").format(avgTrafficTime));
		UserInterface.transitoMin.setText(new DecimalFormat("#.##").format(minTrafficTime));
		UserInterface.transitoMax.setText(new DecimalFormat("#.##").format(maxTrafficTime));
	}
	
		
	public void writeCompleted(Message m) {
		completedMessages.add(m);
		
		double sum = EventsController.clock - m.getArrivalTime();
		totalTrafficSum += sum;

		String s = "";
		for (Message c: completedMessages) {
			s += "Mensagem " + c.getId() + " saiu do sistema com status " + c.getMessageStatus() + "\n";
		}
		
		UserInterface.completedTextPane.setText(s);
		UserInterface.countCompleted.setText(Integer.toString(completedMessages.size()));
	}
	
	public void addLocalQueueMessage(Message m) {
		localQueue.add(m);
		int size = localQueue.size();
		if (size < minLocalQueue) {
			minLocalQueue = size;
		}
		
		if (size > maxLocalQueue) {
			maxLocalQueue = size;
		}
		
		String s = "";
		for (Message ms : localQueue) {
			s += "Mensagem " + ms.getId() + "\n";
		}
		UserInterface.localQueueTextPane.setText(s);
	}
	
	public void updateInTraffic() {
		UserInterface.countTraffic.setText(Integer.toString(issuedMessages - completedMessages.size()));
	}
	
	public void removeLocalQueueMessage(Message m) {
		localQueue.remove(m);
		String s = "";
		for (Message ms : localQueue) {
			s += "Mensagem " + ms.getId() + "\n";
		}
		UserInterface.localQueueTextPane.setText(s);
	}
	
	public void addRemoteQueueMessage(Message m) {
		remoteQueue.add(m);
		int size = remoteQueue.size();
		if (size < minRemoteQueue) {
			minRemoteQueue = size;
		}
		
		if (size > maxRemoteQueue) {
			maxRemoteQueue = size;
		}
		
		String s = "";
		for (Message ms : remoteQueue) {
			s += "Mensagem " + ms.getId() + "\n";
		}
		UserInterface.remoteQueueTextPane.setText(s);	
	}
	
	public void removeRemoteQueueMessage(Message m) {
		remoteQueue.remove(m);
		String s = "";
		for (Message ms : remoteQueue) {
			s += "Mensagem " + ms.getId() + "\n";
		}
		UserInterface.remoteQueueTextPane.setText(s);
	}
	
	public void addSystemMessage(Message m) {
		currentMessages.add(m);

		String s  = "";
		for (Message ms : currentMessages) {
			if (ms.isAtRec()) {
				s += "Mensagem " + ms.getId() + " no centro de recepção\n";
			} else {
				s += "Mensagem " + ms.getId() + " processando no centro " + ms.getReceiver() + "\n";
			}
		}
		UserInterface.systemTextPane.setText(s);
	}
	
	public void removeSystemMessage(Message m) {
		currentMessages.remove(m);

		String s  = "";
		for (Message ms : currentMessages) {
			if (ms.isAtRec()) {
				s += "Mensagem " + ms.getId() + " no centro de recepção\n";
			} else {
				s += "Mensagem " + ms.getId() + " processando no centro " + ms.getReceiver() + "\n";
			}
		}
		UserInterface.systemTextPane.setText(s);
	}
	
	public String report() {
		String separator = "-----------------------------------------------------------------------------------------------------------------------------------";
		String newline = System.getProperty("line.separator");

		
		String s = "*************************" + newline + "Relatório da Simulação" + newline + "*************************" + newline + newline;
		s += "Total de mensagens emitidas: " + getTotalMessages() + newline;
		s += "Total de mensages finalizadas: " + completedMessages.size() + newline;
		s += "Total de mensagens no sistema não entregues por conta do término da simulação: " + (getTotalMessages() - currentMessages.size()) + newline;
		s += "Total de mensagens adiadas: " + (LRA + LLA + RLA + RRA) + newline;
		s += "Total de mensagens com sucesso: " + (LLS + LRS + RLS + RRS) + newline;
		s += "Total de mensagens com falha: " + (LLF + LRF + RLF + RRF) + newline + newline;
		
		s += separator + newline + newline;
		s += "Total de mensagens por tipo:" + newline + newline;
		s += "LLS: " + LLS + "         LLF: " + LLF + "         LLA: " + LLA + newline;
		s += "LRS: " + LRS + "         LRF: " + LRF + "         LRA: " + LRA + newline;
		s += "RLS: " + RLS + "         RLF: " + RLF + "         RLA: " + RLA + newline;
		s += "RRS: " + RRS + "         RRF: " + RRF + "         RRA: " + RRA + newline + newline;

		s += separator + newline + newline;
		s += "Em um dado instante:" + newline + newline;
		s += "Mínimo de mensagens no sistema: " + currentMinMessagesCount + newline;
		s += "Máximo de mensagens no sistema: " + currentMaxMessagesCount + newline;
		s += "Média de mensagens no sistema: " + new DecimalFormat("#.##").format(averageMessage) + newline + newline;
		
		s += separator + newline + newline;
		s += "Taxa de ocupação dos centros:" + newline + newline;
		s += "Tamanho mínimo da fila local: " + minLocalQueue + newline;
		s += "Tamanho máximo da fila local: " + maxLocalQueue + newline;
		s += "Tamanho mínimo da fila remota: " + minRemoteQueue + newline;
		s += "Tamanho máximo da fila remota: " + maxRemoteQueue + newline + newline;

		s += separator + newline + newline;
		s += "Tempo de trânsito das mensagens:" + newline + newline;
		s += "Mínimo: " + new DecimalFormat("#.##").format(minTrafficTime) + "         Médio: " + new DecimalFormat("#.##").format(avgTrafficTime) + "         Máximo: " + new DecimalFormat("#.##").format(maxTrafficTime) + newline + newline;
		
		s += separator + newline + newline;
		s += "Fim do relatório." + newline;
		
		return s;
	}
	
}
