package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblStatusBanco;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;
	// Criar um objeto para acessar o metodo conectar() da classe DAO

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/user.png")));
		setResizable(false);
		setTitle("Usuários");
		setBounds(100, 100, 450, 261);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 20, 46, 14);
		getContentPane().add(lblId);

		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(10, 50, 46, 14);
		getContentPane().add(lblUsuario);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 80, 46, 14);
		getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 110, 46, 14);
		getContentPane().add(lblSenha);

		lblStatusBanco = new JLabel("");
		lblStatusBanco.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff.png")));
		lblStatusBanco.setToolTipText("Informa se o banco de dados está conectado");
		lblStatusBanco.setBounds(346, 50, 64, 64);
		getContentPane().add(lblStatusBanco);

		txtId = new JTextField();
		txtId.setBounds(76, 17, 100, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Insira o nome completo do usuário");
		txtUsuario.setBounds(76, 47, 250, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("primeironome.últimonome");
		txtLogin.setBounds(76, 77, 250, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setToolTipText("Insira a senha do usuário");
		txtSenha.setBounds(75, 107, 250, 20);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);

		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setEnabled(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/create.png")));
		btnCreate.setToolTipText("Adicionar um novo funcionário");
		btnCreate.setBounds(60, 140, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setToolTipText("Atualizar dados do funcionário");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update.png")));
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(184, 140, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Excluir um funcionário");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(308, 140, 64, 64);
		getContentPane().add(btnDelete);

		btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnRead.setToolTipText("Pesquisar");
		btnRead.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setBounds(336, 17, 24, 24);
		getContentPane().add(btnRead);

		// Uso da tecla <Enter> junto com um botao
		getRootPane().setDefaultButton(btnRead);
		
		// Uso da biblioteca atxy2k para restringir o maximo de caracteres
		
		// txtUsuario
		RestrictedTextField nome = new RestrictedTextField(txtUsuario);
		nome.setOnlyText(true);
		nome.setAcceptSpace(true);
		nome.setLimit(50);
		
		// txtLogin
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(50);
		
		// txtSenha
		RestrictedTextField senha = new RestrictedTextField(txtSenha);
		senha.setLimit(250);
		nome.setAcceptSpace(false);		

	} // Fim do construtor

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRead;

	/**
	 * Metodo responsavel por verificar o status da conexao com o banco
	 */
	private void status() {
		try {
			// Uso da classe Connection (JDBC) para estabelecer a conexao
			Connection con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatusBanco.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff.png")));
			} else {
				// System.out.println("Banco conectado!");
				lblStatusBanco.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de encerrar a conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	} // Fim do metodo status

	/**
	 * Metodo responsavel pela pesquisa (Select)
	 */
	private void pesquisar() {

		// validacao
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do funcionário");
			txtId.requestFocus();
		} else {
			String read = "select * from usuarios where id = ?";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(read);
				// A linha abaixo substitui o ? pelo conteudo da caixa de texto txtId;
				// o 1 faz referencia a interrogacao
				pst.setString(1, txtId.getText());
				// Obter os dados do funcionario
				ResultSet rs = pst.executeQuery();
				// Verificar se existe um contato cadastrado
				// rs.next() significa ter um contato correspondente ao ID

				if (rs.next()) {
					txtUsuario.setText(rs.getString(2));
					txtLogin.setText(rs.getString(3));
					txtSenha.setText(rs.getString(4));

					// Habilitar botoes alterar e excluir
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Id inexistente");
					txtId.setText(null);
					txtUsuario.setText(null);
					txtLogin.setText(null);
					txtSenha.setText(null);
					txtUsuario.requestFocus();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(false);
					txtId.setEnabled(false);
				}
				// Fechar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do metodo pesquisar

	/**
	 * Metodo responsavel pelo cadastro de um novo funcionario
	 */

	void adicionar() {
		// Validacao
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a senha");
		} else {
			String create = "insert into usuarios (usuario, login, senha) values (?, ?, ?)";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(create);
				// A linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome, txtFone
				// e txtEmail;
				// o 1, 2, 3 faz referencia a interrogacao
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtSenha.getText());
				// Executar a query e confirmar a insercao
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
					limpar();
				}
				// Encerrar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do Metodo adicionar

	/**
	 * Metodo responsavel por alterar informacoes do funcionario
	 */

	private void alterar() {
		// Validacao
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a senha");
		} else {
			String update = "update usuarios set usuario = ?, login = ?, senha = ? where id = ?";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtSenha.getText());
				pst.setString(4, txtId.getText());
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do funcionário atualizados com sucesso!");
					limpar();
				}
				// Encerrar a conexao
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // Fim do metodo alterar
	
	/**
	 * Metodo responsavel por excluir um contato
	 */
	
	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do funcionário ?", "ATENÇÃO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from usuarios where id = ?";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				// Executar a query e confirmar a exclusao
				int exclui = pst.executeUpdate();
				if (exclui == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");					
				}
				// Encerrar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do metodo excluir

	/**
	 * Metodo usado para limpar os campos
	 */
	private void limpar() {
		txtId.setText(null);
		txtId.setEnabled(true);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
		txtId.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnRead.setEnabled(true);
		btnDelete.setEnabled(false);
	} // Fim do metodo limpar
} // Fim do codigo