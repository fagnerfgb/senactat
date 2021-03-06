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
import java.awt.Color;

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
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Temperatura.class.getResource("/img/celsius-48.png")));
		setModal(true);
		setResizable(false);
		setTitle("Conversão de Fahrenheit para Celsius");
		setBounds(100, 100, 450, 205);
		getContentPane().setLayout(null);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(122, 65, 78, 15);
		getContentPane().add(lblFahrenheit);

		txtFahrenheit = new JTextField();
		txtFahrenheit.setBounds(226, 61, 114, 19);
		getContentPane().add(txtFahrenheit);
		txtFahrenheit.setColumns(10);

		JButton btnCalcular = new JButton("Converter");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(165, 121, 117, 25);
		getContentPane().add(btnCalcular);

		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(122, 94, 70, 15);
		getContentPane().add(lblCelsius);

		txtCelsius = new JTextField();
		txtCelsius.setEditable(false);
		txtCelsius.setBounds(226, 92, 114, 19);
		getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);

		JLabel lblConverteDeFahrenheit = new JLabel("Fahrenheit para Celsius");
		lblConverteDeFahrenheit.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConverteDeFahrenheit.setBounds(59, 12, 330, 30);
		getContentPane().add(lblConverteDeFahrenheit);

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

	}
}
