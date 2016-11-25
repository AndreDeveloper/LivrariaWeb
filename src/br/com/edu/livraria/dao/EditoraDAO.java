package br.com.edu.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.livraria.entity.Editora;



public class EditoraDAO {
	
	public long insert(Editora editora) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Editora` (`Nome`, `Logradouro`, `Numero`, `Complemento`, `Bairro`, `Cidade`, `UF`, `Telefone`, `CNPJ`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, editora.getNome());
			stmt.setString(2, editora.getLograd());
			stmt.setString(3, editora.getNum());
			stmt.setString(4, editora.getCompl());
			stmt.setString(5, editora.getBairro());
			stmt.setString(6, editora.getCidade());
			stmt.setString(7, editora.getUf());
			stmt.setString(8, editora.getTel());
			stmt.setInt(9, editora.getCNPJ());

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
	
	
	
	public int update(Editora editora) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `Editora` SET `Nome`=?, `Logradouro`=?, `Numero`=?,  `Complemento`=?, `Bairro`=?, `Cidade`=?, `UF`=?, `Telefone`=?, `CNPJ`=?   WHERE  `CodEditora`=?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, editora.getNome());
			stmt.setString(2, editora.getLograd());
			stmt.setString(3, editora.getNum());
			stmt.setString(4, editora.getCompl());
			stmt.setString(5, editora.getBairro());
			stmt.setString(6, editora.getCidade());
			stmt.setString(7, editora.getUf());
			stmt.setString(8, editora.getTel());
			stmt.setInt(9, editora.getCNPJ());
			
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

			String query = "DELETE FROM Editora WHERE CodEditora = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	public List<Editora> selectAll(){
		List<Editora> lista = new ArrayList<Editora>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Editora";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Editora editora = new Editora();
				
				editora.setId(rs.getLong("CodEditora"));
				editora.setNome(rs.getString("Nome"));
				
				lista.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Editora> selectByName(String name){
		List<Editora> lista = new ArrayList<Editora>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Editora WHERE Nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Editora editora = new Editora();
				
				editora.setId(rs.getLong("CodEditora"));
				editora.setNome(rs.getString("Nome"));
				
				lista.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
