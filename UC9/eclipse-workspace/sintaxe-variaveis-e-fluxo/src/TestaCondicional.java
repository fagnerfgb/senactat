
public class TestaCondicional {
	public static void main (String[] args) {
		System.out.println("testando condicionais");
		int idade = 5;
		int quantidadePessoas = 3;
		if (idade >= 18) {
			System.out.println("Maior de idade");
		} else if (quantidadePessoas >= 2){
			System.out.println("Menor de idade, mas acompanhado");
		} else {
			System.out.println("Não pode entrar");
		}
	}

}
