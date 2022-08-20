package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.SwingConstants;

public class Temperatura extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtFahrenheit;
	private JTextField txtCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura dialog = new Temperatura();
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
	public Temperatura() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Temperatura.class.getResource("/img/celsius-48.png")));
		setModal(true);
		setResizable(false);
		setTitle("Convers\u00E3o de Fahrenheit para Celsius");
		setBounds(100, 100, 326, 253);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(46, 57, 64, 15);
		getContentPane().add(lblFahrenheit);

		txtFahrenheit = new JTextField();
		txtFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		txtFahrenheit.setBounds(149, 53, 114, 19);
		getContentPane().add(txtFahrenheit);
		txtFahrenheit.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(Temperatura.class.getResource("/img/celsius.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(60, 121, 64, 64);
		getContentPane().add(btnCalcular);

		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(46, 86, 44, 15);
		getContentPane().add(lblCelsius);

		txtCelsius = new JTextField();
		txtCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelsius.setEditable(false);
		txtCelsius.setBounds(149, 84, 114, 19);
		getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);

		JLabel lblConverteDeFahrenheit = new JLabel("Fahrenheit para Celsius");
		lblConverteDeFahrenheit.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConverteDeFahrenheit.setBounds(19, 12, 272, 30);
		getContentPane().add(lblConverteDeFahrenheit);

		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Temperatura.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(184, 121, 64, 64);
		getContentPane().add(btnLimpar);

		// Uso da Biblioteca Atxy2k
		RestrictedTextField validar = new RestrictedTextField(txtFahrenheit, "0123456789.");
		validar.setLimit(6);

	} // Fim do Construtor

	void calcular() {
		// Validação
		if (txtFahrenheit.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a temperatura em Fahrenheit");
			txtFahrenheit.requestFocus();
		} else {

			// Declaração de variáveis
			double fahrenheit, celsius;

			// Entrada
			fahrenheit = Double.parseDouble(txtFahrenheit.getText());

			// Processamento
			celsius = (5 * fahrenheit - 160) / 9;
			celsius = Math.round(celsius * 100.0) / 100.0;

			// Saída
			// A linha abaixo exibe o conteúdo da variável celsius na caixa de texto
			// txtCelsius
			// É necessário converter para String
			txtCelsius.setText(String.valueOf(celsius));
			// JOptionPane.showMessageDialog(null, "A temperatura em Celsius é " + celsius,
			// "Converte temperatura", JOptionPane.INFORMATION_MESSAGE);
		}

	}// fim do método calcular

	/** método para Limpar **/
	void limpar() {
		txtFahrenheit.setText(null);
		txtCelsius.setText(null);
		txtFahrenheit.requestFocus();
	} // Fim do método limpar
}
