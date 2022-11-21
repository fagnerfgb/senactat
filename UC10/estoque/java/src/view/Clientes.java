package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txtId;
	private JTextField txtNomeCliente;
	private JTextField txtCnpjCpf;
	private JTextField txtIeRg;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtEmail;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtAtividadeProfissao;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
	private JTextField txtWhatsapp;
	private JTable table;
	private JButton btnPesquisarId;
	private JButton btnPesquisarCep;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox<Object> cboUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setTitle("Controle de Estoque | Clientes");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 787, 522);
		getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCliente.setBounds(5, 10, 50, 20);
		getContentPane().add(lblCliente);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(5, 200, 85, 20);
		getContentPane().add(lblId);

		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNomeCliente.setBounds(215, 200, 90, 20);
		getContentPane().add(lblNomeCliente);

		JLabel lblCnpjCpf = new JLabel("CPF / CNPJ");
		lblCnpjCpf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCnpjCpf.setBounds(5, 230, 80, 20);
		getContentPane().add(lblCnpjCpf);

		JLabel lblIeRg = new JLabel("RG / IE");
		lblIeRg.setFont(new Font("Verdana", Font.BOLD, 12));
		lblIeRg.setBounds(255, 230, 50, 20);
		getContentPane().add(lblIeRg);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCep.setBounds(5, 260, 85, 20);
		getContentPane().add(lblCep);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEndereco.setBounds(265, 261, 65, 20);
		getContentPane().add(lblEndereco);

		JLabel lblNumero = new JLabel("Nº");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNumero.setBounds(5, 290, 20, 20);
		getContentPane().add(lblNumero);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblComplemento.setBounds(225, 290, 90, 20);
		getContentPane().add(lblComplemento);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBairro.setBounds(5, 320, 85, 20);
		getContentPane().add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCidade.setBounds(355, 320, 45, 20);
		getContentPane().add(lblCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUf.setBounds(670, 320, 20, 20);
		getContentPane().add(lblUf);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefone.setBounds(5, 380, 60, 20);
		getContentPane().add(lblTelefone);

		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Verdana", Font.BOLD, 12));
		lblWhatsapp.setBounds(355, 380, 70, 20);
		getContentPane().add(lblWhatsapp);

		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNascimento.setBounds(475, 230, 80, 20);
		getContentPane().add(lblNascimento);

		JLabel lblAtividadeProfissao = new JLabel("Atividade / Profissão");
		lblAtividadeProfissao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAtividadeProfissao.setBounds(355, 350, 140, 20);
		getContentPane().add(lblAtividadeProfissao);

		txtCliente = new JTextField();
		txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarComFiltro();
			}
		});
		txtCliente.setBounds(65, 10, 300, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);

		txtId = new JTextField();
		txtId.setBounds(95, 200, 80, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		btnPesquisarId = new JButton("");
		btnPesquisarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisarId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisarId.setContentAreaFilled(false);
		btnPesquisarId.setBorderPainted(false);
		btnPesquisarId.setIcon(new ImageIcon(Clientes.class.getResource("/img/search-24.png")));
		btnPesquisarId.setBounds(180, 198, 24, 24);
		getContentPane().add(btnPesquisarId);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(315, 200, 445, 20);
		getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtCnpjCpf = new JTextField();
		txtCnpjCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.-/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCnpjCpf.setEnabled(false);
		txtCnpjCpf.setBounds(95, 230, 150, 20);
		getContentPane().add(txtCnpjCpf);
		txtCnpjCpf.setColumns(10);

		txtIeRg = new JTextField();
		txtIeRg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.-/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtIeRg.setEnabled(false);
		txtIeRg.setColumns(10);
		txtIeRg.setBounds(315, 230, 150, 20);
		getContentPane().add(txtIeRg);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCep.setEnabled(false);
		txtCep.setColumns(10);
		txtCep.setBounds(95, 260, 100, 20);
		getContentPane().add(txtCep);

		btnPesquisarCep = new JButton("");
		btnPesquisarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnPesquisarCep.setEnabled(false);
		btnPesquisarCep.setContentAreaFilled(false);
		btnPesquisarCep.setBorderPainted(false);
		btnPesquisarCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisarCep.setIcon(new ImageIcon(Clientes.class.getResource("/img/search-24.png")));
		btnPesquisarCep.setBounds(200, 258, 24, 24);
		getContentPane().add(btnPesquisarCep);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(5, 350, 85, 20);
		getContentPane().add(lblEmail);

		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(340, 261, 420, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(95, 320, 250, 20);
		getContentPane().add(txtBairro);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 350, 250, 20);
		getContentPane().add(txtEmail);

		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(95, 290, 120, 20);
		getContentPane().add(txtNumero);

		txtComplemento = new JTextField();
		txtComplemento.setEnabled(false);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(325, 290, 185, 20);
		getContentPane().add(txtComplemento);

		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(410, 320, 250, 20);
		getContentPane().add(txtCidade);

		txtAtividadeProfissao = new JTextField();
		txtAtividadeProfissao.setEnabled(false);
		txtAtividadeProfissao.setBounds(505, 350, 255, 20);
		getContentPane().add(txtAtividadeProfissao);
		txtAtividadeProfissao.setColumns(10);

		cboUf = new JComboBox<Object>();
		cboUf.setEnabled(false);
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(700, 320, 60, 20);
		getContentPane().add(cboUf);

		txtNascimento = new JTextField();
		txtNascimento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtNascimento.setEnabled(false);
		txtNascimento.setBounds(565, 230, 195, 20);
		getContentPane().add(txtNascimento);
		txtNascimento.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890-()";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtTelefone.setEnabled(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(95, 380, 250, 20);
		getContentPane().add(txtTelefone);

		txtWhatsapp = new JTextField();
		txtWhatsapp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890-()";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtWhatsapp.setEnabled(false);
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(435, 380, 250, 20);
		getContentPane().add(txtWhatsapp);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 40, 755, 150);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				txtId.setText(table.getModel().getValueAt(setar, 0).toString());
			}
		});
		scrollPane.setViewportView(table);

		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setIcon(new ImageIcon(Clientes.class.getResource("/img/add-64.png")));
		btnCreate.setToolTipText("Adicionar Cliente");
		btnCreate.setEnabled(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBounds(568, 410, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Clientes.class.getResource("/img/update-64.png")));
		btnUpdate.setToolTipText("Atualizar dados do cliente");
		btnUpdate.setEnabled(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(632, 410, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete-64.png")));
		btnDelete.setToolTipText("Excluir cliente");
		btnDelete.setEnabled(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(696, 410, 64, 64);
		getContentPane().add(btnDelete);

		lblStatusCep = new JLabel("");
		lblStatusCep.setBounds(230, 260, 24, 24);
		getContentPane().add(lblStatusCep);

		setLocationRelativeTo(null);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PESQUISAR E ACIONADO
		 */
		getRootPane().setDefaultButton(btnPesquisarId);

		/**
		 * BIBLIOTECA ATXY2K
		 */

		/**
		 * txtNomeCliente
		 */
		RestrictedTextField cliente = new RestrictedTextField(txtNomeCliente);
		cliente.setLimit(60);

		/**
		 * txtCnpjCpf
		 */
		RestrictedTextField cnpjCpf = new RestrictedTextField(txtCnpjCpf);
		cnpjCpf.setLimit(20);

		/**
		 * txtIeRg
		 */
		RestrictedTextField ieRg = new RestrictedTextField(txtIeRg);
		ieRg.setLimit(20);

		/**
		 * txtCep
		 */
		RestrictedTextField cep = new RestrictedTextField(txtCep);
		cep.setLimit(10);

		/**
		 * txtEndereco
		 */
		RestrictedTextField endereco = new RestrictedTextField(txtEndereco);
		endereco.setLimit(50);

		/**
		 * txtNumero
		 */
		RestrictedTextField numero = new RestrictedTextField(txtNumero);
		numero.setLimit(6);

		/**
		 * txtComplemento
		 */
		RestrictedTextField complemento = new RestrictedTextField(txtComplemento);
		complemento.setLimit(20);

		/**
		 * txtBairro
		 */
		RestrictedTextField bairro = new RestrictedTextField(txtBairro);
		bairro.setLimit(50);

		/**
		 * txtCidade
		 */
		RestrictedTextField cidade = new RestrictedTextField(txtCidade);
		cidade.setLimit(50);

		/**
		 * txtTelefone
		 */
		RestrictedTextField fone = new RestrictedTextField(txtTelefone);
		fone.setLimit(15);

		/**
		 * txtWhatsapp
		 */
		RestrictedTextField whatsapp = new RestrictedTextField(txtWhatsapp);
		whatsapp.setLimit(15);

		/**
		 * txtEmail
		 */
		RestrictedTextField email = new RestrictedTextField(txtEmail);
		email.setLimit(50);

		/**
		 * txtNascimento
		 */
		RestrictedTextField nascimento = new RestrictedTextField(txtNascimento);
		nascimento.setLimit(11);

		/**
		 * txtAtividadeProfissao
		 */
		RestrictedTextField atividadeProfissao = new RestrictedTextField(txtAtividadeProfissao);
		atividadeProfissao.setLimit(50);

	}// FIM DO CONSTRUTOR

	DAO dao = new DAO();
	private JLabel lblStatusCep;

	/**
	 * PESQUISA AVANCADA COM FILTRO
	 */

	private void pesquisarComFiltro() {
		String read2 = "select idCli as ID, nomeCliente as Cliente, fone1 as Telefone, fone2 as Whatsapp from clientes where nomeCliente like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtCliente.getText() + "%"); // ATENCAO AO "%"
			ResultSet rs = pst.executeQuery();

			/**
			 * USO DA BIBLIOTECA RS2XML PARA POPULAR A TABELA
			 */
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	} // FIM PESQUISAR COM FILTRO

	/**
	 * PESQUISAR
	 */

	private void pesquisar() {

		/**
		 * VALIDACAO
		 */
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do cliente");
			txtId.requestFocus();
		} else {
			String read = "select * from clientes where idCli = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtNomeCliente.setText(rs.getString(2));
					txtCnpjCpf.setText(rs.getString(3));
					txtIeRg.setText(rs.getString(4));
					txtCep.setText(rs.getString(5));
					txtEndereco.setText(rs.getString(6));
					txtNumero.setText(rs.getString(7));
					txtComplemento.setText(rs.getString(8));
					txtBairro.setText(rs.getString(9));
					txtCidade.setText(rs.getString(10));
					cboUf.setSelectedItem(rs.getString(11));
					txtTelefone.setText(rs.getString(12));
					txtWhatsapp.setText(rs.getString(13));
					txtEmail.setText(rs.getString(14));
					txtNascimento.setText(rs.getString(15));
					txtAtividadeProfissao.setText(rs.getString(16));

					/**
					 * HABILITAR BOTOES
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnPesquisarId.setEnabled(false);
					btnPesquisarCep.setEnabled(true);

					/**
					 * HABILITAR CAMPOS
					 */
					txtNomeCliente.setEnabled(true);
					txtCnpjCpf.setEnabled(true);
					txtIeRg.setEnabled(true);
					txtNomeCliente.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtTelefone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtEmail.setEnabled(true);
					txtAtividadeProfissao.setEnabled(true);
					txtNascimento.setEnabled(true);
					txtId.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
					/**
					 * HABILITAR CAMPOS E BOTOES
					 */
					btnCreate.setEnabled(true);
					btnPesquisarId.setEnabled(false);
					btnPesquisarCep.setEnabled(true);
					txtCnpjCpf.setEnabled(true);
					txtIeRg.setEnabled(true);
					txtNomeCliente.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtTelefone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtEmail.setEnabled(true);
					txtNomeCliente.requestFocus();
					txtId.setEnabled(false);
					txtNascimento.setEnabled(true);
					txtAtividadeProfissao.setEnabled(true);
					btnPesquisarCep.setEnabled(true);
					txtId.setText(null);

				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM PESQUISAR

	/**
	 * ADICIONAR
	 */

	public void adicionar() {
		/**
		 * VALIDACAO
		 */

		if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Cliente");
			txtNomeCliente.requestFocus();
		} else if (txtCnpjCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ ou o CPF");
			txtCnpjCpf.requestFocus();
		} else if (txtIeRg.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscrição Estadual ou o RG");
			txtIeRg.requestFocus();
		} else if (txtNascimento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a data de nascimento ou de fundação");
			txtNascimento.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o endereco");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o numero");
			txtNumero.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a cidade");
			txtCidade.requestFocus();
		} else if (cboUf.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Selecione o estado");
			cboUf.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail do cliente");
			txtEmail.requestFocus();
		} else if (txtAtividadeProfissao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a atividade ou a profissão do cliente");
			txtAtividadeProfissao.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone do cliente");
			txtTelefone.requestFocus();

		} else {
			String create = "insert into clientes (nomeCliente, cnpjCpf, ieRg, cep, endereco, numero, complemento, bairro, cidade, uf, fone1, fone2, email, nascimento, atividadeProfissao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNomeCliente.getText());
				pst.setString(2, txtCnpjCpf.getText());
				pst.setString(3, txtIeRg.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtEndereco.getText());
				pst.setString(6, txtNumero.getText());
				pst.setString(7, txtComplemento.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, cboUf.getSelectedItem().toString());
				pst.setString(11, txtTelefone.getText());
				pst.setString(12, txtWhatsapp.getText());
				pst.setString(13, txtEmail.getText());
				pst.setString(14, txtNascimento.getText());
				pst.setString(15, txtAtividadeProfissao.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
					limpar();
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM ADICIONAR

	/**
	 * ALTERAR
	 */

	private void alterar() {
		/**
		 * VALIDACAO
		 */

		if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Cliente");
			txtNomeCliente.requestFocus();
		} else if (txtCnpjCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ ou o CPF");
			txtCnpjCpf.requestFocus();
		} else if (txtIeRg.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscrição Estadual ou o RG");
			txtIeRg.requestFocus();
		} else if (txtNascimento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a data de nascimento ou de fundação");
			txtNascimento.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o endereco");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o numero");
			txtNumero.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a cidade");
			txtCidade.requestFocus();
		} else if (cboUf.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Selecione o estado");
			cboUf.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail do cliente");
			txtEmail.requestFocus();
		} else if (txtAtividadeProfissao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a atividade ou a profissão do cliente");
			txtAtividadeProfissao.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone do cliente");
			txtTelefone.requestFocus();
		} else {
			String update = "update clientes set nomeCliente = ?, cnpjCpf = ?, ieRG = ?, cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, fone1 = ?, fone2 = ?, email = ?, nascimento = ?, atividadeProfissao = ? where idCli = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtNomeCliente.getText());
				pst.setString(2, txtCnpjCpf.getText());
				pst.setString(3, txtIeRg.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtEndereco.getText());
				pst.setString(6, txtNumero.getText());
				pst.setString(7, txtComplemento.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, cboUf.getSelectedItem().toString());
				pst.setString(11, txtTelefone.getText());
				pst.setString(12, txtWhatsapp.getText());
				pst.setString(13, txtEmail.getText());
				pst.setString(14, txtNascimento.getText());
				pst.setString(15, txtAtividadeProfissao.getText());
				pst.setString(16, txtId.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do cliente atualizados com sucesso!");
					limpar();
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
				}
				/**
				 * FECHA CONEXAO
				 */
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // FIM ALTERAR

	/**
	 * EXCLUIR
	 */

	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusao do cliente ?", "ATENCAO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from clientes where idCli = ?";
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
					JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
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
	 * BUSCAR CEP
	 */

	void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatusCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP nao encontrado! ");
						txtCep.setText(null);
						txtCep.requestFocus();
					}
				}
			}
			// setar o campo endereço
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM BUSCAR CEP

	/**
	 * LIMPAR
	 */

	public void limpar() {
		txtCliente.setText(null);
		txtId.setText(null);
		txtCnpjCpf.setText(null);
		txtIeRg.setText(null);
		txtNomeCliente.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem("");
		txtTelefone.setText(null);
		txtWhatsapp.setText(null);
		txtEmail.setText(null);
		txtNascimento.setText(null);
		txtAtividadeProfissao.setText(null);
		txtCnpjCpf.setEnabled(false);
		txtIeRg.setEnabled(false);
		txtNomeCliente.setEnabled(false);
		txtCep.setEnabled(false);
		txtEndereco.setEnabled(false);
		txtNumero.setEnabled(false);
		txtComplemento.setEnabled(false);
		txtBairro.setEnabled(false);
		txtCidade.setEnabled(false);
		cboUf.setEnabled(false);
		txtTelefone.setEnabled(false);
		txtWhatsapp.setEnabled(false);
		txtEmail.setEnabled(false);
		txtNascimento.setEnabled(false);
		txtAtividadeProfissao.setEnabled(false);
		txtId.setEnabled(true);
		txtId.requestFocus();
		btnPesquisarId.setEnabled(true);
		btnPesquisarCep.setEnabled(false);
		btnCreate.setEnabled(false);
		lblStatusCep.setIcon(null);
		((DefaultTableModel) table.getModel()).setRowCount(0);
	} // FIM LIMPAR
}// FIM DO CODIGO
