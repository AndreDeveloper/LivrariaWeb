package br.com.edu.livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.livraria.entity.Livro;

public class PesquisaDAO {
	
	public List<Livro> perquisarLivro(String tituloLivro, String autorLivro, Double precoLivro) {
		String query = "SELECT (`Titulo`,`PrecoVenda`,`CodAutor`) FROM `Livro` WHERE  like ?";
		List<Livro> lista = new ArrayList<Livro>();
		try {
			Connection con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,  "%" + tituloLivro + "%" );
			stmt.setString(2,  "%" + autorLivro + "%" );
			//stmt.setDouble(3,  "%" + precoLivro + "%" );
			ResultSet rs  = stmt.executeQuery();
			while( rs.next() ) { 
				Livro l = new Livro();
				l.setTituloLivro(rs.getString("tituloLivro"));
				l.setNomeAutor(rs.getString("nomeAutor"));
				l.setPrecoVenda(rs.getDouble("precoLivro"));
				lista.add( l );
			}
		} catch (SQLException e) {
//			throw new Exception( e );
		}
		return lista;
	}

	
	public List<Livro> perquisarLivro(String tituloLivro) {
		String query = "SELECT * FROM `Livro` WHERE Titulo like ?";
		List<Livro> lista = new ArrayList<Livro>();
		try {
			Connection con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,  "%" + tituloLivro + "%" );
			//stmt.setDouble(3,  "%" + precoLivro + "%" );
			ResultSet rs  = stmt.executeQuery();
			while( rs.next() ) { 
				Livro l = new Livro();
				l.setTituloLivro(rs.getString("tituloLivro"));
				l.setNomeAutor(rs.getString("nomeAutor"));
				l.setPrecoVenda(rs.getDouble("precoLivro"));
				lista.add( l );
			}
		} catch (SQLException e) {
//			throw new Exception( e );
		}
		return lista;
	}
}

