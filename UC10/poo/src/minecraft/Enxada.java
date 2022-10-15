/**
 * 
 */
package minecraft;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class Enxada extends Bloco {
	// Atributos
	boolean conquista = false;

	// Novo método
	void arar() {
		System.out.println("Terra preparada para o plantio.");
		conquista = true;
	}
	// Polimorfismo - modificação de um método existente.
	// Importante: mesmo nome do método e somente em caso de herança
	void minerar() {
		System.out.println("Atacar...");		
	}
}
