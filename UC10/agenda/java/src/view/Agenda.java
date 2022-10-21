package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor
	 */
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Agenda de Contatos");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setEnabled(false);
		lblId.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblId.setBounds(360, 40, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(390, 37, 100, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(10, 40, 46, 14);
		contentPane.add(lblNome);

		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFone.setBounds(10, 70, 46, 14);
		contentPane.add(lblFone);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEmail.setBounds(10, 100, 46, 14);
		contentPane.add(lblEmail);

		txtNome = new JTextField();
		txtNome.setBounds(66, 37, 250, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtFone = new JTextField();
		txtFone.setBounds(66, 67, 250, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(66, 97, 250, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnCreate = new JButton("");
		btnCreate.setEnabled(false);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarContato();
			}
		});
		btnCreate.setContentAreaFilled(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBorderPainted(false);
		btnCreate.setToolTipText("Adicionar  contato");
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/add.png")));
		btnCreate.setBounds(48, 137, 64, 64);
		contentPane.add(btnCreate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorderPainted(false);
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Remover contato");
		btnDelete.setBounds(272, 137, 64, 64);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarContato();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setToolTipText("Atualizar contato");
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBounds(160, 137, 64, 64);
		contentPane.add(btnUpdate);

		btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarContato();
			}
		});
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setToolTipText("Pesquisar");
		btnRead.setIcon(new ImageIcon(Agenda.class.getResource("/img/search-24.png")));
		btnRead.setBounds(326, 37, 24, 24);
		contentPane.add(btnRead);

		lblStatus = new JLabel("New label");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(416, 68, 48, 48);
		contentPane.add(lblStatus);

		// Uso da tecla <Enter> junto com um botao
		getRootPane().setDefaultButton(btnRead);

		// Uso da biblioteca atxy2k para restringir o maximo de caracteres
		// txtNome
		RestrictedTextField nome = new RestrictedTextField(txtNome);
		nome.setOnlyText(true);
		nome.setAcceptSpace(true);
		nome.setLimit(50);

		// txtFone
		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone.setLimit(15);
		fone.setOnlyNums(true);

		// txtEmail
		RestrictedTextField email = new RestrictedTextField(txtEmail);
		email.setOnlyText(false);
		email.setAcceptSpace(false);
		email.setLimit(50);

		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setIcon(new ImageIcon(Agenda.class.getResource("/img/eraser.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(384, 137, 64, 64);
		contentPane.add(btnLimpar);
	} // Fim do construtor

	// Criar um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCreate;
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
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				// System.out.println("Banco conectado!");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
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
	private void pesquisarContato() {

		// Validacao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Contato");
			txtNome.requestFocus();
		} else {
			// System.out.println("Teste pesquisar");
			// Iniciar com a instrucao sql
			// ? e um parametro a ser substituido
			String read = "select * from contatos where nome = ?";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(read);
				// A linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome;
				// o 1 faz referencia a interrogacao
				pst.setString(1, txtNome.getText());
				// Obter os dados do usuario
				ResultSet rs = pst.executeQuery();
				// Verificar se existe um contato cadastrado
				// rs.next() significa ter um contato correspondente ao nome pesquisar
				if (rs.next()) {
					// Setar as caixas de texto com o resultado da pesquisa
					txtId.setText(rs.getString(1));
					txtFone.setText(rs.getString(3));
					txtEmail.setText(rs.getString(4));

					// Habilitar botoes alterar e excluir
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Contato inexistente");
					txtFone.setText(null);
					txtEmail.setText(null);
					txtFone.requestFocus();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(false);
				}
				// Fechar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // Fim do metodo pesquisarContato

	/**
	 * Metodo responsavel pelo cadastro de um novo contato
	 */

	void adicionarContato() {
		// Validacao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone");
			txtFone.requestFocus();
		} else {
			// System.out.println("Teste");
			String create = "insert into contatos (nome, fone, email) values (?, ?, ?)";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(create);
				// A linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome, txtFone
				// e txtEmail;
				// o 1, 2, 3 faz referencia a interrogacao
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// Executar a query e confirmar a insercao
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!");
					limpar();
				}
				// Encerrar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do Metodo adicionarContato

	/**
	 * Metodo responsavel por alterar informacoes do contato
	 */

	private void alterarContato() {
		// Validacao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone");
			txtFone.requestFocus();
		} else {
			// System.out.println("Alterado");
			String update = "update contatos set nome = ?, fone = ?, email = ? where id = ? ";
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Prepara o codigo sql para execucao
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtId.getText());
				// Executar a query e confirmar a alteracao
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
					limpar();
				}
				// Encerrar a conexao
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // Fim do metodo alterarContato

	/**
	 * Metodo responsavel por excluir um contato
	 */
	private void excluirContato() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato ?", "ATENÇÃO",
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
					JOptionPane.showMessageDialog(null, "Contato excluído com sucesso!");					
				}
				// Encerrar a conexao
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do metodo excluirContato

	/**
	 * Metodo usado para limpar os campos
	 */
	private void limpar() {
		txtId.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtNome.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnRead.setEnabled(true);
	} // Fim do metodo limpar
} // Fim do codigo
