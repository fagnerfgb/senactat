package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;

public class Dado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtDado;

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
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Dado");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dado.class.getResource("/img/dado-48.png")));
		setBounds(100, 100, 203, 259);
		getContentPane().setLayout(null);

		JButton btnLanar = new JButton("Lançar");
		btnLanar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lancar();
			}
		});
		btnLanar.setBounds(42, 31, 117, 25);
		getContentPane().add(btnLanar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dado.class.getResource("/img/face1.png")));
		lblNewLabel.setBounds(43, 68, 115, 119);
		getContentPane().add(lblNewLabel);

		txtDado = new JTextField();
		txtDado.setEditable(false);
		txtDado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtDado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDado.setBounds(43, 198, 114, 19);
		getContentPane().add(txtDado);
		txtDado.setColumns(10);

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

} // Fim
