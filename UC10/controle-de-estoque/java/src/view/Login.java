package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JLabel lblStatusBanco;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/login.png")));
		setTitle("Sistema de Controle de Estoque - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnAcessar = new JButton("");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.setContentAreaFilled(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/img/acessar.png")));
		btnAcessar.setToolTipText("Clique para fazer logon no sistema");
		btnAcessar.setBounds(433, 53, 64, 64);
		contentPane.add(btnAcessar);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(148, 60, 46, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Insira o login");
		txtLogin.setBounds(204, 57, 211, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(148, 100, 46, 14);
		contentPane.add(lblSenha);

		lblStatusBanco = new JLabel("");
		lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dboff24.png")));
		lblStatusBanco.setBounds(471, 11, 24, 24);
		contentPane.add(lblStatusBanco);

		lblAcesso = new JLabel("");
		lblAcesso.setIcon(new ImageIcon(Login.class.getResource("/img/logon.png")));
		lblAcesso.setBounds(10, 11, 128, 128);
		contentPane.add(lblAcesso);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(204, 97, 211, 20);
		contentPane.add(txtSenha);

		// tecla enter associada ao botao
		getRootPane().setDefaultButton(btnAcessar);
	} // Fim do Construtor

	DAO dao = new DAO();
	private JLabel lblAcesso;
	private JPasswordField txtSenha;

	/**
	 * Metodo responsavel por verificar o status da conexao com o banco
	 */
	private void status() {
		try {
			// Uso da classe Connection (JDBC) para estabelecer a conexao
			Connection con = dao.conectar();
			if (con == null) {
				lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dboff24.png")));
			} else {
				// System.out.println("Banco conectado!");
				lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dbon24.png")));
			}
			// Nunca esquecer de encerrar a conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	} // Fim do metodo status

	private void logar() {
		// validacao da senha (captura segura)
		String capturaSenha = new String(txtSenha.getPassword());
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtSenha.requestFocus();
		} else {
			String read = "select * from usuarios where login = ? and senha = md5(?)";
			try {
				/**
				 * Estabelecer a conexao
				 */
				Connection con = dao.conectar();
				/**
				 * Prepara o codigo sql para execucao
				 */
				PreparedStatement pst = con.prepareStatement(read);
				/**
				 * A linha abaixo substitui o ? pelo conteudo da caixa de texto txtLogin; o 1
				 * faz referencia a interrogacao
				 */
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				/**
				 * Obter os dados do funcionario
				 */
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					// System.out.println("teste do botao acessar");
					Main main = new Main();

					// Captura o perfil do usuario
					String perfil = rs.getString(5);

					if (perfil.equals("admin")) {
						// Habilitar os botoes
						main.btnUsuarios.setEnabled(true);
						main.btnRelatorios.setEnabled(true);

						// Trocar a cor do rodape
						main.panelUsuario.setBackground(Color.RED);
					}
					main.setVisible(true);
					// Alterar a label da tela principal (inserir nome do usuario no rodape)
					// System.out.println(rs.getString(5));
					main.lblUsuario.setText(rs.getString(2));

					// fechar o JFrame
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
				}
				/**
				 * Fechar a conexao
				 */
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
} // Fim do codigo
