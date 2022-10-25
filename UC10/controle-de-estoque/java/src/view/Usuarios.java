package view;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSenha;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;

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
		setTitle("Usu\u00E1rios");
		setBounds(100, 100, 371, 300);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 32, 46, 14);
		getContentPane().add(lblId);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(10, 72, 46, 14);
		getContentPane().add(lblUsuario);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 112, 46, 14);
		getContentPane().add(lblLogin);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 152, 46, 14);
		getContentPane().add(lblSenha);

		txtId = new JTextField();
		txtId.setBounds(93, 32, 80, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Insira o nome completo do usu\u00E1rio");
		txtUsuario.setBounds(93, 72, 250, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Insira o login do usu\u00E1rio");
		txtLogin.setBounds(93, 112, 250, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setToolTipText("Insira a senha do usu\u00E1rio");
		txtSenha.setBounds(93, 152, 250, 20);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);

		lblStatus = new JLabel("");
		lblStatus.setToolTipText("Status da conex\u00E3o com o banco de dados");
		lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/offdb.png")));
		lblStatus.setBounds(279, 5, 64, 64);
		getContentPane().add(lblStatus);

		JButton btnCreate = new JButton("");
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
		btnCreate.setToolTipText("Clique para cadastrar um funcion\u00E1rio");
		btnCreate.setBounds(40, 186, 64, 64);
		getContentPane().add(btnCreate);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setToolTipText("Clique para excluir um funcion\u00E1rio");
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(248, 186, 64, 64);
		getContentPane().add(btnDelete);

		JButton btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnRead.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setBounds(175, 28, 24, 24);
		getContentPane().add(btnRead);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/atualizar.png")));
		btnUpdate.setToolTipText("Atualizar os dados do funcion\u00E1rio");
		btnUpdate.setBounds(144, 186, 64, 64);
		getContentPane().add(btnUpdate);

	} // Fim do construtor

	// Criar um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnRead;
	private JButton btnUpdate;

	/**
	 * Metodo responsavel por verificar o status da conexao com o banco
	 */
	private void status() {
		try {
			Connection con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/offdb.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/ondb.png")));
			}
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
					JOptionPane.showMessageDialog(null, "ID inexistente");
					txtId.setText(null);
					txtUsuario.setText(null);
					txtLogin.setText(null);
					txtSenha.setText(null);
					txtId.requestFocus();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(false);
				}
				// Fechar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do metodo pesquisar

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
			String update = "update contatos set usuario = ?, login = ?, senha = ? where id = ? ";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtId.getText());
				pst.setString(2, txtUsuario.getText());
				pst.setString(3, txtLogin.getText());
				pst.setString(4, txtSenha.getText());
				// Executar a query e confirmar a alteracao
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
	 * Metodo responsavel por excluir um funcionario
	 */
	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste funcionário ?", "ATENÇÃO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from contatos where id = ?";
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
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
		txtId.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnRead.setEnabled(true);
	} // Fim do metodo limpar
} // Fim do codigo
