package sprites;

import java.awt.Color;
import java.awt.Graphics;

public class Laser {

	/*******************
	 **** VARIAVEIS ****
	 *******************/
	int posXL;
	int posYL;

	/********************
	 **** CONSTRUTOR ****
	 ********************/

	public Laser(int posXLIinicial, int posYLInicial) {
		posXL = posXLIinicial;
		posYL = posYLInicial;

	} // Fim do Metodo Laser

	/*************************
	 **** DESENHAR O TIRO ****
	 *************************/
	public void exibirLaser(Graphics g) {
		g.setColor(Color.GREEN);
		// cria um retangulo
		g.fillRect(posXL, posYL, 5, 20); // x, y, width, height
	} // Fim do metodo exibirLaser

	/****************************
	 **** METODO MOVER LASER ****
	 ****************************/
	public void moverLaser() {
		posYL -= 6; // ajuste da velocidade do tiro laser
		// apoio ao entendimento da logica do tiro
		 //System.out.println(posYL);
	} // Fim do metodo moverLaser

	/******************************
	 **** METODO REMOVER LASER ****
	 ******************************/
	public boolean removerLaser() {
		if (posYL < 0) {
			return true;
		} else {
			return false;
		}
	}

} // Fim da Classe Laser
