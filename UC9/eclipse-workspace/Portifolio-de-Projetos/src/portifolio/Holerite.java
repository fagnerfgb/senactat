package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Holerite extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSalarioBruto;
	private JTextField txtHorasTrabalhadasMes;
	private JTextField txtInss;
	private JTextField txtIrpf;
	private JTextField txtProventoValeRefeicao;
	private JTextField txtDescontoValeRefeicao;
	private JTextField txtProventoValeAlimentacao;
	private JTextField txtDescontoValeAlimentacao;
	private JLabel lblAssistenciaMedica;
	private JTextField txtAssistenciaMedica;
	private JLabel lblAssistenciaOdontologica;
	private JTextField txtAssistenciaOdontologica;
	private JTextField txtHoraTrabalhada;
	private JTextField txtSalarioLiquido;
	private JLabel lblDependentes;
	private JTextField txtDependentes;
	private JTextField txtDiasTrabalhadosMes;
	private JTextField txtHoraExtra50;
	private JTextField txtHoraExtra100;
	private JLabel lblPensao;
	private JTextField txtProventoHoraExtra50;
	private JTextField txtProventoHoraExtra100;
	private JTextField txtTotalDeDescontos;
	private JLabel lblTotalDiarioValeTransporte;
	private JTextField txtTotalDiarioValeTransporte;
	private JTextField txtTotalMensalValeTransporte;
	private JTextField txtDescontoValeTransporte;
	private JTextField txtPensao;
	private JCheckBox chckbxValeTransporte;
	private JCheckBox chckbxPensao;
	private JCheckBox chckbxAssistenciaMedica;
	private JCheckBox chckbxAssistenciaOdontologica;
	private JTextField txtFgts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Holerite dialog = new Holerite();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Holerite() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Holerite.class.getResource("/img/salary-48.png")));
		setResizable(false);
		setModal(true);
		setTitle("Holerite");
		setBounds(100, 100, 504, 700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblSalarioBruto = new JLabel("Sal\u00E1rio Bruto");
		lblSalarioBruto.setBounds(10, 39, 88, 14);
		getContentPane().add(lblSalarioBruto);

		JLabel lblHorasTrabalhadasMes = new JLabel("Horas trabalhadas no m\u00EAs");
		lblHorasTrabalhadasMes.setBounds(10, 64, 164, 14);
		getContentPane().add(lblHorasTrabalhadasMes);

		JLabel lblInss = new JLabel("INSS");
		lblInss.setBounds(10, 468, 88, 14);
		getContentPane().add(lblInss);

		JLabel lblIrpf = new JLabel("Imposto de Renda");
		lblIrpf.setBounds(10, 493, 164, 14);
		getContentPane().add(lblIrpf);

		JLabel lblDescVr = new JLabel("Vale Refei\u00E7\u00E3o");
		lblDescVr.setBounds(10, 543, 136, 14);
		getContentPane().add(lblDescVr);

		JLabel lblValeAlimentacao = new JLabel("Vale Alimenta\u00E7\u00E3o");
		lblValeAlimentacao.setBounds(10, 568, 136, 14);
		getContentPane().add(lblValeAlimentacao);

		JLabel lblProvento = new JLabel("Provento");
		lblProvento.setBounds(274, 8, 70, 14);
		getContentPane().add(lblProvento);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(395, 8, 70, 14);
		getContentPane().add(lblDesconto);

		txtSalarioBruto = new JTextField();
		txtSalarioBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalarioBruto.setBounds(240, 33, 115, 20);
		getContentPane().add(txtSalarioBruto);
		txtSalarioBruto.setColumns(10);

		txtHorasTrabalhadasMes = new JTextField();
		txtHorasTrabalhadasMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtHorasTrabalhadasMes.setBounds(186, 58, 50, 20);
		getContentPane().add(txtHorasTrabalhadasMes);
		txtHorasTrabalhadasMes.setColumns(10);

		txtInss = new JTextField();
		txtInss.setFocusable(false);
		txtInss.setHorizontalAlignment(SwingConstants.CENTER);
		txtInss.setEditable(false);
		txtInss.setBounds(360, 462, 115, 20);
		getContentPane().add(txtInss);
		txtInss.setColumns(10);

		txtIrpf = new JTextField();
		txtIrpf.setFocusable(false);
		txtIrpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtIrpf.setEditable(false);
		txtIrpf.setBounds(360, 487, 115, 20);
		getContentPane().add(txtIrpf);
		txtIrpf.setColumns(10);

		txtProventoValeRefeicao = new JTextField();
		txtProventoValeRefeicao.setFocusable(false);
		txtProventoValeRefeicao.setHorizontalAlignment(SwingConstants.CENTER);
		txtProventoValeRefeicao.setEditable(false);
		txtProventoValeRefeicao.setBounds(240, 537, 115, 20);
		getContentPane().add(txtProventoValeRefeicao);
		txtProventoValeRefeicao.setColumns(10);

		txtDescontoValeRefeicao = new JTextField();
		txtDescontoValeRefeicao.setFocusable(false);
		txtDescontoValeRefeicao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescontoValeRefeicao.setEditable(false);
		txtDescontoValeRefeicao.setBounds(360, 537, 115, 20);
		getContentPane().add(txtDescontoValeRefeicao);
		txtDescontoValeRefeicao.setColumns(10);

		txtProventoValeAlimentacao = new JTextField();
		txtProventoValeAlimentacao.setFocusable(false);
		txtProventoValeAlimentacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtProventoValeAlimentacao.setEditable(false);
		txtProventoValeAlimentacao.setBounds(240, 562, 115, 20);
		getContentPane().add(txtProventoValeAlimentacao);
		txtProventoValeAlimentacao.setColumns(10);

		txtDescontoValeAlimentacao = new JTextField();
		txtDescontoValeAlimentacao.setFocusable(false);
		txtDescontoValeAlimentacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescontoValeAlimentacao.setEditable(false);
		txtDescontoValeAlimentacao.setBounds(360, 562, 115, 20);
		getContentPane().add(txtDescontoValeAlimentacao);
		txtDescontoValeAlimentacao.setColumns(10);

		lblAssistenciaMedica = new JLabel("Assist\u00EAncia M\u00E9dica");
		lblAssistenciaMedica.setBounds(10, 270, 136, 14);
		getContentPane().add(lblAssistenciaMedica);

		txtAssistenciaMedica = new JTextField();
		txtAssistenciaMedica.setEnabled(false);
		txtAssistenciaMedica.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssistenciaMedica.setBounds(360, 264, 115, 20);
		getContentPane().add(txtAssistenciaMedica);
		txtAssistenciaMedica.setColumns(10);

		lblAssistenciaOdontologica = new JLabel("Assist\u00EAncia Odontol\u00F3gica");
		lblAssistenciaOdontologica.setBounds(10, 295, 164, 14);
		getContentPane().add(lblAssistenciaOdontologica);

		txtAssistenciaOdontologica = new JTextField();
		txtAssistenciaOdontologica.setEnabled(false);
		txtAssistenciaOdontologica.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssistenciaOdontologica.setBounds(360, 289, 115, 20);
		getContentPane().add(txtAssistenciaOdontologica);
		txtAssistenciaOdontologica.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setIcon(new ImageIcon(Holerite.class.getResource("/img/holerite-64.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setBounds(172, 393, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(Holerite.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(252, 393, 64, 64);
		getContentPane().add(btnLimpar);

		JLabel lblHoraTrabalhada = new JLabel("Valor da Hora Trabalhada");
		lblHoraTrabalhada.setBounds(10, 593, 186, 14);
		getContentPane().add(lblHoraTrabalhada);

		JLabel lblSalarioLiquido = new JLabel("Sal\u00E1rio L\u00EDquido");
		lblSalarioLiquido.setBounds(10, 618, 115, 14);
		getContentPane().add(lblSalarioLiquido);

		txtHoraTrabalhada = new JTextField();
		txtHoraTrabalhada.setFocusable(false);
		txtHoraTrabalhada.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraTrabalhada.setEditable(false);
		txtHoraTrabalhada.setBounds(240, 587, 115, 20);
		getContentPane().add(txtHoraTrabalhada);
		txtHoraTrabalhada.setColumns(10);

		txtSalarioLiquido = new JTextField();
		txtSalarioLiquido.setFocusable(false);
		txtSalarioLiquido.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalarioLiquido.setEditable(false);
		txtSalarioLiquido.setBounds(240, 612, 115, 20);
		getContentPane().add(txtSalarioLiquido);
		txtSalarioLiquido.setColumns(10);

		lblDependentes = new JLabel("Quantidade de dependentes");
		lblDependentes.setBounds(10, 114, 164, 14);
		getContentPane().add(lblDependentes);

		txtDependentes = new JTextField();
		txtDependentes.setHorizontalAlignment(SwingConstants.CENTER);
		txtDependentes.setBounds(186, 108, 50, 20);
		getContentPane().add(txtDependentes);
		txtDependentes.setColumns(10);

		JLabel lblDiasTrabalhadosMes = new JLabel("Dias trabalhados no m\u00EAs");
		lblDiasTrabalhadosMes.setBounds(10, 89, 150, 14);
		getContentPane().add(lblDiasTrabalhadosMes);

		txtDiasTrabalhadosMes = new JTextField();
		txtDiasTrabalhadosMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasTrabalhadosMes.setBounds(186, 83, 50, 20);
		getContentPane().add(txtDiasTrabalhadosMes);
		txtDiasTrabalhadosMes.setColumns(10);

		JLabel lblValeTransporte = new JLabel("Vale transporte ?");
		lblValeTransporte.setBounds(10, 192, 136, 14);
		getContentPane().add(lblValeTransporte);

		JLabel lblHoraExtra50 = new JLabel("Horas extras 50% no m\u00EAs");
		lblHoraExtra50.setBounds(10, 139, 164, 14);
		getContentPane().add(lblHoraExtra50);

		JLabel lblHoraExtra100 = new JLabel("Horas extras 100% no m\u00EAs");
		lblHoraExtra100.setBounds(10, 164, 164, 14);
		getContentPane().add(lblHoraExtra100);

		txtHoraExtra50 = new JTextField();
		txtHoraExtra50.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraExtra50.setBounds(186, 133, 50, 20);
		getContentPane().add(txtHoraExtra50);
		txtHoraExtra50.setColumns(10);

		txtHoraExtra100 = new JTextField();
		txtHoraExtra100.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraExtra100.setBounds(186, 158, 50, 20);
		getContentPane().add(txtHoraExtra100);
		txtHoraExtra100.setColumns(10);

		lblPensao = new JLabel("Paga pens\u00E3o aliment\u00EDcia ?");
		lblPensao.setBounds(10, 245, 164, 14);
		getContentPane().add(lblPensao);

		txtProventoHoraExtra50 = new JTextField();
		txtProventoHoraExtra50.setFocusable(false);
		txtProventoHoraExtra50.setHorizontalAlignment(SwingConstants.CENTER);
		txtProventoHoraExtra50.setEditable(false);
		txtProventoHoraExtra50.setBounds(240, 133, 115, 20);
		getContentPane().add(txtProventoHoraExtra50);
		txtProventoHoraExtra50.setColumns(10);

		txtProventoHoraExtra100 = new JTextField();
		txtProventoHoraExtra100.setFocusable(false);
		txtProventoHoraExtra100.setEditable(false);
		txtProventoHoraExtra100.setHorizontalAlignment(SwingConstants.CENTER);
		txtProventoHoraExtra100.setBounds(240, 158, 115, 20);
		getContentPane().add(txtProventoHoraExtra100);
		txtProventoHoraExtra100.setColumns(10);

		txtTotalDeDescontos = new JTextField();
		txtTotalDeDescontos.setFocusable(false);
		txtTotalDeDescontos.setEditable(false);
		txtTotalDeDescontos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDeDescontos.setBounds(360, 612, 115, 20);
		getContentPane().add(txtTotalDeDescontos);
		txtTotalDeDescontos.setColumns(10);

		lblTotalDiarioValeTransporte = new JLabel("Total por dia");
		lblTotalDiarioValeTransporte.setBounds(10, 220, 70, 14);
		getContentPane().add(lblTotalDiarioValeTransporte);

		txtTotalDiarioValeTransporte = new JTextField();
		txtTotalDiarioValeTransporte.setEnabled(false);
		txtTotalDiarioValeTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDiarioValeTransporte.setBounds(186, 214, 50, 20);
		getContentPane().add(txtTotalDiarioValeTransporte);
		txtTotalDiarioValeTransporte.setColumns(10);

		txtTotalMensalValeTransporte = new JTextField();
		txtTotalMensalValeTransporte.setFocusable(false);
		txtTotalMensalValeTransporte.setEditable(false);
		txtTotalMensalValeTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalMensalValeTransporte.setBounds(240, 214, 115, 20);
		getContentPane().add(txtTotalMensalValeTransporte);
		txtTotalMensalValeTransporte.setColumns(10);

		txtDescontoValeTransporte = new JTextField();
		txtDescontoValeTransporte.setFocusable(false);
		txtDescontoValeTransporte.setEditable(false);
		txtDescontoValeTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescontoValeTransporte.setBounds(360, 214, 115, 20);
		getContentPane().add(txtDescontoValeTransporte);
		txtDescontoValeTransporte.setColumns(10);

		txtPensao = new JTextField();
		txtPensao.setEnabled(false);
		txtPensao.setHorizontalAlignment(SwingConstants.CENTER);
		txtPensao.setBounds(360, 239, 115, 20);
		getContentPane().add(txtPensao);
		txtPensao.setColumns(10);
		chckbxValeTransporte = new JCheckBox("Sim");
		chckbxValeTransporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxValeTransporte.isSelected()) {
					txtTotalDiarioValeTransporte.setEnabled(true);
					txtTotalDiarioValeTransporte.requestFocus();
				} else {
					txtTotalDiarioValeTransporte.setEnabled(false);

				}
			}
		});
		chckbxValeTransporte.setBounds(186, 188, 50, 23);
		getContentPane().add(chckbxValeTransporte);

		chckbxPensao = new JCheckBox("Sim");
		chckbxPensao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxPensao.isSelected()) {
					txtPensao.setEnabled(true);
					txtPensao.requestFocus();

				} else {
					txtPensao.setEnabled(false);
				}
			}

		});
		chckbxPensao.setBounds(186, 241, 50, 23);
		getContentPane().add(chckbxPensao);

		chckbxAssistenciaMedica = new JCheckBox("Sim");
		chckbxAssistenciaMedica.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxAssistenciaMedica.isSelected()) {
					txtAssistenciaMedica.setEnabled(true);
					txtAssistenciaMedica.requestFocus();
				} else {
					txtAssistenciaMedica.setEnabled(false);
				}
			}
		});
		chckbxAssistenciaMedica.setBounds(186, 266, 50, 23);
		getContentPane().add(chckbxAssistenciaMedica);

		chckbxAssistenciaOdontologica = new JCheckBox("Sim");
		chckbxAssistenciaOdontologica.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxAssistenciaOdontologica.isSelected()) {
					txtAssistenciaOdontologica.setEnabled(true);
					txtAssistenciaOdontologica.requestFocus();

				} else {
					txtAssistenciaOdontologica.setEnabled(false);
				}
			}
		});
		chckbxAssistenciaOdontologica.setBounds(186, 291, 50, 23);
		getContentPane().add(chckbxAssistenciaOdontologica);

		JLabel lblNewLabel = new JLabel("FGTS");
		lblNewLabel.setBounds(10, 518, 88, 14);
		getContentPane().add(lblNewLabel);

		txtFgts = new JTextField();
		txtFgts.setFocusable(false);
		txtFgts.setHorizontalAlignment(SwingConstants.CENTER);
		txtFgts.setEditable(false);
		txtFgts.setBounds(240, 512, 115, 20);
		getContentPane().add(txtFgts);

		/********************
		 **** VALIDAÇÕES ****
		 *********************/

		// Validação Salário Bruto
		RestrictedTextField salarioBruto = new RestrictedTextField(txtSalarioBruto, "0123456789.");
		salarioBruto.setLimit(12);

		// Validação Horas Trabalhadas Mes
		RestrictedTextField horasTrabalhadasMes = new RestrictedTextField(txtHorasTrabalhadasMes, "0123456789.");
		horasTrabalhadasMes.setLimit(6);

		// Validação Dependentes
		RestrictedTextField quantidadeDeDependentes = new RestrictedTextField(txtDependentes, "0123456789");
		quantidadeDeDependentes.setLimit(2);

		// Validação Dias trabalhados no mês
		RestrictedTextField diasTrabalhadosMes = new RestrictedTextField(txtDiasTrabalhadosMes, "0123456789");
		diasTrabalhadosMes.setLimit(2);

		// Validação Horas Extras 50%
		RestrictedTextField horaExtra50 = new RestrictedTextField(txtHoraExtra50, "0123456789.");
		horaExtra50.setLimit(4);

		// Validação Horas Extras 100%
		RestrictedTextField horaExtra100 = new RestrictedTextField(txtHoraExtra100, "0123456789.");
		horaExtra100.setLimit(4);

		// Validação Assistencia Medica
		RestrictedTextField assistenciaMedica = new RestrictedTextField(txtAssistenciaMedica, "0123456789.");
		assistenciaMedica.setLimit(12);

		// Validação Assistencia Odontologica
		RestrictedTextField assistenciaOdontologica = new RestrictedTextField(txtAssistenciaOdontologica,
				"0123456789.");
		assistenciaOdontologica.setLimit(12);

		// Validação Vale Transporte
		RestrictedTextField totalDiarioValeTransporte = new RestrictedTextField(txtTotalDiarioValeTransporte,
				"0123456789.");
		totalDiarioValeTransporte.setLimit(6);

		// Validação Pensao
		RestrictedTextField pensao = new RestrictedTextField(txtPensao, "0123456789.");
		pensao.setLimit(12);

	}// Fim do Construtor

	/*************************
	 **** METODO CALCULAR ****
	 *************************/

	void calcular() {

		/*********************************
		 **** DECLARACAO DE VARIAVEIS ****
		 **********************************/

		/**************
		 **** INSS ****
		 ***************/
		double inss1, inss2, inss3, inss4, inssSoma;
		double faixa1TetoInss = 1212.0;
		double faixa2PisoInss = 1212.01;
		double faixa2TetoInss = 2427.35;
		double faixa3PisoInss = 2427.36;
		double faixa3TetoInss = 3641.03;
		double faixa4PisoInss = 3641.04;
		double faixa4TetoInss = 7087.22;
		double aliquotaFaixa1Inss = 0.075;
		double aliquotaFaixa2Inss = 0.09;
		double aliquotaFaixa3Inss = 0.12;
		double aliquotaFaixa4Inss = 0.14;
		double diferencaFaixa2Inss = faixa2TetoInss - faixa2PisoInss;
		double diferencaFaixa3Inss = faixa3TetoInss - faixa3PisoInss;
		double diferencaFaixa4Inss = faixa4TetoInss - faixa4PisoInss;

		/**************
		 **** IRPF ****
		 ***************/
		double irpf;
		double faixa1TetoIrpf = 1903.98;
		double faixa2PisoIrpf = 1903.99;
		double faixa2TetoIrpf = 2826.65;
		double faixa3PisoIrpf = 2826.66;
		double faixa3TetoIrpf = 3751.05;
		double faixa4PisoIrpf = 3751.06;
		double faixa4TetoIrpf = 4664.68;
		double aliquotaFaixa2Irpf = 0.075;
		double aliquotaFaixa3Irpf = 0.15;
		double aliquotaFaixa4Irpf = 0.225;
		double aliquotaFaixa5Irpf = 0.275;
		double deducaoFaixa1Irpf = 0.0;
		double deducaoFaixa2Irpf = 142.8;
		double deducaoFaixa3Irpf = 354.80;
		double deducaoFaixa4Irpf = 636.13;
		double deducaoFaixa5Irpf = 869.36;

		/********************
		 **** BENEFICIOS ****
		 *********************/
		double proventoVr, descontoVr, descontoVa;
		double assistenciaMedica, assistenciaOdontologica;
		double totalDiarioValeTransporte, TotalMensalValeTransporte, descontoValeTransporte;
		double valorVr = 52.5;
		double valorVa = 300.0;
		double faixa1PisoVaVr = 1783.62;
		double faixa1TetoVaVr = faixa1PisoVaVr * 1.5;
		// double faixa2Piso = faixa1PisoVaVr * 1.51;
		double faixa2TetoVaVr = faixa1PisoVaVr * 2.5;
		// double faixa3Piso = faixa1PisoVaVr * 2.51;
		double faixa3TetoVaVr = faixa1PisoVaVr * 5;
		// double faixa4Piso = faixa1PisoVaVr * 5.1;
		// double faixa4Teto = faixa1PisoVaVr * 7.5;
		// double faixa5Piso = faixa1PisoVaVr * 7.51;
		// double faixa5Teto = faixa1PisoVaVr * 10;
		// double faixa6Piso = faixa1PisoVaVr * 10.1;

		double aliquotaFaixa1Vr = 0.002;
		double aliquotaFaixa2Vr = 0.08;
		double aliquotaFaixa3Vr = 0.125;
		double aliquotaFaixa4Vr = 0.17;
		double aliquotaFaixa1Va = 0.002;
		double aliquotaFaixa2Va = 0.06;
		double aliquotaFaixa3Va = 0.14;
		double aliquotaFaixa4Va = 0.19;

		/**
		 * double amCompacto = 470.30; double amEfetivo = 562.25; double amCompleto =
		 * 633.32; double amSuperior = 721.12;
		 * 
		 * double aliquotaFaixa1AmTitular = 0.02; double aliquotaFaixa2AmTitular =
		 * 0.045; double aliquotaFaixa3AmTitular = 0.07; double aliquotaFaixa4AmTitular
		 * = 0.09; double aliquotaFaixa5AmTitular = 0.145; double
		 * aliquotaFaixa6AmTitular = 0.195; double aliquotaFaixa1AmFilho = 0.025; double
		 * aliquotaFaixa2AmFilho = 0.05; double aliquotaFaixa3AmFilho = 0.075; double
		 * aliquotaFaixa4AmFilho = 0.1; double aliquotaFaixa5AmFilho = 0.15; double
		 * aliquotaFaixa6AmFilho = 0.20; double aliquotaFaixa1AmConjuge = 0.2; double
		 * aliquotaFaixa2AmConjuge = 0.3; double aliquotaFaixa3AmConjuge = 0.4; double
		 * aliquotaFaixa4AmConjuge = 0.6; double aliquotaFaixa5AmConjuge = 0.8; double
		 * aliquotaFaixa6AmConjuge = 1; double aliquotaFaixa1Ao = 0.1; double
		 * aliquotaFaixa2Ao = 0.2; double aliquotaFaixa3Ao = 0.35; double
		 * aliquotaFaixa4Ao = 0.5; double aliquotaFaixa5Ao = 0.6;
		 **/

		double aliquotaFgts = 0.08;
		double proventoFgts;

		/*****************
		 **** SALARIO ****
		 *****************/
		double salarioBruto, salarioLiquido, totalDeDescontos, baseDeCalculo;

		/*********************
		 **** DEPENDENTES ****
		 *********************/
		double valorPorDependente = 189.59;
		int quantidadeDeDependentes, diasTrabalhadosMes;

		/**********************
		 **** HORAS EXTRAS ****
		 **********************/
		double horaExtra50, totalHoraExtra50, horaExtra100, totalHoraExtra100;

		/***************************
		 **** HORAS TRABALHADAS ****
		 ***************************/
		double horasTrabalhadasMes, valorHoraTrabalhada;

		/****************************
		 **** PENSAO ALIMENTICIA ****
		 ****************************/
		double pensao;

		/**************************************
		 **** FORMATACAO DE CASAS DECIMAIS ****
		 ***************************************/
		DecimalFormat formatador = new DecimalFormat("R$ 0.00");

		/*************************************
		 **** NAO DEIXAR CAMPOS EM BRANCO ****
		 **************************************/
		if (txtSalarioBruto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o salário bruto");
			txtSalarioBruto.requestFocus();
		} else if (txtHorasTrabalhadasMes.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o total de horas trabalhadas no mês");
			txtHorasTrabalhadasMes.requestFocus();
		} else if (txtDiasTrabalhadosMes.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de dias trabalhados no mês");
			txtDiasTrabalhadosMes.requestFocus();
		} else if (txtDependentes.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de dependentes");
			txtDependentes.requestFocus();
		} else if (txtHoraExtra50.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade horas extras 50% realizadas no mês");
			txtHoraExtra50.requestFocus();
		} else if (txtHoraExtra100.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade horas extras 100% realizadas no mês");
			txtHoraExtra100.requestFocus();
		} else if (chckbxValeTransporte.isSelected() && txtTotalDiarioValeTransporte.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor total diário gasto com transporte");
			txtTotalDiarioValeTransporte.requestFocus();
		} else if (chckbxPensao.isSelected() && txtPensao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor pago com pensão alimentícia");
			txtPensao.requestFocus();
		} else if (chckbxAssistenciaMedica.isSelected() && txtAssistenciaMedica.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor pago para utilizar a assistência médica");
			txtAssistenciaMedica.requestFocus();
		} else if (chckbxAssistenciaOdontologica.isSelected() && txtAssistenciaOdontologica.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor pago para utilizar a assistência odontológica");
			txtAssistenciaOdontologica.requestFocus();
		} else {
			/**************************
			 **** CODIGO PRINCIPAL ****
			 ***************************/

			/***********************************************************************
			 **** CASO O CHECKBOX NAO SEJA MARCADO, ATRIBUI O PARA O JTEXTFIELD ****
			 ***********************************************************************/

			if (txtTotalDiarioValeTransporte.getText().isEmpty()) {
				txtTotalDiarioValeTransporte.setText(String.valueOf(0));
			}

			if (txtAssistenciaMedica.getText().isEmpty()) {
				txtAssistenciaMedica.setText(String.valueOf(0));
			}
			if (txtAssistenciaOdontologica.getText().isEmpty()) {
				txtAssistenciaOdontologica.setText(String.valueOf(0));
			}
			if (txtPensao.getText().isEmpty()) {
				txtPensao.setText(String.valueOf(0));
			}

			/*****************
			 **** ENTRADA ****
			 ******************/
			salarioBruto = Double.parseDouble(txtSalarioBruto.getText());
			horasTrabalhadasMes = Double.parseDouble(txtHorasTrabalhadasMes.getText());
			quantidadeDeDependentes = Integer.parseInt(txtDependentes.getText());
			diasTrabalhadosMes = Integer.parseInt(txtDiasTrabalhadosMes.getText());
			horaExtra50 = Double.parseDouble(txtHoraExtra50.getText());
			horaExtra100 = Double.parseDouble(txtHoraExtra100.getText());
			assistenciaMedica = Double.parseDouble(txtAssistenciaMedica.getText());
			assistenciaOdontologica = Double.parseDouble(txtAssistenciaOdontologica.getText());
			totalDiarioValeTransporte = Double.parseDouble(txtTotalDiarioValeTransporte.getText());
			pensao = Double.parseDouble(txtPensao.getText());

			/************************************
			 **** CALCULO DA HORA TRABALHADA ****
			 *************************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			valorHoraTrabalhada = salarioBruto / horasTrabalhadasMes;

			/***************
			 **** SAIDA ****
			 ****************/
			txtHoraTrabalhada.setText(String.valueOf(formatador.format(valorHoraTrabalhada)));

			// Horas Extras
			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			totalHoraExtra50 = horaExtra50 * valorHoraTrabalhada * 1.5;
			totalHoraExtra100 = horaExtra100 * valorHoraTrabalhada * 2;
			/***************
			 **** SAIDA ****
			 ****************/
			txtProventoHoraExtra50.setText(String.valueOf(formatador.format(totalHoraExtra50)));
			txtProventoHoraExtra100.setText(String.valueOf(formatador.format(totalHoraExtra100)));

			/*******************************************
			 **** FIM DO CALCULO DA HORA TRABALHADA ****
			 *******************************************/

			/*************************
			 **** CALCULO DO INSS ****
			 *************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			if (salarioBruto <= faixa1TetoInss) {
				inssSoma = salarioBruto * aliquotaFaixa1Inss;
			} else if (salarioBruto >= faixa2PisoInss && salarioBruto <= faixa2TetoInss) {
				inss1 = faixa1TetoInss * aliquotaFaixa1Inss;
				inss2 = (salarioBruto - faixa1TetoInss) * aliquotaFaixa2Inss;
				inssSoma = inss1 + inss2;
			} else if (salarioBruto >= faixa3PisoInss && salarioBruto <= faixa3TetoInss) {
				inss1 = faixa1TetoInss * aliquotaFaixa1Inss;
				inss2 = diferencaFaixa2Inss * aliquotaFaixa2Inss;
				inss3 = (salarioBruto - faixa1TetoInss - diferencaFaixa2Inss) * aliquotaFaixa3Inss;
				inssSoma = inss1 + inss2 + inss3;

			} else {
				inss1 = faixa1TetoInss * aliquotaFaixa1Inss;
				inss2 = diferencaFaixa2Inss * aliquotaFaixa2Inss;
				inss3 = diferencaFaixa3Inss * aliquotaFaixa3Inss;
				inssSoma = inss1 + inss2 + inss3;
				if (salarioBruto - faixa1TetoInss - diferencaFaixa2Inss - diferencaFaixa3Inss >= diferencaFaixa4Inss) {
					inss4 = diferencaFaixa4Inss * aliquotaFaixa4Inss;
				} else {
					inss4 = (salarioBruto - faixa1TetoInss - diferencaFaixa2Inss - diferencaFaixa3Inss)
							* aliquotaFaixa4Inss;
				}
				inssSoma = inss1 + inss2 + inss3 + inss4;

			}
			/***************
			 **** SAIDA ****
			 ****************/
			txtInss.setText(String.valueOf(formatador.format(inssSoma)));

			/********************************
			 **** FIM DO CALCULO DO INSS ****
			 ********************************/

			/*********************************
			 **** CALCULO VALE TRANSPORTE ****
			 *********************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			// if (txtTotalDiarioValeTransporte.getText().isEmpty()) {
			// totalDiarioValeTransporte = 0.0;
			// }

			TotalMensalValeTransporte = totalDiarioValeTransporte * diasTrabalhadosMes;

			/***************
			 **** SAIDA ****
			 ****************/
			if (salarioBruto * 0.06 > TotalMensalValeTransporte) {
				descontoValeTransporte = TotalMensalValeTransporte;
			} else {
				descontoValeTransporte = salarioBruto * 0.06;
			}
			txtDescontoValeTransporte.setText(String.valueOf(formatador.format(descontoValeTransporte)));
			txtTotalMensalValeTransporte.setText(String.valueOf(formatador.format(TotalMensalValeTransporte)));

			/****************************************
			 **** FIM DO CALCULO VALE TRANSPORTE ****
			 ****************************************/

			/*************************************
			 **** CALCULO DO IMPOSTO DE RENDA ****
			 *************************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			baseDeCalculo = salarioBruto + totalHoraExtra50 + totalHoraExtra100;
			if (baseDeCalculo <= faixa1TetoIrpf) {
				irpf = deducaoFaixa1Irpf;
			} else if (baseDeCalculo >= faixa2PisoIrpf && baseDeCalculo <= faixa2TetoIrpf) {
				irpf = (baseDeCalculo - inssSoma - (quantidadeDeDependentes * valorPorDependente) - pensao)
						* aliquotaFaixa2Irpf - deducaoFaixa2Irpf;
			} else if (baseDeCalculo >= faixa3PisoIrpf && baseDeCalculo <= faixa3TetoIrpf) {
				irpf = (baseDeCalculo - inssSoma - (quantidadeDeDependentes * valorPorDependente) - pensao)
						* aliquotaFaixa3Irpf - deducaoFaixa3Irpf;
			} else if (baseDeCalculo >= faixa4PisoIrpf && baseDeCalculo <= faixa4TetoIrpf) {
				irpf = (baseDeCalculo - inssSoma - (quantidadeDeDependentes * valorPorDependente) - pensao)
						* aliquotaFaixa4Irpf - deducaoFaixa4Irpf;
			} else {
				irpf = (baseDeCalculo - inssSoma - (quantidadeDeDependentes * valorPorDependente) - pensao)
						* aliquotaFaixa5Irpf - deducaoFaixa5Irpf;
			}
			/***************
			 **** SAIDA ****
			 ****************/
			txtIrpf.setText(String.valueOf(formatador.format(irpf)));

			/********************************************
			 **** FIM DO CALCULO DO IMPOSTO DE RENDA ****
			 ********************************************/

			/**********************************
			 **** CALCULO DO VALE REFEICAO ****
			 ***********************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			proventoVr = valorVr * diasTrabalhadosMes;
			if (salarioBruto <= faixa1TetoVaVr) {
				descontoVr = proventoVr * aliquotaFaixa1Vr;

			} else if (salarioBruto > faixa1TetoVaVr && salarioBruto <= faixa2TetoVaVr) {
				descontoVr = proventoVr * aliquotaFaixa2Vr;
			} else if (salarioBruto > faixa2TetoVaVr && salarioBruto <= faixa3TetoVaVr) {
				descontoVr = proventoVr * aliquotaFaixa3Vr;
			} else {
				descontoVr = proventoVr * aliquotaFaixa4Vr;
			}
			/***************
			 **** SAIDA ****
			 ****************/
			txtProventoValeRefeicao.setText(String.valueOf(formatador.format(proventoVr)));
			txtDescontoValeRefeicao.setText(String.valueOf(formatador.format(descontoVr)));

			/*****************************************
			 **** FIM DO CALCULO DO VALE REFEICAO ****
			 *****************************************/

			/*************************************
			 **** CALCULO DO VALE ALIMENTACAO ****
			 **************************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			if (salarioBruto <= faixa1TetoVaVr) {
				descontoVa = valorVa * aliquotaFaixa1Va;

			} else if (salarioBruto > faixa1TetoVaVr && salarioBruto <= faixa2TetoVaVr) {
				descontoVa = valorVa * aliquotaFaixa2Va;
			} else if (salarioBruto > faixa2TetoVaVr && salarioBruto <= faixa3TetoVaVr) {
				descontoVa = valorVa * aliquotaFaixa3Va;
			} else {
				descontoVa = valorVa * aliquotaFaixa4Va;
			}
			/***************
			 **** SAIDA ****
			 ****************/
			txtProventoValeAlimentacao.setText(String.valueOf(formatador.format(valorVa)));
			txtDescontoValeAlimentacao.setText(String.valueOf(formatador.format(descontoVa)));

			/********************************************
			 **** FIM DO CALCULO DO VALE ALIMENTACAO ****
			 ********************************************/

			/*************************
			 **** CALCULO DO FGTS ****
			 *************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			proventoFgts = baseDeCalculo * aliquotaFgts;

			/***************
			 **** SAIDA ****
			 ****************/
			txtFgts.setText(String.valueOf(formatador.format(proventoFgts)));

			/********************************
			 **** FIM DO CALCULO DO FGTS ****
			 ********************************/

			/************************************
			 **** CALCULO DO SALARIO LIQUIDO ****
			 ************************************/

			/***********************
			 **** PROCESSAMENTO ****
			 ************************/
			salarioLiquido = salarioBruto - inssSoma - irpf - descontoVr - descontoVa - assistenciaMedica
					- assistenciaOdontologica - descontoValeTransporte - pensao;
			totalDeDescontos = inssSoma + irpf + descontoVr + descontoVa + assistenciaMedica + assistenciaOdontologica
					+ descontoValeTransporte + pensao;
			/***************
			 **** SAIDA ****
			 ****************/
			txtSalarioLiquido.setText(String.valueOf(formatador.format(salarioLiquido)));
			txtTotalDeDescontos.setText(String.valueOf(formatador.format(totalDeDescontos)));

			/*******************************************
			 **** FIM DO CALCULO DO SALARIO LIQUIDO ****
			 *******************************************/
		}
		/*********************************
		 **** FIM DO CODIGO PRINCIPAL ****
		 *********************************/
	}

	/********************************
	 **** FIM DO METODO CALCULAR ****
	 ********************************/

	/***********************
	 **** METODO LIMPAR ****
	 ************************/

	void limpar() {
		txtSalarioBruto.setText(null);
		txtHorasTrabalhadasMes.setText(null);
		txtDependentes.setText(null);
		txtInss.setText(null);
		txtIrpf.setText(null);
		txtHoraExtra50.setText(null);
		txtProventoHoraExtra50.setText(null);
		txtHoraExtra100.setText(null);
		txtDiasTrabalhadosMes.setText(null);
		txtProventoHoraExtra100.setText(null);
		txtProventoValeRefeicao.setText(null);
		txtDescontoValeRefeicao.setText(null);
		txtProventoValeAlimentacao.setText(null);
		txtDescontoValeAlimentacao.setText(null);
		txtAssistenciaMedica.setText(null);
		txtAssistenciaOdontologica.setText(null);
		txtHoraTrabalhada.setText(null);
		txtSalarioLiquido.setText(null);
		txtTotalDiarioValeTransporte.setText(null);
		txtTotalMensalValeTransporte.setText(null);
		txtDescontoValeTransporte.setText(null);
		txtTotalDeDescontos.setText(null);
		txtPensao.setText(null);
		txtFgts.setText(null);
		txtSalarioBruto.requestFocus();
		chckbxValeTransporte.setSelected(false);
		chckbxPensao.setSelected(false);
		chckbxAssistenciaMedica.setSelected(false);
		chckbxAssistenciaOdontologica.setSelected(false);
	}
} // Fim do Código
