package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import conexao.Conexao;
import model.Paciente;

public class PacienteDao {
	public  boolean adicionar(Paciente paciente) {
		try {
			Connection cont = Conexao.conectar();
			
			String sql = "insert into paciente (nome, status, local, inicioprevisto, iniciocirurgia, fimcirurgia, saidaprevista) "
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, sql);
			pst.setString(1, paciente.getNome());
			pst.setString(2, paciente.getStatus());
			pst.setString(3, paciente.getLocal());
			pst.setString(4, paciente.getInicioPrevisto());
			pst.setString(5, paciente.getInicioCirurgia());
			pst.setString(6, paciente.getFimCirurgia());
			pst.setString(7, paciente.getSaidaPrevista());
			
			pst.execute();
			pst.close();
			cont.close();
						
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
