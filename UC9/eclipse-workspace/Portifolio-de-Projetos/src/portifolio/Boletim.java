package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Boletim.class.getResource("/img/boletim-48.png")));
		setModal(true);
		setTitle("C\u00E1lculo da M\u00E9dia");
		setResizable(false);
		setBounds(100, 100, 450, 431);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

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

		JLabel lblBimestre1 = new JLabel("1\u00BA Bimestre");
		lblBimestre1.setBounds(12, 175, 100, 15);
		getContentPane().add(lblBimestre1);

		txtNota1 = new JTextField();
		txtNota1.setBounds(110, 171, 76, 19);
		getContentPane().add(txtNota1);
		txtNota1.setColumns(10);

		JLabel lblBimestre2 = new JLabel("2\u00BA Bimestre");
		lblBimestre2.setBounds(233, 175, 100, 15);
		getContentPane().add(lblBimestre2);

		txtNota2 = new JTextField();
		txtNota2.setBounds(340, 171, 76, 19);
		getContentPane().add(txtNota2);
		txtNota2.setColumns(10);

		JLabel lblBimestre3 = new JLabel("3\u00BA Bimestre");
		lblBimestre3.setBounds(12, 206, 91, 15);
		getContentPane().add(lblBimestre3);

		txtNota3 = new JTextField();
		txtNota3.setBounds(110, 202, 76, 19);
		getContentPane().add(txtNota3);
		txtNota3.setColumns(10);

		JLabel lblBimestre4 = new JLabel("4\u00BA Bimestre");
		lblBimestre4.setBounds(233, 206, 91, 15);
		getContentPane().add(lblBimestre4);

		txtNota4 = new JTextField();
		txtNota4.setBounds(340, 202, 76, 19);
		getContentPane().add(txtNota4);
		txtNota4.setColumns(10);

		JButton btnMedia = new JButton("");
		btnMedia.setToolTipText("Calcular m\u00E9dia");
		btnMedia.setIcon(new ImageIcon(Boletim.class.getResource("/img/boletim.png")));
		btnMedia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				media();
			}
		});
		btnMedia.setBounds(102, 256, 64, 64);
		getContentPane().add(btnMedia);

		JLabel lblMdiaEscolar = new JLabel("M\u00E9dia Escolar");
		lblMdiaEscolar.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMdiaEscolar.setBounds(133, 12, 167, 36);
		getContentPane().add(lblMdiaEscolar);

		txtMedia = new JTextField();
		txtMedia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedia.setEditable(false);
		txtMedia.setBounds(160, 347, 114, 19);
		getContentPane().add(txtMedia);
		txtMedia.setColumns(10);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(Boletim.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(268, 256, 64, 64);
		getContentPane().add(btnLimpar);
		
		// Uso da Biblioteca Atxy2k
				
				//Validar nome
				RestrictedTextField nome = new RestrictedTextField(txtNome);
				nome.setOnlyText(true);
				nome.setAcceptSpace(true);
				nome.setLimit(40);
				
				//Validar idade
				RestrictedTextField idade = new RestrictedTextField(txtIdade, "0123456789");
				idade.setLimit(2);
				
				//Validar Disciplina
				RestrictedTextField disciplina = new RestrictedTextField(txtDisciplina);
				disciplina.setOnlyText(true);
				disciplina.setAcceptSpace(true);
				disciplina.setLimit(40);
				
				//Validar Nota1
				RestrictedTextField nota1 = new RestrictedTextField(txtNota1, "0123456789.");
				nota1.setLimit(4);
				
				//Validar Nota2
				RestrictedTextField nota2 = new RestrictedTextField(txtNota2, "0123456789.");
				nota2.setLimit(4);
				
				//Validar Nota3
				RestrictedTextField nota3 = new RestrictedTextField(txtNota3, "0123456789.");
				nota3.setLimit(4);
				
				//Validar Nota4
				RestrictedTextField nota4 = new RestrictedTextField(txtNota4, "0123456789.");
				nota4.setLimit(4);
				

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

			// SaÃ­da
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
	} //fim do método media
	
	/** Método para Limpar **/
	void limpar() {
		txtNome.setText(null);
		txtIdade.setText(null);
		txtDisciplina.setText(null);
		txtNota1.setText(null);
		txtNota2.setText(null);
		txtNota3.setText(null);
		txtNota4.setText(null);
		txtNome.requestFocus();
	} // Fim do método limpar
}
