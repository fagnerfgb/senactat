package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Carta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFace;
	private JLabel lblNaipe;
	private JLabel lblNaipeCentro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carta dialog = new Carta();
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
	public Carta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Carta.class.getResource("/img/cards-48.png")));
		setTitle("Carta");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 356, 397);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.text);
		panel.setBounds(84, 17, 220, 323);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblFace = new JLabel("");
		lblFace.setBackground(SystemColor.text);
		lblFace.setHorizontalAlignment(SwingConstants.LEFT);
		lblFace.setFont(new Font("Arial", Font.BOLD, 22));
		lblFace.setBounds(11, 11, 57, 20);
		panel.add(lblFace);

		lblNaipe = new JLabel("");
		lblNaipe.setBackground(SystemColor.text);
		lblNaipe.setHorizontalAlignment(SwingConstants.LEFT);
		lblNaipe.setFont(new Font("Arial", Font.BOLD, 32));
		lblNaipe.setBounds(9, 36, 28, 20);
		panel.add(lblNaipe);

		lblNaipeCentro = new JLabel("");
		lblNaipeCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblNaipeCentro.setFont(new Font("Arial", Font.BOLD, 90));
		lblNaipeCentro.setBounds(30, 65, 160, 250);
		panel.add(lblNaipeCentro);

		JButton btnCarta = new JButton("");
		btnCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lancar();
			}
		});
		btnCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarta.setToolTipText("Jogar");
		btnCarta.setIcon(new ImageIcon(Carta.class.getResource("/img/cards-64.png")));
		btnCarta.setBounds(10, 76, 64, 64);
		getContentPane().add(btnCarta);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Carta.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(10, 216, 64, 64);
		getContentPane().add(btnLimpar);

	} // Fim do Construtor

	/***********************
	 **** METODO LANCAR ****
	 ***********************/

	void lancar() {
		String[] naipes = { "♥", "♦", "♣", "♠" };
		String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Joker" };
		// String[] faces = {"Joker"};
		Random carta = new Random();
		int indiceFace = carta.nextInt(faces.length);
		int indiceNaipe = carta.nextInt(naipes.length);
		lblFace.setText((faces[indiceFace]));
		lblNaipe.setText((naipes[indiceNaipe]));
		lblNaipeCentro.setText((naipes[indiceNaipe]));

		/********************
		 **** TROCAR COR ****
		 *******************/

		if (indiceNaipe == 0 || indiceNaipe == 1) {
			lblFace.setForeground(Color.RED);
			lblNaipe.setForeground(Color.RED);
			lblNaipeCentro.setForeground(Color.RED);
		} else {
			lblFace.setForeground(Color.BLACK);
			lblNaipe.setForeground(Color.BLACK);
			lblNaipeCentro.setForeground(Color.BLACK);
		}

		if (indiceFace == 10) {
			lblNaipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/valete.png")));
		} else if (indiceFace == 11) {
			lblNaipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/dama.png")));
		} else if (indiceFace == 12) {
			lblNaipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/rei.png")));
		} else if (indiceFace == 13) {
			lblNaipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/coringa.png")));
			lblNaipe.setText(null);
		} else {
			lblNaipeCentro.setIcon(null);
			lblNaipeCentro.setText("  " + naipes[indiceNaipe]);
		}
	}

	/***************
	 **** METODO LIMPAR ****
	 ****************/
	void limpar() {
		lblFace.setText(null);
		lblNaipe.setText(null);
		lblNaipeCentro.setText(null);
		lblNaipeCentro.setIcon(null);

	} // Fim do método limpar
} // Fim do codigo
