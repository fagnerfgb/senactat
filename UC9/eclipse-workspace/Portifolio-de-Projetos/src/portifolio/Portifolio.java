package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Portifolio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portifolio frame = new Portifolio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Portifolio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				/******************************
				 **** EVENTO ATIVAR JANELA ****
				 ******************************/
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.DATE_FIELD);
				lblStatus.setText(formatador.format(data));
			}
		});
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portifolio.class.getResource("/img/pc.png")));
		setForeground(SystemColor.activeCaption);
		setResizable(false);
		setTitle("Portif\u00F3lio de Projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 471);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnImc = new JButton("");
		btnImc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImc.setIcon(new ImageIcon(Portifolio.class.getResource("/img/bmi.png")));
		btnImc.setToolTipText("C\u00E1lculo do IMC");
		btnImc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnImc.setBounds(24, 86, 64, 64);
		contentPane.add(btnImc);

		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Portifolio.class.getResource("/img/about.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setBounds(252, 234, 64, 64);
		contentPane.add(btnSobre);

		JButton btnBoletim = new JButton("");
		btnBoletim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBoletim.setToolTipText("Calculadora da M\u00E9dia");
		btnBoletim.setIcon(new ImageIcon(Portifolio.class.getResource("/img/boletim.png")));
		btnBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boletim boletim = new Boletim();
				boletim.setVisible(true);
			}
		});
		btnBoletim.setBounds(176, 12, 64, 64);
		contentPane.add(btnBoletim);

		JButton btnCelsius = new JButton("");
		btnCelsius.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCelsius.setToolTipText("Converte para Celsius");
		btnCelsius.setIcon(new ImageIcon(Portifolio.class.getResource("/img/celsius.png")));
		btnCelsius.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCelsius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temperatura temperatura = new Temperatura();
				temperatura.setVisible(true);
			}
		});
		btnCelsius.setBounds(24, 12, 64, 64);
		contentPane.add(btnCelsius);

		JButton btnFarenheit = new JButton("");
		btnFarenheit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFarenheit.setIcon(new ImageIcon(Portifolio.class.getResource("/img/fahrenheit.png")));
		btnFarenheit.setToolTipText("Converte para Fahrenheit");
		btnFarenheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temperatura2 temperatura2 = new Temperatura2();
				temperatura2.setVisible(true);
			}
		});
		btnFarenheit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnFarenheit.setBounds(100, 12, 64, 64);
		contentPane.add(btnFarenheit);

		JButton btnPorcentagem = new JButton("");
		btnPorcentagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPorcentagem.setIcon(new ImageIcon(Portifolio.class.getResource("/img/porcentagem.png")));
		btnPorcentagem.setToolTipText("C\u00E1lculo da Porcentagem");
		btnPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Porcentagem porcentagem = new Porcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnPorcentagem.setFont(new Font("Dialog", Font.BOLD, 12));
		btnPorcentagem.setBounds(252, 12, 64, 64);
		contentPane.add(btnPorcentagem);

		JButton btnServico = new JButton("");
		btnServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServico.setIcon(new ImageIcon(Portifolio.class.getResource("/img/hora-trabalho.png")));
		btnServico.setToolTipText("C\u00E1lculo da Hora de Trabalho");
		btnServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoraServico horaservico = new HoraServico();
				horaservico.setVisible(true);
			}
		});
		btnServico.setBounds(100, 86, 64, 64);
		contentPane.add(btnServico);

		JButton btnCombustivel = new JButton("");
		btnCombustivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCombustivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Combustivel combustivel = new Combustivel();
				combustivel.setVisible(true);
			}
		});
		btnCombustivel.setToolTipText("Gasolina ou Etanol ?");
		btnCombustivel.setIcon(new ImageIcon(Portifolio.class.getResource("/img/combustivel.png")));
		btnCombustivel.setBounds(176, 86, 64, 64);
		contentPane.add(btnCombustivel);

		JButton btnEleicao = new JButton("");
		btnEleicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eleitor eleitor = new Eleitor();
				eleitor.setVisible(true);
			}
		});
		btnEleicao.setToolTipText("Elei\u00E7\u00E3o");
		btnEleicao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEleicao.setIcon(new ImageIcon(Portifolio.class.getResource("/img/eleicao.png")));
		btnEleicao.setBounds(252, 86, 64, 64);
		contentPane.add(btnEleicao);

		JButton btnDado = new JButton("");
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dado dado = new Dado();
				dado.setVisible(true);
			}
		});
		btnDado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDado.setToolTipText("Dado");
		btnDado.setIcon(new ImageIcon(Portifolio.class.getResource("/img/dado.png")));
		btnDado.setBounds(24, 160, 64, 64);
		contentPane.add(btnDado);

		JButton btnCep = new JButton("");
		btnCep.setIcon(new ImageIcon(Portifolio.class.getResource("/img/correios-64.png")));
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cep cep = new Cep();
				cep.setVisible(true);
			}
		});
		btnCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCep.setToolTipText("Busca CEP");
		btnCep.setBounds(100, 160, 64, 64);
		contentPane.add(btnCep);

		JButton btnTarot = new JButton("");
		btnTarot.setToolTipText("Tarot");
		btnTarot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTarot.setIcon(new ImageIcon(Portifolio.class.getResource("/img/tarot.png")));
		btnTarot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tarot tarot = new Tarot();
				tarot.setVisible(true);
			}
		});
		btnTarot.setBounds(176, 160, 64, 64);
		contentPane.add(btnTarot);

		JButton btnJoKenPo = new JButton("");
		btnJoKenPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jokenpo jokenpo = new Jokenpo();
				jokenpo.setVisible(true);
			}
		});
		btnJoKenPo.setToolTipText("JoKenPo");
		btnJoKenPo.setIcon(new ImageIcon(Portifolio.class.getResource("/img/jokenpo2.png")));
		btnJoKenPo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJoKenPo.setBounds(252, 160, 64, 64);
		contentPane.add(btnJoKenPo);

		JButton btnTabuada = new JButton("");
		btnTabuada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				tabuada.setVisible(true);
			}
		});
		btnTabuada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTabuada.setToolTipText("Tabuada");
		btnTabuada.setIcon(new ImageIcon(Portifolio.class.getResource("/img/tabuada-64.png")));
		btnTabuada.setBounds(24, 234, 64, 64);
		contentPane.add(btnTabuada);

		JButton btnJurosCompostos = new JButton("");
		btnJurosCompostos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJurosCompostos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JurosCompostos jurosCompostos = new JurosCompostos();
				jurosCompostos.setVisible(true);

			}
		});
		btnJurosCompostos.setIcon(new ImageIcon(Portifolio.class.getResource("/img/juros-compostos-64.png")));
		btnJurosCompostos.setToolTipText("Juros Compostos");
		btnJurosCompostos.setBounds(100, 234, 64, 64);
		contentPane.add(btnJurosCompostos);

		JButton btnHolerite = new JButton("");
		btnHolerite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Holerite holerite = new Holerite();
				holerite.setVisible(true);
			}
		});
		btnHolerite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHolerite.setToolTipText("Holerite");
		btnHolerite.setIcon(new ImageIcon(Portifolio.class.getResource("/img/holerite-64.png")));
		btnHolerite.setBounds(176, 234, 64, 64);
		contentPane.add(btnHolerite);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 383, 335, 39);
		contentPane.add(panel);
		panel.setLayout(null);

		lblStatus = new JLabel("");
		lblStatus.setBounds(10, 0, 315, 39);
		panel.add(lblStatus);
		lblStatus.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(SystemColor.desktop);
		lblStatus.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton btnCarta = new JButton("");
		btnCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carta carta = new Carta();
				carta.setVisible(true);
			}
		});
		btnCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarta.setToolTipText("Carta");
		btnCarta.setIcon(new ImageIcon(Portifolio.class.getResource("/img/baralho-64.png")));
		btnCarta.setBounds(24, 308, 64, 64);
		contentPane.add(btnCarta);
	} // fim do construtor
}
