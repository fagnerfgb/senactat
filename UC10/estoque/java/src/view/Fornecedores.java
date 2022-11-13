package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
		txtRazaoSocial.setToolTipText("Digite a Razão Social do Fornecedor");
		txtRazaoSocial.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(110, 250, 300, 20);
		getContentPane().add(txtRazaoSocial);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNomeFantasia.setBounds(420, 250, 100, 20);
		getContentPane().add(lblNomeFantasia);
		
		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setToolTipText("Digite o Nome Fantasia do fornecedor");
		txtNomeFantasia.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(530, 250, 300, 20);
		getContentPane().add(txtNomeFantasia);
		
		txtCnpj = new JTextField();
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
		txtIe.setToolTipText("Digite o número de Inscricação Estadual do fornecedor");
		txtIe.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIe.setColumns(10);
		txtIe.setBounds(475, 220, 150, 20);
		getContentPane().add(txtIe);
		
		JLabel lblObservacao = new JLabel("Observação");
		lblObservacao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblObservacao.setBounds(5, 370, 100, 20);
		getContentPane().add(lblObservacao);
		
		txtCep = new JTextField();
		txtCep.setToolTipText("Digite o CEP do fornecedor");
		txtCep.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCep.setColumns(10);
		txtCep.setBounds(110, 280, 100, 20);
		getContentPane().add(txtCep);
		
		btnPesquisarCep = new JButton("");
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
		lblEndereco.setBounds(250, 280, 65, 20);
		getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("Digite o endereço do Fornecedor");
		txtEndereco.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(325, 280, 250, 20);
		getContentPane().add(txtEndereco);
		
		JLabel lblNumero = new JLabel("Nº");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNumero.setBounds(585, 280, 20, 20);
		getContentPane().add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setToolTipText("Digite o número do fornecedor");
		txtNumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		txtNumero.setBounds(615, 280, 60, 20);
		getContentPane().add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblComplemento.setBounds(685, 280, 90, 20);
		getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setToolTipText("Digite o complemento do endereço do fornecedor");
		txtComplemento.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(785, 280, 130, 20);
		getContentPane().add(txtComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBairro.setBounds(5, 310, 100, 20);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setToolTipText("Digite o bairro do Fornecedor");
		txtBairro.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		txtBairro.setBounds(110, 310, 250, 20);
		getContentPane().add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCidade.setBounds(370, 310, 45, 20);
		getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setToolTipText("Digite a cidade do Fornecedor");
		txtCidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(425, 310, 250, 20);
		getContentPane().add(txtCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUf.setBounds(685, 310, 20, 20);
		getContentPane().add(lblUf);
		
		cboUf = new JComboBox<Object>();
		cboUf.setToolTipText("Selecione o estado do fornecedor");
		cboUf.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUf.setFont(new Font("Verdana", Font.PLAIN, 11));
		cboUf.setBounds(715, 310, 60, 20);
		getContentPane().add(cboUf);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContato.setBounds(5, 340, 100, 20);
		getContentPane().add(lblContato);
		
		txtContato = new JTextField();
		txtContato.setToolTipText("Digite o nome do contato do Fornecedor");
		txtContato.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtContato.setColumns(10);
		txtContato.setBounds(110, 340, 150, 20);
		getContentPane().add(txtContato);
		
		JLabel lblFone = new JLabel("Telefone");
		lblFone.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFone.setBounds(270, 340, 60, 20);
		getContentPane().add(lblFone);
		
		txtFone = new JTextField();
		txtFone.setToolTipText("Digite o telefone do Fornecedor");
		txtFone.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFone.setColumns(10);
		txtFone.setBounds(340, 340, 90, 20);
		getContentPane().add(txtFone);
		
		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Verdana", Font.BOLD, 12));
		lblWhatsapp.setBounds(440, 340, 70, 20);
		getContentPane().add(lblWhatsapp);
		
		txtWhatsapp = new JTextField();
		txtWhatsapp.setToolTipText("Digite o Whatsapp do fornecedor");
		txtWhatsapp.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(520, 340, 90, 20);
		getContentPane().add(txtWhatsapp);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(620, 340, 45, 20);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Digite o e-mail do fornecedor");
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(675, 340, 240, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSite.setBounds(635, 220, 30, 20);
		getContentPane().add(lblSite);
		
		txtSite = new JTextField();
		txtSite.setToolTipText("Digite o site do fornecedor");
		txtSite.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtSite.setColumns(10);
		txtSite.setBounds(675, 220, 240, 20);
		getContentPane().add(txtSite);
		
		JTextArea txtObservacao = new JTextArea();
		txtObservacao.setToolTipText("Insira informações adicionais neste campo");
		txtObservacao.setBorder(new LineBorder(new Color(191, 205, 219)));
		txtObservacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtObservacao.setBounds(110, 370, 400, 64);
		getContentPane().add(txtObservacao);
		
		btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/add-64.png")));
		btnCreate.setToolTipText("Adicionar fornecedor");
		btnCreate.setEnabled(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBounds(683, 370, 64, 64);
		getContentPane().add(btnCreate);
		
		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update-64.png")));
		btnUpdate.setToolTipText("Adicionar fornecedor");
		btnUpdate.setEnabled(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(767, 370, 64, 64);
		getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete-64.png")));
		btnDelete.setToolTipText("Adicionar fornecedor");
		btnDelete.setEnabled(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(851, 370, 64, 64);
		getContentPane().add(btnDelete);
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/supliers.png")));
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Controle de Estoque | Fornecedores");
		setBounds(100, 100, 957, 481);
		setLocationRelativeTo(null);

	}
}
