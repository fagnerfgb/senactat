package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fornecedores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFornecedor;
	private JTextField txtId;
	private JTextField txtCnpj;
	private JTextField txtIe;
	private JTextField txtRazaoSocial;
	private JTextField txtNomeFantasia;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtContato;
	private JTextField txtFone;
	private JTextField txtWhatsapp;
	private JTextField txtSite;
	private JTextField txtEmail;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setResizable(false);
		setModal(true);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/supliers.png")));
		setTitle("Controle de Estoque - Fornecedores");
		setBounds(100, 100, 784, 511);
		getContentPane().setLayout(null);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFornecedor.setBounds(10, 14, 74, 14);
		getContentPane().add(lblFornecedor);

		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(94, 11, 150, 20);
		getContentPane().add(txtFornecedor);
		txtFornecedor.setColumns(10);

		JLabel lblObservacao = new JLabel("Observação");
		lblObservacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblObservacao.setBounds(10, 416, 70, 14);
		getContentPane().add(lblObservacao);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblId.setBounds(10, 197, 20, 14);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setBounds(30, 194, 50, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCnpj.setBounds(125, 197, 35, 14);
		getContentPane().add(lblCnpj);

		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setToolTipText("Buscar ID");
		btnBuscar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/search.png")));
		btnBuscar.setBounds(85, 192, 24, 24);
		getContentPane().add(btnBuscar);

		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(165, 194, 150, 20);
		getContentPane().add(txtCnpj);

		JLabel lblIe = new JLabel("IE");
		lblIe.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIe.setBounds(320, 197, 20, 14);
		getContentPane().add(lblIe);

		txtIe = new JTextField();
		txtIe.setColumns(10);
		txtIe.setBounds(345, 194, 150, 20);
		getContentPane().add(txtIe);

		JLabel lblRazaoSocial = new JLabel("Razão Social");
		lblRazaoSocial.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblRazaoSocial.setBounds(10, 232, 80, 14);
		getContentPane().add(lblRazaoSocial);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(95, 229, 300, 20);
		getContentPane().add(txtRazaoSocial);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNomeFantasia.setBounds(400, 232, 90, 14);
		getContentPane().add(lblNomeFantasia);

		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(495, 229, 250, 20);
		getContentPane().add(txtNomeFantasia);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCep.setBounds(10, 267, 25, 14);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(40, 264, 100, 20);
		getContentPane().add(txtCep);

		btnCep = new JButton("");
		btnCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCep.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/search.png")));
		btnCep.setToolTipText("Buscar CEP");
		btnCep.setContentAreaFilled(false);
		btnCep.setBorderPainted(false);
		btnCep.setBounds(145, 262, 24, 24);
		getContentPane().add(btnCep);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEndereco.setBounds(175, 267, 55, 14);
		getContentPane().add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(235, 264, 250, 20);
		getContentPane().add(txtEndereco);

		JLabel lblNumero = new JLabel("Nº");
		lblNumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumero.setBounds(490, 267, 20, 14);
		getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(515, 264, 70, 20);
		getContentPane().add(txtNumero);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblComplemento.setBounds(590, 267, 80, 14);
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(675, 264, 70, 20);
		getContentPane().add(txtComplemento);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblBairro.setBounds(10, 302, 40, 14);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(55, 299, 250, 20);
		getContentPane().add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCidade.setBounds(310, 302, 40, 14);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(355, 299, 250, 20);
		getContentPane().add(txtCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblUf.setBounds(610, 302, 20, 14);
		getContentPane().add(lblUf);

		cboUf = new JComboBox<Object>();
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(635, 298, 60, 22);
		getContentPane().add(cboUf);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblContato.setBounds(10, 337, 50, 14);
		getContentPane().add(lblContato);

		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(65, 334, 250, 20);
		getContentPane().add(txtContato);

		JLabel lblFone = new JLabel("Telefone");
		lblFone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFone.setBounds(320, 337, 50, 14);
		getContentPane().add(lblFone);

		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(375, 334, 90, 20);
		getContentPane().add(txtFone);

		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblWhatsapp.setBounds(470, 337, 60, 14);
		getContentPane().add(lblWhatsapp);

		txtWhatsapp = new JTextField();
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(535, 334, 90, 20);
		getContentPane().add(txtWhatsapp);

		JLabel lblSite = new JLabel("Site");
		lblSite.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSite.setBounds(10, 372, 25, 14);
		getContentPane().add(lblSite);

		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(40, 369, 250, 20);
		getContentPane().add(txtSite);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEmail.setBounds(295, 372, 40, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(340, 369, 250, 20);
		getContentPane().add(txtEmail);

		txtObservacao = new JTextArea();
		txtObservacao.setBounds(85, 403, 400, 40);
		getContentPane().add(txtObservacao);

		btnCreate = new JButton("");
		btnCreate.setEnabled(false);
		btnCreate.setToolTipText("Adicionar fornecedor");
		btnCreate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/create.png")));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBounds(495, 391, 64, 64);
		getContentPane().add(btnCreate);

		btnDelete = new JButton("");
		btnDelete.setEnabled(false);
		btnDelete.setToolTipText("Remover fornecedor");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete.png")));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(635, 391, 64, 64);
		getContentPane().add(btnDelete);

		btnUpdate = new JButton("");
		btnUpdate.setEnabled(false);
		btnUpdate.setToolTipText("Atualizar fornecedor");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update.png")));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(566, 391, 64, 64);
		getContentPane().add(btnUpdate);

		/**
		 * Uso da tecla <Enter> junto com um botao
		 */
		getRootPane().setDefaultButton(btnBuscar);

	} // Fim do construtor

	DAO dao = new DAO();
	private JButton btnBuscar;
	private JButton btnCep;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox<Object> cboUf;
	private JTextArea txtObservacao;

	private void pesquisar() {

		/**
		 * validacao
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
					 * Habilitar botoes alterar e excluir
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado");
					btnCreate.setEnabled(true);
					limpar();
					txtId.requestFocus();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void adicionar() {
		/**
		 * Validacao
		 */

		if (txtRazaoSocial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Razao Social");
			txtRazaoSocial.requestFocus();
		} else if (txtNomeFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome Fantasia");
			txtNomeFantasia.requestFocus();
		} else if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ");
			txtCnpj.requestFocus();
		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscricao Social");
			txtIe.requestFocus();
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
			JOptionPane.showMessageDialog(null, "Insira a nome do contato");
			txtContato.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nome do contato");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nome do contato");
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
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
					limpar();
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

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

	}

} // Fim do codigo
