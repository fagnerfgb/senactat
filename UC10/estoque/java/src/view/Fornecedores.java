package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Fornecedores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFornecedor;
	private JTextField txtId;
	private JTextField txtRazaoSocial;
	private JTextField txtNomeFantasia;
	private JTextField txtCnpj;
	private JTextField txtIe;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtContato;
	private JTextField txtFone;
	private JTextField txtWhatsapp;
	private JTextField txtEmail;
	private JTextField txtSite;
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
					Fornecedores dialog = new Fornecedores();
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
	public Fornecedores() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFornecedor.setBounds(5, 10, 100, 20);
		getContentPane().add(lblFornecedor);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(5, 220, 100, 20);
		getContentPane().add(lblId);

		JLabel lblRazaoSocial = new JLabel("Razão Social");
		lblRazaoSocial.setFont(new Font("Verdana", Font.BOLD, 12));
		lblRazaoSocial.setBounds(5, 250, 100, 20);
		getContentPane().add(lblRazaoSocial);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCep.setBounds(5, 280, 100, 20);
		getContentPane().add(lblCep);

		txtFornecedor = new JTextField();
		txtFornecedor.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFornecedor.setToolTipText("Digite o nome do fornecedor");
		txtFornecedor.setColumns(10);
		txtFornecedor.setBounds(110, 10, 300, 20);
		getContentPane().add(txtFornecedor);

		txtId = new JTextField();
		txtId.setToolTipText("Digite o ID do fornecedor");
		txtId.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtId.setColumns(10);
		txtId.setBounds(110, 220, 80, 20);
		getContentPane().add(txtId);

		btnPesquisarId = new JButton("");
		btnPesquisarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisarId.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisarId.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/search-24.png")));
		btnPesquisarId.setToolTipText("Buscar ID");
		btnPesquisarId.setContentAreaFilled(false);
		btnPesquisarId.setBorderPainted(false);
		btnPesquisarId.setBounds(195, 218, 24, 24);
		getContentPane().add(btnPesquisarId);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCnpj.setBounds(235, 220, 35, 20);
		getContentPane().add(lblCnpj);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setEnabled(false);
		txtRazaoSocial.setToolTipText("Digite a Razão Social do Fornecedor");
		txtRazaoSocial.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(110, 250, 490, 20);
		getContentPane().add(txtRazaoSocial);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNomeFantasia.setBounds(605, 250, 100, 20);
		getContentPane().add(lblNomeFantasia);

		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setEnabled(false);
		txtNomeFantasia.setToolTipText("Digite o Nome Fantasia do fornecedor");
		txtNomeFantasia.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(715, 250, 200, 20);
		getContentPane().add(txtNomeFantasia);

		txtCnpj = new JTextField();
		txtCnpj.setEnabled(false);
		txtCnpj.setToolTipText("Digite o CNPJ do fornecedor");
		txtCnpj.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(280, 220, 150, 20);
		getContentPane().add(txtCnpj);

		JLabel lblIe = new JLabel("I.E.");
		lblIe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblIe.setBounds(440, 220, 25, 20);
		getContentPane().add(lblIe);

		txtIe = new JTextField();
		txtIe.setEnabled(false);
		txtIe.setToolTipText("Digite o número de Inscricação Estadual do fornecedor");
		txtIe.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIe.setColumns(10);
		txtIe.setBounds(475, 220, 150, 20);
		getContentPane().add(txtIe);

		JLabel lblObservacao = new JLabel("Observação");
		lblObservacao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblObservacao.setBounds(5, 430, 100, 20);
		getContentPane().add(lblObservacao);

		txtCep = new JTextField();
		txtCep.setEnabled(false);
		txtCep.setToolTipText("Digite o CEP do fornecedor");
		txtCep.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCep.setColumns(10);
		txtCep.setBounds(110, 280, 100, 20);
		getContentPane().add(txtCep);

		btnPesquisarCep = new JButton("");
		btnPesquisarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnPesquisarCep.setEnabled(false);
		btnPesquisarCep.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/search-24.png")));
		btnPesquisarCep.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisarCep.setToolTipText("Buscar CEP");
		btnPesquisarCep.setContentAreaFilled(false);
		btnPesquisarCep.setBorderPainted(false);
		btnPesquisarCep.setBounds(215, 278, 24, 24);
		getContentPane().add(btnPesquisarCep);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEndereco.setBounds(5, 310, 100, 20);
		getContentPane().add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setToolTipText("Digite o endereço do Fornecedor");
		txtEndereco.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(110, 310, 350, 20);
		getContentPane().add(txtEndereco);

		JLabel lblNumero = new JLabel("Nº");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNumero.setBounds(470, 310, 20, 20);
		getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setToolTipText("Digite o número do fornecedor");
		txtNumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		txtNumero.setBounds(500, 310, 120, 20);
		getContentPane().add(txtNumero);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblComplemento.setBounds(630, 310, 90, 20);
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setEnabled(false);
		txtComplemento.setToolTipText("Digite o complemento do endereço do fornecedor");
		txtComplemento.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(730, 310, 185, 20);
		getContentPane().add(txtComplemento);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBairro.setBounds(5, 340, 100, 20);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setToolTipText("Digite o bairro do Fornecedor");
		txtBairro.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		txtBairro.setBounds(110, 340, 320, 20);
		getContentPane().add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCidade.setBounds(440, 340, 45, 20);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setToolTipText("Digite a cidade do Fornecedor");
		txtCidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(495, 340, 320, 20);
		getContentPane().add(txtCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUf.setBounds(825, 340, 20, 20);
		getContentPane().add(lblUf);

		cboUf = new JComboBox<Object>();
		cboUf.setEnabled(false);
		cboUf.setToolTipText("Selecione o estado do fornecedor");
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setFont(new Font("Verdana", Font.PLAIN, 11));
		cboUf.setBounds(855, 340, 60, 20);
		getContentPane().add(cboUf);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContato.setBounds(5, 370, 100, 20);
		getContentPane().add(lblContato);

		txtContato = new JTextField();
		txtContato.setEnabled(false);
		txtContato.setToolTipText("Digite o nome do contato do Fornecedor");
		txtContato.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtContato.setColumns(10);
		txtContato.setBounds(110, 370, 320, 20);
		getContentPane().add(txtContato);

		JLabel lblFone = new JLabel("Telefone");
		lblFone.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFone.setBounds(440, 370, 60, 20);
		getContentPane().add(lblFone);

		txtFone = new JTextField();
		txtFone.setEnabled(false);
		txtFone.setToolTipText("Digite o telefone do Fornecedor");
		txtFone.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFone.setColumns(10);
		txtFone.setBounds(510, 370, 120, 20);
		getContentPane().add(txtFone);

		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Verdana", Font.BOLD, 12));
		lblWhatsapp.setBounds(640, 370, 70, 20);
		getContentPane().add(lblWhatsapp);

		txtWhatsapp = new JTextField();
		txtWhatsapp.setEnabled(false);
		txtWhatsapp.setToolTipText("Digite o Whatsapp do fornecedor");
		txtWhatsapp.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(720, 370, 120, 20);
		getContentPane().add(txtWhatsapp);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(5, 400, 45, 20);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setToolTipText("Digite o e-mail do fornecedor");
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(110, 400, 280, 20);
		getContentPane().add(txtEmail);

		JLabel lblSite = new JLabel("Site");
		lblSite.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSite.setBounds(400, 400, 30, 20);
		getContentPane().add(lblSite);

		txtSite = new JTextField();
		txtSite.setEnabled(false);
		txtSite.setToolTipText("Digite o site do fornecedor");
		txtSite.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtSite.setColumns(10);
		txtSite.setBounds(440, 400, 300, 20);
		getContentPane().add(txtSite);

		txtObservacao = new JTextArea();
		txtObservacao.setEnabled(false);
		txtObservacao.setToolTipText("Insira informações adicionais neste campo");
		txtObservacao.setBorder(new LineBorder(new Color(191, 205, 219)));
		txtObservacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtObservacao.setBounds(110, 430, 425, 94);
		getContentPane().add(txtObservacao);

		btnCreate = new JButton("");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/add-64.png")));
		btnCreate.setToolTipText("Adicionar fornecedor");
		btnCreate.setEnabled(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBounds(683, 445, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update-64.png")));
		btnUpdate.setToolTipText("Atualizar dados do fornecedor");
		btnUpdate.setEnabled(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(767, 445, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete-64.png")));
		btnDelete.setToolTipText("Excluir fornecedor");
		btnDelete.setEnabled(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(851, 445, 64, 64);
		getContentPane().add(btnDelete);
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/supliers.png")));
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Controle de Estoque | Fornecedores");
		setBounds(100, 100, 957, 589);

		setLocationRelativeTo(null);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PESQUISAR E ACIONADO
		 */
		getRootPane().setDefaultButton(btnPesquisarId);

		/**
		 * BIBLIOTECA ATXY2K
		 */

		/**
		 * txtFornecedor
		 */
		RestrictedTextField fornecedor = new RestrictedTextField(txtFornecedor);
		fornecedor.setLimit(60);

		/**
		 * txtCnpj
		 */
		RestrictedTextField cnpj = new RestrictedTextField(txtCnpj);
		cnpj = new RestrictedTextField(txtCnpj, "1234567890.-");
		cnpj.setLimit(20);

		/**
		 * txtIe
		 */
		RestrictedTextField ie = new RestrictedTextField(txtIe);
		ie = new RestrictedTextField(txtIe, "1234567890.-");
		ie.setLimit(20);

		/**
		 * txtRazaoSocial
		 */
		RestrictedTextField razaoSocial = new RestrictedTextField(txtRazaoSocial);
		razaoSocial.setLimit(60);

		/**
		 * txtNomeFantasia
		 */
		RestrictedTextField nomeFantasia = new RestrictedTextField(txtNomeFantasia);
		nomeFantasia.setLimit(60);

		/**
		 * txtCep
		 */
		RestrictedTextField cep = new RestrictedTextField(txtCep);
		cep = new RestrictedTextField(txtCep, "1234567890-");
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
		 * txtContato
		 */
		RestrictedTextField contato = new RestrictedTextField(txtContato);
		contato.setLimit(30);

		/**
		 * txtFone
		 */
		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone = new RestrictedTextField(txtFone, "1234567890-()");
		fone.setLimit(15);

		/**
		 * txtWhatsapp
		 */
		RestrictedTextField whatsapp = new RestrictedTextField(txtWhatsapp);
		whatsapp = new RestrictedTextField(txtWhatsapp, "1234567890-()");
		whatsapp.setLimit(15);

		/**
		 * txtEmail
		 */
		RestrictedTextField email = new RestrictedTextField(txtEmail);
		email.setLimit(50);

		/**
		 * txtEmail
		 */
		RestrictedTextField site = new RestrictedTextField(txtSite);

		lblStatusCep = new JLabel("");
		lblStatusCep.setBounds(249, 280, 20, 20);
		getContentPane().add(lblStatusCep);
		site.setLimit(50);
	} // FIM CONSTRUTOR

	DAO dao = new DAO();
	private JTextArea txtObservacao;
	private JLabel lblStatusCep;

	/**
	 * PESQUISAR
	 */

	private void pesquisar() {

		/**
		 * VALIDACAO
		 */
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Id do fornecedor");
			txtId.requestFocus();
		} else {
			String read = "select * from fornecedores where idFor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtRazaoSocial.setText(rs.getString(2));
					txtNomeFantasia.setText(rs.getString(3));
					txtCnpj.setText(rs.getString(4));
					txtIe.setText(rs.getString(5));
					txtCep.setText(rs.getString(6));
					txtEndereco.setText(rs.getString(7));
					txtNumero.setText(rs.getString(8));
					txtComplemento.setText(rs.getString(9));
					txtBairro.setText(rs.getString(10));
					txtCidade.setText(rs.getString(11));
					cboUf.setSelectedItem(rs.getString(12));
					txtContato.setText(rs.getString(13));
					txtFone.setText(rs.getString(14));
					txtWhatsapp.setText(rs.getString(15));
					txtEmail.setText(rs.getString(16));
					txtSite.setText(rs.getString(17));
					txtObservacao.setText(rs.getString(18));
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
					txtCnpj.setEnabled(true);
					txtIe.setEnabled(true);
					txtRazaoSocial.setEnabled(true);
					txtNomeFantasia.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtContato.setEnabled(true);
					txtFone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtSite.setEnabled(true);
					txtEmail.setEnabled(true);
					txtObservacao.setEnabled(true);
					txtId.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado");
					/**
					 * HABILITAR CAMPOS E BOTOES
					 */
					btnCreate.setEnabled(true);
					btnPesquisarId.setEnabled(false);
					btnPesquisarCep.setEnabled(true);
					txtCnpj.setEnabled(true);
					txtIe.setEnabled(true);
					txtRazaoSocial.setEnabled(true);
					txtNomeFantasia.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtContato.setEnabled(true);
					txtFone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtSite.setEnabled(true);
					txtEmail.setEnabled(true);
					txtObservacao.setEnabled(true);
					txtCnpj.requestFocus();
					txtId.setEnabled(false);
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

		if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ");
			txtCnpj.requestFocus();
		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscricao Estadual");
			txtIe.requestFocus();
		} else if (txtRazaoSocial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Razao Social");
			txtRazaoSocial.requestFocus();
		} else if (txtNomeFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome Fantasia");
			txtNomeFantasia.requestFocus();
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
		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do contato");
			txtContato.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone contato");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail do contato");
			txtEmail.requestFocus();
		} else {
			String create = "insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtRazaoSocial.getText());
				pst.setString(2, txtNomeFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtWhatsapp.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObservacao.getText());

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

		if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ");
			txtCnpj.requestFocus();
		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscricao Estadual");
			txtIe.requestFocus();
		} else if (txtRazaoSocial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Razao Social");
			txtRazaoSocial.requestFocus();
		} else if (txtNomeFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome Fantasia");
			txtNomeFantasia.requestFocus();
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
		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do contato");
			txtContato.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone contato");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail do contato");
			txtEmail.requestFocus();
		} else {
			String update = "update fornecedores set razaoSocial = ?, fantasia = ?, cnpj = ?, ie = ?, cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, nomeContato = ?, fone1 = ?, fone2 = ?, email = ?, site = ?, obs = ? where idFor = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtRazaoSocial.getText());
				pst.setString(2, txtNomeFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtWhatsapp.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObservacao.getText());
				pst.setString(18, txtId.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do usuario atualizados com sucesso!");
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
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusao do fornecedor ?", "ATENCAO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idFor = ?";
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
					JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
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
		txtFornecedor.setText(null);
		txtId.setText(null);
		txtCnpj.setText(null);
		txtIe.setText(null);
		txtRazaoSocial.setText(null);
		txtNomeFantasia.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem("");
		txtContato.setText(null);
		txtFone.setText(null);
		txtWhatsapp.setText(null);
		txtSite.setText(null);
		txtEmail.setText(null);
		txtObservacao.setText(null);
		txtCnpj.setEnabled(false);
		txtIe.setEnabled(false);
		txtRazaoSocial.setEnabled(false);
		txtNomeFantasia.setEnabled(false);
		txtCep.setEnabled(false);
		txtEndereco.setEnabled(false);
		txtNumero.setEnabled(false);
		txtComplemento.setEnabled(false);
		txtBairro.setEnabled(false);
		txtCidade.setEnabled(false);
		cboUf.setEnabled(false);
		txtContato.setEnabled(false);
		txtFone.setEnabled(false);
		txtWhatsapp.setEnabled(false);
		txtSite.setEnabled(false);
		txtEmail.setEnabled(false);
		txtObservacao.setEnabled(false);
		txtId.setEnabled(true);
		txtId.requestFocus();
		btnPesquisarId.setEnabled(true);
		btnPesquisarCep.setEnabled(false);
		btnCreate.setEnabled(false);

	} // FIM LIMPAR
} // FIM CODIGO
