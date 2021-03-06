package portifolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Boletim extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtDisciplina;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
	private JTextField txtMedia;

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
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Boletim.class.getResource("/img/boletim-48.png")));
		setModal(true);
		setTitle("Cálculo da Média");
		setResizable(false);
		setBounds(100, 100, 450, 343);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 70, 70, 15);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(110, 67, 283, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(12, 105, 70, 15);
		getContentPane().add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setBounds(110, 103, 114, 19);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(12, 140, 70, 15);
		getContentPane().add(lblDisciplina);

		txtDisciplina = new JTextField();
		txtDisciplina.setBounds(110, 139, 114, 19);
		getContentPane().add(txtDisciplina);
		txtDisciplina.setColumns(10);

		JLabel lblBimestre1 = new JLabel("1º Bimestre");
		lblBimestre1.setBounds(12, 175, 100, 15);
		getContentPane().add(lblBimestre1);

		txtNota1 = new JTextField();
		txtNota1.setBounds(110, 171, 76, 19);
		getContentPane().add(txtNota1);
		txtNota1.setColumns(10);

		JLabel lblBimestre2 = new JLabel("2º Bimestre");
		lblBimestre2.setBounds(233, 175, 100, 15);
		getContentPane().add(lblBimestre2);

		txtNota2 = new JTextField();
		txtNota2.setBounds(340, 171, 76, 19);
		getContentPane().add(txtNota2);
		txtNota2.setColumns(10);

		JLabel lblBimestre3 = new JLabel("3º Bimestre");
		lblBimestre3.setBounds(12, 206, 91, 15);
		getContentPane().add(lblBimestre3);

		txtNota3 = new JTextField();
		txtNota3.setBounds(110, 202, 76, 19);
		getContentPane().add(txtNota3);
		txtNota3.setColumns(10);

		JLabel lblBimestre4 = new JLabel("4º Bimestre");
		lblBimestre4.setBounds(233, 206, 91, 15);
		getContentPane().add(lblBimestre4);

		txtNota4 = new JTextField();
		txtNota4.setBounds(340, 202, 76, 19);
		getContentPane().add(txtNota4);
		txtNota4.setColumns(10);

		JButton btnMedia = new JButton("Média Final");
		btnMedia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				media();
			}
		});
		btnMedia.setBounds(165, 233, 117, 25);
		getContentPane().add(btnMedia);

		JLabel lblMdiaEscolar = new JLabel("Média Escolar");
		lblMdiaEscolar.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMdiaEscolar.setBounds(131, 12, 185, 36);
		getContentPane().add(lblMdiaEscolar);

		txtMedia = new JTextField();
		txtMedia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedia.setEditable(false);
		txtMedia.setBounds(167, 270, 114, 19);
		getContentPane().add(txtMedia);
		txtMedia.setColumns(10);

	}// Fim do Construtor

	void media() {
		// Validação
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome");
			txtNome.requestFocus();
		} else if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a idade");
			txtIdade.requestFocus();
		} else if (txtDisciplina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a disciplina");
			txtDisciplina.requestFocus();
		} else if (txtNota1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nota 1");
			txtNota1.requestFocus();
		} else if (txtNota2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nota 2");
			txtNota2.requestFocus();
		} else if (txtNota3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nota 3");
			txtNota3.requestFocus();
		} else if (txtNota4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nota 4");
			txtNota4.requestFocus();
		} else {
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
			if (media < 5.0) {
				JOptionPane.showMessageDialog(null, nome + ",\nA sua idade é " + idade + " anos! \nA sua média em "
						+ disciplina + " é " + media + "!\nREPROVADO", "Média", JOptionPane.ERROR_MESSAGE);
				txtMedia.setText(String.valueOf(media));
			} else {
				JOptionPane.showMessageDialog(null, nome + ",\nA sua idade é " + idade + " anos! \nA sua média em "
						+ disciplina + " é " + media + "!\n APROVADO!", "Média", JOptionPane.INFORMATION_MESSAGE);
				txtMedia.setText(String.valueOf(media));
			}
		}
	}
}
