package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
		lblUsuario.setBounds(5, 70, 55, 20);
		getContentPane().add(lblUsuario);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLogin.setBounds(5, 40, 55, 20);
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
		txtUsuario.setEnabled(false);
		txtUsuario.setToolTipText("Digite o nome completo do usuário");
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(65, 70, 250, 20);
		getContentPane().add(txtUsuario);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite o login do usuário");
		txtLogin.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtLogin.setColumns(10);
		txtLogin.setBounds(65, 40, 250, 20);
		getContentPane().add(txtLogin);

		cboPerfil = new JComboBox<Object>();
		cboPerfil.setEnabled(false);
		cboPerfil.setToolTipText("Selecione o perfil do usuário");
		cboPerfil.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "admin", "user" }));
		cboPerfil.setFont(new Font("Verdana", Font.PLAIN, 12));
		cboPerfil.setBounds(65, 130, 70, 22);
		getContentPane().add(cboPerfil);

		btnCreate = new JButton("");
		btnCreate.setEnabled(false);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setToolTipText("Adicionar usuário");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add-64.png")));
		btnCreate.setBounds(64, 170, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VERIFICAR SE O CHECKBOX ESTA HABILITADO
				if (!chkAlterarSenha.isSelected()) {
					alterarUsuarioSemAlterarSenha();
				} else {
					alterarUsuarioComSenha();
				}
			}
		});
		btnUpdate.setToolTipText("Atualizar informações do usuário");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update-64.png")));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(192, 170, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setToolTipText("Excluir usuário");
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete-64.png")));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(320, 170, 64, 64);
		getContentPane().add(btnDelete);

		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisar.setToolTipText("Digite o login e clique para pesquisar");
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search-24.png")));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBounds(325, 38, 24, 24);
		getContentPane().add(btnPesquisar);

		chkAlterarSenha = new JCheckBox("Alterar senha");
		chkAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setEditable(true);
				txtSenha.setText(null);
				txtSenha.setBackground(Color.ORANGE);
				txtSenha.setEnabled(true);
				txtSenha.requestFocus();
			}
		});
		chkAlterarSenha.setToolTipText("Alterar a senha do usuário");
		chkAlterarSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		chkAlterarSenha.setBounds(321, 100, 110, 20);
		getContentPane().add(chkAlterarSenha);
		chkAlterarSenha.setVisible(false);

		txtSenha = new JPasswordField();
		txtSenha.setEnabled(false);
		txtSenha.setToolTipText("Digite a senha do usuário");
		txtSenha.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtSenha.setBounds(65, 100, 250, 20);
		getContentPane().add(txtSenha);
		
		
		setLocationRelativeTo(null);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PESQUISAR E ACIONADO
		 */
		getRootPane().setDefaultButton(btnPesquisar);
		
		/**
		 * BIBLIOTECA ATXY2K
		 */
		
		/**
		 * txtLogin
		 */
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login = new RestrictedTextField(txtLogin,"abcdefghijklmnopqrstuvwywz1234567890.");
		login.setLimit(20);		
		
		/**
		 * txtUsuario
		 */
		RestrictedTextField usuario = new RestrictedTextField(txtUsuario);
		usuario.setOnlyText(true);
		usuario.setAcceptSpace(true);
		usuario.setLimit(50);
		
		

	} // FIM CONSTRUTOR

	DAO dao = new DAO();
	private JPasswordField txtSenha;

	/**
	 * PESQUISAR
	 */
	private void pesquisar() {
		/**
		 * VALIDACAO
		 */
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Login do usuário");
			txtLogin.requestFocus();
		} else {
			String read = "select * from usuarios where login = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(read);

				/**
				 * SUBSTITUIR INTERROGACAO PELO CAMPO NECESSARIO
				 */
				pst.setString(1, txtLogin.getText());

				/**
				 * OBTER DADOS
				 */
				ResultSet rs = pst.executeQuery();

				/**
				 * VERIFICAR SE EXISTE USUARIO COM O LOGIN CORRESPONDENTE
				 */
				if (rs.next()) {
					// txtId.setEnabled(false);
					txtId.setText(rs.getString(1));
					txtUsuario.setText(rs.getString(2));
					txtLogin.setText(rs.getString(3));
					txtSenha.setText(rs.getString(4));
					cboPerfil.setSelectedItem(rs.getString(5));

					/**
					 * HABILITAR BOTOES
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

					/**
					 * EXIBIR CHECKBOX
					 */
					chkAlterarSenha.setVisible(true);

					/**
					 * DESATIVAR A EDICAO DA SENHA
					 */
					txtSenha.setEditable(false);
					
					/**
					 * DESABILITAR PESQUISA
					 */
					btnPesquisar.setEnabled(false);
					
					/**
					 * HABILITAR CAMPOS
					 */
					txtUsuario.setEnabled(true);
					cboPerfil.setEnabled(true);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
					/**
					 * HABILITAR BOTAO ADICIONAR
					 */
					btnCreate.setEnabled(true);
					
					/**
					 * HABILITAR CAMPOS
					 */
					txtUsuario.setEnabled(true);
					txtSenha.setEnabled(true);
					cboPerfil.setEnabled(true);
					
					txtUsuario.requestFocus();
				}
				/**
				 * FECHAR CONEXAO
				 */
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM PESQUISAR

	/**
	 * ADICIONAR
	 */

	void adicionar() {
		/**
		 * VALIDACAO
		 */
		String capturaSenha = new String(txtSenha.getPassword());
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtSenha.requestFocus();
		} else {
			String create = "insert into usuarios (usuario, login, senha, perfil) values (?, ?, md5(?), ?)";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(create);

				/**
				 * SUBSTITUIR INTERROGACAO PELOS CAMPOS NECESSARIOS
				 */
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());

				/**
				 * EXECUTAR A CONFIRMAR
				 */
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
					limpar();
				}

				/**
				 * FECHAR CONEXAO
				 */
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Usuario existente - Usuario nao adicionado");
				txtLogin.setText(null);
				txtLogin.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	} // FIM ADICIONAR

	/**
	 * ALTERAR USUARIO COM SENHA
	 */

	private void alterarUsuarioComSenha() {
		String capturaSenha = new String(txtSenha.getPassword());
		/**
		 * VALIDACAO
		 */

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome completo");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtSenha.requestFocus();
		} else {
			String update = "update usuarios set usuario = ?, login = ?, senha = md5(?) , perfil = ? where id = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				pst.setString(5, txtId.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do usuario atualizados com sucesso!");
					limpar();
				}
				/**
				 * FECHA CONEXAO
				 */
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // FIM ALTERAR USUARIO COM SENHA

	/**
	 * ALTERAR USUARIO SEM ALTERAR SENHA
	 */

	private void alterarUsuarioSemAlterarSenha() {
		/**
		 * VALIDACAO
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
				 * ESTABELECER A CONEXAO
				 */

				Connection con = dao.conectar();
				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, cboPerfil.getSelectedItem().toString());
				pst.setString(4, txtId.getText());

				/**
				 * EXECUTAR E CONFIRMAR
				 */
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do usuario atualizados com sucesso!");
					limpar();
				}
				/**
				 * FECHAR CONEXAO
				 */
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM ALTERAR USUARIO SEM ALTERAR SENHA

	/**
	 * EXCLUIR
	 */

	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuario ?", "ATENÇÃO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from usuarios where id = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				/**
				 * EXECUTAR QUERY E CONFIRMAR EXCLUSAO
				 */
				int exclui = pst.executeUpdate();
				if (exclui == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso!");
				}
				/**
				 * FECHAR CONEXAO
				 */
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM EXCLUIR

	/**
	 * LIMPAR
	 */
	private void limpar() {
		txtId.setText(null);
		txtUsuario.setText(null);
		txtUsuario.setEnabled(false);
		txtLogin.setText(null);
		txtSenha.setText(null);
		txtSenha.setEditable(true);
		txtSenha.setEnabled(false);
		txtLogin.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnPesquisar.setEnabled(true);
		btnDelete.setEnabled(false);
		cboPerfil.setSelectedItem("");
		cboPerfil.setEnabled(false);
		txtSenha.setBackground(Color.WHITE);
		chkAlterarSenha.setSelected(false);
		chkAlterarSenha.setVisible(false);
	} // FIM LIMPAR

} // FIM CODIGO
