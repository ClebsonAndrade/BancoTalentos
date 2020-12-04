package br.edu.ifs.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifs.dao.FabricaConexoesPostgres;
import br.edu.ifs.dao.IFabricaConexoes;
import br.edu.ifs.dao.ICandidatoDAO;
import br.edu.ifs.dao.CandidatoDAOPostgres;
import br.edu.ifs.modelo.Candidato;

@WebServlet("/CadastrarCandidato.do")
public class CadastrarCandidato extends HttpServlet{
	private static final long serialVersionUTD = 1L;
	
	public CadastrarCandidato() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nome = request.getParameter("nome");
		String Email = request.getParameter("email");
		String Senha = request.getParameter("senha");
		String Cpf = request.getParameter("cpf");
		String Formacao_academica = request.getParameter("formacao_academica");
		String Experiencia_prof = request.getParameter("experiencia_prof");
		String senha = request.getParameter("senha");
		String Aperfeicoamento = request.getParameter("aperfeicoamento");
		String Telefone = request.getParameter("telefone");
		
		
		try {
			
			Candidato candidato = new Candidato(Nome, Cpf, Senha, Formacao_academica, Experiencia_prof, Aperfeicoamento, Telefone, Email);
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			ICandidatoDAO candidatoDao = new CandidatoDAOPostgres(fabrica.obterConexao());
			int id = candidatoDao.criar(candidato);
			
			response.sendRedirect("candidato/ExibirPerfil.jsp?id="+id);
			
		} catch(SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
			
		} catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");

		}
				
	}
	
}
