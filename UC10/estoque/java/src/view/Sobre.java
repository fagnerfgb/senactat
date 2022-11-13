package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setModal(true);
		setResizable(false);
		setTitle("Controle de Estoque | Sobre");
		setBounds(100, 100, 550, 350);
		getContentPane().setLayout(null);
		
		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setFont(new Font("Verdana", Font.BOLD, 24));
		lblSobre.setBounds(222, 10, 90, 40);
		getContentPane().add(lblSobre);
		
		JTextPane txtpnolueEuSou = new JTextPane();
		txtpnolueEuSou.setEditable(false);
		txtpnolueEuSou.setText("Olá! Eu sou o Fagner! \r\nTrabalho com infraestrutura de TI e estudo inglês e francês.\r\nEstes são os meus primeiros passos em desenvolvimento de sistemas.\r\n\r\nHello! My name is Fagner!\r\nI work with IT Infrastructure and I'am learning English and French.\r\nThese are my first steps in systems development.\r\n\r\nSalut! Je m'appelle Fagner.\r\nJe travaille avec l'infrastructure de la technologie de l'information et j'étudie l'anglais et le français. \r\nJe m'initie au développement de systèmes.");
		txtpnolueEuSou.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtpnolueEuSou.setBounds(18, 60, 350, 245);
		getContentPane().add(txtpnolueEuSou);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit.png")));
		lblLogo.setBounds(386, 60, 128, 128);
		getContentPane().add(lblLogo);
		
		JLabel lblLicenca = new JLabel("Sob a licença MIT");
		lblLicenca.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenca.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLicenca.setBounds(386, 223, 128, 20);
		getContentPane().add(lblLicenca);
		
		JLabel lblVersao = new JLabel("Versão 1.0");
		lblVersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblVersao.setBounds(386, 278, 128, 20);
		getContentPane().add(lblVersao);
		
		setLocationRelativeTo(null);

	}
}
