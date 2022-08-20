package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabuada extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTabuada;
	private JTextArea txtArea;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuada dialog = new Tabuada();
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
	public Tabuada() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabuada.class.getResource("/img/tabuada-28.png")));
		setTitle("Tabuada");
		setModal(true);
		setBounds(100, 100, 253, 371);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Tabuada");
		lblNewLabel.setBounds(35, 24, 65, 14);
		getContentPane().add(lblNewLabel);

		txtTabuada = new JTextField();
		txtTabuada.setBounds(116, 21, 86, 20);
		getContentPane().add(txtTabuada);
		txtTabuada.setColumns(10);

		btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setIcon(new ImageIcon(Tabuada.class.getResource("/img/tabuada-64.png")));
		btnCalcular.setBounds(36, 49, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(Tabuada.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(136, 52, 64, 64);
		getContentPane().add(btnLimpar);

		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(66, 129, 104, 176);
		getContentPane().add(txtArea);
		
		// Validação Tabuada
				RestrictedTextField tabuada = new RestrictedTextField(txtTabuada, "0123456789");
				tabuada.setLimit(3);

	} // Fim do Construtor

	void calcular() {
		// validação
		if (txtTabuada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Qual a tabuada que você deseja saber ?");
			txtTabuada.requestFocus();
		} else {
			// variáveis + entrada
			int valor = Integer.parseInt(txtTabuada.getText());
			// processamento
			for (int i = 0; i < 11; i++) {
				txtArea.append(" " + String.valueOf(valor) + " x " + i + " = " + valor * i + "\n");
			}
			//desabilitar o botão
			btnCalcular.setEnabled(false);
		}

	} // Fim do método calcular

	void limpar() {
		txtTabuada.setText(null);
		txtArea.setText(null);
		txtTabuada.requestFocus();
		//Habilitar o botão
		btnCalcular.setEnabled(true);

	} // Fim do método Limpar
} // Fim do Código
