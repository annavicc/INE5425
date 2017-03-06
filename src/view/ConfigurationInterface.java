package view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.ValuesConfiguration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ConfigurationInterface extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtTECLocal;
	private JTextField txtTECRemote;
	private JTextField txtTrafficLL;
	private JTextField txtTrafficLR;
	private JTextField txtTrafficRL;
	private JTextField txtTrafficRR;
	private JTextField txtProportionLLS;
	private JTextField txtProportionLLF;
	private JTextField txtProportionLLA;
	private JTextField txtProportionLRS;
	private JTextField txtProportionLRF;
	private JTextField txtProportionLRA;
	private JTextField txtProportionRLS;
	private JTextField txtProportionRLF;
	private JTextField txtProportionRLA;
	private JTextField txtProportionRRS;
	private JTextField txtProportionRRF;
	private JTextField txtProportionRRA;
	private JTextField txtServCenterLLS1;
	private JTextField txtServCenterLLS2;
	private JTextField txtServCenterLLS3;
	private JTextField txtServCenterLLF1;
	private JTextField txtServCenterLLF2;
	private JTextField txtServCenterLLF3;
	private JTextField txtServCenterLLA1;
	private JTextField txtServCenterLLA2;
	private JTextField txtServCenterLLA3;
	private JTextField txtServCenterLRS1;
	private JTextField txtServCenterLRS2;
	private JTextField txtServCenterLRS3;
	private JTextField txtServCenterLRF3;
	private JTextField txtServCenterLRF2;
	private JTextField txtServCenterLRF1;
	private JTextField txtServCenterLRA1;
	private JTextField txtServCenterLRA2;
	private JTextField txtServCenterLRA3;
	private JTextField txtServCenterRLS1;
	private JTextField txtServCenterRLS2;
	private JTextField txtServCenterRLS3;
	private JTextField txtServCenterRLF1;
	private JTextField txtServCenterRLF2;
	private JTextField txtServCenterRLF3;
	private JTextField txtServCenterRLA1;
	private JTextField txtServCenterRLA2;
	private JTextField txtServCenterRLA3;
	private JTextField txtServCenterRRS1;
	private JTextField txtServCenterRRS2;
	private JTextField txtServCenterRRS3;
	private JTextField txtServCenterRRF1;
	private JTextField txtServCenterRRF2;
	private JTextField txtServCenterRRF3;
	private JTextField txtServCenterRRA1;
	private JTextField txtServCenterRRA2;
	private JTextField txtServCenterRRA3;
	public static JComboBox cmbTSFuncLLS;
	private JComboBox cmbTSFuncLLF;
	private JComboBox cmbTSFuncLLA;
	private JComboBox cmbTSFuncLRS;
	private JComboBox cmbTSFuncLRF;
	private JComboBox cmbTSFuncLRA;
	private JComboBox cmbTSFuncRRS;
	private JComboBox cmbTSFuncRRF;
	private JComboBox cmbTSFuncRRA;
	private JComboBox cmbTSFuncRLS;
	private JComboBox cmbTSFuncRLF;
	private JComboBox cmbTSFuncRLA;

	
	private ValuesConfiguration controller;
	private boolean isAnyEmpty = false;
	private JLabel lblLocalServers;
	private JLabel lblRemoteServers;
	private JTextField txtReceptionTime;
	private JTextField txtLocalServers;
	private JTextField txtRemoteServers;
	private JTextField simulationSpeed;
	private JLabel lblTempoLimite;
	private JLabel label_1;
	private JTextField maxTime;
	private JLabel lblemBrancoPara;
	private JLabel lblParaControlarEm;
	private JTextField expireTime;
	
	public ConfigurationInterface() {
		
		controller = ValuesConfiguration.getInstance();
		setTitle("Configurar Vari\u00E1veis");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel tecPanel = new JPanel();
		tecPanel.setBounds(0, 0, 240, 176);
		getContentPane().add(tecPanel);
		tecPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		tecPanel.setLayout(null);
		
		JLabel lblTEC = new JLabel("TEC");
		lblTEC.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTEC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTEC.setBounds(60, 5, 131, 27);
		tecPanel.add(lblTEC);
		
		txtRemoteServers = new JTextField();
		txtLocalServers = new JTextField();
		txtReceptionTime = new JTextField();
		simulationSpeed = new JTextField();
		maxTime = new JTextField();
		expireTime = new JTextField();
		
		txtTECLocal = new JTextField();
		txtTECLocal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTECLocal.setBounds(98, 68, 70, 20);
		tecPanel.add(txtTECLocal);
		txtTECLocal.setColumns(10);
		
		JLabel lblTECLocal = new JLabel("Local");
		lblTECLocal.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTECLocal.setBounds(27, 71, 38, 14);
		tecPanel.add(lblTECLocal);
		
		txtTECRemote = new JTextField();
		txtTECRemote.setHorizontalAlignment(SwingConstants.CENTER);
		txtTECRemote.setBounds(98, 113, 70, 20);
		tecPanel.add(txtTECRemote);
		txtTECRemote.setColumns(10);
		
		JLabel lblTECRemote = new JLabel("Remoto");
		lblTECRemote.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTECRemote.setBounds(27, 116, 46, 14);
		tecPanel.add(lblTECRemote);
		
		JLabel lblExpo = new JLabel("EXPO");
		lblExpo.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblExpo.setBounds(118, 43, 46, 14);
		tecPanel.add(lblExpo);
		
		JPanel trafficPanel = new JPanel();
		trafficPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		trafficPanel.setBounds(0, 176, 240, 186);
		getContentPane().add(trafficPanel);
		trafficPanel.setLayout(null);
		
		JLabel lblTraffic = new JLabel("Volume de tr\u00E1fego (%)");
		lblTraffic.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraffic.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTraffic.setBounds(42, 5, 168, 27);
		trafficPanel.add(lblTraffic);
		
		JLabel lblTrafficLL = new JLabel("LL");
		lblTrafficLL.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTrafficLL.setBounds(22, 60, 46, 14);
		trafficPanel.add(lblTrafficLL);
		
		

		txtTrafficLL = new JTextField();
		txtTrafficLL.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrafficLL.setBounds(42, 57, 62, 20);
		trafficPanel.add(txtTrafficLL);
		txtTrafficLL.setColumns(10);
		
		JLabel lblTrafficRR = new JLabel("RR");
		lblTrafficRR.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTrafficRR.setBounds(141, 110, 46, 14);
		trafficPanel.add(lblTrafficRR);
		
		txtTrafficRR = new JTextField();
		txtTrafficRR.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrafficRR.setBounds(157, 107, 62, 20);
		trafficPanel.add(txtTrafficRR);
		txtTrafficRR.setColumns(10);
		
		JLabel lblTrafficLR = new JLabel("LR");
		lblTrafficLR.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTrafficLR.setBounds(22, 110, 46, 14);
		trafficPanel.add(lblTrafficLR);
		
		txtTrafficLR = new JTextField();
		txtTrafficLR.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrafficLR.setBounds(42, 107, 62, 20);
		trafficPanel.add(txtTrafficLR);
		txtTrafficLR.setColumns(10);
		
		JLabel lblTrafficRL = new JLabel("RL");
		lblTrafficRL.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTrafficRL.setBounds(141, 60, 46, 14);
		trafficPanel.add(lblTrafficRL);
		
		txtTrafficRL = new JTextField();
		txtTrafficRL.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrafficRL.setBounds(157, 57, 62, 20);
		trafficPanel.add(txtTrafficRL);
		txtTrafficRL.setColumns(10);
		
		
		JPanel proportionPanel = new JPanel();
		proportionPanel.setBounds(0, 363, 240, 228);
		proportionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(proportionPanel);
		proportionPanel.setLayout(null);
		
		JLabel lblProportion = new JLabel("Propor\u00E7\u00F5es (%)");
		lblProportion.setHorizontalAlignment(SwingConstants.CENTER);
		lblProportion.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblProportion.setBounds(63, 5, 131, 28);
		proportionPanel.add(lblProportion);
		
		JLabel lblProportionLL = new JLabel("LL");
		lblProportionLL.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionLL.setBounds(12, 80, 23, 14);
		proportionPanel.add(lblProportionLL);
		
		JLabel lblProportionLR = new JLabel("LR");
		lblProportionLR.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionLR.setBounds(12, 109, 23, 14);
		proportionPanel.add(lblProportionLR);
		
		JLabel lblProportionRL = new JLabel("RL");
		lblProportionRL.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionRL.setBounds(12, 136, 23, 14);
		proportionPanel.add(lblProportionRL);
		
		JLabel lblProportionRR = new JLabel("RR");
		lblProportionRR.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionRR.setBounds(13, 163, 23, 14);
		proportionPanel.add(lblProportionRR);
		
		txtProportionLLS = new JTextField();
		txtProportionLLS.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLLS.setBounds(43, 76, 43, 20);
		proportionPanel.add(txtProportionLLS);
		txtProportionLLS.setColumns(10);
		
		txtProportionLLF = new JTextField();
		txtProportionLLF.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLLF.setColumns(10);
		txtProportionLLF.setBounds(105, 75, 43, 20);
		proportionPanel.add(txtProportionLLF);
		
		txtProportionLLA = new JTextField();
		txtProportionLLA.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLLA.setColumns(10);
		txtProportionLLA.setBounds(167, 75, 43, 20);
		proportionPanel.add(txtProportionLLA);
		
		txtProportionLRS = new JTextField();
		txtProportionLRS.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLRS.setColumns(10);
		txtProportionLRS.setBounds(43, 104, 43, 20);
		proportionPanel.add(txtProportionLRS);
		
		txtProportionLRF = new JTextField();
		txtProportionLRF.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLRF.setColumns(10);
		txtProportionLRF.setBounds(105, 103, 43, 20);
		proportionPanel.add(txtProportionLRF);
		
		txtProportionLRA = new JTextField();
		txtProportionLRA.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionLRA.setColumns(10);
		txtProportionLRA.setBounds(167, 102, 43, 20);
		proportionPanel.add(txtProportionLRA);
		
		txtProportionRLS = new JTextField();
		txtProportionRLS.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRLS.setColumns(10);
		txtProportionRLS.setBounds(43, 132, 43, 20);
		proportionPanel.add(txtProportionRLS);
		
		txtProportionRLF = new JTextField();
		txtProportionRLF.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRLF.setColumns(10);
		txtProportionRLF.setBounds(105, 132, 43, 20);
		proportionPanel.add(txtProportionRLF);
		
		txtProportionRLA = new JTextField();
		txtProportionRLA.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRLA.setColumns(10);
		txtProportionRLA.setBounds(167, 132, 43, 20);
		proportionPanel.add(txtProportionRLA);
		
		txtProportionRRS = new JTextField();
		txtProportionRRS.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRRS.setColumns(10);
		txtProportionRRS.setBounds(43, 159, 43, 20);
		proportionPanel.add(txtProportionRRS);
		
		txtProportionRRF = new JTextField();
		txtProportionRRF.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRRF.setColumns(10);
		txtProportionRRF.setBounds(105, 159, 43, 20);
		proportionPanel.add(txtProportionRRF);
		
		txtProportionRRA = new JTextField();
		txtProportionRRA.setHorizontalAlignment(SwingConstants.CENTER);
		txtProportionRRA.setColumns(10);
		txtProportionRRA.setBounds(167, 159, 43, 20);
		proportionPanel.add(txtProportionRRA);
		
		JLabel lblProportionS = new JLabel("S");
		lblProportionS.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionS.setBounds(63, 44, 23, 14);
		proportionPanel.add(lblProportionS);
		
		JLabel lblProportionF = new JLabel("F");
		lblProportionF.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionF.setBounds(127, 44, 14, 14);
		proportionPanel.add(lblProportionF);
		
		JLabel lblProportionA = new JLabel("A");
		lblProportionA.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblProportionA.setBounds(187, 44, 23, 14);
		proportionPanel.add(lblProportionA);
		
		JPanel tsPanel = new JPanel();
		tsPanel.setBounds(239, 0, 688, 591);
		getContentPane().add(tsPanel);
		tsPanel.setLayout(null);
		
		JLabel lblTS = new JLabel("Tempos de Servi\u00E7o");
		lblTS.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTS.setBounds(386, 8, 147, 25);
		tsPanel.add(lblTS);
		
		JLabel lblTSProc = new JLabel("Tipo");
		lblTSProc.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTSProc.setBounds(247, 40, 51, 31);
		tsPanel.add(lblTSProc);
		
		JLabel lblTSLLS = new JLabel("LLS");
		lblTSLLS.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLLS.setBounds(252, 86, 46, 14);
		tsPanel.add(lblTSLLS);
		
		JLabel lblTSLLF = new JLabel("LLF");
		lblTSLLF.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLLF.setBounds(252, 124, 46, 14);
		tsPanel.add(lblTSLLF);
		
		JLabel lblTSLLA = new JLabel("LLA");
		lblTSLLA.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLLA.setBounds(252, 163, 46, 14);
		tsPanel.add(lblTSLLA);
		
		JLabel lblTSLRS = new JLabel("LRS");
		lblTSLRS.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLRS.setBounds(252, 202, 46, 14);
		tsPanel.add(lblTSLRS);
		
		JLabel lblTSLRF = new JLabel("LRF");
		lblTSLRF.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLRF.setBounds(252, 242, 46, 14);
		tsPanel.add(lblTSLRF);
		
		JLabel lblTSLRA = new JLabel("LRA");
		lblTSLRA.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSLRA.setBounds(252, 281, 46, 14);
		tsPanel.add(lblTSLRA);
		
		JLabel lblTSRLS = new JLabel("RLS");
		lblTSRLS.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRLS.setBounds(252, 319, 46, 14);
		tsPanel.add(lblTSRLS);
		
		JLabel lblTSRLF = new JLabel("RLF");
		lblTSRLF.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRLF.setBounds(252, 360, 46, 14);
		tsPanel.add(lblTSRLF);
		
		JLabel lblTSRLA = new JLabel("RLA");
		lblTSRLA.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRLA.setBounds(252, 396, 46, 14);
		tsPanel.add(lblTSRLA);
		
		JLabel lblTSRRS = new JLabel("RRS");
		lblTSRRS.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRRS.setBounds(252, 437, 46, 14);
		tsPanel.add(lblTSRRS);
		
		JLabel lblTSRRF = new JLabel("RRF");
		lblTSRRF.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRRF.setBounds(252, 472, 46, 14);
		tsPanel.add(lblTSRRF);
		
		JLabel lblTSRRA = new JLabel("RRA");
		lblTSRRA.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTSRRA.setBounds(252, 507, 46, 14);
		tsPanel.add(lblTSRRA);
		
		tsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblTSFunc = new JLabel("Fun\u00E7\u00E3o");
		lblTSFunc.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTSFunc.setBounds(347, 47, 46, 14);
		tsPanel.add(lblTSFunc);
		
		cmbTSFuncLLS = new JComboBox();
		cmbTSFuncLLS.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLLS.setBounds(322, 83, 90, 20);
		tsPanel.add(cmbTSFuncLLS);
		cmbTSFuncLLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					disableTextArea(txtServCenterLLS2, txtServCenterLLS3, cmbTSFuncLLS);
			}
		});
		
		cmbTSFuncLLF = new JComboBox();
		cmbTSFuncLLF.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLLF.setSelectedIndex(1);
		cmbTSFuncLLF.setBounds(322, 121, 90, 20);
		tsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		tsPanel.add(cmbTSFuncLLF);
		cmbTSFuncLLF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterLLF2, txtServCenterLLF3, cmbTSFuncLLF);
			}
		});
		
		cmbTSFuncLLA = new JComboBox();
		cmbTSFuncLLA.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLLA.setSelectedIndex(2);
		cmbTSFuncLLA.setBounds(322, 160, 90, 20);
		tsPanel.add(cmbTSFuncLLA);
		cmbTSFuncLLA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterLLA2, txtServCenterLLA3, cmbTSFuncLLA);
			}
		});
		
		cmbTSFuncLRS = new JComboBox();
		cmbTSFuncLRS.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLRS.setBounds(322, 199, 90, 20);
		tsPanel.add(cmbTSFuncLRS);
		cmbTSFuncLRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterLRS2, txtServCenterLRS3, cmbTSFuncLRS);
			}
		});
		
		
		cmbTSFuncLRF = new JComboBox();
		cmbTSFuncLRF.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLRF.setSelectedIndex(2);
		cmbTSFuncLRF.setBounds(322, 239, 90, 20);
		tsPanel.add(cmbTSFuncLRF);
		cmbTSFuncLRF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterLRF2, txtServCenterLRF3, cmbTSFuncLRF);
			}
		});
		
		cmbTSFuncLRA = new JComboBox();
		cmbTSFuncLRA.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncLRA.setSelectedIndex(1);
		cmbTSFuncLRA.setBounds(322, 275, 90, 20);
		tsPanel.add(cmbTSFuncLRA);
		cmbTSFuncLRA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterLRA2, txtServCenterLRA3, cmbTSFuncLRA);
			}
		});
		
		
		cmbTSFuncRLS = new JComboBox();
		cmbTSFuncRLS.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRLS.setSelectedIndex(2);
		cmbTSFuncRLS.setBounds(322, 311, 90, 20);
		tsPanel.add(cmbTSFuncRLS);
		cmbTSFuncRLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRLS2, txtServCenterRLS3, cmbTSFuncRLS);
			}
		});
		
		cmbTSFuncRLF = new JComboBox();
		cmbTSFuncRLF.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRLF.setBounds(322, 352, 90, 20);
		tsPanel.add(cmbTSFuncRLF);
		cmbTSFuncRLF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRLF2, txtServCenterRLF3, cmbTSFuncRLF);
			}
		});
		
		cmbTSFuncRLA = new JComboBox();
		cmbTSFuncRLA.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRLA.setBounds(322, 393, 90, 20);
		tsPanel.add(cmbTSFuncRLA);
		cmbTSFuncRLA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRLA2, txtServCenterRLA3, cmbTSFuncRLA);
			}
		});
		
		cmbTSFuncRRS = new JComboBox();
		cmbTSFuncRRS.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRRS.setSelectedIndex(2);
		cmbTSFuncRRS.setBounds(322, 434, 90, 20);
		tsPanel.add(cmbTSFuncRRS);
		cmbTSFuncRRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRRS2, txtServCenterRRS3, cmbTSFuncRRS);
			}
		});
		
		cmbTSFuncRRF = new JComboBox();
		cmbTSFuncRRF.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRRF.setSelectedIndex(1);
		cmbTSFuncRRF.setBounds(322, 469, 90, 20);
		tsPanel.add(cmbTSFuncRRF);
		cmbTSFuncRRF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRRF2, txtServCenterRRF3, cmbTSFuncRRF);
			}
		});
		
		cmbTSFuncRRA = new JComboBox();
		cmbTSFuncRRA.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "TRIANGULAR", "UNIFORME", "CONSTANTE"}));
		cmbTSFuncRRA.setBounds(322, 504, 90, 20);
		tsPanel.add(cmbTSFuncRRA);
		cmbTSFuncRRA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				disableTextArea(txtServCenterRRA2, txtServCenterRRA3, cmbTSFuncRRA);
			}
		});
		
		txtServCenterLLS1 = new JTextField();
		txtServCenterLLS1.setHorizontalAlignment(SwingConstants.CENTER);

		txtServCenterLLS1.setColumns(10);
		txtServCenterLLS1.setBounds(427, 83, 65, 20);
		tsPanel.add(txtServCenterLLS1);
		
		txtServCenterLLS2 = new JTextField();
		txtServCenterLLS2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLS2.setColumns(10);
		txtServCenterLLS2.setBounds(508, 83, 65, 20);
		tsPanel.add(txtServCenterLLS2);
		
		txtServCenterLLS3 = new JTextField();
		txtServCenterLLS3.setEnabled(false);
		txtServCenterLLS3.setColumns(10);
		txtServCenterLLS3.setBounds(589, 83, 65, 20);
		tsPanel.add(txtServCenterLLS3);
		
		txtServCenterLLF1 = new JTextField();
		txtServCenterLLF1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLF1.setColumns(10);
		txtServCenterLLF1.setBounds(427, 121, 65, 20);
		tsPanel.add(txtServCenterLLF1);
		
		txtServCenterLLF2 = new JTextField();
		txtServCenterLLF2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLF2.setColumns(10);
		txtServCenterLLF2.setBounds(508, 121, 65, 20);
		tsPanel.add(txtServCenterLLF2);
		
		txtServCenterLLF3 = new JTextField();
		txtServCenterLLF3.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLF3.setColumns(10);
		txtServCenterLLF3.setBounds(589, 121, 65, 20);
		tsPanel.add(txtServCenterLLF3);

		txtServCenterLLA1 = new JTextField();
		txtServCenterLLA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLA1.setColumns(10);
		txtServCenterLLA1.setBounds(427, 160, 65, 20);
		tsPanel.add(txtServCenterLLA1);
		
		txtServCenterLLA2 = new JTextField();
		txtServCenterLLA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLLA2.setColumns(10);
		txtServCenterLLA2.setBounds(508, 160, 65, 20);
		tsPanel.add(txtServCenterLLA2);
		
		txtServCenterLLA3 = new JTextField();
		txtServCenterLLA3.setEnabled(false);
		txtServCenterLLA3.setColumns(10);
		txtServCenterLLA3.setBounds(589, 160, 65, 20);
		tsPanel.add(txtServCenterLLA3);

		txtServCenterLRS1 = new JTextField();
		txtServCenterLRS1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRS1.setColumns(10);
		txtServCenterLRS1.setBounds(427, 199, 65, 20);
		tsPanel.add(txtServCenterLRS1);
		
		txtServCenterLRS2 = new JTextField();
		txtServCenterLRS2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRS2.setColumns(10);
		txtServCenterLRS2.setBounds(508, 199, 65, 20);
		tsPanel.add(txtServCenterLRS2);
		
		txtServCenterLRS3 = new JTextField();
		txtServCenterLRS3.setEnabled(false);
		txtServCenterLRS3.setColumns(10);
		txtServCenterLRS3.setBounds(589, 199, 65, 20);
		tsPanel.add(txtServCenterLRS3);
		
		txtServCenterLRF3 = new JTextField();
		txtServCenterLRF3.setEnabled(false);
		txtServCenterLRF3.setColumns(10);
		txtServCenterLRF3.setBounds(589, 239, 65, 20);
		tsPanel.add(txtServCenterLRF3);
		
		txtServCenterLRF2 = new JTextField();
		txtServCenterLRF2.setColumns(10);
		txtServCenterLRF2.setBounds(508, 239, 65, 20);
		tsPanel.add(txtServCenterLRF2);
		txtServCenterLRF2.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtServCenterLRF1 = new JTextField();
		txtServCenterLRF1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRF1.setColumns(10);
		txtServCenterLRF1.setBounds(427, 239, 65, 20);
		tsPanel.add(txtServCenterLRF1);

		txtServCenterLRA1 = new JTextField();
		txtServCenterLRA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRA1.setColumns(10);
		txtServCenterLRA1.setBounds(427, 275, 65, 20);
		tsPanel.add(txtServCenterLRA1);
		
		txtServCenterLRA2 = new JTextField();
		txtServCenterLRA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRA2.setColumns(10);
		txtServCenterLRA2.setBounds(508, 275, 65, 20);
		tsPanel.add(txtServCenterLRA2);
		
		txtServCenterLRA3 = new JTextField();
		txtServCenterLRA3.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterLRA3.setColumns(10);
		txtServCenterLRA3.setBounds(589, 275, 65, 20);
		tsPanel.add(txtServCenterLRA3);
		
		txtServCenterRLS1 = new JTextField();
		txtServCenterRLS1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLS1.setColumns(10);
		txtServCenterRLS1.setBounds(427, 311, 65, 20);
		tsPanel.add(txtServCenterRLS1);
		
		txtServCenterRLS2 = new JTextField();
		txtServCenterRLS2.setColumns(10);
		txtServCenterRLS2.setBounds(508, 311, 65, 20);
		tsPanel.add(txtServCenterRLS2);
		
		txtServCenterRLS3 = new JTextField();
		txtServCenterRLS3.setEnabled(false);
		txtServCenterRLS2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLS3.setColumns(10);
		txtServCenterRLS3.setBounds(589, 311, 65, 20);
		tsPanel.add(txtServCenterRLS3);
		
		txtServCenterRLF1 = new JTextField();
		txtServCenterRLF1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLF1.setColumns(10);
		txtServCenterRLF1.setBounds(427, 352, 65, 20);
		tsPanel.add(txtServCenterRLF1);
		
		txtServCenterRLF2 = new JTextField();
		txtServCenterRLF2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLF2.setColumns(10);
		txtServCenterRLF2.setBounds(508, 352, 65, 20);
		tsPanel.add(txtServCenterRLF2);
		
		txtServCenterRRF3 = new JTextField();
		txtServCenterRRF3.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRF3.setColumns(10);
		txtServCenterRRF3.setBounds(589, 469, 65, 20);
		tsPanel.add(txtServCenterRRF3);
		
		
		txtServCenterRLA1 = new JTextField();
		txtServCenterRLA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLA1.setColumns(10);
		txtServCenterRLA1.setBounds(427, 393, 65, 20);
		tsPanel.add(txtServCenterRLA1);
		
		txtServCenterRLA2 = new JTextField();
		txtServCenterRLA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRLA2.setColumns(10);
		txtServCenterRLA2.setBounds(508, 393, 65, 20);
		tsPanel.add(txtServCenterRLA2);
		
		txtServCenterRLA3 = new JTextField();
		txtServCenterRLA3.setEnabled(false);
		txtServCenterRLA3.setColumns(10);
		txtServCenterRLA3.setBounds(589, 393, 65, 20);
		tsPanel.add(txtServCenterRLA3);
		
		txtServCenterRRS1 = new JTextField();
		txtServCenterRRS1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRS1.setColumns(10);
		txtServCenterRRS1.setBounds(427, 434, 65, 20);
		tsPanel.add(txtServCenterRRS1);
		
		txtServCenterRRS2 = new JTextField();
		txtServCenterRRS2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRS2.setColumns(10);
		txtServCenterRRS2.setBounds(508, 434, 65, 20);
		tsPanel.add(txtServCenterRRS2);
		
		txtServCenterRRS3 = new JTextField();
		txtServCenterRRS3.setEnabled(false);
		txtServCenterRRS3.setColumns(10);
		txtServCenterRRS3.setBounds(589, 434, 65, 20);
		tsPanel.add(txtServCenterRRS3);

		txtServCenterRRF1 = new JTextField();
		txtServCenterRRF1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRF1.setColumns(10);
		txtServCenterRRF1.setBounds(427, 469, 65, 20);
		tsPanel.add(txtServCenterRRF1);
		
		txtServCenterRRF2 = new JTextField();
		txtServCenterRRF2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRF2.setColumns(10);
		txtServCenterRRF2.setBounds(508, 469, 65, 20);
		tsPanel.add(txtServCenterRRF2);

		
		txtServCenterRLF3 = new JTextField();
		txtServCenterRLF3.setEnabled(false);
		txtServCenterRLF3.setColumns(10);
		txtServCenterRLF3.setBounds(589, 352, 65, 20);
		tsPanel.add(txtServCenterRLF3);
				

		txtServCenterRRA1 = new JTextField();
		txtServCenterRRA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRA1.setColumns(10);
		txtServCenterRRA1.setBounds(427, 504, 65, 20);
		tsPanel.add(txtServCenterRRA1);
		
		txtServCenterRRA2 = new JTextField();
		txtServCenterRRA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtServCenterRRA2.setColumns(10);
		txtServCenterRRA2.setBounds(508, 504, 65, 20);
		tsPanel.add(txtServCenterRRA2);
		
		txtServCenterRRA3 = new JTextField();
		txtServCenterRRA3.setEnabled(false);
		txtServCenterRRA3.setColumns(10);
		txtServCenterRRA3.setBounds(589, 504, 65, 20);
		tsPanel.add(txtServCenterRRA3);
		
		setDefaultValues();
		
		JButton btnReset = new JButton("Resetar Vari\u00E1veis");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDefaultValues();
			}
		});
		btnReset.setBounds(427, 557, 132, 23);
		tsPanel.add(btnReset);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double expire = getActualValue(expireTime);
				double maxSimulationTime = getActualValue(maxTime);
				double runSpeed = getActualValue(simulationSpeed);
				double receptionTime = getActualValue(txtReceptionTime);
				double server1 = getActualValue(txtLocalServers); 
				double server2 = getActualValue(txtRemoteServers);
				double tecs[] = getTec();
				double volumes[] = getVolume();
				double status[] = getStatus();
				double distLLS[] = getDistributionLLS();
				double distLLF[] = getDistributionLLF();
				double distLLA[] = getDistributionLLA();
				double distLRS[] = getDistributionLRS();
				double distLRF[] = getDistributionLRF();
				double distLRA[] = getDistributionLRA();
				double distRLS[] = getDistributionRLS();
				double distRLF[] = getDistributionRLF();
				double distRLA[] = getDistributionRLA();
				double distRRS[] = getDistributionRRS();
				double distRRF[] = getDistributionRRF();
				double distRRA[] = getDistributionRRA();
				
				if (isAnyEmpty) {
					JOptionPane.showMessageDialog(null, "As variáveis que não foram atribuidos valores terão valor default");
					isAnyEmpty = false;
				}
			
				controller.onSetVariablesClicked(expire, maxSimulationTime, runSpeed, tecs, volumes, status, distLLS, distLLF, distLLA,
						distLRS, distLRF, distLRA, distRLS, distRLF, distRLA,
						distRRS, distRRF, distRRA, receptionTime, (int)server1, (int)server2
						);
			}
		});
		btnSave.setBounds(565, 557, 89, 23);
		tsPanel.add(btnSave);
		
		JLabel lblTSServCenter = new JLabel("Centro de Servi\u00E7o");
		lblTSServCenter.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTSServCenter.setBounds(487, 47, 106, 14);
		tsPanel.add(lblTSServCenter);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 218, 591);
		tsPanel.add(panel);
		panel.setLayout(null);
		
		
		txtRemoteServers.setBounds(74, 93, 70, 20);
		panel.add(txtRemoteServers);
		txtRemoteServers.setHorizontalAlignment(SwingConstants.CENTER);
		txtRemoteServers.setColumns(10);
		
		lblRemoteServers = new JLabel("Servidores Remotos");
		lblRemoteServers.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblRemoteServers.setBounds(48, 48, 137, 52);
		panel.add(lblRemoteServers);
		
		txtLocalServers.setBounds(74, 36, 70, 20);
		panel.add(txtLocalServers);
		txtLocalServers.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocalServers.setColumns(10);
		
		lblLocalServers = new JLabel("Servidores Locais");
		lblLocalServers.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblLocalServers.setBounds(48, 0, 119, 37);
		panel.add(lblLocalServers);
		lblLocalServers.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtReceptionTime.setBounds(74, 149, 70, 20);
		panel.add(txtReceptionTime);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		txtReceptionTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtReceptionTime.setColumns(10);
		
		JLabel lblTSRec = new JLabel("Tempo de Recep\u00E7\u00E3o");
		lblTSRec.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTSRec.setBounds(48, 113, 140, 43);
		panel.add(lblTSRec);
		
		JLabel lblVelocidadeDeSimulao = new JLabel("Velocidade de simula\u00E7\u00E3o");
		lblVelocidadeDeSimulao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelocidadeDeSimulao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblVelocidadeDeSimulao.setBounds(8, 180, 198, 43);
		panel.add(lblVelocidadeDeSimulao);
		
		simulationSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		simulationSpeed.setColumns(10);
		simulationSpeed.setBounds(72, 234, 70, 20);
		panel.add(simulationSpeed);
		
		JLabel lblsegundos = new JLabel("(segundos)");
		lblsegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblsegundos.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblsegundos.setBounds(8, 200, 198, 43);
		panel.add(lblsegundos);
		
		lblTempoLimite = new JLabel("Tempo limite da simula\u00E7\u00E3o");
		lblTempoLimite.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoLimite.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoLimite.setBounds(8, 400, 198, 43);
		panel.add(lblTempoLimite);
		
		label_1 = new JLabel("(segundos)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		label_1.setBounds(7, 420, 198, 43);
		panel.add(label_1);
		
		maxTime.setHorizontalAlignment(SwingConstants.CENTER);
		maxTime.setColumns(10);
		maxTime.setBounds(74, 491, 70, 20);
		panel.add(maxTime);
		
		lblemBrancoPara = new JLabel("(Deixe em branco para");
		lblemBrancoPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblemBrancoPara.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblemBrancoPara.setBounds(24, 437, 158, 43);
		panel.add(lblemBrancoPara);
		
		lblParaControlarEm = new JLabel("controlar em tempo real)");
		lblParaControlarEm.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaControlarEm.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblParaControlarEm.setBounds(18, 448, 174, 52);
		panel.add(lblParaControlarEm);
		
		JLabel lblTempoLimiteDe = new JLabel("Tempo limite da mensagem");
		lblTempoLimiteDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoLimiteDe.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoLimiteDe.setBounds(10, 265, 198, 43);
		panel.add(lblTempoLimiteDe);
		
		JLabel lblNoSistemasegundos = new JLabel("no sistema (segundos)");
		lblNoSistemasegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoSistemasegundos.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNoSistemasegundos.setBounds(10, 285, 198, 43);
		panel.add(lblNoSistemasegundos);
		
		expireTime.setHorizontalAlignment(SwingConstants.CENTER);
		expireTime.setColumns(10);
		expireTime.setBounds(74, 319, 70, 20);
		panel.add(expireTime);
	}


	private double[] getTec() {
		double[] tecs = new double[2];
		
		tecs[0] = getActualValue(txtTECLocal);
		tecs[1] = getActualValue(txtTECRemote);

		return tecs;
	}

	private double[] getVolume() {
		double[] volumes = new double[4];
		
		volumes[0] = getActualValue(txtTrafficLL);
		volumes[1] = getActualValue(txtTrafficLR);
		volumes[2] = getActualValue(txtTrafficRL);
		volumes[3] = getActualValue(txtTrafficRR);
				
		return volumes;
	}

	private double[] getStatus() {
		
		double[] status = new double[12];
		
		status[0] = getActualValue(txtProportionLLS);
		status[1] = getActualValue(txtProportionLLF);
		status[2] = getActualValue(txtProportionLLA);
		status[3] = getActualValue(txtProportionLRS);
		status[4] = getActualValue(txtProportionLRF);
		status[5] = getActualValue(txtProportionLRA);
		status[6] = getActualValue(txtProportionRLS);
		status[7] = getActualValue(txtProportionRLF);
		status[8] = getActualValue(txtProportionRLA);
		status[9] = getActualValue(txtProportionRRS);
		status[10] = getActualValue(txtProportionRRF);
		status[11] = getActualValue(txtProportionRRA);
		
		return status;
	}

	private double[] getDistributionLLS() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterLLS1);

		dist[1] = getActualValue(txtServCenterLLS2);

		dist[2] = getActualValue(txtServCenterLLS3);
		
		dist[3] = cmbTSFuncLLS.getSelectedIndex();
		
		return dist;
		
	}
	
	private double[] getDistributionLLF() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterLLF1);

		dist[1] = getActualValue(txtServCenterLLF2);

		dist[2] = getActualValue(txtServCenterLLF3);

		dist[3] = cmbTSFuncLLF.getSelectedIndex();

		return dist;
	}
	
	private double[] getDistributionLLA() {
		double[] dist = new double[4];
		
		dist[0] = getActualValue(txtServCenterLLA1);

		dist[1] = getActualValue(txtServCenterLLA2);

		dist[2] = getActualValue(txtServCenterLLA3);
		
		dist[3] = cmbTSFuncLLA.getSelectedIndex();
				
		return dist;
	}
	
	private double[] getDistributionLRS() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterLRS1);

		dist[1] = getActualValue(txtServCenterLRS2);

		dist[2] = getActualValue(txtServCenterLRS3);

		dist[3] = cmbTSFuncLRS.getSelectedIndex();

		return dist;
	}
	
	private double[] getDistributionLRF() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterLRF1);

		dist[1] = getActualValue(txtServCenterLRF2);

		dist[2] = getActualValue(txtServCenterLRF3);

		dist[3] = cmbTSFuncLRF.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionLRA() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterLRA1);

		dist[1] = getActualValue(txtServCenterLRA2);

		dist[2] = getActualValue(txtServCenterLRA3);

		dist[3] = cmbTSFuncLRA.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionRLS() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRLS1);

		dist[1] = getActualValue(txtServCenterRLS2);

		dist[2] = getActualValue(txtServCenterRLS3);

		dist[3] = cmbTSFuncRLS.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionRLF() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRLF1);

		dist[1] = getActualValue(txtServCenterRLF2);

		dist[2] = getActualValue(txtServCenterRLF3);

		dist[3] = cmbTSFuncRLF.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionRLA() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRLA1);

		dist[1] = getActualValue(txtServCenterRLA2);

		dist[2] = getActualValue(txtServCenterRLA3);

		dist[3] = cmbTSFuncRLA.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionRRS() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRRS1);

		dist[1] = getActualValue(txtServCenterRRS2);

		dist[2] = getActualValue(txtServCenterRRS3);

		dist[3] = cmbTSFuncRRS.getSelectedIndex();

		return dist;
	}
	
	private double[] getDistributionRRF() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRRF1);

		dist[1] = getActualValue(txtServCenterRRF2);

		dist[2] = getActualValue(txtServCenterRRF3);

		dist[3] = cmbTSFuncRRF.getSelectedIndex();
		
		return dist;
	}
	
	private double[] getDistributionRRA() {
		double[] dist= new double[4];
		
		dist[0] = getActualValue(txtServCenterRRA1);

		dist[1] = getActualValue(txtServCenterRRA2);

		dist[2] = getActualValue(txtServCenterRRA3);

		dist[3] = cmbTSFuncRRA.getSelectedIndex();
		
		return dist;
	}
	
	private double getActualValue(JTextField f ) {
		String s = f.getText();
		
		if (s.equals("")) {
			isAnyEmpty = true;
			return -1;
		} else {
			return Double.parseDouble(s);
		}
	}

	public void disableTextArea(JTextField textField2, JTextField textField3, JComboBox box) {
		if (box.getSelectedItem().equals("CONSTANTE")) {
			textField2.setEnabled(false);
			textField3.setEnabled(false);
		} else if (box.getSelectedItem().equals("TRIANGULAR")) {
			textField2.setEnabled(true);
			textField3.setEnabled(true);
		} else {
			textField2.setEnabled(true);
			textField3.setEnabled(false);
		}
	}
	
	public void setDefaultValues() {
		
		double exp = controller.getExpireTime();
		expireTime.setText(Double.toString(exp));
		
		double[] tecs = controller.getTecs();
		txtTECLocal.setText(Double.toString(tecs[0]));
		txtTECRemote.setText(Double.toString(tecs[1]));
		
		double[] traffic = controller.getTraffic();
		txtTrafficLL.setText(Double.toString(traffic[0]));
		txtTrafficLR.setText(Double.toString(traffic[1]));
		txtTrafficRL.setText(Double.toString(traffic[2]));
		txtTrafficRR.setText(Double.toString(traffic[3]));
		
		double[] prop = controller.getStatus();
		txtProportionLLS.setText(Double.toString(prop[0]));
		txtProportionLLF.setText(Double.toString(prop[1]));
		txtProportionLLA.setText(Double.toString(prop[2]));
		txtProportionLRS.setText(Double.toString(prop[3]));
		txtProportionLRF.setText(Double.toString(prop[4]));
		txtProportionLRA.setText(Double.toString(prop[5]));
		txtProportionRLS.setText(Double.toString(prop[6]));
		txtProportionRLF.setText(Double.toString(prop[7]));
		txtProportionRRS.setText(Double.toString(prop[9]));
		txtProportionRLA.setText(Double.toString(prop[8]));
		txtProportionRRF.setText(Double.toString(prop[10]));
		txtProportionRRA.setText(Double.toString(prop[11]));

		double[] p = controller.getLLS();
		cmbTSFuncLLS.setSelectedItem("NORMAL");
		txtServCenterLLS1.setText(Double.toString(p[0]));
		txtServCenterLLS2.setText(Double.toString(p[1]));
		txtServCenterLLS3.setText("");
		
		p = controller.getLLF();
		cmbTSFuncLLF.setSelectedItem("TRIANGULAR");
		txtServCenterLLF1.setText(Double.toString(p[0]));		
		txtServCenterLLF2.setText(Double.toString(p[1]));		
		txtServCenterLLF3.setText(Double.toString(p[2]));		
		
		p = controller.getLLA();
		cmbTSFuncLLA.setSelectedItem("UNIFORME");
		txtServCenterLLA1.setText(Double.toString(p[0]));
		txtServCenterLLA2.setText(Double.toString(p[1]));
		txtServCenterLLA3.setText("");
		
		p = controller.getLRF();
		cmbTSFuncLRF.setSelectedItem("UNIFORME");
		txtServCenterLRF1.setText(Double.toString(p[0]));
		txtServCenterLRF2.setText(Double.toString(p[1]));
		txtServCenterLRF3.setText("");
		
		p = controller.getLRS();
		cmbTSFuncLRS.setSelectedItem("NORMAL");
		txtServCenterLRS1.setText(Double.toString(p[0]));
		txtServCenterLRS2.setText(Double.toString(p[1]));
		txtServCenterLRS3.setText("");
		
		p = controller.getLRA();
		cmbTSFuncLRA.setSelectedItem("TRIANGULAR");
		txtServCenterLRA1.setText(Double.toString(p[0]));
		txtServCenterLRA2.setText(Double.toString(p[1]));
		txtServCenterLRA3.setText(Double.toString(p[2]));

		p = controller.getRLS();
		cmbTSFuncRLS.setSelectedItem("UNIFORME");
		txtServCenterRLS1.setText(Double.toString(p[0]));
		txtServCenterRLS2.setText(Double.toString(p[1]));
		txtServCenterRLS3.setText("");
		
		p = controller.getRLF();
		cmbTSFuncRLF.setSelectedItem("NORMAL");
		txtServCenterRLF1.setText(Double.toString(p[0]));
		txtServCenterRLF2.setText(Double.toString(p[1]));
		txtServCenterRLF3.setText("");

		p = controller.getRLA();
		cmbTSFuncRLA.setSelectedItem("NORMAL");
		txtServCenterRLA1.setText(Double.toString(p[0]));
		txtServCenterRLA2.setText(Double.toString(p[1]));
		txtServCenterRLA3.setText("");
		
		p = controller.getRRS();
		cmbTSFuncRRS.setSelectedItem("UNIFORME");
		txtServCenterRRS1.setText(Double.toString(p[0]));
		txtServCenterRRS2.setText(Double.toString(p[1]));
		txtServCenterRRS3.setText("");
		
		p = controller.getRRF();
		cmbTSFuncRRF.setSelectedItem("TRIANGULAR");
		txtServCenterRRF1.setText(Double.toString(p[0]));
		txtServCenterRRF2.setText(Double.toString(p[1]));
		txtServCenterRRF3.setText(Double.toString(p[2]));
		
		p = controller.getRRA();
		cmbTSFuncRRA.setSelectedItem("NORMAL");
		txtServCenterRRA1.setText(Double.toString(p[0]));
		txtServCenterRRA2.setText(Double.toString(p[1]));
		txtServCenterRRA3.setText("");
		
		txtRemoteServers.setText(Integer.toString(controller.getServerRemote()));
		txtLocalServers.setText(Integer.toString(controller.getServerLocal()));
		txtReceptionTime.setText(Double.toString(controller.getReception()));
		simulationSpeed.setText(Double.toString(controller.getRunSpeed()/100));
		maxTime.setText("");

	}
}
