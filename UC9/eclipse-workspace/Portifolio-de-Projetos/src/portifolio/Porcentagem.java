package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.ImageIcon;

public class Porcentagem extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtPorcentagem;
	private JTextField txtValor;
	private JTextField txtResultado;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTextField txtVenda;
	private JTextField txtSubtotal;
	private JTextField txtDesconto;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Porcentagem dialog = new Porcentagem();
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
	public Porcentagem() {
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Porcentagem.class.getResource("/img/porcentagem-48.png")));
		setTitle("Cálculo da Porcentagem");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 499, 492);
		getContentPane().setLayout(null);

		txtPorcentagem = new JTextField();
		txtPorcentagem.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorcentagem.setFont(new Font("Dialog", Font.BOLD, 14));
		txtPorcentagem.setBounds(22, 129, 44, 20);
		getContentPane().add(txtPorcentagem);
		txtPorcentagem.setColumns(10);

		JLabel lbl1 = new JLabel("% de");
		lbl1.setBounds(76, 129, 44, 20);
		getContentPane().add(lbl1);

		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("Dialog", Font.BOLD, 14));
		txtValor.setBounds(116, 129, 114, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JButton btnPorcentagem = new JButton("");
		btnPorcentagem.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/percentage-64.png")));
		btnPorcentagem.setToolTipText("Calcular");
		btnPorcentagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnPorcentagem.setBounds(249, 107, 64, 64);
		getContentPane().add(btnPorcentagem);

		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		txtResultado.setBounds(334, 130, 114, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		txtCusto = new JTextField();
		txtCusto.setBounds(22, 256, 114, 19);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		txtLucro = new JTextField();
		txtLucro.setBounds(168, 255, 44, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

		txtVenda = new JTextField();
		txtVenda.setEditable(false);
		txtVenda.setBounds(334, 256, 114, 19);
		getContentPane().add(txtVenda);
		txtVenda.setColumns(10);

		JLabel lblCusto = new JLabel("Custo (R$)");
		lblCusto.setBounds(36, 229, 87, 15);
		getContentPane().add(lblCusto);

		JLabel lblLucro = new JLabel("Lucro (%)");
		lblLucro.setBounds(148, 229, 70, 15);
		getContentPane().add(lblLucro);

		JLabel lblVenda = new JLabel("Venda (R$)");
		lblVenda.setBounds(341, 229, 84, 15);
		getContentPane().add(lblVenda);

		JButton btnPVenda = new JButton("");
		btnPVenda.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/profit-64.png")));
		btnPVenda.setToolTipText("Calcular");
		btnPVenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lucro();
			}
		});
		btnPVenda.setBounds(249, 233, 64, 64);
		getContentPane().add(btnPVenda);

		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(22, 388, 114, 19);
		getContentPane().add(txtSubtotal);
		txtSubtotal.setColumns(10);

		txtDesconto = new JTextField();
		txtDesconto.setBounds(168, 388, 44, 19);
		getContentPane().add(txtDesconto);
		txtDesconto.setColumns(10);

		JButton btnDesconto = new JButton("");
		btnDesconto.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/discount-64.png")));
		btnDesconto.setToolTipText("Calcular");
		btnDesconto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desconto();
			}
		});
		btnDesconto.setBounds(249, 365, 64, 64);
		getContentPane().add(btnDesconto);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(334, 388, 114, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblSubtotal = new JLabel("Subtotal (R$)");
		lblSubtotal.setBounds(26, 371, 109, 15);
		getContentPane().add(lblSubtotal);

		JLabel lblDesconto = new JLabel("Desc (%)");
		lblDesconto.setBounds(157, 371, 61, 15);
		getContentPane().add(lblDesconto);

		JLabel lblTotal = new JLabel("Total (R$)");
		lblTotal.setBounds(353, 371, 84, 15);
		getContentPane().add(lblTotal);

		JLabel lblPorcentagem = new JLabel("Porcentagem");
		lblPorcentagem.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPorcentagem.setBounds(156, 71, 188, 30);
		getContentPane().add(lblPorcentagem);

		JLabel lblCustoXVenda = new JLabel("Preço de Venda");
		lblCustoXVenda.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCustoXVenda.setBounds(128, 196, 237, 25);
		getContentPane().add(lblCustoXVenda);

		JLabel lblDesconto_1 = new JLabel("Desconto");
		lblDesconto_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDesconto_1.setBounds(179, 335, 142, 32);
		getContentPane().add(lblDesconto_1);

		// Validação Porcentagem
		RestrictedTextField porcentagem = new RestrictedTextField(txtPorcentagem, "0123456789");
		porcentagem.setLimit(3);

		// Validação Valor
		RestrictedTextField valor = new RestrictedTextField(txtValor, "0123456789");
		valor.setLimit(6);

		// Validação Custo
		RestrictedTextField custo = new RestrictedTextField(txtCusto, "0123456789");
		custo.setLimit(6);

		// Validação Lucro
		RestrictedTextField lucro = new RestrictedTextField(txtLucro, "0123456789");
		lucro.setLimit(3);

		// Validação SubTotal
		RestrictedTextField subtotal = new RestrictedTextField(txtSubtotal, "0123456789");
		subtotal.setLimit(6);

		// Validação Desconto
		RestrictedTextField desconto = new RestrictedTextField(txtDesconto, "0123456789");

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(22, 12, 64, 64);
		getContentPane().add(btnLimpar);
		desconto.setLimit(3);

	}// Fim do Construtor

	void calcular() {
		// Validação
		if (txtPorcentagem.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a porcentagem");
			txtPorcentagem.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor a calcular");
			txtValor.requestFocus();
		} else {
			// Declaração das variáveis
			double porcentagem, valor, resultado;

			// Entrada
			porcentagem = Double.parseDouble(txtPorcentagem.getText());
			valor = Double.parseDouble(txtValor.getText());

			// Processamento
			resultado = (porcentagem * valor) / 100;
			resultado = Math.round(resultado * 100.0) / 100.0;

			// Saída
			txtResultado.setText(String.valueOf(resultado));
		}

	} // Fim do método para calcular a porcentagem

	void lucro() {
		// Validação
		if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o preço de custo");
			txtCusto.requestFocus();
		} else if (txtLucro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a margem de lucro");
			txtLucro.requestFocus();
		} else {
			// Declaração de variáveis
			double custo, lucro, venda;

			// Entrada
			custo = Double.parseDouble(txtCusto.getText());
			lucro = Double.parseDouble(txtLucro.getText());

			// Processamento
			venda = custo + (custo * lucro) / 100;

			// Saída
			txtVenda.setText(String.valueOf(venda));
		}
	} // Fim do método para calcular o lucro

	void desconto() {
		if (txtSubtotal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o subtotal");
			txtSubtotal.requestFocus();
		} else if (txtDesconto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o percentual de desconto");
			txtDesconto.requestFocus();
		} else {
			// Declaração de variáveis
			double subtotal, desconto, total;

			// Entrada
			subtotal = Double.parseDouble(txtSubtotal.getText());
			desconto = Double.parseDouble(txtDesconto.getText());

			// Processamento
			total = subtotal - (subtotal * desconto) / 100;

			// Saída
			txtTotal.setText(String.valueOf(total));
		}
	} // Fim do método para calcular o desconto

	/** Método para Limpar **/
	void limpar() {
		txtPorcentagem.setText(null);
		txtValor.setText(null);
		txtResultado.setText(null);
		txtCusto.setText(null);
		txtLucro.setText(null);
		txtVenda.setText(null);
		txtSubtotal.setText(null);
		txtDesconto.setText(null);
		txtTotal.setText(null);
		txtPorcentagem.requestFocus();
	} // Fim do método limpar
}
