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
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;

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

		txtNota1 = new JTextField();
		txtNota1.setBounds(110, 121, 76, 19);
		getContentPane().add(txtNota1);
		txtNota1.setColumns(10);

		JLabel lblBimestre2 = new JLabel("2º Bimestre");
		lblBimestre2.setBounds(233, 125, 100, 15);
		getContentPane().add(lblBimestre2);

		txtNota2 = new JTextField();
		txtNota2.setBounds(340, 121, 76, 19);
		getContentPane().add(txtNota2);
		txtNota2.setColumns(10);

		JLabel lblBimestre3 = new JLabel("3º Bimestre");
		lblBimestre3.setBounds(12, 156, 91, 15);
		getContentPane().add(lblBimestre3);

		txtNota3 = new JTextField();
		txtNota3.setBounds(110, 152, 76, 19);
		getContentPane().add(txtNota3);
		txtNota3.setColumns(10);

		JLabel lblBimestre4 = new JLabel("4º Bimestre");
		lblBimestre4.setBounds(233, 156, 91, 15);
		getContentPane().add(lblBimestre4);

		txtNota4 = new JTextField();
		txtNota4.setBounds(340, 152, 76, 19);
		getContentPane().add(txtNota4);
		txtNota4.setColumns(10);

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
		nota1 = Double.parseDouble(txtNota1.getText());
		nota2 = Double.parseDouble(txtNota2.getText());
		nota3 = Double.parseDouble(txtNota3.getText());
		nota4 = Double.parseDouble(txtNota4.getText());
		
		// Processamento
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		media = Math.round(media * 100.0) / 100.0;

		// Saída
		JOptionPane.showMessageDialog(null, nome + ",\nA sua idade é " + idade + " anos! \nA sua média em "
				+ disciplina + " é " + media + "!", "Média", JOptionPane.INFORMATION_MESSAGE);

	}

}