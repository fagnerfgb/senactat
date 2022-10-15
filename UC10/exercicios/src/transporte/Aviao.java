package transporte;

public class Aviao extends Carro {
	
	// Atributos
	double envergadura;
	
	
	// M�todos
	void aterrisar() {
		System.out.println("Aterrisando...");
	}
	
	// Polimorfismo
	void acelerar() {
		System.out.println("Decolando...");
	}
}
