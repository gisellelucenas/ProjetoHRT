package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean alterar(Paciente objP) {
		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = " update paciente set " 
					+ "nome  = ?," 
					+ "status = ?,"
					+ "local = ?," 
					+ "inicioprevisto = ?," 
					+ "iniciocirurgia = ?," 
					+ "fimcirurgia = ?,"
					+ "saidaprevista    = ? " 
					+ "where id	= ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, objP.getNome());
			pst.setString(2, objP.getStatus());
			pst.setString(3, objP.getLocal());
			pst.setString(4, objP.getInicioPrevisto());
			pst.setString(5, objP.getInicioCirurgia());
			pst.setString(6, objP.getFimCirurgia());
			pst.setString(7, objP.getSaidaPrevista());
			pst.setInt(8, objP.getId());
		

			pst.execute();
			pst.close();
			cont.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean apagar(int id) {
		
		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = "delete from paciente where id = ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setInt(1, id);

			pst.execute();
			pst.close();
			cont.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
//	Criei o metodo lista paciente 
//	retonra a lista de paciente
	public List<Paciente> listaPaciente() {
		List<Paciente> ls = new ArrayList<>();

		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select * from paciente order by id");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Paciente p = new Paciente();
				p.setId(rs.getInt("id"));//				aqui são informações do Banco de dados 
				p.setNome(rs.getString("nome"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local"));
				p.setInicioPrevisto(rs.getString("inicioprevisto"));
				p.setInicioCirurgia(rs.getString("Iniciocirurgia"));
				p.setFimCirurgia(rs.getString("fimcirurgia"));
				p.setSaidaPrevista(rs.getString("saidaprevista"));
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}
}
