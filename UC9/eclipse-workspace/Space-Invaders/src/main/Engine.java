package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import sprites.Laser;
import sprites.Nave;

@SuppressWarnings("serial")
public class Engine extends JPanel implements Runnable, KeyListener {
	/*************************
	 **** VINCULAR A NAVE ****
	 *************************/
	Nave nave = new Nave();
	public int sentido;

	/*******************************
	 **** VINCULAR O BACKDROP ******
	 *******************************/
	Backdrop backdrop = new Backdrop();
	// public int movimenta;

	/**************************************************
	 **** VINCULAR O TIRO USANDO UM VETOR DINAMICO ****
	 **************************************************/
	// Laser laser = new Laser();
	public ArrayList<Laser> laser = new ArrayList<Laser>();
	
	/**************************
	 **** VINCULAR O AUDIO ****
	 **************************/
	Sound somLaser = new Sound();
	
	

	/********************
	 **** CONSTRUTOR ****
	 *********************/
	public Engine() {
		/**************************
		 **** CRIAR UMA THREAD ****
		 **************************/
		Thread game = new Thread(this);
		game.start(); // Iniciar processamento do jogo (run())
	}

	@Override
	public void run() {
		while (true) {
			/**************************
			 **** MECANICA DO JOGO ****
			 **************************/
			refresh(); // Atualizar o JPanel -> JFrame
			repaint(); // Redesenhar os assets
			delay(); // Tempo antes do refresh (ajustes UX)

		}
	}

	public void refresh() {
		// nave
		nave.moverNave(sentido);
		// laser
		for (int i = 0; i < laser.size(); i++) {
			laser.get(i).moverLaser();
			// se o laser chegar ao fim da tela (posYL < 0 )
			if (laser.get(i).removerLaser() == true) {
				laser.remove(i);
			}
		}
		// Entendimento da logica do tiro
		//System.out.println(laser.size());
	}

	/***************************************************
	 **** LIMPAR A TELA E EVITAR O RASTRO DO SPRITE ****
	 ***************************************************/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		backdrop.exibirFundo(g);
		// laser
		for (int i = 0; i < laser.size(); i++) {
			laser.get(i).exibirLaser(g);
		}
		nave.exibirNave(g);

	}

	public void delay() {
		/********************************
		 **** TRATAMENTO DE EXCECOES ****
		 ********************************/
		try {
			Thread.sleep(6); // milissegundos

		} catch (Exception e) {
			System.out.println(e);
		}

	} // Fim do metodo void

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/******************************
	 **** PRESSIONAR UMA TECLA ****
	 ******************************/
	@Override
	public void keyPressed(KeyEvent e) {
		/******************************
		 **** SE PRESSIONA TECLA > ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			// nave.moverNave(sentido = 1);
			sentido = 1;
		}
		/******************************
		 **** SE PRESSIONA TECLA < ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			// nave.moverNave(sentido = -1);
			sentido = -1;
		}
		/******************************
		 **** SE PRESSIONA TECLA ^ ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			sentido = 2;
		}
		/******************************
		 **** SE PRESSIONA TECLA v ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_X) {
			sentido = -2;
		}
		/****************
		 **** ATIRAR ****
		 ****************/
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			laser.add(nave.atirar());
			somLaser.play();
			
		}

	}

	/**************************
	 **** SOLTAR UMA TECLA ****
	 **************************/
	@Override
	public void keyReleased(KeyEvent e) {
		// se soltar a tecla seta direita
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			sentido = 0;
		}

		// se soltar a tecla seta esquerda
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			sentido = 0;
		}

		// se soltar a tecla seta acima
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			sentido = 0;
		}

		// se soltar a tecla seta abaixo
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			sentido = 0;
		}
	}
} // Fim da classe Engine
