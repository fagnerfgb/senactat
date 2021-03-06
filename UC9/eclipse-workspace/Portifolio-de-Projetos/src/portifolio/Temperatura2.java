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

public class Temperatura2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCelsius;
	private JTextField txtFahrenheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura2 dialog = new Temperatura2();
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
	public Temperatura2() {
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Temperatura2.class.getResource("/img/fahrenheit-48.png")));
		setTitle("Converter de Celsius para Farenheit");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);

		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(123, 61, 70, 15);
		getContentPane().add(lblCelsius);

		txtCelsius = new JTextField();
		txtCelsius.setBounds(211, 59, 114, 19);
		getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(123, 90, 78, 15);
		getContentPane().add(lblFahrenheit);

		txtFahrenheit = new JTextField();
		txtFahrenheit.setEditable(false);
		txtFahrenheit.setBounds(211, 88, 114, 19);
		getContentPane().add(txtFahrenheit);
		txtFahrenheit.setColumns(10);

		JButton btnConverter = new JButton("Converter");
		btnConverter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnConverter.setBounds(165, 127, 117, 25);
		getContentPane().add(btnConverter);

		JLabel lblDeCelsiusPara = new JLabel("De Celsius para Fahrenheit");
		lblDeCelsiusPara.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDeCelsiusPara.setBounds(43, 12, 362, 29);
		getContentPane().add(lblDeCelsiusPara);

	} // Fim do Construtor

	void calcular() {
		// Valida????o
		if (txtCelsius.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a temperatura em Celsius");
			txtCelsius.requestFocus();
		} else {
			// Declara????o de Vari??veis
			double celsius, fahrenheit;

			// Entrada
			celsius = Double.parseDouble(txtCelsius.getText());

			// Processamento
			fahrenheit = 1.8 * celsius + 32;
			fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;

			// Sa??da
			txtFahrenheit.setText(String.valueOf(fahrenheit));
		}
	}

}
