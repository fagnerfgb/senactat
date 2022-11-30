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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLucro;
	private JTextField txtId;
	private JTextField txtProduto;
	private JTextField txtCodigoDeBarras;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMinimo;
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// txtCodigoDeBarras.requestFocus();
			}
		});
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		setModal(true);
		setResizable(false);
		setTitle("Controle de Estoque | Produtos");
		setBounds(100, 100, 495, 658);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(5, 41, 20, 20);
		getContentPane().add(lblId);

		JLabel lblCodigoDeBarras = new JLabel("Código de barras");
		lblCodigoDeBarras.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCodigoDeBarras.setBounds(5, 11, 120, 20);
		getContentPane().add(lblCodigoDeBarras);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProduto.setBounds(5, 71, 79, 20);
		getContentPane().add(lblProduto);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescricao.setBounds(5, 101, 65, 20);
		getContentPane().add(lblDescricao);

		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFabricante.setBounds(5, 131, 79, 20);
		getContentPane().add(lblFabricante);

		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblValidade.setBounds(5, 221, 60, 20);
		getContentPane().add(lblValidade);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEstoque.setBounds(5, 161, 55, 20);
		getContentPane().add(lblEstoque);

		JLabel lblEstoqueMinimo = new JLabel("Estoque Mínimo");
		lblEstoqueMinimo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEstoqueMinimo.setBounds(245, 161, 105, 20);
		getContentPane().add(lblEstoqueMinimo);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUnidade.setBounds(5, 251, 55, 20);
		getContentPane().add(lblUnidade);

		JLabel lblLocalizacao = new JLabel("Localização");
		lblLocalizacao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLocalizacao.setBounds(5, 281, 85, 20);
		getContentPane().add(lblLocalizacao);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCusto.setBounds(5, 311, 79, 20);
		getContentPane().add(lblCusto);

		lblLucro = new JLabel("Lucro");
		lblLucro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLucro.setBounds(245, 311, 40, 20);
		getContentPane().add(lblLucro);

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
		txtId.setToolTipText("Digite o ID do produto");
		txtId.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtId.setColumns(10);
		txtId.setBounds(135, 41, 80, 20);
		getContentPane().add(txtId);

		txtProduto = new JTextField();
		txtProduto.setToolTipText("Insira o nome do produto");
		txtProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtProduto.setColumns(10);
		txtProduto.setBounds(135, 71, 325, 20);
		getContentPane().add(txtProduto);

		txtCodigoDeBarras = new JTextField();
		txtCodigoDeBarras.addKeyListener(new KeyAdapter() {
			// leitor de codigo de barras
			// evento ao pressionar tecla enter
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisarBarcode();
				}
			}
		});
		txtCodigoDeBarras.setToolTipText("Insira o código de barras do produto");
		txtCodigoDeBarras.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCodigoDeBarras.setColumns(10);
		txtCodigoDeBarras.setBounds(135, 11, 325, 20);
		getContentPane().add(txtCodigoDeBarras);

		txtDescricao = new JTextField();
		txtDescricao.setToolTipText("Insira a descrição do produto");
		txtDescricao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(135, 101, 325, 20);
		getContentPane().add(txtDescricao);

		txtFabricante = new JTextField();
		txtFabricante.setToolTipText("Insira o fabricante do produto");
		txtFabricante.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(135, 131, 325, 20);
		getContentPane().add(txtFabricante);

		txtEstoque = new JTextField();
		txtEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstoque.setTransferHandler(null);
			}
		});
		txtEstoque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				txtEstoque.setTransferHandler(null);
			}
		});
		txtEstoque.setToolTipText("Insira o estoque do produto");
		txtEstoque.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(135, 161, 100, 20);
		getContentPane().add(txtEstoque);

		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstoqueMinimo.setTransferHandler(null);
			}
		});
		txtEstoqueMinimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				txtEstoqueMinimo.setTransferHandler(null);
			}
		});
		txtEstoqueMinimo.setToolTipText("Insira o estoque mínimo do produto");
		txtEstoqueMinimo.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEstoqueMinimo.setColumns(10);
		txtEstoqueMinimo.setBounds(360, 161, 100, 20);
		getContentPane().add(txtEstoqueMinimo);

		txtLocalizacao = new JTextField();
		txtLocalizacao.setToolTipText("Insira a localização do produto");
		txtLocalizacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtLocalizacao.setColumns(10);
		txtLocalizacao.setBounds(135, 281, 325, 20);
		getContentPane().add(txtLocalizacao);

		txtCusto = new JTextField();
		txtCusto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCusto.setTransferHandler(null);
			}
		});
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				txtCusto.setTransferHandler(null);
			}
		});
		txtCusto.setToolTipText("Insira o preço de custo do produto");
		txtCusto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCusto.setColumns(10);
		txtCusto.setBounds(135, 311, 100, 20);
		getContentPane().add(txtCusto);

		txtLucro = new JTextField();
		txtLucro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLucro.setTransferHandler(null);
			}
		});
		txtLucro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validação (aceita somente os caracteres da String)
				String caracteres = "1234567890.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				txtLucro.setTransferHandler(null);
			}
		});
		txtLucro.setToolTipText("Insira o lucro do produto");
		txtLucro.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtLucro.setColumns(10);
		txtLucro.setBounds(295, 311, 100, 20);
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
		btnCreate.setBounds(247, 550, 64, 64);
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
		btnUpdate.setBounds(322, 550, 64, 64);
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
		btnDelete.setBounds(396, 550, 64, 64);
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
		btnPesquisarId.setBounds(220, 39, 24, 24);
		getContentPane().add(btnPesquisarId);

		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 342, 455, 200);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtIdFor = new JTextField();
		txtIdFor.setEditable(false);
		txtIdFor.setBounds(314, 15, 80, 20);
		panel.add(txtIdFor);
		txtIdFor.setToolTipText("ID do Fornecedor");
		txtIdFor.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIdFor.setColumns(10);

		JLabel lblIdFor = new JLabel("ID");
		lblIdFor.setBounds(284, 15, 20, 20);
		panel.add(lblIdFor);
		lblIdFor.setFont(new Font("Verdana", Font.BOLD, 12));

		txtFornecedor = new JTextField();
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarComFiltro();
			}
		});
		txtFornecedor.setToolTipText("");
		txtFornecedor.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFornecedor.setColumns(10);
		txtFornecedor.setBounds(5, 15, 234, 20);
		panel.add(txtFornecedor);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 40, 440, 150);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				txtIdFor.setText(table.getModel().getValueAt(setar, 0).toString());
			}
		});
		scrollPane.setViewportView(table);

		JButton btnPesquisarIdFornecedor = new JButton("");
		btnPesquisarIdFornecedor.setIcon(new ImageIcon(Produtos.class.getResource("/img/search-24.png")));
		btnPesquisarIdFornecedor.setToolTipText("Buscar ID do Fornecedor");
		btnPesquisarIdFornecedor.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisarIdFornecedor.setContentAreaFilled(false);
		btnPesquisarIdFornecedor.setBorderPainted(false);
		btnPesquisarIdFornecedor.setBounds(249, 13, 24, 24);
		panel.add(btnPesquisarIdFornecedor);

		cboUnidade = new JComboBox<Object>();
		cboUnidade.setToolTipText("Selecione a unidade do produto");
		cboUnidade.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "CX", "PÇ", "UN" }));
		cboUnidade.setFont(new Font("Arial", Font.PLAIN, 11));
		cboUnidade.setBounds(135, 251, 115, 20);
		getContentPane().add(cboUnidade);

		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEntrada.setBounds(5, 191, 115, 20);
		getContentPane().add(lblEntrada);

		dateEntrada = new JDateChooser();
		dateEntrada.setEnabled(false);
		dateEntrada.setDateFormatString("d/M/y");
		dateEntrada.setToolTipText("Insira a data de entrada do produto");
		dateEntrada.setBounds(135, 191, 200, 20);
		getContentPane().add(dateEntrada);

		dateValidade = new JDateChooser();
		dateValidade.setDateFormatString("d/M/ y");
		dateValidade.setToolTipText("Insira o prazo de validade do produto");
		dateValidade.setBounds(135, 221, 200, 20);
		getContentPane().add(dateValidade);

		/**
		 * AO PRESSIONAR A TECLA ENTER O BOTAO PESQUISAR E ACIONADO
		 */
		// getRootPane().setDefaultButton(btnPesquisarId);

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
		 * txtLucro
		 */
		RestrictedTextField lucro = new RestrictedTextField(txtLucro);

		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPorcentagem.setBounds(405, 311, 20, 20);
		getContentPane().add(lblPorcentagem);
		lucro.setLimit(11);

	} // FIM DO CONSTRUTOR

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPesquisarId;
	private JTextField txtIdFor;
	private JTextField txtFornecedor;
	private JTable table;
	private JPanel panel;
	private JComboBox<Object> cboUnidade;
	private JScrollPane scrollPane;
	private JDateChooser dateValidade;
	private JDateChooser dateEntrada;

	/**
	 * PESQUISA COM FILTRO
	 */

	private void pesquisarComFiltro() {

		String read2 = "select idFor as ID, fantasia as Fornecedor from fornecedores where fantasia like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtFornecedor.getText() + "%"); // Atencao "%"
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM PESQUISA COM FILTRO

	/**
	 * PESQUISAR
	 */

	private void pesquisar() {

		/**
		 * VALIDACAO
		 */
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do produto");
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
					// dateEntrada.setDate(rs.getDate(6));
					String setarDataEntrada = rs.getString(6);
					java.util.Date dataEntrada = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataEntrada);
					dateEntrada.setDate(dataEntrada);

					// dateValidade.setDate(rs.getDate(7));
					String setarDataValidade = rs.getString(7);
					java.util.Date dataValidade = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataValidade);
					dateValidade.setDate(dataValidade);

					txtEstoque.setText(rs.getString(8));
					txtEstoqueMinimo.setText(rs.getString(9));
					cboUnidade.setSelectedItem(rs.getString(10));
					txtLocalizacao.setText(rs.getString(11));
					txtCusto.setText(rs.getString(12));
					txtLucro.setText(rs.getString(13));
					txtIdFor.setText(rs.getString(14));

					/**
					 * HABILITAR BOTOES
					 */
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					dateValidade.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
					/**
					 * HABILITAR CAMPOS E BOTOES
					 */
					btnCreate.setEnabled(true);
					btnPesquisarId.setEnabled(false);
					txtId.setEnabled(false);
					txtId.setText(null);
					txtCodigoDeBarras.requestFocus();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // FIM PESQUISAR

	/**
	 * PESQUISAR USANDO CODIGO DE BARRAS
	 */

	private void pesquisarBarcode() {

		/**
		 * VALIDACAO
		 */
		// if (txtId.getText().isEmpty()) {
		// JOptionPane.showMessageDialog(null, "Insira o ID do produto");
		// txtId.requestFocus();
		// } else {
		String read = "select * from produtos where barcode = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtCodigoDeBarras.getText());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				txtId.setText(rs.getString(1));
				txtCodigoDeBarras.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				txtDescricao.setText(rs.getString(4));
				txtFabricante.setText(rs.getString(5));
				// dateEntrada.setDate(rs.getDate(6));
				String setarDataEntrada = rs.getString(6);
				java.util.Date dataEntrada = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataEntrada);
				dateEntrada.setDate(dataEntrada);

				// dateValidade.setDate(rs.getDate(7));
				String setarDataValidade = rs.getString(7);
				java.util.Date dataValidade = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataValidade);
				dateValidade.setDate(dataValidade);

				txtEstoque.setText(rs.getString(8));
				txtEstoqueMinimo.setText(rs.getString(9));
				cboUnidade.setSelectedItem(rs.getString(10));
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
				txtId.setEnabled(false);
				dateValidade.setEnabled(false);

			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				txtId.setEnabled(false);
				btnCreate.setEnabled(true);
				btnPesquisarId.setEnabled(false);
				txtProduto.requestFocus();

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// }
	} // FIM PESQUISAR USANDO CODIGO DE BARRAS

	/**
	 * ADICIONAR
	 */

	public void adicionar() {
		/**
		 * VALIDACAO
		 */

		if (txtCodigoDeBarras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o código de barras do produto");
			txtCodigoDeBarras.requestFocus();
		} else if (txtProduto.getText().isEmpty()) {
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
		} else if (dateValidade.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Insira a data de validade");
			dateValidade.requestFocus();
		} else if (cboUnidade.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Insira a unidade do produto");
			cboUnidade.requestFocus();
		} else if (txtLocalizacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a localização do produto");
			txtLocalizacao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço de custo");
			txtCusto.requestFocus();
		} else if (txtIdFor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Fornecedor");
			txtFornecedor.requestFocus();

		} else {
			String insert = "insert into produtos (barcode, produto, descricao, fabricante, dataval, estoque, estoquemin, unidade, localizacao, custo, lucro, idFor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(insert);
				pst.setString(1, txtCodigoDeBarras.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtDescricao.getText());
				pst.setString(4, txtFabricante.getText());

				/**
				 * FORMATAR O VALOR DO JCALENDAR PARA INSERCAO CORRETA NO BANCO
				 */
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateValidade.getDate());
				pst.setString(5, dataFormatada); // x -> parâmetro do componente dateChooser

				// pst.setDate(5, (Date) dateValidade.getDate());
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoqueMinimo.getText());
				pst.setString(8, cboUnidade.getSelectedItem().toString());
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
		if (txtCodigoDeBarras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o código de barras do produto");
			txtCodigoDeBarras.requestFocus();
		} else if (txtProduto.getText().isEmpty()) {
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
		} else if (cboUnidade.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Insira a unidade do produto");
			cboUnidade.requestFocus();
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
				
				/**
				 * FORMATAR O VALOR DO JCALENDAR PARA INSERCAO CORRETA NO BANCO
				 */
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateValidade.getDate());
				pst.setString(5, dataFormatada); // x -> parâmetro do componente dateChooser
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoqueMinimo.getText());
				pst.setString(8, cboUnidade.getSelectedItem().toString());
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
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto!");
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

	/**
	 * LIMPAR
	 */

	public void limpar() {
		txtId.setText(null);
		txtCodigoDeBarras.setText(null);
		txtProduto.setText(null);
		txtDescricao.setText(null);
		txtFabricante.setText(null);
		txtEstoque.setText(null);
		txtEstoqueMinimo.setText(null);
		dateValidade.setDate(null);
		dateEntrada.setDate(null);
		cboUnidade.setSelectedItem("");
		txtLocalizacao.setText(null);
		txtCusto.setText(null);
		txtLucro.setText(null);
		txtIdFor.setText(null);
		txtFornecedor.setText(null);
		txtId.setEnabled(true);
		txtCodigoDeBarras.requestFocus();
		btnPesquisarId.setEnabled(true);
		btnCreate.setEnabled(false);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		dateValidade.setDate(null);
		dateEntrada.setDate(null);

	} // FIM LIMPAR
} // FIM DO CODIGO
