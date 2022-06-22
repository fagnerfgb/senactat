package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Boletim extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtDisciplina;
	private JTextField txtBimestre1;
	private JTextField txtBimestre2;
	private JTextField txtBimestre3;
	private JTextField txtBimestre4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boletim dialog = new Boletim();
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
	public Boletim() {
		setModal(true);
		setTitle("Cálculo da Média");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 20, 70, 15);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(110, 17, 283, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(12, 55, 70, 15);
		getContentPane().add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setBounds(110, 53, 114, 19);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(12, 90, 70, 15);
		getContentPane().add(lblDisciplina);

		txtDisciplina = new JTextField();
		txtDisciplina.setBounds(110, 89, 114, 19);
		getContentPane().add(txtDisciplina);
		txtDisciplina.setColumns(10);

		JLabel lblBimestre1 = new JLabel("1º Bimestre");
		lblBimestre1.setBounds(12, 125, 100, 15);
		getContentPane().add(lblBimestre1);

		txtBimestre1 = new JTextField();
		txtBimestre1.setBounds(110, 121, 76, 19);
		getContentPane().add(txtBimestre1);
		txtBimestre1.setColumns(10);

		JLabel lblBimestre2 = new JLabel("2º Bimestre");
		lblBimestre2.setBounds(233, 125, 100, 15);
		getContentPane().add(lblBimestre2);

		txtBimestre2 = new JTextField();
		txtBimestre2.setBounds(340, 121, 76, 19);
		getContentPane().add(txtBimestre2);
		txtBimestre2.setColumns(10);

		JLabel lblBimestre3 = new JLabel("3º Bimestre");
		lblBimestre3.setBounds(12, 156, 91, 15);
		getContentPane().add(lblBimestre3);

		txtBimestre3 = new JTextField();
		txtBimestre3.setBounds(110, 152, 76, 19);
		getContentPane().add(txtBimestre3);
		txtBimestre3.setColumns(10);

		JLabel lblBimestre4 = new JLabel("4º Bimestre");
		lblBimestre4.setBounds(233, 156, 91, 15);
		getContentPane().add(lblBimestre4);

		txtBimestre4 = new JTextField();
		txtBimestre4.setBounds(340, 152, 76, 19);
		getContentPane().add(txtBimestre4);
		txtBimestre4.setColumns(10);

		JButton btnMedia = new JButton("Média Final");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				media();
			}
		});
		btnMedia.setBounds(161, 208, 117, 25);
		getContentPane().add(btnMedia);

	}// Fim do Construtor

	void media() {
		// Declaração de variáveis
		String nome, disciplina;
		double nota1, nota2, nota3, nota4, media;
		int idade;

		// Entrada
		nome = txtNome.getText();
		idade = Integer.parseInt(txtIdade.getText());
		disciplina = txtDisciplina.getText();
		nota1 = Double.parseDouble(txtBimestre1.getText());
		nota2 = Double.parseDouble(txtBimestre2.getText());
		nota3 = Double.parseDouble(txtBimestre3.getText());
		nota4 = Double.parseDouble(txtBimestre4.getText());
		
		// Processamento
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		media = Math.round(media * 100.0) / 100.0;

		// Saída
		JOptionPane.showMessageDialog(null, nome + ",\nA sua idade é " + idade + " anos! \nA sua média em "
				+ disciplina + " é " + media + "!", "Média", JOptionPane.DEFAULT_OPTION);

	}

}
