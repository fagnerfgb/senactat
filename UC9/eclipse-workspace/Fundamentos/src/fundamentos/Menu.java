/**
 * Fundamentos da Lógica de Programação com Java
 * Exemplo de uso da estrutura Case
 */
package fundamentos;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Menu de opções: ");
		System.out.println("1. Windows");
		System.out.println("2. Linux");
		System.out.println("3. Mac OS");
		System.out.println("Digite a opção desejada: ");
		int opcao = 3;
		System.out.println("Opção escolhida: " + opcao);
		switch (opcao) {
		case 1:
			System.out.println("Carregando o Windows");
			break;
		case 2:
			System.out.println("Carregando o Linux");
			break;
		case 3:
			System.out.println("Carregando o Mac OS");
			break;
		default:
			System.out.println("Opção Inválida");
			break;
		}
	}
}
