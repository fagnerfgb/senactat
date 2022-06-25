package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class IMC extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtIdade;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMC.class.getResource("/img/bmi48.png")));
		setModal(true);
		setTitle("IMC");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton btnSalvar = new JButton("Gravar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnSalvar.setBounds(165, 215, 117, 25);
		getContentPane().add(btnSalvar);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(27, 79, 70, 15);
		getContentPane().add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setBounds(127, 75, 296, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Peso (Kg)");
		lblNewLabel.setBounds(27, 139, 70, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Altura (m)");
		lblNewLabel_1.setBounds(27, 168, 70, 15);
		getContentPane().add(lblNewLabel_1);

		txtPeso = new JTextField();
		txtPeso.setBounds(127, 137, 150, 19);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(127, 166, 148, 19);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setBounds(27, 110, 70, 15);
		getContentPane().add(lblNewLabel_3);

		txtIdade = new JTextField();
		txtIdade.setBounds(127, 108, 148, 19);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CÁLCULO DO IMC");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_4.setBounds(74, 30, 291, 29);
		getContentPane().add(lblNewLabel_4);

	}// fim do construtor
	
	// Método responsável pelo cálculo do IMC
	void calcular() {
		// Declaração de variáveis
		String nome;
		double peso, altura, imc;
		int idade;

		//Entrada
		// Armazenando o conteúdo das caixas de texto nas variáveis
		nome = txtNome.getText();

		// Armazenando e convertendo o conteúdo das caixas de texto nas variáveis
		peso = Double.parseDouble(txtPeso.getText());
		altura = Double.parseDouble(txtAltura.getText());
		idade = Integer.parseInt(txtIdade.getText());
		
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
		if (imc < 18.5) {
			JOptionPane.showMessageDialog(null,
					nome + ",\nA sua idade é " + idade + " anos! \nO seu peso é " + peso + " kilos! \nA sua altura é "
							+ altura + " metros!\nO seu IMC é " + imc + "! \nVocê está muito magro!",
					"IMC", JOptionPane.DEFAULT_OPTION);
		}
		if (imc >= 18.5 && imc <= 24.9) {
			JOptionPane.showMessageDialog(null,
					nome + ",\nA sua idade é " + idade + " anos! \nO seu peso é " + peso + " kilos! \nA sua altura é "
							+ altura + " metros!\nO seu IMC é " + imc + "! \nO seu IMC está normal!",
					"IMC", JOptionPane.DEFAULT_OPTION);
		}
		if (imc > 25 && imc <= 29.9) {
			JOptionPane.showMessageDialog(null,
					nome + ",\nA sua idade é " + idade + " anos! \nO seu peso é " + peso + " kilos! \nA sua altura é "
							+ altura + " metros!\nO seu IMC é " + imc + "! \nVocê está com sobrepeso!",
					"IMC", JOptionPane.DEFAULT_OPTION);
		}
		if (imc > 30 && imc <= 39.9) {
			JOptionPane.showMessageDialog(null,
					nome + ",\nA sua idade é " + idade + " anos! \nO seu peso é " + peso + " kilos! \nA sua altura é "
							+ altura + " metros!\nO seu IMC é " + imc + "! \nVocê está com obesidade!",
					"IMC", JOptionPane.DEFAULT_OPTION);
		}
		if (imc > 40) {
			JOptionPane.showMessageDialog(null,
					nome + ",\nA sua idade é " + idade + " anos! \nO seu peso é " + peso + " kilos! \nA sua altura é "
							+ altura + " metros!\nO seu IMC é " + imc + "! \nVocê está com obesidade grave!",
					"IMC", JOptionPane.DEFAULT_OPTION);
		}
	}

}

