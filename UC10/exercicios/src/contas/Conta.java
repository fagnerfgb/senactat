package contas;

public class Conta {
	// atributos
	private String cliente;
	private double saldo;

	// construtor
	public Conta() {
		System.out.println("--------------------------------------------");
		System.out.println("Agência 0261");

	}

	// metodos

	protected void exibirSaldo() {
		System.out.println("Saldo:  R$ " + saldo);
	}

	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);
	}

	void transferir(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferência:  R$ " + valor);
	}

	double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
