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

/**
 * Servlet implementation class AlterarUsuario
 */
@WebServlet("/AlterarPerfil.do")
public class AlterarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @param Id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
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
			
			Candidato candidato = new Candidato();
			candidato.setId(Integer.parseInt(Id));
			candidato.setNome(Nome);
			candidato.setEmail(Email);
			candidato.setSenha(Senha);
			candidato.setCpf(Cpf);
			candidato.setAperfeicoamento(Aperfeicoamento);
			candidato.setExperiencia_prof(Experiencia_prof);
			candidato.setFormacao_academica(Formacao_academica);
			candidato.setTelefone(Telefone);
			
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			ICandidatoDAO candidatoDao = new CandidatoDAOPostgres(fabrica.obterConexao());
			candidatoDao.atualizar(candidato);	
			
			response.sendRedirect("candidato/ExibirPerfil.jsp");
			
		} catch(SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
			
		} catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");

		}
	}

}
