package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Converter de Celsius para Farenheit");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(77, 55, 70, 15);
		getContentPane().add(lblCelsius);
		
		txtCelsius = new JTextField();
		txtCelsius.setBounds(165, 53, 114, 19);
		getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(77, 101, 102, 15);
		getContentPane().add(lblFahrenheit);
		
		txtFahrenheit = new JTextField();
		txtFahrenheit.setEditable(false);
		txtFahrenheit.setBounds(165, 99, 114, 19);
		getContentPane().add(txtFahrenheit);
		txtFahrenheit.setColumns(10);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnConverter.setBounds(162, 163, 117, 25);
		getContentPane().add(btnConverter);

	} // Fim do Construtor
	
	void calcular() {
		//Declaração de Variáveis
		double celsius, fahrenheit;
		
		// Entrada
		celsius = Double.parseDouble(txtCelsius.getText());
		
		// Processamento
		fahrenheit = 1.8 * celsius + 32;
		fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;
		
		// Saída
		txtFahrenheit.setText(String.valueOf(fahrenheit));
	}

}