package portifolio;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JRadioButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Jokenpo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnPedra;
	private JRadioButton rdbtnPapel;
	private JRadioButton rdbtnTesoura;
	private JLabel lblPc;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jokenpo dialog = new Jokenpo();
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
	public Jokenpo() {
		setBackground(Color.WHITE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jokenpo.class.getResource("/img/pedra.png")));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
		rdbtnPedra = new JRadioButton("");
		rdbtnPedra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnPedra.setContentAreaFilled(false);
		rdbtnPedra.setToolTipText("Pedra");
		buttonGroup.add(rdbtnPedra);
		rdbtnPedra.setBounds(50, 89, 21, 23);
		getContentPane().add(rdbtnPedra);
		
		rdbtnPapel = new JRadioButton("");
		rdbtnPapel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnPapel.setContentAreaFilled(false);
		rdbtnPapel.setBorder(null);
		rdbtnPapel.setToolTipText("Papel");
		buttonGroup.add(rdbtnPapel);
		rdbtnPapel.setBounds(142, 89, 21, 23);
		getContentPane().add(rdbtnPapel);
		
		rdbtnTesoura = new JRadioButton("");
		rdbtnTesoura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnTesoura.setBorder(null);
		rdbtnTesoura.setContentAreaFilled(false);
		rdbtnTesoura.setToolTipText("Tesoura");
		buttonGroup.add(rdbtnTesoura);
		rdbtnTesoura.setBounds(234, 89, 21, 23);
		getContentPane().add(rdbtnTesoura);
		
		JLabel lblPedra = new JLabel("");
		lblPedra.setBorder(null);
		lblPedra.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pedra.png")));
		lblPedra.setBounds(28, 11, 64, 64);
		getContentPane().add(lblPedra);
		
		JLabel lblPapel = new JLabel("");
		lblPapel.setBorder(null);
		lblPapel.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/papel.png")));
		lblPapel.setBounds(120, 11, 64, 64);
		getContentPane().add(lblPapel);
		
		JLabel lblTesoura = new JLabel("");
		lblTesoura.setBorder(null);
		lblTesoura.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/tesoura.png")));
		lblTesoura.setBounds(212, 11, 64, 64);
		getContentPane().add(lblTesoura);
		
		JButton btnPow = new JButton("");
		btnPow.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/jokenpo2.png")));
		btnPow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pow();
			}
		});
		btnPow.setToolTipText("Jogar");
		btnPow.setBounds(120, 119, 64, 64);
		getContentPane().add(btnPow);
		
		lblPc = new JLabel("");
		lblPc.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pc.png")));
		lblPc.setBounds(66, 194, 171, 139);
		getContentPane().add(lblPc);
		setTitle("JoKenPo");
		setResizable(false);
		setBounds(100, 100, 320, 400);
		setLocationRelativeTo(null);

	} // Fim do Construtor
	
	void pow() {
		// validação
		if (!rdbtnPedra.isSelected() && !rdbtnPapel.isSelected() && !rdbtnTesoura.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione uma opção");
		} else {
			// lógica principal
			Random random = new Random();
			int pc = random.nextInt(3);
			// Dica para verificar o número sorteado
			// System.out.println(pc);
			// Associar o número a imagem
			switch (pc) {
			case 0:
				lblPc.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pcpapel.png")));
				break;
			case 1:
				lblPc.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pcpedra.png")));
				break;
			case 2:
				lblPc.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pctesoura.png")));
				break;
			}
			if (rdbtnPedra.isSelected() && (pc == 1) || rdbtnPapel.isSelected() && (pc == 0)
					|| rdbtnTesoura.isSelected() && (pc == 2)) {
				JOptionPane.showMessageDialog(null, "Empate");
			} else if (rdbtnPedra.isSelected() && (pc == 2) || rdbtnPapel.isSelected() && (pc == 1)
					|| rdbtnTesoura.isSelected() && (pc == 0)) {
				JOptionPane.showMessageDialog(null, "Você venceu");
			} else {
				JOptionPane.showMessageDialog(null, "Você perdeu");
			}
			// Limpar os campos
			lblPc.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pc.png")));
			buttonGroup.clearSelection();
		}
	} // Fim do método pow
} // Fim do Código
