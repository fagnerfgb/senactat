package model;

public class JavaBeans {
	/**
	 * Variaveis
	 */
	private String idcon;
	private String nome;
	private String fone;
	private String email;

	/**
	 * Construtor
	 */

	public JavaBeans() {
		super();

	}

	public JavaBeans(String idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	/**
	 * Getters and Setters
	 * 
	 */

	public String getIdcon() {
		return idcon;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
