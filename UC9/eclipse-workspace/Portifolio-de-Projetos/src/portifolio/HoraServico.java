package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.SwingConstants;

public class HoraServico extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCustoOperacional;
	private JTextField txtHoras;
	private JTextField txtRendimento;
	private JTextField txtReservaServico;
	private JTextField txtInvestimentoServico;
	private JTextField txtEstimativaHoras;
	private JTextField txtValorServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoraServico dialog = new HoraServico();
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
	public HoraServico() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HoraServico.class.getResource("/img/hora-trabalho-48.png")));
		setTitle("C\u00E1lculo da Hora de um Servi\u00E7o");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 447, 380);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblRemuneracao = new JLabel("Remunera\u00E7\u00E3o Pretendida");
		lblRemuneracao.setBounds(12, 15, 146, 15);
		getContentPane().add(lblRemuneracao);

		JLabel lblCustoOperacional = new JLabel("Custo Operacional Mensal");
		lblCustoOperacional.setBounds(12, 46, 167, 15);
		getContentPane().add(lblCustoOperacional);

		JLabel lblHoras = new JLabel("Horas trabalhadas por m\u00EAs");
		lblHoras.setBounds(12, 77, 167, 15);
		getContentPane().add(lblHoras);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setHorizontalAlignment(SwingConstants.CENTER);
		txtRemuneracao.setBounds(214, 11, 114, 19);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		txtCustoOperacional = new JTextField();
		txtCustoOperacional.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustoOperacional.setBounds(214, 42, 114, 19);
		getContentPane().add(txtCustoOperacional);
		txtCustoOperacional.setColumns(10);

		txtHoras = new JTextField();
		txtHoras.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoras.setBounds(214, 73, 114, 19);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(HoraServico.class.getResource("/img/hora-trabalho.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hora();
			}
		});
		btnCalcular.setBounds(357, 37, 64, 64);
		getContentPane().add(btnCalcular);

		JLabel lblRendimento = new JLabel("Custo da Hora Trabalhada");
		lblRendimento.setBounds(12, 104, 167, 15);
		getContentPane().add(lblRendimento);

		txtRendimento = new JTextField();
		txtRendimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtRendimento.setEditable(false);
		txtRendimento.setBounds(214, 104, 114, 19);
		getContentPane().add(txtRendimento);
		txtRendimento.setColumns(10);

		JLabel lblReserva = new JLabel("Reserva de Emerg\u00EAncia");
		lblReserva.setBounds(12, 220, 136, 15);
		getContentPane().add(lblReserva);

		txtReservaServico = new JTextField();
		txtReservaServico.setHorizontalAlignment(SwingConstants.CENTER);
		txtReservaServico.setEditable(false);
		txtReservaServico.setBounds(214, 218, 114, 19);
		getContentPane().add(txtReservaServico);
		txtReservaServico.setColumns(10);

		JLabel lblInvestimentos = new JLabel("Reserva para Investimentos");
		lblInvestimentos.setBounds(12, 249, 167, 15);
		getContentPane().add(lblInvestimentos);

		txtInvestimentoServico = new JTextField();
		txtInvestimentoServico.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvestimentoServico.setEditable(false);
		txtInvestimentoServico.setBounds(214, 247, 114, 19);
		getContentPane().add(txtInvestimentoServico);
		txtInvestimentoServico.setColumns(10);

		JLabel lblFaturamentoMensal = new JLabel("Rendimento L\u00EDquido");
		lblFaturamentoMensal.setBounds(12, 306, 114, 15);
		getContentPane().add(lblFaturamentoMensal);

		JLabel lblEstimativaDeHoras = new JLabel("Estimativa de Horas");
		lblEstimativaDeHoras.setBounds(12, 161, 114, 15);
		getContentPane().add(lblEstimativaDeHoras);

		txtEstimativaHoras = new JTextField();
		txtEstimativaHoras.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstimativaHoras.setBounds(214, 160, 114, 19);
		getContentPane().add(txtEstimativaHoras);
		txtEstimativaHoras.setColumns(10);

		JButton btnProcessar = new JButton("");
		btnProcessar.setIcon(new ImageIcon(HoraServico.class.getResource("/img/money-64.png")));
		btnProcessar.setToolTipText("Calcular");
		btnProcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processar();
			}
		});
		btnProcessar.setBounds(357, 160, 64, 64);
		getContentPane().add(btnProcessar);

		JLabel lblValorCobradoPelo = new JLabel("Valor cobrado pelo servi\u00E7o");
		lblValorCobradoPelo.setBounds(12, 191, 156, 15);
		getContentPane().add(lblValorCobradoPelo);

		txtValorServico = new JTextField();
		txtValorServico.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorServico.setEditable(false);
		txtValorServico.setBounds(214, 191, 114, 19);
		getContentPane().add(txtValorServico);
		txtValorServico.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(35, 144, 360, 5);
		getContentPane().add(panel);

		txtRendimentoLiquidoServico = new JTextField();
		txtRendimentoLiquidoServico.setHorizontalAlignment(SwingConstants.CENTER);
		txtRendimentoLiquidoServico.setEditable(false);
		txtRendimentoLiquidoServico.setBounds(214, 306, 114, 19);
		getContentPane().add(txtRendimentoLiquidoServico);
		txtRendimentoLiquidoServico.setColumns(10);

		JLabel lblReservaCustoOperacional = new JLabel("Reserva Custo Operacional");
		lblReservaCustoOperacional.setBounds(12, 276, 167, 15);
		getContentPane().add(lblReservaCustoOperacional);

		txtCustoOperacionalServico = new JTextField();
		txtCustoOperacionalServico.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustoOperacionalServico.setEditable(false);
		txtCustoOperacionalServico.setBounds(214, 278, 114, 19);
		getContentPane().add(txtCustoOperacionalServico);
		txtCustoOperacionalServico.setColumns(10);

		// Validação Remuneração
		RestrictedTextField remuneracao = new RestrictedTextField(txtRemuneracao, "0123456789.");
		remuneracao.setLimit(9);

		// Validação Custo Operacional
		RestrictedTextField custoOperacional = new RestrictedTextField(txtCustoOperacional, "0123456789.");
		custoOperacional.setLimit(9);

		// Validação Horas
		RestrictedTextField horasMes = new RestrictedTextField(txtHoras, "0123456789");
		horasMes.setLimit(4);

		// Validação Estimativa Horas
		RestrictedTextField estimativaHoras = new RestrictedTextField(txtEstimativaHoras, "0123456789");
		estimativaHoras.setLimit(4);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(HoraServico.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(357, 261, 64, 64);
		getContentPane().add(btnLimpar);
		estimativaHoras.setLimit(3);

	} // Fim do Construtor

	// Variávies globais;
	double rendimento, investimentoServico, custoOperacionalServico, reservaServico, rendimentoLiquido, remuneracao,
			horas, reserva, custoOperacional, investimento;
	double percentualInvestimento = 0.2;
	double percentualReserva = 0.3;
	private JTextField txtRendimentoLiquidoServico;
	private JTextField txtCustoOperacionalServico;
	// formatador de casas decimais
	DecimalFormat formatador = new DecimalFormat("R$ 0.00");

	void hora() {
		// Validação
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a remuneracao mensal pretendida");
			txtRemuneracao.requestFocus();
		} else if (txtCustoOperacional.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o custo operacional mensal");
			txtCustoOperacional.requestFocus();
		} else if (txtHoras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de horas trabalhadas por mês");
			txtHoras.requestFocus();
		} else {

			// Declarando as variáveis

			// Entrada
			remuneracao = Double.parseDouble(txtRemuneracao.getText());
			custoOperacional = Double.parseDouble(txtCustoOperacional.getText());
			horas = Double.parseDouble(txtHoras.getText());

			// Processamento
			reserva = remuneracao * percentualReserva;
			investimento = remuneracao * percentualInvestimento;
			rendimento = (remuneracao + custoOperacional + reserva + investimento) / horas;
			rendimento = Math.round(rendimento * 100.0) / 100.0;

			// Saída
			txtRendimento.setText(String.valueOf(formatador.format(rendimento)));
		}

	} // Fim do método hora

	void processar() {
		// ValidaÃ§Ã£o
		if (txtEstimativaHoras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de horas para realizar o serviço");
			txtEstimativaHoras.requestFocus();
		} else {
			// Declarando as variáveis
			double estimativaHoras, valorServico;

			// Entrada
			estimativaHoras = Double.parseDouble(txtEstimativaHoras.getText());

			// Processamento
			valorServico = estimativaHoras * rendimento;
			valorServico = Math.round(valorServico * 100.0) / 100.0;

			reservaServico = (remuneracao / horas) * percentualReserva * estimativaHoras;
			reservaServico = Math.round(reservaServico * 100.0) / 100.0;

			investimentoServico = (remuneracao / horas) * percentualInvestimento * estimativaHoras;
			investimentoServico = Math.round(investimentoServico * 100.0) / 100.0;

			custoOperacionalServico = custoOperacional / horas * estimativaHoras;
			custoOperacionalServico = Math.round(custoOperacionalServico * 100.0) / 100.0;

			rendimentoLiquido = valorServico - reservaServico - investimentoServico - custoOperacionalServico;
			rendimentoLiquido = Math.round(rendimentoLiquido * 100.0) / 100.0;

			// Saída
			txtValorServico.setText(String.valueOf(formatador.format(valorServico)));
			txtReservaServico.setText(String.valueOf(formatador.format(reservaServico)));
			txtInvestimentoServico.setText(String.valueOf(formatador.format(investimentoServico)));
			txtRendimentoLiquidoServico.setText(String.valueOf(formatador.format(rendimentoLiquido)));
			txtCustoOperacionalServico.setText(String.valueOf(formatador.format(custoOperacionalServico)));
			JOptionPane.showMessageDialog(null,
					"Valor do Serviço é R$" + valorServico + "\nO valor da reserva de emergência é R$" + reservaServico
							+ "\nO valor da reserva para investimento é R$" + investimentoServico
							+ "\nO valor da reserva de custo operacional é R$" + custoOperacionalServico
							+ "\nO rendimento líquido do serviço é R$" + rendimentoLiquido,
					"Relatório", JOptionPane.INFORMATION_MESSAGE);
		}
	} // Fim do método processar

	/** Método para Limpar **/
	void limpar() {
		txtRemuneracao.setText(null);
		txtCustoOperacional.setText(null);
		txtHoras.setText(null);
		txtEstimativaHoras.setText(null);
		txtReservaServico.setText(null);
		txtInvestimentoServico.setText(null);
		txtValorServico.setText(null);
		txtRendimento.setText(null);
		txtCustoOperacionalServico.setText(null);
		txtRendimentoLiquidoServico.setText(null);
		txtRemuneracao.requestFocus();
	} // Fim do método limpar
} // Fim
