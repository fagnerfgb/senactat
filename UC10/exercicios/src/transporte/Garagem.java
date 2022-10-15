package transporte;

public class Garagem {

	public static void main(String[] args) {
		Carro ferrari = new Carro();
		ferrari.cor = "Vermelha";
		ferrari.ano = 2022;

		System.out.println("Carro: Ferrari");
		System.out.println("Cor: " + ferrari.cor);
		System.out.println("Ano: " + ferrari.ano);

		ferrari.ligar();
		ferrari.acelerar();
		ferrari.desligar();

		Carro fusca = new Carro();
		fusca.cor = "Azul";
		fusca.ano = 1966;

		System.out.println("Carro: Fusca");
		System.out.println("Cor: " + fusca.cor);
		System.out.println("Ano: " + fusca.ano);

		fusca.ligar();
		fusca.acelerar();
		fusca.desligar();

		Carro camaro = new Carro();
		camaro.cor = "Amarelo";
		camaro.ano = 2012;

		System.out.println("Carro: Camaro");
		System.out.println("Cor: " + camaro.cor);
		System.out.println("Ano: " + camaro.ano);

		camaro.ligar();
		camaro.acelerar();
		camaro.desligar();

		Carro uno = new Carro();
		uno.cor = "Branco";
		uno.ano = 1994;

		System.out.println("Carro: Uno");
		System.out.println("Cor: " + uno.cor);
		System.out.println("Ano: " + uno.ano);

		uno.ligar();
		uno.acelerar();
		uno.desligar();

	}
}
