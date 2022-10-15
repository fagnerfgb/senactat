package transporte;

public class Hangar {

	public static void main(String[] args) {
		Aviao a380 = new Aviao();
		a380.cor = "Branco";
		a380.ano = 2019;
		a380.envergadura = 80;

		System.out.println("Avi�o: Airbus A380");
		System.out.println("Cor: " + a380.cor);
		System.out.println("Ano: " + a380.ano);
		System.out.println("Envergadura: " + a380.envergadura + " metros");

		a380.ligar();
		a380.acelerar();
		a380.aterrisar();
		a380.desligar();
		
		Aviao cessna152 = new Aviao();
		cessna152.cor = "Branco / Laranja";
		cessna152.ano = 2008;
		cessna152.envergadura = 10;

		System.out.println("Avi�o: Cessna 152");
		System.out.println("Cor: " + cessna152.cor);
		System.out.println("Ano: " + cessna152.ano);
		System.out.println("Envergadura: " + cessna152.envergadura + " metros");

		cessna152.ligar();
		cessna152.acelerar();
		cessna152.aterrisar();
		cessna152.desligar();
	}
}
