package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		btnCreate.setBounds(51, 137, 64, 64);
		contentPane.add(btnCreate);

		JButton btnDelete = new JButton("");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorderPainted(false);
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Remover contato");
		btnDelete.setBounds(166, 137, 64, 64);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setToolTipText("Atualizar contato");
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBounds(281, 137, 64, 64);
		contentPane.add(btnUpdate);

		JButton btnRead = new JButton("");
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setToolTipText("Pesquisar");
		btnRead.setIcon(new ImageIcon(Agenda.class.getResource("/img/search-24.png")));
		btnRead.setBounds(326, 37, 24, 24);
		contentPane.add(btnRead);

		lblStatus = new JLabel("New label");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(396, 145, 48, 48);
		contentPane.add(lblStatus);
	} // Fim do construtor

	// Criar um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;

	/**
	 * Metodo responsavel por verificar o status da conexao com o banco
	 */
	private void status() {

		// Uso da classe Connection (JDBC) para estabelecer a conexao
		Connection con = dao.conectar();
		if (con == null) {
			System.out.println("Erro de conexão");
			lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		} else {
			System.out.println("Banco conectado!");
			lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
		}

	}
}
