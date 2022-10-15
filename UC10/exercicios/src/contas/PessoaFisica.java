package contas;

public class PessoaFisica {

	public static void main(String[] args) {
		Conta cc1 = new Conta();
		cc1.setSaldo(10000);
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		cc1.sacar(1000);
		cc1.exibirSaldo();

		Conta cc2 = new Conta();
		cc2.setCliente("Natalia da Paz Almeida");
		cc2.setSaldo(20000);
		System.out.println("Cliente: " + cc2.getCliente());
		cc2.exibirSaldo();
		cc2.depositar(10000);
		cc2.exibirSaldo();

		System.out.println("Transferência");
		System.out.println("Sacado: " + cc1.getCliente());
		System.out.println("Favorecido: " + cc2.getCliente());
		cc1.transferir(cc2, 5000);
		cc1.exibirSaldo();
		cc2.exibirSaldo();

		System.out.println("Relatório Gerencial");
		Conta gerente = new Conta();
		double relatorio = gerente.soma(cc1.getSaldo(), cc2.getSaldo());
		System.out.println("Saldo total nas contas: R$ " + relatorio);

	}

}
