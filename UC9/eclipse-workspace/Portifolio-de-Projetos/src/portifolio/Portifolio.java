package portifolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Portifolio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portifolio frame = new Portifolio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Portifolio() {
		setForeground(new Color(0, 102, 153));
		setResizable(false);
		setTitle("Portifólio de Projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnNewButton.setBounds(46, 107, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sobre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(271, 107, 117, 25);
		contentPane.add(btnNewButton_1);
	} // fim do construtor
}
