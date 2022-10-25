package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;
import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/login.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAcessar = new JButton("");
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.setContentAreaFilled(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/img/acessar.png")));
		btnAcessar.setToolTipText("Clique para acessar");
		btnAcessar.setBounds(113, 190, 64, 64);
		contentPane.add(btnAcessar);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 110, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setToolTipText("Insira o seu login");
		txtLogin.setBounds(66, 110, 211, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 150, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setToolTipText("Insira a senha");
		txtSenha.setBounds(66, 150, 211, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 30, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(66, 30, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(10, 70, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setBounds(66, 70, 211, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/offdb.png")));
		lblStatus.setBounds(213, 5, 64, 64);
		contentPane.add(lblStatus);
	} // Fim do Construtor
	
	
	
	
} // Fim do codigo
