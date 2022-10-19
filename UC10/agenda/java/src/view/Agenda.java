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
		lblId.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblId.setBounds(360, 40, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
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

		JButton btnCreate = new JButton("");
		btnCreate.setContentAreaFilled(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBorderPainted(false);
		btnCreate.setToolTipText("Adicionar  contato");
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/add.png")));
		btnCreate.setBounds(76, 137, 64, 64);
		contentPane.add(btnCreate);

		JButton btnDelete = new JButton("");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorderPainted(false);
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Remover contato");
		btnDelete.setBounds(216, 137, 64, 64);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setToolTipText("Atualizar contato");
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBounds(356, 137, 64, 64);
		contentPane.add(btnUpdate);

		JButton btnRead = new JButton("");
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
	} // Fim do construtor

	// Criar um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;

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
		// System.out.println("Teste pesquisar");
		// Iniciar com a instrucao sql
		// ? e um parametro a ser substituido
		String read = "select * from contatos where nome = ?";
		try {
			// Estabelecer a conexao
			Connection con = dao.conectar();
			// Prepara o código sql para execucao
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
				
			} else {
				JOptionPane.showMessageDialog(null, "Contato inexistente");
			}
			// Fechar a conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	} // Fim do metodo pesquisarContato
} // Fim do codigo
