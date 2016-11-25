package br.com.edu.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.livraria.entity.Autor;


public class AutorDAO {
	
	public long insert(Autor autor) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Autor` (`Nome`, `DataNascimento`, `DataFalescimento`, `LocalNascimento`, `LocalMorte`, `Biografia`) VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, autor.getNomeAutor());
			stmt.setDate(2, new Date(autor.getDataNasc().getTime()));
			stmt.setDate(3, new Date(autor.getDataFalesc().getTime()));
			stmt.setString(4, autor.getLocalNascimento());
			stmt.setString(5, autor.getLocalMorte());
			stmt.setString(6, autor.getBiografia());

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			idGerado = r.getLong(1);

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idGerado;
	}
	
	
	
	public int update(Autor autor) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `Autor` SET `Nome`=?, `DataNascimento`=?,  `DataFalescimento`=?, `LocalNascimento`=?, `LocalMorte`=?, `Biografia`=? WHERE  `CodAutor`=?;";

			
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, autor.getNomeAutor());
			stmt.setDate(2, new Date(autor.getDataNasc().getTime()));
			stmt.setDate(3, new Date(autor.getDataFalesc().getTime()));
			stmt.setString(4, autor.getLocalNascimento());
			stmt.setString(5, autor.getLocalMorte());
			stmt.setString(6, autor.getBiografia());

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	public int delete(long id) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM Autor WHERE CodAutor = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	public List<Autor> selectAll(){
		List<Autor> lista = new ArrayList<Autor>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Autor";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Autor autor = new Autor();
				
				autor.setId(rs.getLong("CodAutor"));
				autor.setNomeAutor(rs.getString("Nome"));
				
				lista.add(autor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Autor> selectByName(String name){
		List<Autor> lista = new ArrayList<Autor>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Autor WHERE Nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1,"%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Autor autor = new Autor();
				
				autor.setId(rs.getLong("CodAutor"));
				autor.setNomeAutor(rs.getString("Nome"));
				
				lista.add(autor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
