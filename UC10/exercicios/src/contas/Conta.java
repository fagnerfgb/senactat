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

	// Criar metodos publicos para "usar" as variaveis

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		// System.out.println("Saldo: R$ " + saldo);
		return saldo;

	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/* Metodos */

	/**
	 * Metodo simples para exibir o saldo
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo:  R$ " + saldo);
	}

	/**
	 * Metodo com parametro (variavel)
	 * 
	 * @param valor
	 */

	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	/**
	 * Metodo com parametro (variavel)
	 * 
	 * @param valor
	 */
	void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);
	}

	/**
	 * Metodo com parametro (objeto e variavel)
	 * 
	 * @param destino (objeto)
	 * @param valor   (variavel)
	 */
	void transferir(Conta destino, double valor) {
		this.sacar(valor); //this se refere a ele mesmo
		destino.depositar(valor);
		System.out.println("Transferência:  R$ " + valor);
	}

	/**
	 * Metodo com 2 parametros (variaveis) e um retorno obrigatorio
	 * 
	 * @param cc1
	 * @param cc2
	 * @return total
	 */
	double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}

}
