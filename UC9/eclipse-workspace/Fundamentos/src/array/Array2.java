/**
 * Array Simples
 * Exemplo 2 - Sorteio de uma carta
 */
package array;

import java.util.Random;

public class Array2 {

	public static void main(String[] args) {

		/**************************************************
		 **** LEFT ALT + 3, 4, 5, 6 (TECLADO NUMERICO) ****
		 **************************************************/
		String[] naipes = { "♥", "♦", "♣", "♠" };
		String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.println(faces[0] + naipes[1]);
		System.out.println(faces[11] + naipes[0]);

		/**
		for (int i = 0; i < faces.length; i++) {
			for (int j = 0; j < naipes.length; j++) {
				System.out.println(faces[i] + naipes[j]);
			}
		} 
		**/
		System.out.println("===========================");
		System.out.println("Carta sorteada:");
		/**********************************************************************
		 **** CRIAR UM OBJETO DE NOME CARTA PARA GERAR UM NUMERO ALEATORIO ****
		 **********************************************************************/
		Random carta = new Random();
		
		/***************************************************************************************************************
		 **** CRIAR UMA VARIAVEL DO TIPO INTEIRO QUE RECEBE UM NUMERO ALEATORIO ENTRE 0 E O TAMANHO MAXIMO DO VETOR ****
		 ***************************************************************************************************************/
		int indiceFace = carta.nextInt(faces.length);
		int indiceNaipe = carta.nextInt(naipes.length);
		
		/****************************
		 **** EXIBIR O RESULTADO ****
		 ****************************/
		System.out.println(faces[indiceFace]+ naipes[indiceNaipe]);
		
	}
}
