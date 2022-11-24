package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnUsuarios;
	JButton btnRelatorios;
	JLabel lblRotulo;
	JLabel lblNomeUsuario;
	JLabel lblDataHora;
	JPanel panelUsuario;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/estoque.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.LONG);
				lblDataHora.setText(formatador.format(data));
			}
		});
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		getContentPane().setLayout(null);
				
		btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setEnabled(false);
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/users.png")));
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setBorderPainted(false);
		btnUsuarios.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnUsuarios.setBounds(10, 10, 128, 128);
		getContentPane().add(btnUsuarios);
		
		JButton btnFornecedores = new JButton("");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/supliers.png")));
		btnFornecedores.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnFornecedores.setContentAreaFilled(false);
		btnFornecedores.setBorderPainted(false);
		btnFornecedores.setBounds(148, 10, 128, 128);
		getContentPane().add(btnFornecedores);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/products.png")));
		btnProdutos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorderPainted(false);
		btnProdutos.setBounds(286, 10, 128, 128);
		getContentPane().add(btnProdutos);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/clientes.png")));
		btnClientes.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBounds(10, 138, 128, 128);
		getContentPane().add(btnClientes);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setEnabled(false);
		btnRelatorios.setToolTipText("Relatórios");
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/report.png")));
		btnRelatorios.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setBounds(148, 138, 128, 128);
		getContentPane().add(btnRelatorios);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/about.png")));
		btnSobre.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorderPainted(false);
		btnSobre.setBounds(286, 138, 128, 128);
		getContentPane().add(btnSobre);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.activeCaption);
		panelUsuario.setBounds(0, 276, 426, 40);
		getContentPane().add(panelUsuario);
		panelUsuario.setLayout(null);
		
		lblRotulo = new JLabel("Usuário:");
		lblRotulo.setForeground(SystemColor.text);
		lblRotulo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblRotulo.setBounds(2, 0, 60, 40);
		panelUsuario.add(lblRotulo);
		
		lblNomeUsuario = new JLabel("");
		lblNomeUsuario.setForeground(SystemColor.text);
		lblNomeUsuario.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNomeUsuario.setBounds(70, 0, 170, 40);
		panelUsuario.add(lblNomeUsuario);
		
		lblDataHora = new JLabel("");
		lblDataHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataHora.setForeground(SystemColor.text);
		lblDataHora.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDataHora.setBounds(242, 0, 181, 40);
		panelUsuario.add(lblDataHora);
		setForeground(SystemColor.controlText);
		setResizable(false);
		setTitle("Controle de Estoque");
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setBounds(100, 100, 443, 356);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
