package view;

import java.awt.Color;
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
import javax.swing.JCheckBox;

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
		txtId.setEnabled(false);
		txtId.setBounds(76, 17, 100, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Insira o nome completo do usu�rio");
		txtUsuario.setBounds(76, 47, 250, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("primeironome.�ltimonome");
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
		btnCreate.setToolTipText("Adicionar um novo funcionário");
		btnCreate.setBounds(61, 184, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar se o checkbox esta selecionado
				if (chckSenha.isSelected()) {
					alterar();
					//System.out.println("Senha alterada");
				} else {
					alterarUsuarioSenha();
				}
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
		btnDelete.setToolTipText("Excluir um funcion�rio");
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
		btnRead.setBounds(334, 75, 24, 24);
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

		cboPerfil = new JComboBox<Object>();
		cboPerfil.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "admin", "user" }));
		cboPerfil.setBounds(76, 140, 80, 22);
		getContentPane().add(cboPerfil);

		chckSenha = new JCheckBox("Alterar senha");
		chckSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fazer o check na caixa Jcheckbox
				txtPassword.setEditable(true);
				txtPassword.setText(null);
				txtPassword.requestFocus();
				txtPassword.setBackground(Color.ORANGE);
			}
		});
		chckSenha.setVisible(false);
		chckSenha.setBounds(325, 106, 103, 23);
		getContentPane().add(chckSenha);

	} // Fim do construtor

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRead;
	private JPasswordField txtPassword;
	private JComboBox<Object> cboPerfil;
	private JCheckBox chckSenha;

	/**
	 * Metodo responsavel pela pesquisa por ID(Select)
	 */
	private void pesquisar() {

		/**
		 * validacao
		 */
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Login do usuário");
			txtLogin.requestFocus();
		} else {
			String read = "select * from usuarios where login = ?";
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
				pst.setString(1, txtLogin.getText());
				/**
				 * Obter os dados do funcionario
				 */
				ResultSet rs = pst.executeQuery();
				/**
				 * Verificar se existe um funcionario cadastrado rs.next() significa ter um
				 * funcionario correspondente ao ID
				 */
				if (rs.next()) {
					//txtId.setEnabled(false);
					txtId.setText(rs.getString(1));
					txtUsuario.setText(rs.getString(2));
					txtLogin.setText(rs.getString(3));
					txtPassword.setText(rs.getString(4));
					cboPerfil.setSelectedItem(rs.getString(5));

					/**
					 * Habilitar botoes alterar e excluir
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

					// Exibir o checkbox
					chckSenha.setVisible(true);

					// Desativar a edição da senha
					txtPassword.setEditable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
					limpar();
					btnCreate.setEnabled(true);
					txtUsuario.requestFocus();
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
		String capturaSenha = new String(txtPassword.getPassword());
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtPassword.requestFocus();
		} else {
			String create = "insert into usuarios (usuario, login, senha, perfil) values (?, ?, md5(?), ?)";
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
				 * A linha abaixo substitui o ? pelo conteudo da caixa de texto txtUsuario,
				 * txtLogin e txtSenha e cboPerfil
				 */
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				/**
				 * Executar a query e confirmar a insercao
				 */
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!");
					limpar();
				}
				/**
				 * Encerrar a conexao
				 */
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Usuario existente - Usuario nao adicionado");
				txtLogin.setText(null);
				txtLogin.requestFocus();
			} 
			catch (Exception e2) {
				System.out.println(e2);
			} 
		}
	} // Fim do Metodo adicionar

	/**
	 * Metodo responsavel por alterar informacoes do funcionario
	 */

	private void alterar() {
		String capturaSenha = new String(txtPassword.getPassword());
		/**
		 * Validacao
		 */

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtPassword.requestFocus();
		} else {
			String update = "update usuarios set usuario = ?, login = ?, senha = md5(?) , perfil = ? where id = ?";
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
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				pst.setString(5, txtId.getText());
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

	private void alterarUsuarioSenha() {
		/**
		 * Validacao
		 */

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else {
			String update = "update usuarios set usuario = ?, login = ?, perfil = ? where id = ?";
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
				pst.setString(3, cboPerfil.getSelectedItem().toString());
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

	}

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
		//txtId.setEnabled(true);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtPassword.setText(null);
		txtPassword.setEditable(true);
		txtLogin.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnRead.setEnabled(true);
		btnDelete.setEnabled(false);
		cboPerfil.setSelectedItem("");
		txtPassword.setBackground(Color.WHITE);
		chckSenha.setSelected(false);
		chckSenha.setVisible(false);

	} // Fim do metodo limpar
} // Fim do codigo
