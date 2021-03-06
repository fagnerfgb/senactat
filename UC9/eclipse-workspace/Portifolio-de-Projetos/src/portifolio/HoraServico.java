package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JPanel;
import java.awt.Color;

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
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HoraServico.class.getResource("/img/hora-trabalho-48.png")));
		setTitle("Cálculo da Hora de um Serviço");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 422, 489);
		getContentPane().setLayout(null);

		JLabel lblRemuneracao = new JLabel("Remuneração Pretendida");
		lblRemuneracao.setBounds(12, 45, 184, 15);
		getContentPane().add(lblRemuneracao);

		JLabel lblCustoOperacional = new JLabel("Custo Operacional Mensal");
		lblCustoOperacional.setBounds(12, 76, 192, 15);
		getContentPane().add(lblCustoOperacional);

		JLabel lblHoras = new JLabel("Horas trabalhadas por mês");
		lblHoras.setBounds(12, 107, 205, 15);
		getContentPane().add(lblHoras);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(214, 41, 114, 19);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		txtCustoOperacional = new JTextField();
		txtCustoOperacional.setBounds(214, 72, 114, 19);
		getContentPane().add(txtCustoOperacional);
		txtCustoOperacional.setColumns(10);

		txtHoras = new JTextField();
		txtHoras.setBounds(214, 103, 114, 19);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hora();
			}
		});
		btnCalcular.setBounds(151, 134, 117, 25);
		getContentPane().add(btnCalcular);

		JLabel lblRendimento = new JLabel("Custo da Hora Trabalhada");
		lblRendimento.setBounds(12, 171, 192, 15);
		getContentPane().add(lblRendimento);

		txtRendimento = new JTextField();
		txtRendimento.setEditable(false);
		txtRendimento.setBounds(214, 171, 114, 19);
		getContentPane().add(txtRendimento);
		txtRendimento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Custo Hora");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(131, 0, 158, 42);
		getContentPane().add(lblNewLabel);

		JLabel lblReserva = new JLabel("Reserva de Emergência");
		lblReserva.setBounds(12, 309, 170, 15);
		getContentPane().add(lblReserva);

		txtReservaServico = new JTextField();
		txtReservaServico.setEditable(false);
		txtReservaServico.setBounds(214, 307, 114, 19);
		getContentPane().add(txtReservaServico);
		txtReservaServico.setColumns(10);

		JLabel lblInvestimentos = new JLabel("Reserva para Investimentos");
		lblInvestimentos.setBounds(12, 338, 205, 15);
		getContentPane().add(lblInvestimentos);

		txtInvestimentoServico = new JTextField();
		txtInvestimentoServico.setEditable(false);
		txtInvestimentoServico.setBounds(214, 336, 114, 19);
		getContentPane().add(txtInvestimentoServico);
		txtInvestimentoServico.setColumns(10);

		JLabel lblFaturamentoMensal = new JLabel("Rendimento Líquido");
		lblFaturamentoMensal.setBounds(12, 395, 152, 15);
		getContentPane().add(lblFaturamentoMensal);

		JLabel lblEstimativaDeHoras = new JLabel("Estimativa de Horas");
		lblEstimativaDeHoras.setBounds(12, 218, 147, 15);
		getContentPane().add(lblEstimativaDeHoras);

		txtEstimativaHoras = new JTextField();
		txtEstimativaHoras.setBounds(214, 217, 114, 19);
		getContentPane().add(txtEstimativaHoras);
		txtEstimativaHoras.setColumns(10);

		JButton btnProcessar = new JButton("Processar");
		btnProcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processar();
			}
		});
		btnProcessar.setBounds(151, 245, 117, 25);
		getContentPane().add(btnProcessar);

		JLabel lblValorCobradoPelo = new JLabel("Valor cobrado pelo serviço");
		lblValorCobradoPelo.setBounds(12, 280, 192, 15);
		getContentPane().add(lblValorCobradoPelo);

		txtValorServico = new JTextField();
		txtValorServico.setEditable(false);
		txtValorServico.setBounds(214, 280, 114, 19);
		getContentPane().add(txtValorServico);
		txtValorServico.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(30, 198, 360, 5);
		getContentPane().add(panel);

		txtRendimentoLiquidoServico = new JTextField();
		txtRendimentoLiquidoServico.setEditable(false);
		txtRendimentoLiquidoServico.setBounds(214, 395, 114, 19);
		getContentPane().add(txtRendimentoLiquidoServico);
		txtRendimentoLiquidoServico.setColumns(10);

		JLabel lblReservaCustoOperacional = new JLabel("Reserva Custo Operacional");
		lblReservaCustoOperacional.setBounds(12, 365, 205, 15);
		getContentPane().add(lblReservaCustoOperacional);

		txtCustoOperacionalServico = new JTextField();
		txtCustoOperacionalServico.setEditable(false);
		txtCustoOperacionalServico.setBounds(214, 367, 114, 19);
		getContentPane().add(txtCustoOperacionalServico);
		txtCustoOperacionalServico.setColumns(10);

	} // Fim do Construtor

	// Variáveis globais;
	double rendimento, investimentoServico, custoOperacionalServico, reservaServico, rendimentoLiquido, remuneracao,
			horas, reserva, custoOperacional, investimento;
	double percentualInvestimento = 0.2;
	double percentualReserva = 0.3;
	private JTextField txtRendimentoLiquidoServico;
	private JTextField txtCustoOperacionalServico;

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
			txtRendimento.setText(String.valueOf(rendimento));
		}

	} // Fim do método hora

	void processar() {
		// Validação
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
			txtValorServico.setText(String.valueOf(valorServico));
			txtReservaServico.setText(String.valueOf(reservaServico));
			txtInvestimentoServico.setText(String.valueOf(investimentoServico));
			txtRendimentoLiquidoServico.setText(String.valueOf(rendimentoLiquido));
			txtCustoOperacionalServico.setText(String.valueOf(custoOperacionalServico));
			JOptionPane.showMessageDialog(null,
					"Valor do Serviço é R$" + valorServico + "\nO valor da reserva de emergência é R$" + reservaServico
							+ "\nO valor da reserva para investimento é R$" + investimentoServico
							+ "\nO valor da reserva de custo operacional é R$" + custoOperacionalServico
							+ "\nO rendimento líquido do serviço é R$" + rendimentoLiquido,
					"Relatório", JOptionPane.INFORMATION_MESSAGE);
		}
	} // Fim do método processar
} // Fim
