package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Backdrop {
	BufferedImage background;
	int posBackY = 0;

	/********************
	 **** CONSTRUTOR ****
	 *********************/
	public Backdrop() {
		try {
			/***************************
			 **** CARREGAR A IMAGEM ****
			 ***************************/
			background = ImageIO.read(new File("img/background.jpg"));
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel carregar a imagem");
			System.out.println(e);
		}
	}

	/****************************************************
	 **** METODO RESPONSAVEL POR DESENHAR O BACKDROP ****
	 ****************************************************/
	public void exibirFundo(Graphics g) {
		g.drawImage(background, 0, posBackY - 720, null);
		g.drawImage(background, 0, posBackY, null);
		if (posBackY > 720) {
			posBackY = 0;
		} else {
			posBackY+=2;
		}

	}

}