package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about-48.png")));
		setTitle("Sobre");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setEditable(false);
		txtpnSobre.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtpnSobre.setText("Olá! Eu sou o Fagner! \nTrabalho com infraestrutura de TI e estudo inglês e francês.\nEstes são os meus primeiros passos em desenvolvimento de sistemas.\n\nHello! My name is Fagner!\nI work with IT Infrastructure and I'am learning English and French.\nThese are my first steps in systems development.\n");
		txtpnSobre.setBounds(24, 52, 253, 177);
		getContentPane().add(txtpnSobre);
		
		JLabel lblSobALicena = new JLabel("Sob a licença MIT");
		lblSobALicena.setBounds(295, 192, 131, 15);
		getContentPane().add(lblSobALicena);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit.png")));
		label.setBounds(298, 52, 128, 128);
		getContentPane().add(label);
		
		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSobre.setBounds(182, 12, 84, 28);
		getContentPane().add(lblSobre);

	}
}
