package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

public class IMC extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JLabel lblImagem;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
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
	public IMC() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMC.class.getResource("/img/bmi48.png")));
		setModal(true);
		setTitle("IMC");
		setResizable(false);
		setBounds(100, 100, 469, 498);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(IMC.class.getResource("/img/bmi.png")));
		btnSalvar.setToolTipText("Calcular o IMC");
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnSalvar.setBounds(232, 258, 64, 64);
		getContentPane().add(btnSalvar);

		JLabel lblNewLabel = new JLabel("Peso (Kg)");
		lblNewLabel.setBounds(232, 76, 64, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Altura (m)");
		lblNewLabel_1.setBounds(232, 167, 81, 15);
		getContentPane().add(lblNewLabel_1);

		txtPeso = new JTextField();
		txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeso.setBounds(323, 74, 100, 19);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setHorizontalAlignment(SwingConstants.CENTER);
		txtAltura.setBounds(323, 167, 100, 19);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc.png")));
		lblImagem.setBounds(12, 12, 213, 425);
		getContentPane().add(lblImagem);

		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(323, 398, 100, 19);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		JLabel lblOSeuImc = new JLabel("O seu IMC \u00E9");
		lblOSeuImc.setBounds(232, 398, 81, 15);
		getContentPane().add(lblOSeuImc);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(IMC.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(359, 260, 64, 64);
		getContentPane().add(btnLimpar);

		// Validação Peso
		RestrictedTextField peso = new RestrictedTextField(txtPeso, "0123456789.");
		peso.setLimit(5);

		// Validação Altura
		RestrictedTextField altura = new RestrictedTextField(txtAltura, "0123456789.");
		altura.setLimit(5);

	}// fim do construtor

	// Método responsável pelo cáculo do IMC
	void calcular() {
		// validaçãoo
		if (txtPeso.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o peso");
			txtPeso.requestFocus();
		} else if (txtAltura.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a altura");
			txtAltura.requestFocus();
		} else {

			// Declaração de variáveis
			// String nome;
			double peso, altura, imc;
			// int idade;

			// Entrada
			// Armazenando o conteúdo das caixas de texto nas variáveis
			// nome = txtNome.getText();

			// Armazenando e convertendo o conteÃºdo das caixas de texto nas variáveis
			peso = Double.parseDouble(txtPeso.getText());
			altura = Double.parseDouble(txtAltura.getText());
			// idade = Integer.parseInt(txtIdade.getText());

			// Processamento
			// Cálculo do IMC
			imc = peso / (altura * altura);
			imc = Math.round(imc * 100.0) / 100.0;

			// Exibir o conteúdo das variáveis em uma caixa de mensagem
			// JOptionPane.showMessageDialog(null, nome + ",\nA sua idade é " + idade + "
			// anos! \nO seu peso é " + peso + " kilos! \nA sua altura é " + altura + "
			// metros!\nO seu IMC é " + Math.round(imc)+"!", "Ficha do Aluno",
			// JOptionPane.DEFAULT_OPTION);

			// Saída
			txtResultado.setText(String.valueOf(imc));
			if (imc < 17) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc1.png")));
			} else if (imc >= 17.0 && imc < 18.5) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc2.png")));
			} else if (imc >= 18.5 && imc < 25.0) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc3.png")));
			} else if (imc >= 25 && imc < 30.0) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc4.png")));
			} else if (imc >= 30 && imc < 35.0) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc5.png")));
			} else if (imc >= 35 && imc < 40.0) {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc6.png")));
			} else {
				lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc7.png")));
			}

		}

	}// fim do método calcular

	/** Método para Limpar **/
	void limpar() {
		txtPeso.setText(null);
		txtAltura.setText(null);
		lblImagem.setIcon(new ImageIcon(IMC.class.getResource("/img/imc.png")));
		txtResultado.setText(null);
		txtPeso.requestFocus();
	} // Fim do método limpar
}
