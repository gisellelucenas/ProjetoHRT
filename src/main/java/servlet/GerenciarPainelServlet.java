package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDao;
import model.Paciente;

@WebServlet("/painelServlet")
public class GerenciarPainelServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PacienteDao pacienteDao = new PacienteDao();
			Paciente paciente = new Paciente();
		
			int id = 0;
			if (req.getParameter("id") != null && req.getParameter("id") != "") {
				id = Integer.parseInt(req.getParameter("id"));
			}
			String acao = req.getParameter("acao");
		
			if (acao != null && acao.equals("apagar")) {
				pacienteDao.apagar(id);
			} else if(id > 0) {
				
				paciente.setId(id);
				paciente.setNome(req.getParameter("nome"));
				paciente.setStatus(req.getParameter("status"));
				paciente.setLocal(req.getParameter("local"));
				paciente.setInicioPrevisto(req.getParameter("inicio-previsto"));
				paciente.setInicioCirurgia(req.getParameter("inicio-cirurgia"));
				paciente.setFimCirurgia(req.getParameter("fim-cirurgia"));
				paciente.setSaidaPrevista(req.getParameter("saida-previsto"));
				
				pacienteDao.alterar(paciente);
				
			} else {
				paciente.setNome(req.getParameter("nome"));
				paciente.setStatus(req.getParameter("status"));
				paciente.setLocal(req.getParameter("local"));
				paciente.setInicioPrevisto(req.getParameter("inicio-previsto"));
				paciente.setInicioCirurgia(req.getParameter("inicio-cirurgia"));
				paciente.setFimCirurgia(req.getParameter("fim-cirurgia"));
				paciente.setSaidaPrevista(req.getParameter("saida-previsto"));
				
				pacienteDao.adicionar(paciente);
			}
			res.sendRedirect("gerenciar-painel.jsp");
			System.out.println("Gravado!");
		}
		

	}

