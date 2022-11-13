package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/**
	 * VARIAVEIS PARA CONEXAO COM O BANCO DE DADOS
	 */

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.56.10:3306/estoque";
	private String user = "root";
	private String password = "123@Senac";

	/**
	 * ABRIR CONEXAO COM O BANCO DE DADOS
	 */

	public Connection conectar() {

		// CRIACAO DE OBJETO
		Connection con = null;

		// TRATAMENTO DE EXCECOES
		try {
			/**
			 * LOGICA PRINCIPAL
			 */

			// USO DO DRIVER
			Class.forName(driver);

			// OBTER PARAMETROS E REALIZAR A CONEXAO
			con = DriverManager.getConnection(url, user, password);

			// RETORNAR A CONEXAO
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}