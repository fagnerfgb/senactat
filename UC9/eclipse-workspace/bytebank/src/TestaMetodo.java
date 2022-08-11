
public class TestaMetodo {

	public static void main(String[] args) {
		Conta contaDoFagner = new Conta();
		contaDoFagner.saldo = 100;
		if (contaDoFagner.deposita(50)) {
			System.out.println("Deposito realizado com sucesso!");
			System.out.println(contaDoFagner.saldo);
		}

		boolean conseguiuRetirar = contaDoFagner.saca(20);
		System.out.println(contaDoFagner.saldo);
		System.out.println(conseguiuRetirar);

		Conta contaDaMarcela = new Conta();
		contaDaMarcela.deposita(1000);

		if (contaDaMarcela.transfere(3000, contaDoFagner)) {
			System.out.println("Transferencia realizada com sucesso");
		} else {
			System.out.println("Saldo insuficiente");
		}
		System.out.println(contaDaMarcela.saldo);
		System.out.println(contaDoFagner.saldo);
	}
}
