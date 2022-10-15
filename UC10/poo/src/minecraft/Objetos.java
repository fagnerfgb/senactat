/**
 * 
 */
package minecraft;

/**
 * @author fagner.gbraga
 *
 */
public class Objetos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Objetos =========");
		// Objeto 1
		Enxada enxadaPedra = new Enxada();
		enxadaPedra.textura = "Pedra";
		enxadaPedra.resistencia = 5;
		System.out.println("Enxada: " + enxadaPedra.textura);
		System.out.println("Resitência: " + enxadaPedra.resistencia);
		enxadaPedra.arar();
		if (enxadaPedra.conquista == true) {
			System.out.println("Conquista desbloqueada!");
		}
		// Objeto 2
		Enxada enxadaDiamante = new Enxada();
		enxadaDiamante.textura = "Diamante";
		enxadaDiamante.resistencia = 10;
		System.out.println("Enxada: " + enxadaDiamante.textura);
		System.out.println("Resitência: " + enxadaDiamante.resistencia);
		enxadaDiamante.construir();
		enxadaDiamante.minerar();
	}
	
}
