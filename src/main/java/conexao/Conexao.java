package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://chunee.db.elephantsql.com:5432/crvakcpl";
			String usuariosDb = "crvakcpl";
			String senhaDb = "9Grt-canGKWaLeoHsb-fUrBJP6htoyao";
			return DriverManager.getConnection(url, usuariosDb, senhaDb);
		} catch (Exception e) {
			System.out.println("Erro de conexão");
			e.printStackTrace();
			return null;
		}
	}
}
