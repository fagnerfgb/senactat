package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Font;

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
		setTitle("Sobre");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setEditable(false);
		txtpnSobre.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtpnSobre.setText("Olá! Eu sou o Fagner! \nTrabalho com infraestrutura de TI e estudo inglês e francês.\nEstes são os meus primeiros passos em desenvolvimento de sistemas.\n\nHello! My name is Fagner!\nI work with IT infrastructure and I study English and French.\nThese are my first steps in systems development.\n\nSalut ! Je m'appelle Fagner.\nJe travaille avec la infrastructure de technologie de l'information et j'étudie l'anglais et le français.\nMaintenant je commence à apprendre à développer des systèmes.\n\n");
		txtpnSobre.setBounds(36, 12, 384, 230);
		getContentPane().add(txtpnSobre);

	}
}
