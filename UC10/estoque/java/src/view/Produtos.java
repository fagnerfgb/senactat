package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLucro;
	private JTextField txtPesquisaProduto;
	private JTable table;
	private JTextField txtId;
	private JTextField txtProduto;
	private JTextField txtCodigoDeBarras;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtValidade;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMinimo;
	private JTextField txtUnidade;
	private JTextField txtLocalizacao;
	private JTextField txtCusto;
	private JTextField txtLucro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
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
	public Produtos() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		setModal(true);
		setResizable(false);
		setTitle("Controle de Estoque | Produtos");
		setBounds(100, 100, 980, 463);
		getContentPane().setLayout(null);

		JLabel lblPesquisaProduto = new JLabel("Produto");
		lblPesquisaProduto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPesquisaProduto.setBounds(5, 10, 55, 20);
		getContentPane().add(lblPesquisaProduto);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(5, 220, 20, 20);
		getContentPane().add(lblId);

		JLabel lblCodigoDeBarras = new JLabel("Código de barras");
		lblCodigoDeBarras.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCodigoDeBarras.setBounds(5, 250, 120, 20);
		getContentPane().add(lblCodigoDeBarras);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProduto.setBounds(486, 250, 79, 20);
		getContentPane().add(lblProduto);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescricao.setBounds(5, 280, 65, 20);
		getContentPane().add(lblDescricao);

		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFabricante.setBounds(486, 280, 79, 20);
		getContentPane().add(lblFabricante);

		JLabel lblValidade = new JLabel("Data de validade");
		lblValidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblValidade.setBounds(486, 311, 115, 20);
		getContentPane().add(lblValidade);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEstoque.setBounds(5, 310, 55, 20);
		getContentPane().add(lblEstoque);

		JLabel lblEstoqueMinimo = new JLabel("Estoque Mínimo");
		lblEstoqueMinimo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEstoqueMinimo.setBounds(245, 310, 105, 20);
		getContentPane().add(lblEstoqueMinimo);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUnidade.setBounds(726, 311, 55, 20);
		getContentPane().add(lblUnidade);

		JLabel lblLocalizacao = new JLabel("Localização");
		lblLocalizacao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLocalizacao.setBounds(5, 340, 85, 20);
		getContentPane().add(lblLocalizacao);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCusto.setBounds(5, 370, 79, 20);
		getContentPane().add(lblCusto);

		lblLucro = new JLabel("Lucro");
		lblLucro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLucro.setBounds(291, 370, 40, 20);
		getContentPane().add(lblLucro);

		JLabel lblIdFor = new JLabel("ID Fornecedor");
		lblIdFor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblIdFor.setBounds(486, 370, 95, 20);
		getContentPane().add(lblIdFor);

		txtPesquisaProduto = new JTextField();
		txtPesquisaProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarComFiltro();
			}
		});
		txtPesquisaProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPesquisaProduto.setBounds(70, 10, 300, 20);
		getContentPane().add(txtPesquisaProduto);
		txtPesquisaProduto.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBounds(5, 40, 936, 170);
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

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtId.setToolTipText("Digite o ID do fornecedor");
		txtId.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtId.setColumns(10);
		txtId.setBounds(135, 221, 80, 20);
		getContentPane().add(txtId);

		txtProduto = new JTextField();
		txtProduto.setEnabled(false);
		txtProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtProduto.setColumns(10);
		txtProduto.setBounds(616, 250, 325, 20);
		getContentPane().add(txtProduto);

		txtCodigoDeBarras = new JTextField();
		txtCodigoDeBarras.setEnabled(false);
		txtCodigoDeBarras.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCodigoDeBarras.setColumns(10);
		txtCodigoDeBarras.setBounds(135, 250, 325, 20);
		getContentPane().add(txtCodigoDeBarras);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(135, 280, 325, 20);
		getContentPane().add(txtDescricao);

		txtFabricante = new JTextField();
		txtFabricante.setEnabled(false);
		txtFabricante.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(616, 280, 325, 20);
		getContentPane().add(txtFabricante);

		txtValidade = new JTextField();
		txtValidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtValidade.setEnabled(false);
		txtValidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtValidade.setColumns(10);
		txtValidade.setBounds(616, 311, 100, 20);
		getContentPane().add(txtValidade);

		txtEstoque = new JTextField();
		txtEstoque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEstoque.setEnabled(false);
		txtEstoque.setToolTipText("Digite o ID do fornecedor");
		txtEstoque.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(135, 310, 100, 20);
		getContentPane().add(txtEstoque);

		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEstoqueMinimo.setEnabled(false);
		txtEstoqueMinimo.setToolTipText("Digite o ID do fornecedor");
		txtEstoqueMinimo.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEstoqueMinimo.setColumns(10);
		txtEstoqueMinimo.setBounds(360, 310, 100, 20);
		getContentPane().add(txtEstoqueMinimo);

		txtUnidade = new JTextField();
		txtUnidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		txtUnidade.setEnabled(false);
		txtUnidade.setToolTipText("Digite o ID do fornecedor");
		txtUnidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(791, 311, 100, 20);
		getContentPane().add(txtUnidade);

		txtLocalizacao = new JTextField();
		txtLocalizacao.setEnabled(false);
		txtLocalizacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtLocalizacao.setColumns(10);
		txtLocalizacao.setBounds(135, 340, 325, 20);
		getContentPane().add(txtLocalizacao);

		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCusto.setEnabled(false);
		txtCusto.setToolTipText("Digite o ID do fornecedor");
		txtCusto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCusto.setColumns(10);
		txtCusto.setBounds(135, 370, 100, 20);
		getContentPane().add(txtCusto);

		txtLucro = new JTextField();
		txtLucro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtLucro.setEnabled(false);
		txtLucro.setToolTipText("Digite o ID do fornecedor");
		txtLucro.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtLucro.setColumns(10);
		txtLucro.setBounds(360, 370, 100, 20);
		getContentPane().add(txtLucro);

		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setIcon(new ImageIcon(Produtos.class.getResource("/img/add-64.png")));
		btnCreate.setToolTipText("Adicionar produto");
		btnCreate.setEnabled(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBounds(726, 348, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Produtos.class.getResource("/img/update-64.png")));
		btnUpdate.setToolTipText("Atualizar dados do produto");
		btnUpdate.setEnabled(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(801, 348, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Produtos.class.getResource("/img/delete-64.png")));
		btnDelete.setToolTipText("Excluir produtor");
		btnDelete.setEnabled(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(875, 348, 64, 64);
		getContentPane().add(btnDelete);

		btnPesquisarId = new JButton("");
		btnPesquisarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisarId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisarId.setIcon(new ImageIcon(Produtos.class.getResource("/img/search-24.png")));
		btnPesquisarId.setToolTipText("Buscar ID");
		btnPesquisarId.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisarId.setContentAreaFilled(false);
		btnPesquisarId.setBorderPainted(false);
		btnPesquisarId.setBounds(220, 219, 24, 24);
		getContentPane().add(btnPesquisarId);

		txtIdFor = new JTextField();
		txtIdFor.setEnabled(false);
		txtIdFor.setToolTipText("Digite o ID do fornecedor");
		txtIdFor.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIdFor.setColumns(10);
		txtIdFor.setBounds(616, 370, 80, 20);
		getContentPane().add(txtIdFor);
		
		setLocationRelativeTo(null);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PESQUISAR E ACIONADO
		 */
		getRootPane().setDefaultButton(btnPesquisarId);
		
		/**
		 * BIBLIOTECA ATXY2K
		 */
		
		/**
		 * txtCodigoDeBarras
		 */
		RestrictedTextField barcode = new RestrictedTextField(txtCodigoDeBarras);
		barcode.setLimit(255);
		
		
		/**
		 * txtProduto
		 */
		RestrictedTextField produto = new RestrictedTextField(txtProduto);
		produto.setLimit(50);
		
		/**
		 * txtDescricao
		 */
		RestrictedTextField descricao = new RestrictedTextField(txtDescricao);
		descricao.setLimit(255);
		
		/**
		 * txtFabricante
		 */
		RestrictedTextField fabricante = new RestrictedTextField(txtFabricante);
		fabricante.setLimit(50);
		
		/**
		 * txtEstoque
		 */
		RestrictedTextField estoque = new RestrictedTextField(txtEstoque);
		estoque.setLimit(6);
		
		/**
		 * txtEstoqueMinimo
		 */
		RestrictedTextField estoqueMinimo = new RestrictedTextField(txtEstoqueMinimo);
		estoqueMinimo.setLimit(6);
		
		/**
		 * txtValidade
		 */
		RestrictedTextField validade = new RestrictedTextField(txtValidade);
		validade.setLimit(10);
		
		/**
		 * txtUnidade
		 */
		RestrictedTextField unidade = new RestrictedTextField(txtUnidade);
		unidade.setLimit(2);
		
		/**
		 * txtLocalizacao
		 */
		RestrictedTextField localizacao = new RestrictedTextField(txtLocalizacao);
		localizacao.setLimit(50);
		
		/**
		 * txtCusto
		 */
		RestrictedTextField custo = new RestrictedTextField(txtCusto);
		custo.setLimit(11);
		
		/**
		 * txtIdFor
		 */
		RestrictedTextField idfor = new RestrictedTextField(txtIdFor);
		idfor.setLimit(9);
		
		
		
		
		

	} // FIM DO CONSTRUTOR

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPesquisarId;
	private JTextField txtIdFor;

	/**
	 * PESQUISA AVANCADA COM FILTRO
	 */

	private void pesquisarComFiltro() {
		String read2 = "select codigo as ID, produto as Produto, estoque as Estoque, dataval as Validade, custo as Custo from produtos where produto like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtPesquisaProduto.getText() + "%"); // ATENCAO AO "%"
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
			JOptionPane.showMessageDialog(null, "Insira o ID do produto");
			txtId.requestFocus();
		} else {
			String read = "select * from produtos where codigo = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtCodigoDeBarras.setText(rs.getString(2));
					txtProduto.setText(rs.getString(3));
					txtDescricao.setText(rs.getString(4));
					txtFabricante.setText(rs.getString(5));
					txtValidade.setText(rs.getString(7));
					txtEstoque.setText(rs.getString(8));
					txtEstoqueMinimo.setText(rs.getString(9));
					txtUnidade.setText(rs.getString(10));
					txtLocalizacao.setText(rs.getString(11));
					txtCusto.setText(rs.getString(12));
					txtLucro.setText(rs.getString(13));
					txtIdFor.setText(rs.getString(14));

					/**
					 * HABILITAR BOTOES
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnPesquisarId.setEnabled(false);

					/**
					 * HABILITAR CAMPOS
					 */
					txtCodigoDeBarras.setEnabled(true);
					txtProduto.setEnabled(true);
					txtDescricao.setEnabled(true);
					txtFabricante.setEnabled(true);
					txtEstoque.setEnabled(true);
					txtEstoqueMinimo.setEnabled(true);
					txtValidade.setEnabled(true);
					txtUnidade.setEnabled(true);
					txtLocalizacao.setEnabled(true);
					txtCusto.setEnabled(true);
					txtLucro.setEnabled(true);
					txtIdFor.setEnabled(true);
					txtId.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
					/**
					 * HABILITAR CAMPOS E BOTOES
					 */
					txtCodigoDeBarras.setEnabled(true);
					txtProduto.setEnabled(true);
					txtDescricao.setEnabled(true);
					txtFabricante.setEnabled(true);
					txtEstoque.setEnabled(true);
					txtEstoqueMinimo.setEnabled(true);
					txtValidade.setEnabled(true);
					txtUnidade.setEnabled(true);
					txtLocalizacao.setEnabled(true);
					txtCusto.setEnabled(true);
					txtLucro.setEnabled(true);
					txtId.setEnabled(false);
					btnCreate.setEnabled(true);
					btnPesquisarId.setEnabled(false);
					txtIdFor.setEnabled(true);
					txtCodigoDeBarras.requestFocus();
					txtId.setEnabled(false);
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

		if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do produto");
			txtProduto.requestFocus();
		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o fabricante do produto");
			txtFabricante.requestFocus();
		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade disponível em estoque");
			txtEstoque.requestFocus();
		} else if (txtEstoqueMinimo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor mínimo em estoque");
			txtEstoqueMinimo.requestFocus();
		} else if (txtUnidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a unidade do produto");
			txtUnidade.requestFocus();
		} else if (txtLocalizacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a localização do produto");
			txtLocalizacao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço de custo");
			txtCusto.requestFocus();
		} else if (txtIdFor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Fornecedor");
			txtIdFor.requestFocus();

		} else {
			String create = "insert into produtos (barcode, produto, descricao, fabricante, dataval, estoque, estoquemin, unidade, localizacao, custo, lucro, idFor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtCodigoDeBarras.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtDescricao.getText());
				pst.setString(4, txtFabricante.getText());
				pst.setString(5, txtValidade.getText());
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoqueMinimo.getText());
				pst.setString(8, txtUnidade.getText());
				pst.setString(9, txtLocalizacao.getText());
				pst.setString(10, txtCusto.getText());
				pst.setString(11, txtLucro.getText());
				pst.setString(12, txtIdFor.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
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

		if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do produto");
			txtProduto.requestFocus();
		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o fabricante do produto");
			txtFabricante.requestFocus();
		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade disponível em estoque");
			txtEstoque.requestFocus();
		} else if (txtEstoqueMinimo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor mínimo em estoque");
			txtEstoqueMinimo.requestFocus();
		} else if (txtUnidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a unidade do produto");
			txtUnidade.requestFocus();
		} else if (txtLocalizacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a localização do produto");
			txtLocalizacao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço de custo");
			txtCusto.requestFocus();
		} else if (txtIdFor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Fornecedor");
			txtIdFor.requestFocus();

		} else {
			String update = "update produtos set barcode = ?, produto = ?, descricao = ?, fabricante = ?, dataval = ?, estoque = ?, estoquemin = ?, unidade = ?, localizacao = ?, custo = ?, lucro = ?, idFor = ? where codigo = ?";
			try {
				/**
				 * ESTABELECER A CONEXAO
				 */
				Connection con = dao.conectar();

				/**
				 * PREPARAR SQL PARA EXECUCAO
				 */
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtCodigoDeBarras.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtDescricao.getText());
				pst.setString(4, txtFabricante.getText());
				pst.setString(5, txtValidade.getText());
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoqueMinimo.getText());
				pst.setString(8, txtUnidade.getText());
				pst.setString(9, txtLocalizacao.getText());
				pst.setString(10, txtCusto.getText());
				pst.setString(11, txtLucro.getText());
				pst.setString(12, txtIdFor.getText());
				pst.setString(13, txtId.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do produto atualizados com sucesso!");
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
	 * LIMPAR
	 */

	public void limpar() {
		txtId.setText(null);
		txtPesquisaProduto.setText(null);
		txtCodigoDeBarras.setText(null);
		txtProduto.setText(null);
		txtDescricao.setText(null);
		txtFabricante.setText(null);
		txtEstoque.setText(null);
		txtEstoqueMinimo.setText(null);
		txtValidade.setText(null);
		txtUnidade.setText(null);
		txtLocalizacao.setText(null);
		txtCusto.setText(null);
		txtLucro.setText(null);
		txtIdFor.setText(null);
		txtId.setEnabled(false);
		txtCodigoDeBarras.setEnabled(false);
		txtProduto.setEnabled(false);
		txtDescricao.setEnabled(false);
		txtFabricante.setEnabled(false);
		txtEstoque.setEnabled(false);
		txtEstoqueMinimo.setEnabled(false);
		txtValidade.setEnabled(false);
		txtUnidade.setEnabled(false);
		txtLocalizacao.setEnabled(false);
		txtCusto.setEnabled(false);
		txtLucro.setEnabled(false);
		txtId.setEnabled(true);
		txtIdFor.setEnabled(false);
		txtPesquisaProduto.requestFocus();
		btnPesquisarId.setEnabled(true);
		btnCreate.setEnabled(false);
		((DefaultTableModel) table.getModel()).setRowCount(0);

	} // FIM LIMPAR

	/**
	 * EXCLUIR
	 */

	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusao do produto ?", "ATENCAO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from produtos where codigo = ?";
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
					JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
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

} // FIM DO CODIGO
