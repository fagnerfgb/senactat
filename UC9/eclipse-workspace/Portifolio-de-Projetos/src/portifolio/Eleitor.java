package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Eleitor extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor dialog = new Eleitor();
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
	public Eleitor() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Verifica Status do Eleitor");
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eleitor.class.getResource("/img/eleicao-48.png")));
		setBounds(100, 100, 297, 203);
		getContentPane().setLayout(null);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(119, 25, 48, 15);
		getContentPane().add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdade.setBounds(86, 52, 114, 19);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JButton btnVerifica = new JButton("Verifica");
		btnVerifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verifica();
			}
		});
		btnVerifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerifica.setBounds(85, 83, 117, 25);
		getContentPane().add(btnVerifica);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(51, 120, 184, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

	} // Fim do Construtor

	void verifica() {
		// Valida????o
		if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a idade");
			txtIdade.requestFocus();
		} else {

			// Vari??veis
			int idade;

			// Entrada
			idade = Integer.parseInt(txtIdade.getText());

			// Processamento e Sa??da
			if (idade < 16) {
				txtResultado.setText(String.valueOf("Voto proibido"));
				JOptionPane.showMessageDialog(null, "Voto proibido", "A sua hora vai chegar",
						JOptionPane.ERROR_MESSAGE);
			} else if (idade > 17 && idade < 71) {
				txtResultado.setText(String.valueOf("Voto obrigat??rio"));
				JOptionPane.showMessageDialog(null, "Voto obrigat??rio", "Cumpra com o seu dever c??vico!",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				txtResultado.setText(String.valueOf("Voto facultativo"));
				JOptionPane.showMessageDialog(null, "Voto facultativo", "A decis??o ?? sua!",
						JOptionPane.QUESTION_MESSAGE);
			}
		}
	} // Fim do m??todo verifica
}// Fim
