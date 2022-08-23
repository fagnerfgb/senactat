package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Sobre extends JDialog {

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
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about-48.png")));
		setTitle("Sobre");
		setModal(true);
		setBounds(100, 100, 450, 418);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setEditable(false);
		txtpnSobre.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtpnSobre.setText("Ol\u00E1! Eu sou o Fagner! \r\nTrabalho com infraestrutura de TI e estudo ingl\u00EAs e franc\u00EAs.\r\nEstes s\u00E3o os meus primeiros passos em desenvolvimento de sistemas.\r\n\r\nHello! My name is Fagner!\r\nI work with IT Infrastructure and I'am learning English and French.\r\nThese are my first steps in systems development.\r\n\r\nSalut! Je m'appelle Fagner.\r\nJe travaille avec l'infrastructure de la technologie de l'information et j'\u00E9tudie l'anglais et le fran\u00E7ais.\r\nJe m'initie au d\u00E9veloppement de syst\u00E8mes.\r\n");
		txtpnSobre.setBounds(24, 52, 253, 305);
		getContentPane().add(txtpnSobre);
		
		JLabel lblSobALicena = new JLabel("Sob a licen\u00E7a MIT");
		lblSobALicena.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobALicena.setBounds(295, 207, 131, 15);
		getContentPane().add(lblSobALicena);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit.png")));
		lblLogo.setBounds(295, 57, 131, 128);
		getContentPane().add(lblLogo);
		
		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSobre.setBounds(182, 12, 84, 28);
		getContentPane().add(lblSobre);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o 6.0");
		lblVersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersao.setBounds(315, 234, 91, 15);
		getContentPane().add(lblVersao);

	}
}
