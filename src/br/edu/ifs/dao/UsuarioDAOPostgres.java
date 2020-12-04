package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.modelo.Candidato;

public class UsuarioDAOPostgres implements IUsuarioDAO {

	private Connection conexao;
	
	public UsuarioDAOPostgres(Connection pConexao) {
		this.conexao = pConexao;
	}
	
	@Override
	public int criar(Candidato candidato) throws SQLException {
		String sql = "INSERT INTO tb_usuario (nome, login, senha) VALUES (?, ?, MD5(?))";
		int id = 0;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getLogin());
			stmt.setString(3, candidato.getSenha());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('tb_usuario', 'id')) AS id";
			stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
			
			return id;
		} catch(SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	@Override
	public Candidato recuperar(int id) throws Exception, SQLException {
		String sql = "SELECT * FROM tb_usuario WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Candidato candidato = new Candidato(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
				
				return candidato;
			} else {
				throw new Exception("O ID do usu�rio n�o existe");
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	@Override
	public boolean atualizar(Candidato candidato) throws SQLException {
		String sql = "UPDATE tb_usuario SET nome=?, login=?, senha=MD5(?) WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getLogin());
			stmt.setString(3, candidato.getSenha());
			stmt.setInt(4, candidato.getId());
			stmt.executeUpdate(); 
			
			
		
			return true ;
		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	@Override
	public boolean excluir(Candidato candidato) throws SQLException {
		String sql = "DELETE FROM tb_usuario WHERE id = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, candidato.getId());
			stmt.execute(); 
			
			
		
			return true ;
		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	
	
	
	@Override
	public Candidato buscarPorLogin(String login) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> listar() throws SQLException {
		String sql = "SELECT id, nome, login, senha FROM tb_usuario ORDER BY id";
		List<Candidato> listaUsuarios = new ArrayList<Candidato>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(); 
			
			
			while(rs.next()) {
				
				Candidato candidato = new Candidato(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("login"),
						rs.getString("senha")
				);
				
				listaUsuarios.add(candidato);
			}
			
		
			return listaUsuarios;
		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	@Override
	public Candidato autenticar(String login, String senha) throws SQLException {
		String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = MD5(?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Candidato candidato = new Candidato(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
				return candidato;
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
		
		
	}

	@Override
	public List<Candidato> listar(int linhas, int paginas) throws SQLException {
		String sql = "SELECT id, nome, login, senha FROM tb_usuario ORDER BY id LIMIT ? OFFSET ?";
		List<Candidato> listaUsuarios = new ArrayList<Candidato>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, linhas);
			stmt.setInt(2, (paginas*linhas-linhas));
			ResultSet rs = stmt.executeQuery(); 
			
			
			while(rs.next()) {
				
				Candidato candidato = new Candidato(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("login"),
						rs.getString("senha")
				);
				
				listaUsuarios.add(candidato);
			}
			
		
			return listaUsuarios;
		} catch (SQLException e) {
			throw e;
		} finally {
			conexao.close();
		}
	}

	@Override
	public int recuperarTotalUsuarios() throws SQLException {
		String sql = "SELECT COUNT(*) as TotalUsuarios FROM tb_usuario";
		int totalUsuarios = 0;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				totalUsuarios = rs.getInt("totalUsuarios");
			}
			
			return totalUsuarios;

		} catch (SQLException e) {
			throw e;
		} 
	}

}

	
