package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
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
		setModal(true);
		setBackground(SystemColor.textHighlight);
		setForeground(SystemColor.textHighlight);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/user.png")));
		setResizable(false);
		setTitle("Controle de Estoque - Usu\u00E1rios");
		setBounds(100, 100, 450, 329);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(SystemColor.desktop);
		lblId.setBounds(10, 20, 46, 14);
		getContentPane().add(lblId);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(10, 50, 46, 14);
		getContentPane().add(lblUsuario);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 80, 46, 14);
		getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 110, 46, 14);
		getContentPane().add(lblSenha);

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
		btnCreate.setToolTipText("Adicionar um novo funcionÃ¡rio");
		btnCreate.setBounds(61, 184, 64, 64);
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
		btnUpdate.setBounds(185, 184, 64, 64);
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
		btnDelete.setBounds(309, 184, 64, 64);
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
		btnRead.setBounds(184, 14, 24, 24);
		getContentPane().add(btnRead);

		/**
		 * Uso da tecla <Enter> junto com um botao
		 */
		getRootPane().setDefaultButton(btnRead);

		/**
		 * Uso da biblioteca atxy2k para restringir o maximo de caracteres
		 */

		/**
		 * txtUsuario
		 */
		RestrictedTextField usuario = new RestrictedTextField(txtUsuario);
		usuario.setOnlyText(true);
		usuario.setAcceptSpace(true);
		usuario.setLimit(50);

		/**
		 * txtLogin
		 */
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(50);
		
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(76, 107, 250, 20);
		getContentPane().add(txtPassword);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(10, 140, 46, 14);
		getContentPane().add(lblPerfil);
		
		cboPerfil = new JComboBox();
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] {"", "admin", "user"}));
		cboPerfil.setBounds(76, 140, 80, 22);
		getContentPane().add(cboPerfil);
		
		

	} // Fim do construtor

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRead;
	private JPasswordField txtPassword;
	private JComboBox cboPerfil;

	/**
	 * Metodo responsavel pela pesquisa por ID(Select)
	 */
	private void pesquisar() {

		/**
		 * validacao
		 */
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do funcionário");
			txtId.requestFocus();
		} else {
			String read = "select * from usuarios where id = ?";
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
				 * A linha abaixo substitui o ? pelo conteudo da caixa de texto txtId; o 1 faz
				 * referencia a interrogacao
				 */
				pst.setString(1, txtId.getText());
				/**
				 * Obter os dados do funcionario
				 */
				ResultSet rs = pst.executeQuery();
				/**
				 * Verificar se existe um funcionario cadastrado rs.next() significa ter um
				 * funcionario correspondente ao ID
				 */
				if (rs.next()) {
					txtId.setEnabled(false);
					txtUsuario.setText(rs.getString(2));
					txtLogin.setText(rs.getString(3));
					txtPassword.setText(rs.getString(4));
					cboPerfil.setSelectedItem(rs.getString(5));

					/**
					 * Habilitar botoes alterar e excluir
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
					txtId.setText(null);
					txtUsuario.setText(null);
					txtLogin.setText(null);
					txtPassword.setText(null);
					txtUsuario.requestFocus();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(false);
					txtId.setEnabled(false);
				}
				/**
				 * Fechar a conexao
				 */
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
		/**
		 * Validacao
		 */
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (txtPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a senha");
		} else {
			String create = "insert into usuarios (usuario, login, senha) values (?, ?, ?)";
			try {
				/**
				 * Estabelecer a conexao
				 */
				Connection con = dao.conectar();
				/**
				 * Prepara o codigo sql para execucao
				 */
				PreparedStatement pst = con.prepareStatement(create);
				/**
				 * A linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome, txtFone
				 * e txtEmail; o 1, 2, 3 faz referencia a interrogacao
				 */
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtPassword.getText());
				/**
				 * Executar a query e confirmar a insercao
				 */
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
					limpar();
				}
				/**
				 * Encerrar a conexao
				 */
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
		/**
		 * Validacao
		 */
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (txtPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a senha");
		} else {
			String update = "update usuarios set usuario = ?, login = ?, senha = ? where id = ?";
			try {
				/**
				 * Estabelecer a conexao
				 */
				Connection con = dao.conectar();
				/**
				 * Prepara o codigo sql para execucao
				 */
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtPassword.getText());
				pst.setString(4, txtId.getText());
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do funcionário atualizados com sucesso!");
					limpar();
				}
				/**
				 * Encerrar a conexao
				 */
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
				/**
				 * Estabelecer a conexao
				 */
				Connection con = dao.conectar();
				/**
				 * Prepara o codigo sql para execucao
				 */
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				/**
				 * Executar a query e confirmar a exclusao
				 */
				int exclui = pst.executeUpdate();
				if (exclui == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
				}
				/**
				 * Encerrar a conexao
				 */
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
		txtPassword.setText(null);
		txtId.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnRead.setEnabled(true);
		btnDelete.setEnabled(false);
	} // Fim do metodo limpar
} // Fim do codigo
