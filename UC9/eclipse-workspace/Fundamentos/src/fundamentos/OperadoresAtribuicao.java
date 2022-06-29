/**
 * Operadores de Atribuição
 */
package fundamentos;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class OperadoresAtribuicao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x = 5;
		System.out.println("         Operadores Aritméticos");
		System.out.println("--------------------------------------");
		System.out.println("| Operador | Exemplo  | Resultado       ");
		System.out.println("|    =     |  x = 5   | " + x);
		System.out.println("|    +=    |  x += 5  | " + (x += 5));
		System.out.println("|    -=    |  x -= 4  | " + (x -= 4));
		System.out.println("|    *=    |  x *= 3  | " + (x *= 3));
		System.out.println("|    /=    |  x /= 2  | " + (x /= 2));
		x++; //soma 1 a variável x (x = x + 1)
		System.out.println("|    ++    |  x++     | " + (x));
		x--; //substrai 1 a variável x (x = x - 1)
		System.out.println("|    --    |  x--     | " + x);
		System.out.println("-----------------------------------------");
	}
}
