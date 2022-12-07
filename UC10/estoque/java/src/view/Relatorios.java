package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;

public class Relatorios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		setTitle("Relatórios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 663, 295);
		getContentPane().setLayout(null);

		JButton btnReposicao = new JButton("Reposição");
		btnReposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reposicaoEstoque();
			}
		});
		btnReposicao.setFont(new Font("Verdana", Font.BOLD, 12));
		btnReposicao.setBounds(10, 59, 200, 23);
		getContentPane().add(btnReposicao);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnClientes.setFont(new Font("Verdana", Font.BOLD, 12));
		btnClientes.setBounds(430, 25, 200, 23);
		getContentPane().add(btnClientes);

		JButton btnPrecoDeVenda = new JButton("Preço de Venda");
		btnPrecoDeVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precoDeVenda();
			}
		});
		btnPrecoDeVenda.setFont(new Font("Verdana", Font.BOLD, 12));
		btnPrecoDeVenda.setBounds(10, 25, 200, 23);
		getContentPane().add(btnPrecoDeVenda);

		JButton btnProdutosVencidos = new JButton("Produtos Vencidos");
		btnProdutosVencidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosVencidos();
			}
		});
		btnProdutosVencidos.setFont(new Font("Verdana", Font.BOLD, 12));
		btnProdutosVencidos.setBounds(220, 25, 200, 23);
		getContentPane().add(btnProdutosVencidos);

		JButton btnValorTotalMercadorias = new JButton("Valor Total Mercadorias");
		btnValorTotalMercadorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorTotalMercadorias();
			}
		});
		btnValorTotalMercadorias.setFont(new Font("Verdana", Font.BOLD, 12));
		btnValorTotalMercadorias.setBounds(220, 59, 200, 23);
		getContentPane().add(btnValorTotalMercadorias);

		JButton btnUsuarios = new JButton("Usuários");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioUsuarios();
			}
		});
		btnUsuarios.setFont(new Font("Verdana", Font.BOLD, 12));
		btnUsuarios.setBounds(430, 59, 200, 23);
		getContentPane().add(btnUsuarios);
		
		JButton btnTeste = new JButton("Teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teste();
			}
		});
		btnTeste.setFont(new Font("Verdana", Font.BOLD, 12));
		btnTeste.setBounds(10, 114, 200, 23);
		getContentPane().add(btnTeste);

	} // FIM DO CONSTRUTOR

	DAO dao = new DAO();

	/**
	 * FORMATADOR DE CASAS DECIMAIS
	 */
	DecimalFormat moeda = new DecimalFormat("0.00");

	/**
	 * METODO REPOSICAO DE ESTOQUE
	 */
	private void reposicaoEstoque() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME REPOSICAO.PDF
			PdfWriter.getInstance(document, new FileOutputStream("reposicao.pdf"));
			document.open();
			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Reposição de estoque"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(5); // PdfPTable(5) - colunas

			/**
			 * CABECALHO DA TABELA
			 */
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Estoque mínimo"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// ACESSAR O BANCO DE DADOS
			String relReposicao = "select codigo,produto,date_format(dataval,'%d/%m/%Y'), estoque, estoquemin from produtos where estoque < estoquemin";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}
		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("reposicao.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM REPOSICAO ESTOQUE

	/**
	 * CLIENTES
	 */
	private void relatorioClientes() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME CLIENTES.PDF
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();

			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Clientes cadastrados"));
			document.add(new Paragraph(" "));

			/**
			 * CABECALHO DA TABELA
			 */
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// ACESSAR O BANCO DE DADOS
			String relClientes = "select nomeCliente,fone1,cnpjCpf,email from clientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}

		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM CLIENTES

	/**
	 * PRECO DE VENDA
	 */
	private void precoDeVenda() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME PRECO-DE-VENDA.PDF
			PdfWriter.getInstance(document, new FileOutputStream("preco-de-venda.pdf"));
			document.open();

			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Preço de Venda dos Produtos"));
			document.add(new Paragraph(" "));

			/**
			 * CABECALHO DA TABELA
			 */
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Preço de Custo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Preço de Venda"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// ACESSAR O BANCO DE DADOS
			String venda = "select codigo, produto, custo, (custo + (custo * lucro) / 100) from produtos;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(venda);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}

		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("preco-de-venda.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM PRECO DE VENDA

	/**
	 * PRODUTOS VENCIDOS
	 */
	private void produtosVencidos() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME PRODUTOS-VENCIDOS.PDF
			PdfWriter.getInstance(document, new FileOutputStream("produtos-vencidos.pdf"));
			document.open();

			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Produtos Vencidos"));
			document.add(new Paragraph(" "));

			/**
			 * CABECALHO DA TABELA
			 */
			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Localização"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data de Validade"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Dias Vencidos"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// ACESSAR O BANCO DE DADOS
			String vencidos = "select codigo, produto, localizacao, date_format(dataval, '%d/%m/%Y'), datediff(dataval,curdate()) from produtos where datediff(dataval,curdate()) < 0;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(vencidos);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}

		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("produtos-vencidos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM PRODUTOS VENCIDOS

	/**
	 * VALOR TOTAL DAS MERCADORIAS EM ESTOQUE
	 */
	private void valorTotalMercadorias() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME TOTAL-MERCADORIAS.PDF
			PdfWriter.getInstance(document, new FileOutputStream("total-mercadorias.pdf"));
			document.open();

			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Valor total das Mercadorias em Estoque"));
			document.add(new Paragraph(" "));

			/**
			 * CABECALHO DA TABELA
			 */
			PdfPTable tabela = new PdfPTable(1);
			PdfPCell col1 = new PdfPCell(new Paragraph("Total"));

			tabela.addCell(col1);

			// ACESSAR O BANCO DE DADOS
			String estoque = "select sum(estoque * custo) from produtos;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(estoque);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}

		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("total-mercadorias.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM VALOR TOTAL DAS MERCADORIAS EM ESTOQUE

	/**
	 * RELATORIO DE USUARIOS
	 */
	private void relatorioUsuarios() {
		// CRIAR OBJETO PARA CONSTRUIR PAGINA PDF
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		// GERAR O DOCUMENTO PDF
		try {
			// CRIA UM DOCUMENTO PDF EM BRANCO DE NOME USUARIOS.PDF
			PdfWriter.getInstance(document, new FileOutputStream("usuarios.pdf"));
			document.open();

			// GERAR O CONTEUDO DO DOCUMENTO
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			/**
			 * DOCUMENT.ADD - ADICIONA UM PARAGRAFO
			 */
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Relatório de Usuários"));
			document.add(new Paragraph(" "));

			/**
			 * CABECALHO DA TABELA
			 */

			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome completo"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Login"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Perfil"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// ACESSAR O BANCO DE DADOS
			String usuarios = "select id, usuario, login, perfil from usuarios;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(usuarios);
				ResultSet rs = pst.executeQuery();

				/**
				 * ENQUANTO HOUVER DADOS NA TABELA DO BANCO, OBTER O VALOR
				 */
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// ADICIONAR A TABELA AO DOCUMENTO PDF
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // EXECUTA O CODIGO INDEPENDENTE DO RESULTADO
			document.close();
		}

		// ABRIR O ARQUIVO PDF NO LEITOR PADRAO DO PC
		try {
			Desktop.getDesktop().open(new File("usuarios.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // FIM RELATORIO DE USUARIOS
	
	private void teste() {
		
		
	}

} // FIM DO CODIGO
