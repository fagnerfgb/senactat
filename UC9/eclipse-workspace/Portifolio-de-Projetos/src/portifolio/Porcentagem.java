package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Color;

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
		setBounds(100, 100, 479, 278);
		getContentPane().setLayout(null);

		txtPorcentagem = new JTextField();
		txtPorcentagem.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorcentagem.setFont(new Font("Dialog", Font.BOLD, 14));
		txtPorcentagem.setBounds(20, 54, 44, 20);
		getContentPane().add(txtPorcentagem);
		txtPorcentagem.setColumns(10);

		JLabel lbl1 = new JLabel("% de");
		lbl1.setBounds(74, 54, 44, 20);
		getContentPane().add(lbl1);

		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("Dialog", Font.BOLD, 14));
		txtValor.setBounds(114, 54, 114, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JButton button = new JButton("=");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		button.setBounds(231, 49, 95, 25);
		getContentPane().add(button);

		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		txtResultado.setBounds(332, 54, 114, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		txtCusto = new JTextField();
		txtCusto.setBounds(20, 126, 114, 19);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		txtLucro = new JTextField();
		txtLucro.setBounds(166, 126, 44, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

		txtVenda = new JTextField();
		txtVenda.setEditable(false);
		txtVenda.setBounds(332, 126, 114, 19);
		getContentPane().add(txtVenda);
		txtVenda.setColumns(10);

		JLabel lblCusto = new JLabel("Custo (R$)");
		lblCusto.setBounds(34, 106, 87, 15);
		getContentPane().add(lblCusto);

		JLabel lblLucro = new JLabel("Lucro (%)");
		lblLucro.setBounds(146, 106, 70, 15);
		getContentPane().add(lblLucro);

		JLabel lblVenda = new JLabel("Venda (R$)");
		lblVenda.setBounds(339, 106, 84, 15);
		getContentPane().add(lblVenda);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lucro();
			}
		});
		btnCalcular.setBounds(231, 120, 95, 25);
		getContentPane().add(btnCalcular);

		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(20, 210, 114, 19);
		getContentPane().add(txtSubtotal);
		txtSubtotal.setColumns(10);

		txtDesconto = new JTextField();
		txtDesconto.setBounds(166, 210, 44, 19);
		getContentPane().add(txtDesconto);
		txtDesconto.setColumns(10);

		JButton btnCalcular2 = new JButton("Calcular");
		btnCalcular2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desconto();
			}
		});
		btnCalcular2.setBounds(231, 204, 95, 25);
		getContentPane().add(btnCalcular2);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(332, 210, 114, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblSubtotal = new JLabel("Subtotal (R$)");
		lblSubtotal.setBounds(24, 193, 109, 15);
		getContentPane().add(lblSubtotal);

		JLabel lblDesconto = new JLabel("Desc (%)");
		lblDesconto.setBounds(155, 193, 61, 15);
		getContentPane().add(lblDesconto);

		JLabel lblTotal = new JLabel("Total (R$)");
		lblTotal.setBounds(351, 193, 84, 15);
		getContentPane().add(lblTotal);

		JLabel lblPorcentagem = new JLabel("Porcentagem");
		lblPorcentagem.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPorcentagem.setBounds(143, 12, 188, 30);
		getContentPane().add(lblPorcentagem);

		JLabel lblCustoXVenda = new JLabel("Preço de Venda");
		lblCustoXVenda.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCustoXVenda.setBounds(119, 83, 237, 25);
		getContentPane().add(lblCustoXVenda);

		JLabel lblDesconto_1 = new JLabel("Desconto");
		lblDesconto_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDesconto_1.setBounds(166, 157, 142, 32);
		getContentPane().add(lblDesconto_1);

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
}
