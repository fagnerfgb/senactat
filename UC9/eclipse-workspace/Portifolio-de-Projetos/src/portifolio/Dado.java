package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Dado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtDado;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dado dialog = new Dado();
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
	public Dado() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Dado");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dado.class.getResource("/img/dado-48.png")));
		setBounds(100, 100, 203, 318);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JButton btnLancar = new JButton("");
		btnLancar.setIcon(new ImageIcon(Dado.class.getResource("/img/dado.png")));
		btnLancar.setToolTipText("Jogar");
		btnLancar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lancar();
			}
		});
		btnLancar.setBounds(19, 30, 64, 64);
		getContentPane().add(btnLancar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/dice.png")));
		lblNewLabel.setBounds(29, 105, 128, 128);
		getContentPane().add(lblNewLabel);

		txtDado = new JTextField();
		txtDado.setEditable(false);
		txtDado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtDado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDado.setBounds(36, 245, 114, 19);
		getContentPane().add(txtDado);
		txtDado.setColumns(10);

		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Dado.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(102, 30, 64, 64);
		getContentPane().add(btnLimpar);

	} // Fim do Construtor

	void lancar() {
		Random random = new Random();
		int face = random.nextInt(6) + 1;
		switch (face) {
		case 1:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face1.png")));
			break;
		case 2:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face2.png")));
			break;
		case 3:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face3.png")));
			break;
		case 4:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face4.png")));
			break;
		case 5:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face5.png")));
			break;
		case 6:
			lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face6.png")));
			break;
		}
		txtDado.setText(String.valueOf(face));
	} // Fim do método lancar

	/** Método para Limpar **/
	void limpar() {
		txtDado.setText(null);
		lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/dice.png")));
		
	} // Fim do método limpar

} // Fim
