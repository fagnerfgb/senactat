package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	// Criando variaveis encapsuladas para acesso ao banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.56.10:3306/db_estoque";
	private String user = "root";
	private String password = "123@Senac";

	// Metodo responsavel por abrir um conexao
	public Connection conectar() {

		// Criar um objeto
		Connection con = null;

		// Tratamento de excecoes
		try {
			// logica principal para abrir a conexao
			// uso do driver
			Class.forName(driver);
			// Obter os parametros da conexao
			con = DriverManager.getConnection(url, user, password); // conectar
			// retornar a conexao
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}