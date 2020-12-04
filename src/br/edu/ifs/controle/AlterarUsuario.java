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

/**
 * Servlet implementation class AlterarUsuario
 */
@WebServlet("/AlterarUsuario.do")
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarUsuario() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String Nome = request.getParameter("nome");
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		
		
		
		try {
			
			Candidato candidato = new Candidato();
			candidato.setId(Integer.parseInt(Id));
			candidato.setNome(Nome);
			candidato.setLogin(Login);
			candidato.setSenha(Senha);
			
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			IUsuarioDAO usuarioDao = new UsuarioDAOPostgres(fabrica.obterConexao());
			usuarioDao.atualizar(candidato);	
			
			response.sendRedirect("usuario/ListarUsuario.jsp");
			
		} catch(SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
			
		} catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");

		}
	}

}
