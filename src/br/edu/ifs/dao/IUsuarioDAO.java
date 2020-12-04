package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.modelo.Candidato;

public interface IUsuarioDAO {

	public int criar(Candidato candidato) throws SQLException;
	
	public Candidato recuperar(int id) throws Exception, SQLException;
	
	public boolean atualizar(Candidato candidato) throws SQLException;
	
	public boolean excluir(Candidato candidato) throws SQLException;
	
	
	public Candidato buscarPorLogin(String login) throws SQLException;
	
	public List<Candidato> listar() throws SQLException;
	
	public List<Candidato> listar(int linhas, int paginas) throws SQLException;
	
	public Candidato autenticar(String login, String senha) throws SQLException;

	public int recuperarTotalUsuarios() throws SQLException;
}
