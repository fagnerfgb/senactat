package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Combustivel extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtGasolina;
	private JTextField txtEtanol;
	private JTextField txtResultado;
	private JLabel lblStatus;
	private JTextField txtPercentual;

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
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Gasolina ou Etanol ?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Combustivel.class.getResource("/img/combustivel-48.png")));
		setModal(true);
		setBounds(100, 100, 385, 427);
		getContentPane().setLayout(null);

		JLabel lblPreoDaGasolina = new JLabel("Gasolina");
		lblPreoDaGasolina.setBounds(22, 54, 62, 15);
		getContentPane().add(lblPreoDaGasolina);

		JLabel lblPreoDoEtanol = new JLabel("Etanol");
		lblPreoDoEtanol.setBounds(22, 84, 54, 15);
		getContentPane().add(lblPreoDoEtanol);

		txtGasolina = new JTextField();
		txtGasolina.setHorizontalAlignment(SwingConstants.CENTER);
		txtGasolina.setBounds(134, 54, 114, 19);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);

		txtEtanol = new JTextField();
		txtEtanol.setHorizontalAlignment(SwingConstants.CENTER);
		txtEtanol.setBounds(134, 84, 114, 19);
		getContentPane().add(txtEtanol);
		txtEtanol.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(134, 114, 114, 25);
		getContentPane().add(btnCalcular);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(35, 354, 318, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		JLabel lblQualAMelhor = new JLabel("Qual a melhor op????o ?");
		lblQualAMelhor.setFont(new Font("Dialog", Font.BOLD, 24));
		lblQualAMelhor.setBounds(43, 12, 297, 30);
		getContentPane().add(lblQualAMelhor);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
		lblStatus.setBounds(34, 182, 320, 160);
		getContentPane().add(lblStatus);

		txtPercentual = new JTextField();
		txtPercentual.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPercentual.setEditable(false);
		txtPercentual.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentual.setBounds(134, 154, 114, 19);
		getContentPane().add(txtPercentual);
		txtPercentual.setColumns(10);

		JLabel lblPercentual = new JLabel("Percentual");
		lblPercentual.setBounds(22, 154, 88, 15);
		getContentPane().add(lblPercentual);

	} // Fim do Construtor

	void calcular() {
		// Valida????o
		if (txtGasolina.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Insira o pre??o da gasolina");
		txtGasolina.requestFocus();
		} else if (txtEtanol.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o pre??o do etanol");
			txtEtanol.requestFocus();
		} else {
		// Declara????o de vari??veis
		double gasolina, etanol;
		//double percentual;

		// Entrada
		gasolina = Double.parseDouble(txtGasolina.getText());
		etanol = Double.parseDouble(txtEtanol.getText());
		

		// Processamento/Sa??da
		//percentual = etanol / (gasolina * 0.7) ;
		//percentual = Math.round(percentual * 100.0) / 100.0;
		//txtPercentual.setText(String.valueOf(percentual+"%"));
		if (etanol < 0.7 * gasolina) {
			txtResultado.setText(String.valueOf("O etanol ?? mais vantajoso que a gasolina"));
			lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/etanol.png")));
			/*JOptionPane.showMessageDialog(null, "O etanol ?? mais vantajoso que a gasolina", "Vai de Etanol",
					JOptionPane.DEFAULT_OPTION);*/
		} else {
			txtResultado.setText(String.valueOf("A gasolina ?? mais vantajosa que o etanol"));
			lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/gasolina.png")));
			/*JOptionPane.showMessageDialog(null, "A gasolina ?? mais vantajosa que o etanol", "Vai de Gasosa",
					JOptionPane.DEFAULT_OPTION);*/
		}
		}

	}
}
// Fim do c??digo
