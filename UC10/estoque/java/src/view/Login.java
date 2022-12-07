package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	DAO dao = new DAO();
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
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Controle de Estoque | Login");
		setBounds(100, 100, 280, 216);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLogin.setBounds(5, 45, 40, 20);
		getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSenha.setBounds(5, 75, 40, 20);
		getContentPane().add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "abcdefghijklmnopqrstuvwywz1234567890.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtLogin.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtLogin.setToolTipText("Insira o login");
		txtLogin.setColumns(10);
		txtLogin.setBounds(55, 45, 200, 20);
		getContentPane().add(txtLogin);

		JButton btnAcessar = new JButton("");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/img/acessar.png")));
		btnAcessar.setToolTipText("Clique para fazer logon no sistema");
		btnAcessar.setContentAreaFilled(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.setBounds(100, 107, 64, 64);
		getContentPane().add(btnAcessar);

		lblStatusBanco = new JLabel("");
		lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dboff24.png")));
		lblStatusBanco.setBounds(5, 11, 24, 24);
		getContentPane().add(lblStatusBanco);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Insira a senha");
		txtSenha.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtSenha.setBounds(55, 76, 200, 20);
		getContentPane().add(txtSenha);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PARA FAZER LOGON E ACESSADO
		 */
		getRootPane().setDefaultButton(btnAcessar);
		
		/**
		 * BIBLIOTECA ATXY2K
		 */
		
		/**
		 * txtLogin
		 */
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(20);		
		
		/**
		 * txtUsuario
		 */
		RestrictedTextField usuario = new RestrictedTextField(txtSenha);
		usuario.setLimit(50);
	} // FIM DO CONSTRUTOR

	/**
	 * VERIFICAR STATUS DA CONEXAO COM O BANCO DE DADOS
	 */

	private void status() {
		try {
			Connection con = dao.conectar();
			if (con == null) {
				lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dboff24.png")));
			} else {
				lblStatusBanco.setIcon(new ImageIcon(Login.class.getResource("/img/dbon24.png")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void logar() {
		/**
		 * CAPTURA A SENHA DE FORMA SEGURA
		 */
		String capturaSenha = new String(txtSenha.getPassword());

		/**
		 * VALIDACOES
		 */
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login do usuário");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Insira a senha do usuaário");
			txtSenha.requestFocus();
		} else {
			String read = "select * from usuarios where login = ? and senha = md5(?)";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARA O CODIGO SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(read);

				/**
				 * SUBSTITUI A ? PELO CONTEUDO DAS CAIXAS DE TEXTO
				 */
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);

				/**
				 * OBTER OS DADOS DO USUARIO
				 */
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					Main main = new Main();

					/**
					 * CAPTURAR O PERFIL DO USUARIO
					 */
					String perfil = rs.getString(5);

					if (perfil.equals("admin")) {
						/**
						 * HABILITAR OS BOTOES E TROCAR COR DO RODAPE
						 */
						main.btnUsuarios.setEnabled(true);
						main.btnRelatorios.setEnabled(true);
						main.panelUsuario.setBackground(Color.RED);
					}
					main.setVisible(true);

					/**
					 * INSERIR O NOME DO USUARIO NO RODAPE
					 */
					main.lblNomeUsuario.setText(rs.getString(2));

					/**
					 * FECHAR O JFRAME
					 */
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha não confere(m)");
					txtLogin.setText(null);
					txtSenha.setText(null);
					txtLogin.requestFocus();

				}

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

} // FIM DO CODIGO
