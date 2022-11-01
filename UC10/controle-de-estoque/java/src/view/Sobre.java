package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setTitle("Sobre");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 551, 404);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setFont(new Font("Verdana", Font.BOLD, 24));
		lblSobre.setBounds(222, 27, 90, 40);
		getContentPane().add(lblSobre);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit.png")));
		lblLogo.setBounds(390, 85, 128, 128);
		getContentPane().add(lblLogo);

		JLabel lblLicenca = new JLabel("Sob a licen\u00E7a MIT");
		lblLicenca.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLicenca.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenca.setBounds(390, 265, 128, 14);
		getContentPane().add(lblLicenca);

		JLabel lblVersao = new JLabel("Vers\u00E3o 1.0");
		lblVersao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblVersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersao.setBounds(390, 331, 128, 14);
		getContentPane().add(lblVersao);

		JTextPane txtpnolueEuSou = new JTextPane();
		txtpnolueEuSou.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtpnolueEuSou.setText(
				"Ol\u00E1! Eu sou o Fagner! \r\nTrabalho com infraestrutura de TI e estudo ingl\u00EAs e franc\u00EAs.\r\nEstes s\u00E3o os meus primeiros passos em desenvolvimento de sistemas.\r\n\r\nHello! My name is Fagner!\r\nI work with IT Infrastructure and I'am learning English and French.\r\nThese are my first steps in systems development.\r\n\r\nSalut! Je m'appelle Fagner.\r\nJe travaille avec l'infrastructure de la technologie de l'information et j'\u00E9tudie l'anglais et le fran\u00E7ais. \r\nJe m'initie au d\u00E9veloppement de syst\u00E8mes.");
		txtpnolueEuSou.setBounds(10, 83, 350, 262);
		getContentPane().add(txtpnolueEuSou);

	}
}
