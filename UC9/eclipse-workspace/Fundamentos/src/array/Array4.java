/**
 * Fundamentos do Java
 * Estudo do array de duas dimensoes (Matriz)
 */
package array;

public class Array4 {

	public static void main(String[] args) {
		// [] [] linha coluna
		String[][] agenda = { { "Bill Gates", "9999-1234", "bill@outlook.com" },
				{ "Fagner Geraldes Braga", "96102-4801", "fagner.fgb@gmail.com" },
				{ "Allan Gomes", "1234-56789", "allan.gomes@gmail.com" } };
		// recuperar o email do Fagner
		System.out.println(agenda[1][2]);
		System.out.println("========================");
		// recuperar o telefone do Bill Gates
		System.out.println(agenda[0][1]);
		System.out.println("========================");

		// percorrer todos os elementos da matriz e imprimir na tela
		System.out.println("== Agenda de Contatos ==");
		System.out.println("========================");
		for (int i = 0; i < agenda.length; i++) {
			for (int j = 0; j < agenda[i].length; j++) {
				System.out.println(agenda[i][j]);
			}
			System.out.println("========================");
		}
	}
}
