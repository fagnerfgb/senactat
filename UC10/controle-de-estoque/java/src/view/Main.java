package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRodape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblRodape.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/estoque.png")));
		setTitle("Controle de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnUsuarios = new JButton("");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setBorderPainted(false);
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setBounds(10, 11, 128, 128);
		contentPane.add(btnUsuarios);

		JButton btnFornecedores = new JButton("");
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/supliers.png")));
		btnFornecedores.setBorderPainted(false);
		btnFornecedores.setContentAreaFilled(false);
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setBounds(148, 11, 128, 128);
		contentPane.add(btnFornecedores);

		JButton btnProdutos = new JButton("");
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/products.png")));
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorderPainted(false);
		btnProdutos.setBounds(286, 11, 128, 128);
		contentPane.add(btnProdutos);

		JButton btnClientes = new JButton("");
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/clientes.png")));
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBounds(10, 173, 128, 128);
		contentPane.add(btnClientes);

		JButton btnRelatorios = new JButton("");
		btnRelatorios.setToolTipText("Relat\u00F3rios");
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/report.png")));
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setBounds(148, 173, 128, 128);
		contentPane.add(btnRelatorios);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorderPainted(false);
		btnSobre.setBounds(286, 173, 128, 128);
		contentPane.add(btnSobre);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 316, 427, 40);
		contentPane.add(panel);

		lblRodape = new JLabel("");
		lblRodape.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(lblRodape);
		lblRodape.setForeground(SystemColor.desktop);
		lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
	} // Fim do construtor
} // Fim do codigo
