package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Porcentagem extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtPorcentagem;
	private JTextField txtValor;
	private JTextField txtResultado;
	private JLabel lblCculoDaPorcentagem;

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
		setTitle("Cálculo da Porcentagem");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtPorcentagem = new JTextField();
		txtPorcentagem.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorcentagem.setFont(new Font("Dialog", Font.BOLD, 14));
		txtPorcentagem.setBounds(10, 97, 44, 47);
		getContentPane().add(txtPorcentagem);
		txtPorcentagem.setColumns(10);
		
		JLabel lbl1 = new JLabel("% de");
		lbl1.setBounds(64, 113, 44, 15);
		getContentPane().add(lbl1);
		
		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("Dialog", Font.BOLD, 14));
		txtValor.setBounds(118, 97, 114, 47);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		button.setBounds(242, 108, 70, 25);
		getContentPane().add(button);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		txtResultado.setBounds(322, 97, 114, 47);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		lblCculoDaPorcentagem = new JLabel("Cálculo da Porcentagem");
		lblCculoDaPorcentagem.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCculoDaPorcentagem.setBounds(66, 24, 330, 47);
		getContentPane().add(lblCculoDaPorcentagem);

	}// Fim do Construtor
	
	void calcular() {
	// Declaração das variáveis
	double porcentagem, valor, resultado;
	
	// Entrada
	porcentagem = Double.parseDouble(txtPorcentagem.getText());
	valor = Double.parseDouble(txtValor.getText());
	
	// Processamento
	resultado = (porcentagem * valor)/ 100;
	resultado = Math.round(resultado * 100.0) / 100.0;
	
	//Saída
	txtResultado.setText(String.valueOf(resultado));
	
	}
	
	
	

}
