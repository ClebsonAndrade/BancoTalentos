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
import br.edu.ifs.dao.IUsuarioDAO;
import br.edu.ifs.dao.UsuarioDAOPostgres;
import br.edu.ifs.modelo.Candidato;

@WebServlet("/CadastrarUsuario.do")
public class CadastrarUsuario extends HttpServlet{
	private static final long serialVersionUTD = 1L;
	
	public CadastrarUsuario() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nome = request.getParameter("nome");
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		
		try {
			
			Candidato candidato = new Candidato(Nome, Login, Senha);
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			IUsuarioDAO usuarioDao = new UsuarioDAOPostgres(fabrica.obterConexao());
			int id = usuarioDao.criar(candidato);
			
			response.sendRedirect("usuario/ExibirUsuario.jsp?id="+id);
			
		} catch(SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
			
		} catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");

		}
				
	}
	
}
