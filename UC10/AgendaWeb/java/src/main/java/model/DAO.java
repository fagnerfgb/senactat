package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/**
	 * Modulo de conexao
	 */

	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.56.10:3306/agenda_db?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123@Senac";

	// Metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	} // Fim do metodo conectar
	
	// Teste de conexao
	
//	public void testeConexao() {
//		try {
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		} // Fim do metodo testeConexao
//	
//	}
}
