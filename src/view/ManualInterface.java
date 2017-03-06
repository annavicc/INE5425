package view;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

public class ManualInterface extends JFrame {
	public ManualInterface() {
		setTitle("Manual do Usu\u00E1rio");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 930, 172);
		getContentPane().add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.setLayout(null);
		
		JLabel lblBotesIniciais = new JLabel("Bot\u00F5es Iniciais:");
		lblBotesIniciais.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblBotesIniciais.setBounds(22, 0, 127, 26);
		panel.add(lblBotesIniciais);
		
		JLabel lblConfigurarVariveis = new JLabel("Configurar Vari\u00E1veis:");
		lblConfigurarVariveis.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblConfigurarVariveis.setBounds(36, 26, 151, 34);
		panel.add(lblConfigurarVariveis);
		
		JLabel lblNewLabel = new JLabel("Clicado quando se deseja setar as vari\u00E1veis para a simula\u00E7\u00E3o.");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(170, 33, 370, 22);
		panel.add(lblNewLabel);
		
		JLabel lblIniciarSimulao = new JLabel("Iniciar Simula\u00E7\u00E3o:");
		lblIniciarSimulao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblIniciarSimulao.setBounds(37, 55, 119, 34);
		panel.add(lblIniciarSimulao);
		
		JLabel lblClicadoApenasUma = new JLabel("Clicado apenas uma vez para dar in\u00EDcio a simula\u00E7\u00E3o.");
		lblClicadoApenasUma.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblClicadoApenasUma.setBounds(153, 62, 441, 22);
		panel.add(lblClicadoApenasUma);
		
		JLabel lblPausarSimulao = new JLabel("Pausar Simula\u00E7\u00E3o:");
		lblPausarSimulao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblPausarSimulao.setBounds(36, 85, 151, 34);
		panel.add(lblPausarSimulao);
		
		JLabel lblClicadoQuandoSe = new JLabel("Clicado quando se deseja pausar a simula\u00E7\u00E3o para an\u00E1lise das estat\u00EDsticas. Clicado novamente para retomar a execu\u00E7\u00E3o.");
		lblClicadoQuandoSe.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblClicadoQuandoSe.setBounds(153, 92, 720, 22);
		panel.add(lblClicadoQuandoSe);
		
		JLabel lblTerminarSimulao = new JLabel("Terminar Simula\u00E7\u00E3o:");
		lblTerminarSimulao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTerminarSimulao.setBounds(36, 113, 151, 34);
		panel.add(lblTerminarSimulao);
		
		JLabel lblClicadoParaEncerrar = new JLabel("Clicado para encerrar a simula\u00E7\u00E3o.");
		lblClicadoParaEncerrar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblClicadoParaEncerrar.setBounds(170, 120, 208, 22);
		panel.add(lblClicadoParaEncerrar);
		
		JLabel lblSeCamposFicarem = new JLabel("Se houver campos em branco, valores default s\u00E3o assumidos.");
		lblSeCamposFicarem.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblSeCamposFicarem.setBounds(535, 33, 380, 22);
		panel.add(lblSeCamposFicarem);
		
		JLabel lblVelocidadeDaSimulao = new JLabel("Velocidade da simula\u00E7\u00E3o:");
		lblVelocidadeDaSimulao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblVelocidadeDaSimulao.setBounds(35, 141, 187, 34);
		panel.add(lblVelocidadeDaSimulao);
		
		JLabel lblControlaAVelocidade = new JLabel("Controla a velocidade da simula\u00E7\u00E3o (devagar, r\u00E1pida).");
		lblControlaAVelocidade.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblControlaAVelocidade.setBounds(198, 148, 588, 22);
		panel.add(lblControlaAVelocidade);
		
		JLabel lblGeraORelatrio = new JLabel("Gera o RELAT\u00D3RIO FINAL e o salva no local do programa.");
		lblGeraORelatrio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblGeraORelatrio.setBounds(376, 120, 354, 22);
		panel.add(lblGeraORelatrio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 170, 930, 352);
		getContentPane().add(panel_1);
		
		JLabel lblInterfaceDeEstatsticas = new JLabel("Interface de Estat\u00EDsticas:");
		lblInterfaceDeEstatsticas.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblInterfaceDeEstatsticas.setBounds(23, 0, 230, 31);
		panel_1.add(lblInterfaceDeEstatsticas);
		
		JLabel lblListaDeEventos = new JLabel("Lista de Eventos:");
		lblListaDeEventos.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblListaDeEventos.setBounds(39, 31, 151, 34);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(lblListaDeEventos);
		
		JLabel lblPainelQueDescreve = new JLabel("Painel que descreve com detalhes todas as ocorr\u00EAncias de evento durante a simula\u00E7\u00E3o de acordo at\u00E9 o instante atual.");
		lblPainelQueDescreve.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblPainelQueDescreve.setBounds(146, 38, 727, 22);
		panel_1.add(lblPainelQueDescreve);
		
		JLabel lblMensagensDoSistema = new JLabel("Mensagens do Sistema:");
		lblMensagensDoSistema.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblMensagensDoSistema.setBounds(39, 58, 151, 34);
		panel_1.add(lblMensagensDoSistema);
		
		JLabel lblTaxaMnimaMdia = new JLabel("Taxa m\u00EDnima, m\u00E9dia e m\u00E1xima das mensagens do sistema em um dado instante.");
		lblTaxaMnimaMdia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTaxaMnimaMdia.setBounds(188, 64, 494, 22);
		panel_1.add(lblTaxaMnimaMdia);
		
		JLabel lblTaxaMnimaMdia_1 = new JLabel("Taxa m\u00EDnima, m\u00E9dia e m\u00E1xima de ocupa\u00E7\u00E3o de cada um dos centros num dado instante.");
		lblTaxaMnimaMdia_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTaxaMnimaMdia_1.setBounds(240, 93, 621, 22);
		panel_1.add(lblTaxaMnimaMdia_1);
		
		JLabel lblTaxaDeOcupao = new JLabel("Taxa de Ocupa\u00E7\u00E3o dos Centros:");
		lblTaxaDeOcupao.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTaxaDeOcupao.setBounds(39, 86, 220, 34);
		panel_1.add(lblTaxaDeOcupao);
		
		JLabel lblTempoMnimoMdio = new JLabel("Tempo m\u00EDnimo, m\u00E9dio e m\u00E1ximo que mensagens levaram desde a chegada no sistema at\u00E9 sua sa\u00EDda.");
		lblTempoMnimoMdio.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTempoMnimoMdio.setBounds(261, 122, 611, 22);
		panel_1.add(lblTempoMnimoMdio);
		
		JLabel lblTempoDeTrnsito = new JLabel("Tempo de Tr\u00E2nsito das Mensagens:");
		lblTempoDeTrnsito.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoDeTrnsito.setBounds(39, 115, 236, 34);
		panel_1.add(lblTempoDeTrnsito);
		
		JLabel lblQuantidadeTotalDe = new JLabel("Quantidade total de mensagens que foram emitidas no sistema.");
		lblQuantidadeTotalDe.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblQuantidadeTotalDe.setBounds(199, 152, 494, 22);
		panel_1.add(lblQuantidadeTotalDe);
		
		JLabel lblMensagensDespachadas = new JLabel("Mensagens despachadas:");
		lblMensagensDespachadas.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblMensagensDespachadas.setBounds(39, 144, 181, 34);
		panel_1.add(lblMensagensDespachadas);
		
		JLabel lblQuantidadeDeMensagens_1 = new JLabel("Quantidade de mensagens emitidas durante a simula\u00E7\u00E3o de acordo com cada tipo (LLS, LLF, ..., RRA).");
		lblQuantidadeDeMensagens_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblQuantidadeDeMensagens_1.setBounds(269, 179, 619, 22);
		panel_1.add(lblQuantidadeDeMensagens_1);
		
		JLabel lblQuantidadeDeMensagens = new JLabel("Quantidade de mensagens por tipo:");
		lblQuantidadeDeMensagens.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblQuantidadeDeMensagens.setBounds(39, 172, 238, 34);
		panel_1.add(lblQuantidadeDeMensagens);
		
		JLabel lblTotalDeMensagens = new JLabel("Quantidade de mensagens que entraram no siistema e ainda n\u00E3o sa\u00EDram.");
		lblTotalDeMensagens.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTotalDeMensagens.setBounds(250, 208, 494, 22);
		panel_1.add(lblTotalDeMensagens);
		
		JLabel lblTotalDeMensagens_1 = new JLabel("Total de Mensagens em Tr\u00E2nsito:");
		lblTotalDeMensagens_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTotalDeMensagens_1.setBounds(39, 201, 253, 34);
		panel_1.add(lblTotalDeMensagens_1);
		
		JLabel lblQuantidadeDeMensagens_2 = new JLabel("Quantidade de mensagens que j\u00E1 sa\u00EDram do sistema.");
		lblQuantidadeDeMensagens_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblQuantidadeDeMensagens_2.setBounds(243, 239, 494, 22);
		panel_1.add(lblQuantidadeDeMensagens_2);
		
		JLabel lblTotalDeMensagens_2 = new JLabel("Total de Mensagens Finalizadas:");
		lblTotalDeMensagens_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTotalDeMensagens_2.setBounds(39, 232, 211, 34);
		panel_1.add(lblTotalDeMensagens_2);
		
		JLabel lblMostraOId = new JLabel("Mostra o ID das mensagens que est\u00E3o sendo processadas em um centro no instante atual.");
		lblMostraOId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblMostraOId.setBounds(277, 267, 598, 22);
		panel_1.add(lblMostraOId);
		
		JLabel lblMensagens = new JLabel("Mensagens processando nos Centros:");
		lblMensagens.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblMensagens.setBounds(39, 260, 242, 34);
		panel_1.add(lblMensagens);
		
		JLabel lblMostraOId_1 = new JLabel("Mostra o ID das mensagens que est\u00E3o esperando para serem processadas na fila de um centro no momento.");
		lblMostraOId_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblMostraOId_1.setBounds(243, 296, 664, 22);
		panel_1.add(lblMostraOId_1);
		
		JLabel lblFilaDoServidor = new JLabel("Fila do Servidor Remoto / Local:");
		lblFilaDoServidor.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblFilaDoServidor.setBounds(39, 289, 236, 34);
		panel_1.add(lblFilaDoServidor);
		
		JLabel lblMostraOId_2 = new JLabel("Mostra o ID e Status das mensagens que sa\u00EDram do sistema.");
		lblMostraOId_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblMostraOId_2.setBounds(201, 324, 494, 22);
		panel_1.add(lblMostraOId_2);
		
		JLabel lblMensagensCompletadas = new JLabel("Mensagens Completadas:");
		lblMensagensCompletadas.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblMensagensCompletadas.setBounds(40, 317, 181, 34);
		panel_1.add(lblMensagensCompletadas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 522, 930, 367);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		getContentPane().add(panel_2);
		
		JLabel lblConfiguraoDeVariveis = new JLabel("Configura\u00E7\u00E3o de Vari\u00E1veis:");
		lblConfiguraoDeVariveis.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblConfiguraoDeVariveis.setBounds(25, 0, 271, 26);
		panel_2.add(lblConfiguraoDeVariveis);
		
		JLabel lblTec = new JLabel("TEC (s):");
		lblTec.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTec.setBounds(36, 30, 55, 34);
		panel_2.add(lblTec);
		
		JLabel lblTempoEntreChegadas = new JLabel("Tempo entre chegadas para mensagens do tipo Local e Remoto. Valor \u00E9 usado em c\u00E1lculo de uma exponencial.");
		lblTempoEntreChegadas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTempoEntreChegadas.setBounds(88, 37, 703, 22);
		panel_2.add(lblTempoEntreChegadas);
		
		JLabel lblVolumeDeTrfego = new JLabel("Volume de Tr\u00E1fego (%):");
		lblVolumeDeTrfego.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblVolumeDeTrfego.setBounds(37, 59, 211, 34);
		panel_2.add(lblVolumeDeTrfego);
		
		JLabel lblVolumeDeTrfego_1 = new JLabel("Volume de tr\u00E1fego esperado para cada tipo de dire\u00E7\u00E3o (LL, LR, RL, RR).");
		lblVolumeDeTrfego_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblVolumeDeTrfego_1.setBounds(189, 66, 441, 22);
		panel_2.add(lblVolumeDeTrfego_1);
		
		JLabel lblTaxaEsperadaPara = new JLabel("Taxa esperada para sucesso, falha e adiamento para cada tipo de dire\u00E7\u00E3o (LL, LR, RL, RR) de mensagem.");
		lblTaxaEsperadaPara.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTaxaEsperadaPara.setBounds(146, 94, 720, 22);
		panel_2.add(lblTaxaEsperadaPara);
		
		JLabel lblPropores = new JLabel("Propor\u00E7\u00F5es (%):");
		lblPropores.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblPropores.setBounds(36, 87, 151, 34);
		panel_2.add(lblPropores);
		
		JLabel lblNmeroDeServidores = new JLabel("N\u00FAmero de Servidores Local / Remoto:");
		lblNmeroDeServidores.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNmeroDeServidores.setBounds(36, 115, 266, 34);
		panel_2.add(lblNmeroDeServidores);
		
		JLabel lblNmeroDeServidores_1 = new JLabel("N\u00FAmero de servidores que processam mensagens em cada centro.");
		lblNmeroDeServidores_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNmeroDeServidores_1.setBounds(282, 122, 588, 22);
		panel_2.add(lblNmeroDeServidores_1);
		
		JLabel lblTempoDeRecepo = new JLabel("Tempo de Recep\u00E7\u00E3o (s):");
		lblTempoDeRecepo.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoDeRecepo.setBounds(36, 146, 165, 34);
		panel_2.add(lblTempoDeRecepo);
		
		JLabel lblTempoParaProcessamento = new JLabel("Tempo para processamento no centro de recep\u00E7\u00E3o.");
		lblTempoParaProcessamento.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTempoParaProcessamento.setBounds(190, 153, 588, 22);
		panel_2.add(lblTempoParaProcessamento);
		
		JLabel lblTempoDeServio = new JLabel("Tempos de Servi\u00E7o:");
		lblTempoDeServio.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoDeServio.setBounds(36, 268, 151, 34);
		panel_2.add(lblTempoDeServio);
		
		JLabel lblEscolheseOTipo = new JLabel("Escolhe-se o tipo de fun\u00E7\u00E3o dispon\u00EDvel para calcular o tempo de servi\u00E7o nos centros (de acordo com o tipo de mensagem).");
		lblEscolheseOTipo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblEscolheseOTipo.setBounds(161, 275, 742, 22);
		panel_2.add(lblEscolheseOTipo);
		
		JLabel lblCamposEm = new JLabel("* Campos deixados em branco assumem valores default.");
		lblCamposEm.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblCamposEm.setBounds(36, 296, 446, 34);
		panel_2.add(lblCamposEm);
		
		JLabel lblVelocidadeDaSimulao_1 = new JLabel("Velocidade da simula\u00E7\u00E3o (s):");
		lblVelocidadeDaSimulao_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblVelocidadeDaSimulao_1.setBounds(35, 177, 213, 34);
		panel_2.add(lblVelocidadeDaSimulao_1);
		
		JLabel lblVelocidadeParaA = new JLabel("Velocidade para a execu\u00E7\u00E3o da simula\u00E7\u00E3o.");
		lblVelocidadeParaA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblVelocidadeParaA.setBounds(223, 184, 271, 22);
		panel_2.add(lblVelocidadeParaA);
		
		JLabel lblTempoLimiteDa = new JLabel("Tempo limite da mensagem no sistema (s):");
		lblTempoLimiteDa.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoLimiteDa.setBounds(36, 209, 301, 34);
		panel_2.add(lblTempoLimiteDa);
		
		JLabel lblTempoMximoDe = new JLabel("Tempo m\u00E1ximo de perman\u00EAncia da mensagem no sistema antes de expirar.");
		lblTempoMximoDe.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTempoMximoDe.setBounds(309, 216, 588, 22);
		panel_2.add(lblTempoMximoDe);
		
		JLabel lblTempoMximoDe_1 = new JLabel("Tempo m\u00E1ximo de simula\u00E7\u00E3o (s):");
		lblTempoMximoDe_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTempoMximoDe_1.setBounds(36, 238, 238, 34);
		panel_2.add(lblTempoMximoDe_1);
		
		JLabel lblTempoTotalQue = new JLabel("Tempo total que se quer realizar a simula\u00E7\u00E3o.");
		lblTempoTotalQue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTempoTotalQue.setBounds(249, 245, 271, 22);
		panel_2.add(lblTempoTotalQue);
		
		JLabel lblDeixadoEmBranco = new JLabel("Deixado em branco caso se queira controlar dinamicamente.");
		lblDeixadoEmBranco.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDeixadoEmBranco.setBounds(520, 244, 390, 22);
		panel_2.add(lblDeixadoEmBranco);
		
		JLabel lblAteno = new JLabel("* ATEN\u00C7\u00C3O: a simula\u00E7\u00E3o \u00E9 realizada em SEGUNDOS, por\u00E9m os eventos s\u00E3o gerados em cent\u00E9simos de segundos para melhor monitoramento!");
		lblAteno.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblAteno.setBounds(36, 325, 894, 34);
		panel_2.add(lblAteno);
	}
}
