package br.com.edu.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;



public class CategoriaDAO {
	
	public long insert(int id, String categoria) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Categoria` (`CodCategoria`,`Nome`) VALUES (?,?);";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, id);
			stmt.setString(2, categoria);

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
	
	
	
	public int update(String categoria) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `Autor` SET `Nome`=?, WHERE  `CodAutor`=?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, categoria);
			
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

			String query = "DELETE FROM Categoria WHERE CodCategoria = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	public List<String> selectAll() {
		List<String> books = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Categoria;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				books.add(rs.getString("Nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

}
