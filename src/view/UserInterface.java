package view;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controller.UserActionController;
import model.ValuesConfiguration;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class UserInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JTextPane futureEventsListTextPane;
	public static JTextPane remoteQueueTextPane;
	public static JTextPane localQueueTextPane;
	public static JTextPane systemTextPane;
	public static JTextPane completedTextPane;
	private UserActionController controller;
	public static JFormattedTextField maxMsg;
	public static JFormattedTextField minMsg;
	public static JFormattedTextField avgMsg;
	public static JFormattedTextField ocupacaoRem;
	public static JFormattedTextField ocupacaoLoc;
	public static JFormattedTextField transitoMax;
	public static JFormattedTextField transitoAvg;
	public static JFormattedTextField transitoMin;
	public static JFormattedTextField contLLS;
	public static JFormattedTextField contLLF;
	public static JFormattedTextField contLLA;
	public static JFormattedTextField contLRS;
	public static JFormattedTextField contLRF;
	public static JFormattedTextField contLRA;
	public static JFormattedTextField contRLS;
	public static JFormattedTextField contRLF;
	public static JFormattedTextField contRLA;
	public static JFormattedTextField contRRS;
	public static JFormattedTextField contRRF;
	public static JFormattedTextField contRRA;
	public static JFormattedTextField countTraffic;
	public static JFormattedTextField countCompleted;
	public static JFormattedTextField totalDespachadas;
	
	 
	public UserInterface() {
		

		controller = new UserActionController();
		setResizable(false);
		setTitle("Sistema de Correio Eletr\u00F4nico");
		getContentPane().setLayout(null);
		Border border = LineBorder.createGrayLineBorder();
		
		JPanel futureEventsPanel = new JPanel();
		futureEventsPanel.setBounds(295, 0, 660, 477);
		
		futureEventsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(futureEventsPanel);
		futureEventsPanel.setLayout(null);
		
		
		JLabel lblFutureEventsList = new JLabel("Lista de Eventos");
		lblFutureEventsList.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblFutureEventsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblFutureEventsList.setBounds(217, 9, 241, 29);
		futureEventsPanel.add(lblFutureEventsList);
		lblFutureEventsList.setVerticalTextPosition(SwingConstants.CENTER);
		lblFutureEventsList.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 49, 602, 417);
		futureEventsPanel.add(scrollPane);
		
		futureEventsListTextPane = new JTextPane();
		futureEventsListTextPane.setEditable(false);
		scrollPane.setViewportView(futureEventsListTextPane);
		
		/* Panel for buttons */
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBounds(-1, 0, 298, 477);
		getContentPane().add(buttonPanel);
		
		JButton btnInitializeSimulation = new JButton("Iniciar Simulação");
		btnInitializeSimulation.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnInitializeSimulation.setBounds(60, 175, 180, 33);
		btnInitializeSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.onStartSimulationClicked();
				futureEventsListTextPane.setText("Iniciando a simulação.");
				btnInitializeSimulation.setEnabled(false);
			}
		});
		buttonPanel.setLayout(null);
		buttonPanel.add(btnInitializeSimulation);
		
		JButton btnPauseSimulation = new JButton("Pausar Simulação");
		btnPauseSimulation.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnPauseSimulation.setBounds(60, 252, 180, 33);
		btnPauseSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.onPauseSimulationClicked();
				if (controller.isPaused()) {
					btnPauseSimulation.setText("Resumir");
				} else {
					btnPauseSimulation.setText("Pausar");
				}
			}
		});
		buttonPanel.add(btnPauseSimulation);
		
		JButton btnEndSimulation = new JButton("Terminar Simula\u00E7\u00E3o");
		btnEndSimulation.setFont(new Font("Yu Gothic Light", Font.BOLD, 14));
		btnEndSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.onTerminateSimulationClicked();
					JOptionPane.showMessageDialog(null,"Simulação finalizada! Relátorio salvo no local do executável do programa.");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnEndSimulation .setBounds(60, 325, 180, 33);
		buttonPanel.add(btnEndSimulation);
		
		JLabel lblOperation = new JLabel("Opera\u00E7\u00F5es");
		lblOperation.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperation.setBounds(73, 11, 158, 33);
		buttonPanel.add(lblOperation);
		lblOperation.setFont(new Font("Yu Gothic Medium", Font.BOLD, 21));
		lblOperation.setHorizontalTextPosition(JLabel.CENTER);
		lblOperation.setVerticalTextPosition(JLabel.CENTER);
		lblOperation.setBorder(border);
		
		JButton btnUpdateVariables = new JButton("Configurar vari\u00E1veis");
		btnUpdateVariables.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnUpdateVariables.setBounds(60, 93, 180, 33);
		buttonPanel.add(btnUpdateVariables);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValuesConfiguration.getInstance().increaseSpeed();
			}
		});
		button.setBounds(25, 443, 89, 23);
		buttonPanel.add(button);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValuesConfiguration.getInstance().decreaseRunSpeed();
			}
		});	
		button_1.setBounds(182, 443, 89, 23);
		buttonPanel.add(button_1);
		
		JLabel lblVelocidadeDaSimulao = new JLabel("Velocidade da simula\u00E7\u00E3o");
		lblVelocidadeDaSimulao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelocidadeDaSimulao.setFont(new Font("Yu Gothic Light", Font.BOLD, 14));
		lblVelocidadeDaSimulao.setBounds(25, 398, 229, 34);
		buttonPanel.add(lblVelocidadeDaSimulao);
		JPanel statisticsPanel = new JPanel();
		statisticsPanel.setBounds(-1, 477, 956, 518);

		statisticsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(statisticsPanel);
		statisticsPanel.setLayout(null);
		
		JLabel lblStatistics = new JLabel("Estat\u00EDsticas");
		lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistics.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		lblStatistics.setBounds(393, 1, 167, 34);
		statisticsPanel.add(lblStatistics);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(54, 352, 160, 155);
		statisticsPanel.add(scrollPane_1);
		
		systemTextPane = new JTextPane();
		systemTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		systemTextPane.setEditable(false);
		scrollPane_1.setViewportView(systemTextPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(292, 352, 160, 155);
		statisticsPanel.add(scrollPane_2);
		
		localQueueTextPane = new JTextPane();
		localQueueTextPane.setEditable(false);
		scrollPane_2.setViewportView(localQueueTextPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(532, 352, 154, 155);
		statisticsPanel.add(scrollPane_3);
		
		remoteQueueTextPane = new JTextPane();
		remoteQueueTextPane.setEditable(false);
		scrollPane_3.setViewportView(remoteQueueTextPane);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(751, 352, 154, 155);
		statisticsPanel.add(scrollPane_4);
		
		completedTextPane = new JTextPane();
		completedTextPane.setEditable(false);
		scrollPane_4.setViewportView(completedTextPane);
		
		JLabel lblLocalQueue = new JLabel("Fila Servidor Local");
		lblLocalQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalQueue.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblLocalQueue.setBounds(280, 314, 179, 27);
		statisticsPanel.add(lblLocalQueue);
		
		JLabel lblRemoteQueue = new JLabel("Fila Servidor Remoto");
		lblRemoteQueue.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblRemoteQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoteQueue.setBounds(521, 314, 173, 27);
		statisticsPanel.add(lblRemoteQueue);
		
		JLabel lblSystemMessages = new JLabel("Mensagens Processando Nos Centros");
		lblSystemMessages.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblSystemMessages.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystemMessages.setBounds(8, 313, 260, 31);
		statisticsPanel.add(lblSystemMessages);
		
		JLabel lblCompletedMessages = new JLabel("Mensagens Completadas");
		lblCompletedMessages.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompletedMessages.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblCompletedMessages.setBounds(735, 310, 173, 34);
		statisticsPanel.add(lblCompletedMessages);
		
		JLabel lblMensagensNoSistema = new JLabel("Mensagens no Sistema");
		lblMensagensNoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagensNoSistema.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblMensagensNoSistema.setBounds(95, 47, 160, 47);
		statisticsPanel.add(lblMensagensNoSistema);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMin.setBounds(41, 89, 63, 21);
		statisticsPanel.add(lblMin);
		
		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMdia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdia.setBounds(129, 86, 63, 27);
		statisticsPanel.add(lblMdia);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMax.setBounds(213, 92, 63, 14);
		statisticsPanel.add(lblMax);
		
		JLabel lblOcupacaoCentro = new JLabel("Taxa Ocupa\u00E7\u00E3o dos Centros");
		lblOcupacaoCentro.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacaoCentro.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOcupacaoCentro.setBounds(385, 46, 206, 47);
		statisticsPanel.add(lblOcupacaoCentro);
		
		minMsg = new JFormattedTextField();
		minMsg.setBackground(SystemColor.textHighlightText);
		minMsg.setEditable(false);
		minMsg.setHorizontalAlignment(SwingConstants.CENTER);
		minMsg.setBounds(44, 112, 63, 20);
		statisticsPanel.add(minMsg);
		
		avgMsg = new JFormattedTextField();
		avgMsg.setBackground(SystemColor.text);
		avgMsg.setEditable(false);
		avgMsg.setHorizontalAlignment(SwingConstants.CENTER);
		avgMsg.setBounds(129, 112, 63, 20);
		statisticsPanel.add(avgMsg);
		
		maxMsg = new JFormattedTextField();
		maxMsg.setBackground(SystemColor.text);
		maxMsg.setEditable(false);
		maxMsg.setHorizontalAlignment(SwingConstants.CENTER);
		maxMsg.setBounds(213, 112, 63, 20);
		statisticsPanel.add(maxMsg);
		
		ocupacaoRem = new JFormattedTextField();
		ocupacaoRem.setBackground(SystemColor.text);
		ocupacaoRem.setEditable(false);
		ocupacaoRem.setHorizontalAlignment(SwingConstants.CENTER);
		ocupacaoRem.setBounds(502, 112, 63, 20);
		statisticsPanel.add(ocupacaoRem);
		
		ocupacaoLoc = new JFormattedTextField();
		ocupacaoLoc.setBackground(SystemColor.text);
		ocupacaoLoc.setEditable(false);
		ocupacaoLoc.setHorizontalAlignment(SwingConstants.CENTER);
		ocupacaoLoc.setBounds(412, 112, 63, 20);
		statisticsPanel.add(ocupacaoLoc);
		
		JLabel lblOcupacaoL = new JLabel("Local");
		lblOcupacaoL.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacaoL.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblOcupacaoL.setBounds(412, 83, 63, 27);
		statisticsPanel.add(lblOcupacaoL);
		
		JLabel lblOcupacaoRM = new JLabel("Remoto");
		lblOcupacaoRM.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacaoRM.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblOcupacaoRM.setBounds(502, 83, 63, 27);
		statisticsPanel.add(lblOcupacaoRM);
		
		JLabel lblTempoDeTrnsito = new JLabel("Tempo de Tr\u00E2nsito das Mensagens");
		lblTempoDeTrnsito.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoDeTrnsito.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTempoDeTrnsito.setBounds(674, 37, 231, 57);
		statisticsPanel.add(lblTempoDeTrnsito);
		
		JLabel lblIn = new JLabel("Min");
		lblIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIn.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblIn.setBounds(665, 87, 77, 21);
		statisticsPanel.add(lblIn);
		
		JLabel lblMdio = new JLabel("M\u00E9dio");
		lblMdio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdio.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMdio.setBounds(758, 84, 63, 27);
		statisticsPanel.add(lblMdio);
		
		JLabel lblMax_1 = new JLabel("Max");
		lblMax_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMax_1.setBounds(842, 84, 63, 27);
		statisticsPanel.add(lblMax_1);
		
		transitoMax = new JFormattedTextField();
		transitoMax.setBackground(SystemColor.text);
		transitoMax.setEditable(false);
		transitoMax.setHorizontalAlignment(SwingConstants.CENTER);
		transitoMax.setBounds(842, 113, 63, 20);
		statisticsPanel.add(transitoMax);
		
		transitoAvg = new JFormattedTextField();
		transitoAvg.setBackground(SystemColor.text);
		transitoAvg.setEditable(false);
		transitoAvg.setHorizontalAlignment(SwingConstants.CENTER);
		transitoAvg.setBounds(758, 113, 63, 20);
		statisticsPanel.add(transitoAvg);
		
		transitoMin = new JFormattedTextField();
		transitoMin.setBackground(SystemColor.text);
		transitoMin.setEditable(false);
		transitoMin.setHorizontalAlignment(SwingConstants.CENTER);
		transitoMin.setBounds(673, 113, 63, 20);
		statisticsPanel.add(transitoMin);
		
		JLabel lblMensagensDespachadas = new JLabel("Mensagens Despachadas");
		lblMensagensDespachadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagensDespachadas.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblMensagensDespachadas.setBounds(74, 160, 195, 54);
		statisticsPanel.add(lblMensagensDespachadas);
		
		totalDespachadas = new JFormattedTextField();
		totalDespachadas.setHorizontalAlignment(SwingConstants.CENTER);
		totalDespachadas.setEditable(false);
		totalDespachadas.setBackground(Color.WHITE);
		totalDespachadas.setBounds(129, 225, 63, 20);
		statisticsPanel.add(totalDespachadas);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTotal.setBounds(129, 203, 63, 21);
		statisticsPanel.add(lblTotal);
		
		contRLS = new JFormattedTextField();
		contRLS.setHorizontalAlignment(SwingConstants.CENTER);
		contRLS.setEditable(false);
		contRLS.setBackground(Color.WHITE);
		contRLS.setBounds(378, 246, 63, 20);
		statisticsPanel.add(contRLS);
		
		JLabel lblQuantidadeDeMensagens = new JLabel("Quantidade de Mensagens por Tipo");
		lblQuantidadeDeMensagens.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidadeDeMensagens.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblQuantidadeDeMensagens.setBounds(351, 148, 240, 47);
		statisticsPanel.add(lblQuantidadeDeMensagens);
		
		JLabel lblLr = new JLabel("LR");
		lblLr.setHorizontalAlignment(SwingConstants.CENTER);
		lblLr.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblLr.setBounds(321, 225, 63, 24);
		statisticsPanel.add(lblLr);
		
		JLabel lblRl = new JLabel("RL");
		lblRl.setHorizontalAlignment(SwingConstants.CENTER);
		lblRl.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblRl.setBounds(322, 247, 63, 21);
		statisticsPanel.add(lblRl);
		
		contRRS = new JFormattedTextField();
		contRRS.setHorizontalAlignment(SwingConstants.CENTER);
		contRRS.setEditable(false);
		contRRS.setBackground(Color.WHITE);
		contRRS.setBounds(378, 267, 63, 20);
		statisticsPanel.add(contRRS);
		
		contLLS = new JFormattedTextField();
		contLLS.setHorizontalAlignment(SwingConstants.CENTER);
		contLLS.setEditable(false);
		contLLS.setBackground(Color.WHITE);
		contLLS.setBounds(378, 204, 63, 20);
		statisticsPanel.add(contLLS);
		
		contLRS = new JFormattedTextField();
		contLRS.setHorizontalAlignment(SwingConstants.CENTER);
		contLRS.setEditable(false);
		contLRS.setBackground(Color.WHITE);
		contLRS.setBounds(378, 225, 63, 20);
		statisticsPanel.add(contLRS);
		
		JLabel lblRr = new JLabel("RR");
		lblRr.setHorizontalAlignment(SwingConstants.CENTER);
		lblRr.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblRr.setBounds(323, 269, 63, 21);
		statisticsPanel.add(lblRr);
		
		JLabel lblLl = new JLabel("LL");
		lblLl.setHorizontalAlignment(SwingConstants.CENTER);
		lblLl.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblLl.setBounds(322, 202, 63, 24);
		statisticsPanel.add(lblLl);
		
		contLLF = new JFormattedTextField();
		contLLF.setHorizontalAlignment(SwingConstants.CENTER);
		contLLF.setEditable(false);
		contLLF.setBackground(Color.WHITE);
		contLLF.setBounds(452, 204, 63, 20);
		statisticsPanel.add(contLLF);
		
		contLRF = new JFormattedTextField();
		contLRF.setHorizontalAlignment(SwingConstants.CENTER);
		contLRF.setEditable(false);
		contLRF.setBackground(Color.WHITE);
		contLRF.setBounds(452, 225, 63, 20);
		statisticsPanel.add(contLRF);
		
		contRLF = new JFormattedTextField();
		contRLF.setHorizontalAlignment(SwingConstants.CENTER);
		contRLF.setEditable(false);
		contRLF.setBackground(Color.WHITE);
		contRLF.setBounds(452, 246, 63, 20);
		statisticsPanel.add(contRLF);
		
		contRRF = new JFormattedTextField();
		contRRF.setHorizontalAlignment(SwingConstants.CENTER);
		contRRF.setEditable(false);
		contRRF.setBackground(Color.WHITE);
		contRRF.setBounds(452, 267, 63, 20);
		statisticsPanel.add(contRRF);
		
		contLLA = new JFormattedTextField();
		contLLA.setHorizontalAlignment(SwingConstants.CENTER);
		contLLA.setEditable(false);
		contLLA.setBackground(Color.WHITE);
		contLLA.setBounds(522, 204, 63, 20);
		statisticsPanel.add(contLLA);
		
		contLRA = new JFormattedTextField();
		contLRA.setHorizontalAlignment(SwingConstants.CENTER);
		contLRA.setEditable(false);
		contLRA.setBackground(Color.WHITE);
		contLRA.setBounds(522, 225, 63, 20);
		statisticsPanel.add(contLRA);
		
		contRLA = new JFormattedTextField();
		contRLA.setHorizontalAlignment(SwingConstants.CENTER);
		contRLA.setEditable(false);
		contRLA.setBackground(Color.WHITE);
		contRLA.setBounds(522, 246, 63, 20);
		statisticsPanel.add(contRLA);
		
		contRRA = new JFormattedTextField();
		contRRA.setHorizontalAlignment(SwingConstants.CENTER);
		contRRA.setEditable(false);
		contRRA.setBackground(Color.WHITE);
		contRRA.setBounds(522, 267, 63, 20);
		statisticsPanel.add(contRRA);
		
		JLabel lblSucesso = new JLabel("Sucesso");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblSucesso.setBounds(378, 183, 63, 24);
		statisticsPanel.add(lblSucesso);
		
		JLabel lblFalha = new JLabel("Falha");
		lblFalha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalha.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblFalha.setBounds(452, 183, 63, 24);
		statisticsPanel.add(lblFalha);
		
		JLabel lblAdiamento = new JLabel("Adiamento");
		lblAdiamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdiamento.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblAdiamento.setBounds(516, 181, 75, 29);
		statisticsPanel.add(lblAdiamento);
		
		JLabel lblTotalDeMensagens = new JLabel("Total de mensagens em tr\u00E2nsito");
		lblTotalDeMensagens.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDeMensagens.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTotalDeMensagens.setBounds(674, 148, 240, 47);
		statisticsPanel.add(lblTotalDeMensagens);
		
		countTraffic = new JFormattedTextField();
		countTraffic.setHorizontalAlignment(SwingConstants.CENTER);
		countTraffic.setEditable(false);
		countTraffic.setBackground(Color.WHITE);
		countTraffic.setBounds(758, 193, 63, 20);
		statisticsPanel.add(countTraffic);
		
		JLabel lblTotalDeMensagens_1 = new JLabel("Total de mensagens finalizadas");
		lblTotalDeMensagens_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDeMensagens_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTotalDeMensagens_1.setBounds(674, 214, 240, 47);
		statisticsPanel.add(lblTotalDeMensagens_1);
		
		countCompleted = new JFormattedTextField();
		countCompleted.setHorizontalAlignment(SwingConstants.CENTER);
		countCompleted.setEditable(false);
		countCompleted.setBackground(Color.WHITE);
		countCompleted.setBounds(758, 254, 63, 20);
		statisticsPanel.add(countCompleted);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuHelp);
		
		JButton btnHelp = new JButton("Manual");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManualInterface manual = new ManualInterface();
				manual.setBounds(150, 100, 940, 920);
				manual.setVisible(true);
				
			}
		});
		btnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuHelp.add(btnHelp);
		btnUpdateVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationInterface conf = new ConfigurationInterface();
				conf.setBounds(150, 100, 920, 630);
				conf.setVisible(true);
			}
		});
		
	}
}
