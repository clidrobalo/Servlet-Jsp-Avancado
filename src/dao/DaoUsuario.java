package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.UsuarioBean;
import connection.SingleConnection;


public class DaoUsuario {

private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void gravarImagem(String imagemStr, Long id) {
		System.out.println("Imagem: " + imagemStr);
		System.out.println("Id: " + id);
		String query = "UPDATE usuario set imagem = ? where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, imagemStr);
			statement.setLong(2, id);
			
			statement.executeUpdate();
			// Salvar no banco de dados
			connection.commit();
			System.out.println("Imagem gravada com sucesso.");
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UsuarioBean getUser(String login) {
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();

		String query = "SELECT * FROM usuario where login = ?";

		try {
			PreparedStatement select = connection.prepareStatement(query);
			select.setString(1, login);
			ResultSet resultado = select.executeQuery();

			UsuarioBean usuario = new UsuarioBean();
			while (resultado.next()) {
				usuario.setId(Long.parseLong(resultado.getString("id")));
				usuario.setUser(resultado.getString("login"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTelefone(resultado.getString("telefone"));
				usuario.setCep(resultado.getString("cep"));
				usuario.setRua(resultado.getString("rua"));
				usuario.setBairro(resultado.getString("bairro"));
				usuario.setCidade(resultado.getString("cidade"));
				usuario.setUf(resultado.getString("uf"));
				usuario.setIbge(resultado.getString("ibge"));
				usuario.setSenha(resultado.getString("senha"));
				//bean.setFotoBase64(resultado.getString("fotobase64"));
				usuario.setContentType(resultado.getString("contenttype"));
				usuario.setCurriculo(resultado.getString("curriculo"));
				usuario.setContentTypeCurriculo("contenttypecurriculo");
				usuario.setMiniaturaBase64("miniaturabase64");
				usuario.setImagem(resultado.getString("imagem"));
			}

			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List<UsuarioBean> getUsers() {
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();

		String query = "SELECT * FROM usuario";

		try {
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet resultado = select.executeQuery();

			while (resultado.next()) {
				UsuarioBean usuario = new UsuarioBean();
				usuario.setId(Long.parseLong(resultado.getString("id")));
				usuario.setUser(resultado.getString("login"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTelefone(resultado.getString("telefone"));
				usuario.setCep(resultado.getString("cep"));
				usuario.setRua(resultado.getString("rua"));
				usuario.setBairro(resultado.getString("bairro"));
				usuario.setCidade(resultado.getString("cidade"));
				usuario.setUf(resultado.getString("uf"));
				usuario.setIbge(resultado.getString("ibge"));
				usuario.setSenha(resultado.getString("senha"));
				//bean.setFotoBase64(resultado.getString("fotobase64"));
				usuario.setContentType(resultado.getString("contenttype"));
				usuario.setCurriculo(resultado.getString("curriculo"));
				usuario.setContentTypeCurriculo("contenttypecurriculo");
				usuario.setMiniaturaBase64("miniaturabase64");
				usuario.setImagem(resultado.getString("imagem"));
				lista.add(usuario);
			}

			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<String> getImages() {
		List<String> imagens = new ArrayList<String>();

		String query = "SELECT imagem FROM usuario where imagem IS NOT NULL";

		try {
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet resultado = select.executeQuery();

			while (resultado.next()) {
				String imagem = (resultado.getString("imagem"));
				imagens.add(imagem);
			}

			return imagens;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imagens;
	}
	
	
	public void delete(Long id) {
		String query = "DELETE FROM usuario WHERE id = ?"; 
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public UsuarioBean consultar(Long id) {
		String query = "SELECT * FROM usuario WHERE id = ?";
		
		UsuarioBean usuario = new UsuarioBean();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				usuario.setId(Long.parseLong(result.getString("id")));
				usuario.setUser(result.getString("login"));
				usuario.setNome(result.getString("nome"));
				usuario.setTelefone(result.getString("telefone"));
				usuario.setCep(result.getString("cep"));
				usuario.setRua(result.getString("rua"));
				usuario.setBairro(result.getString("bairro"));
				usuario.setCidade(result.getString("cidade"));
				usuario.setUf(result.getString("uf"));
				usuario.setIbge(result.getString("ibge"));
				usuario.setSenha(result.getString("senha"));
				usuario.setFotoBase64(result.getString("fotobase64"));
				usuario.setContentType(result.getString("contenttype"));
				usuario.setCurriculo(result.getString("curriculo"));
				usuario.setContentTypeCurriculo(result.getString("contenttypecurriculo"));
				usuario.setMiniaturaBase64(result.getString("miniaturabase64"));
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public boolean userExiste(String login) {
		String query = "SELECT * FROM usuario WHERE login = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, login);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
