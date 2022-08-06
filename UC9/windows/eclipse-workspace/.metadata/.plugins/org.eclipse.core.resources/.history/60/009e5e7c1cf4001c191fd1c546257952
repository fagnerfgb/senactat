package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HoraServico extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCustoOperacional;
	private JTextField txtHoras;
	private JTextField txtRendimento;

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
		setTitle("Cálculo da Hora de um Serviço");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblRemuneracao = new JLabel("Remuneração");
		lblRemuneracao.setBounds(12, 15, 106, 15);
		getContentPane().add(lblRemuneracao);
		
		JLabel lblCustoOperacional = new JLabel("Custo Operacional");
		lblCustoOperacional.setBounds(12, 71, 146, 15);
		getContentPane().add(lblCustoOperacional);
		
		JLabel lblHoras = new JLabel("Horas trabalhadas");
		lblHoras.setBounds(12, 127, 146, 15);
		getContentPane().add(lblHoras);
		
		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(161, 12, 114, 19);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);
		
		txtCustoOperacional = new JTextField();
		txtCustoOperacional.setBounds(161, 69, 114, 19);
		getContentPane().add(txtCustoOperacional);
		txtCustoOperacional.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(161, 126, 114, 19);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hora();
			}
		});
		btnCalcular.setBounds(165, 232, 117, 25);
		getContentPane().add(btnCalcular);
		
		JLabel lblRendimento = new JLabel("Rendimento");
		lblRendimento.setBounds(12, 183, 106, 15);
		getContentPane().add(lblRendimento);
		
		txtRendimento = new JTextField();
		txtRendimento.setEditable(false);
		txtRendimento.setBounds(161, 183, 114, 19);
		getContentPane().add(txtRendimento);
		txtRendimento.setColumns(10);

	} // Fim do Construtor
	
	void hora() {
		// Declarando as variáveis
		double remuneracao, reserva, custoOperacional, investimentos, horas, rendimento;
		
		// Entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custoOperacional = Double.parseDouble(txtCustoOperacional.getText());
		horas = Double.parseDouble(txtHoras.getText());
		
		// Processamento
		reserva = 0.3 * remuneracao;
		investimentos = 0.2 * remuneracao;
		rendimento = (remuneracao + custoOperacional + reserva + investimentos) / horas;
		rendimento = Math.round(rendimento * 100.0) / 100.0;
		
		// Saída
		txtRendimento.setText(String.valueOf(rendimento));
		
		
		
	}
	
} // Fim
