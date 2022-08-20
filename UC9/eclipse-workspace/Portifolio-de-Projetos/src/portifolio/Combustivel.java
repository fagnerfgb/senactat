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
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Combustivel extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtGasolina;
	private JTextField txtEtanol;
	private JTextField txtResultado;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combustivel dialog = new Combustivel();
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
	public Combustivel() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Gasolina ou Etanol ?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Combustivel.class.getResource("/img/combustivel-48.png")));
		setModal(true);
		setBounds(100, 100, 385, 449);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblPreoDaGasolina = new JLabel("Gasolina");
		lblPreoDaGasolina.setBounds(71, 54, 51, 15);
		getContentPane().add(lblPreoDaGasolina);

		JLabel lblPreoDoEtanol = new JLabel("Etanol");
		lblPreoDoEtanol.setBounds(75, 84, 47, 15);
		getContentPane().add(lblPreoDoEtanol);

		txtGasolina = new JTextField();
		txtGasolina.setHorizontalAlignment(SwingConstants.CENTER);
		txtGasolina.setBounds(182, 54, 114, 19);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);

		txtEtanol = new JTextField();
		txtEtanol.setHorizontalAlignment(SwingConstants.CENTER);
		txtEtanol.setBounds(180, 84, 114, 19);
		getContentPane().add(txtEtanol);
		txtEtanol.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(Combustivel.class.getResource("/img/combustivel.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(80, 115, 64, 64);
		getContentPane().add(btnCalcular);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(25, 373, 318, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		JLabel lblQualAMelhor = new JLabel("Qual a melhor op\u00E7\u00E3o ?");
		lblQualAMelhor.setFont(new Font("Dialog", Font.BOLD, 24));
		lblQualAMelhor.setBounds(50, 12, 269, 30);
		getContentPane().add(lblQualAMelhor);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
		lblStatus.setBounds(24, 201, 320, 160);
		getContentPane().add(lblStatus);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Combustivel.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(224, 115, 64, 64);
		getContentPane().add(btnLimpar);

		// Validação Gasolina
		RestrictedTextField gasolina = new RestrictedTextField(txtGasolina, "0123456789.");
		gasolina.setLimit(5);

		// Validação Etanol
		RestrictedTextField etanol = new RestrictedTextField(txtEtanol, "0123456789.");
		etanol.setLimit(5);

	} // Fim do Construtor

	void calcular() {
		// validação
		if (txtGasolina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço da gasolina");
			txtGasolina.requestFocus();
		} else if (txtEtanol.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço do etanol");
			txtEtanol.requestFocus();
		} else {
			// Declaração de variáveis
			double gasolina, etanol;
			// double percentual;

			// Entrada
			gasolina = Double.parseDouble(txtGasolina.getText());
			etanol = Double.parseDouble(txtEtanol.getText());

			// Processamento/Saída
			// percentual = etanol / (gasolina * 0.7) ;
			// percentual = Math.round(percentual * 100.0) / 100.0;
			// txtPercentual.setText(String.valueOf(percentual+"%"));
			if (etanol < 0.7 * gasolina) {
				txtResultado.setText(String.valueOf("O etanol é mais vantajoso que a gasolina"));
				lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/etanol.png")));
				/*
				 * JOptionPane.showMessageDialog(null,
				 * "O etanol é mais vantajoso que a gasolina", "Vai de Etanol",
				 * JOptionPane.DEFAULT_OPTION);
				 */
			} else {
				txtResultado.setText(String.valueOf("A gasolina é mais vantajosa que o etanol"));
				lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/gasolina.png")));
				/*
				 * JOptionPane.showMessageDialog(null,
				 * "A gasolina é mais vantajosa que o etanol", "Vai de Gasosa",
				 * JOptionPane.DEFAULT_OPTION);
				 */
			}
		}

	}// Fim do método Calcular

	/** Método para Limpar **/
	void limpar() {
		txtGasolina.setText(null);
		txtEtanol.setText(null);
		txtResultado.setText(null);
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
		txtGasolina.requestFocus();
	} // Fim do método limpar
}
// Fim do código
