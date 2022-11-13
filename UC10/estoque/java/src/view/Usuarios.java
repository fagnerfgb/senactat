package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JCheckBox;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JComboBox<Object> cboPerfil;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPesquisar;
	private JCheckBox chkAlterarSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/users.png")));
		setResizable(false);
		setModal(true);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Controle de Estoque | Usuários");
		setBounds(100, 100, 464, 280);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(5, 10, 55, 20);
		getContentPane().add(lblId);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUsuario.setBounds(5, 40, 55, 20);
		getContentPane().add(lblUsuario);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLogin.setBounds(5, 70, 55, 20);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSenha.setBounds(5, 100, 55, 20);
		getContentPane().add(lblSenha);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPerfil.setBounds(5, 130, 55, 20);
		getContentPane().add(lblPerfil);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setToolTipText("Digite");
		txtId.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtId.setBounds(65, 10, 70, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Digite o nome completo do usuário");
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(65, 40, 250, 20);
		getContentPane().add(txtUsuario);
		
		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite o login do usuário");
		txtLogin.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtLogin.setColumns(10);
		txtLogin.setBounds(65, 70, 250, 20);
		getContentPane().add(txtLogin);
		
		txtSenha = new JTextField();
		txtSenha.setToolTipText("Digite a senha do usuário");
		txtSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtSenha.setColumns(10);
		txtSenha.setBounds(65, 100, 250, 20);
		getContentPane().add(txtSenha);
		
		cboPerfil = new JComboBox<Object>();
		cboPerfil.setToolTipText("Selecione o perfil do usuário");
		cboPerfil.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "admin", "user"}));
		cboPerfil.setFont(new Font("Verdana", Font.PLAIN, 12));
		cboPerfil.setBounds(65, 130, 70, 22);
		getContentPane().add(cboPerfil);
		
		btnCreate = new JButton("");
		btnCreate.setToolTipText("Adicionar usuário");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add-64.png")));
		btnCreate.setBounds(64, 170, 64, 64);
		getContentPane().add(btnCreate);
		
		btnUpdate = new JButton("");
		btnUpdate.setToolTipText("Atualizar informações do usuário");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update-64.png")));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(192, 170, 64, 64);
		getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("");
		btnDelete.setToolTipText("Excluir usuário");
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete-64.png")));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(320, 170, 64, 64);
		getContentPane().add(btnDelete);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setToolTipText("Digite o login e clique para pesquisar");
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search-24.png")));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBounds(325, 68, 24, 24);
		getContentPane().add(btnPesquisar);
		
		chkAlterarSenha = new JCheckBox("Alterar senha");
		chkAlterarSenha.setToolTipText("Alterar a senha do usuário");
		chkAlterarSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		chkAlterarSenha.setBounds(321, 100, 110, 20);
		getContentPane().add(chkAlterarSenha);
		
		setLocationRelativeTo(null);

	}
}
