package portifolio;

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
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class JurosCompostos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCapital;
	private JTextField txtJuros;
	private JTextField txtPeriodo;
	private JTextField txtMontante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JurosCompostos dialog = new JurosCompostos();
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
	public JurosCompostos() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JurosCompostos.class.getResource("/img/juros-48.png")));
		setResizable(false);
		setTitle("Juros Compostos");
		setBounds(100, 100, 282, 271);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblCapital = new JLabel("Capital");
		lblCapital.setBounds(10, 27, 127, 14);
		getContentPane().add(lblCapital);

		JLabel lblJuros = new JLabel("Taxa de juros mensal");
		lblJuros.setBounds(10, 55, 127, 14);
		getContentPane().add(lblJuros);

		JLabel lblPeriodo = new JLabel("Per\u00EDodo em meses");
		lblPeriodo.setBounds(10, 83, 127, 14);
		getContentPane().add(lblPeriodo);

		txtCapital = new JTextField();
		txtCapital.setHorizontalAlignment(SwingConstants.CENTER);
		txtCapital.setBounds(147, 24, 86, 20);
		getContentPane().add(txtCapital);
		txtCapital.setColumns(10);

		txtJuros = new JTextField();
		txtJuros.setHorizontalAlignment(SwingConstants.CENTER);
		txtJuros.setBounds(147, 52, 86, 20);
		getContentPane().add(txtJuros);
		txtJuros.setColumns(10);

		txtPeriodo = new JTextField();
		txtPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeriodo.setBounds(147, 80, 86, 20);
		getContentPane().add(txtPeriodo);
		txtPeriodo.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setIcon(new ImageIcon(JurosCompostos.class.getResource("/img/juros-64.png")));
		btnCalcular.setBounds(46, 108, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(JurosCompostos.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(156, 108, 64, 64);
		getContentPane().add(btnLimpar);

		txtMontante = new JTextField();
		txtMontante.setHorizontalAlignment(SwingConstants.CENTER);
		txtMontante.setEditable(false);
		txtMontante.setBounds(147, 193, 86, 20);
		getContentPane().add(txtMontante);
		txtMontante.setColumns(10);

		JLabel lblMontante = new JLabel("Montante");
		lblMontante.setBounds(10, 196, 86, 14);
		getContentPane().add(lblMontante);

		// Validar Capital
		RestrictedTextField capital = new RestrictedTextField(txtCapital, "0123456789.");
		capital.setLimit(20);

		// Validar Juros
		RestrictedTextField juros = new RestrictedTextField(txtJuros, "0123456789.");
		juros.setLimit(4);

		// Validar Período
		RestrictedTextField periodo = new RestrictedTextField(txtPeriodo, "0123456789");
		
		JLabel lblPorcento = new JLabel("%");
		lblPorcento.setBounds(243, 55, 46, 14);
		getContentPane().add(lblPorcento);
		periodo.setLimit(4);

	} // Fim do Construtor

	/** Método para Calcular **/
	void calcular() {
		// Validação
		if (txtCapital.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o capital a ser investido");
			txtCapital.requestFocus();
		} else if (txtJuros.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a taxa de juros mensal");
			txtJuros.requestFocus();
		} else if (txtPeriodo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o período em meses");
			txtPeriodo.requestFocus();
		} else {
			// Declaração de variáveis
			double capital, juros, montante;
			int periodo;
			
			// formatador de casas decimais
			DecimalFormat formatador = new DecimalFormat("R$ 0.00");
			// Entrada
			capital = Double.parseDouble(txtCapital.getText());
			juros = Double.parseDouble(txtJuros.getText());
			periodo = Integer.parseInt(txtPeriodo.getText());
			// Processamento
			montante = capital * Math.pow(1 + juros / 100, periodo);
			// Saída
			txtMontante.setText(String.valueOf(formatador.format(montante)));
		}

	}

	/** Método para Limpar **/
	void limpar() {
		txtCapital.setText(null);
		txtJuros.setText(null);
		txtPeriodo.setText(null);
		txtMontante.setText(null);
		txtCapital.requestFocus();
	} // Fim do método limpar
} // Fim do Código
