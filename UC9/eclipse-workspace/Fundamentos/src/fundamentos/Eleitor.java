/**
 * Sistema de verificação de eleitor
 * Fundamentos do Java
 * Exemplo de uso da estrutura else if
 * 
 */
package fundamentos;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class Eleitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int idade = 71;
		if (idade < 16) {
			System.out.println("Voto proibido");
		} else if (idade > 17 && idade < 71) {
			System.out.println("Voto obrigatório");
		} else {
			System.out.println("Voto facultativo");
		}

	}

}
