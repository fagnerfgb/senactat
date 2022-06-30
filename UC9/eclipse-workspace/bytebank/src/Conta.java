public class Conta {
	double saldo;
	int agencia;
	int numero;
	String titular;

	public boolean deposita(double valor) {
		this.saldo += valor;
		return true;
	}

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino) {
		if(this.saldo >= valor) {
			saca(valor);
			destino.deposita(valor);
			return true;
		} else {
			return false;
		}
	}
	
}

// 
