package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

public class Tarot extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCarta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarot dialog = new Tarot();
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
	public Tarot() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tarot.class.getResource("/img/tarot-48.png")));
		setTitle("Baralho de Tarot");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 291, 479);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblCarta = new JLabel("");
		lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot0.png")));
		lblCarta.setBounds(56, 101, 163, 300);
		getContentPane().add(lblCarta);
		
		JButton btnJogar = new JButton("");
		btnJogar.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot.png")));
		btnJogar.setToolTipText("Jogar");
		btnJogar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogar();
			}
		});
		btnJogar.setBounds(49, 25, 64, 64);
		getContentPane().add(btnJogar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Tarot.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(162, 25, 64, 64);
		getContentPane().add(btnLimpar);

	}// Fim do Construtor
	void jogar() {
		Random random = new Random();
		int carta = random.nextInt(22) + 1;
		switch (carta) {
		case 1:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot1.png")));
			break;
		case 2:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot2.png")));
			break;
		case 3:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot3.png")));
			break;
		case 4:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot4.png")));
			break;
		case 5:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot5.png")));
			break;
		case 6:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot6.png")));
			break;
		case 7:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot7.png")));
			break;
		case 8:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot8.png")));
			break;
		case 9:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot9.png")));
			break;
		case 10:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot10.png")));
			break;
		case 11:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot11.png")));
			break;
		case 12:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot12.png")));
			break;
		case 13:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot13.png")));
			break;
		case 14:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot14.png")));
			break;
		case 15:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot15.png")));
			break;
		case 16:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot16.png")));
			break;
		case 17:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot17.png")));
			break;
		case 18:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot18.png")));
			break;
		case 19:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot19.png")));
			break;
		case 20:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot20.png")));
			break;
		case 21:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot21.png")));
			break;
		case 22:
			lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot22.png")));
			break;
		}
		
	} // Fim do método lancar
	
	/** método para Limpar **/
	void limpar() {
		lblCarta.setIcon(new ImageIcon(Tarot.class.getResource("/img/tarot0.png")));
		} // Fim do método limpar
	
} // Fim
