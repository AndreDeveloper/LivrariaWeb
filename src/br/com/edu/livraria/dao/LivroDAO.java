package br.com.edu.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.livraria.entity.Livro;
import br.com.edu.livraria.utils.ImagemFormater;


public class LivroDAO {
	
	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	public long insert(Livro livro) throws SQLException{
		long idGerado = -1;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Livro` "
					+ "(`CodAutor`,"
					+ " `CodCategoria`,"
					+ " `CodEditora`,"
					+ " `DataPublicacao`, "
					+ "`Formato`,"
					+ " `ISBN`,"
					+ " `MargemLucro`,"
					+ " `NumeroPaginas`,"
					+ " `PrecoCusto`,"
					+ " `PrecoVenda`,"
					+ " `QtdeEmEstoque`,"
					+ " `Resumo`,"
					+ " `Sumario`,"
					+ " `Titulo`,"
					+ " `Imagem`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, livro.getIdAutor());
			stmt.setInt(2, livro.getIdCategoriaLivro());
			stmt.setInt(3, livro.getIdEditora());
			stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
			stmt.setInt(5, livro.getFormato() );
			stmt.setInt(6,livro.getIsbn());
			stmt.setDouble(7, livro.getMargemLucro());
			stmt.setInt(8,livro.getNumeroPaginas());
			stmt.setDouble(9,livro.getPrecoCusto());
			stmt.setDouble(10, livro.getPrecoVenda());
			stmt.setInt(11, livro.getQtdeEmEstoque());
			stmt.setString(12, livro.getResumo());
			stmt.setString(13,livro.getSumario());
			stmt.setString(14,livro.getTituloLivro());
			//stmt.setBytes(15, ImagemFormater.imagemParaByte(livro.getImagePath()));
					


			
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
	
	
	
	public int update(Livro livro) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE "
					+ "`Livro` SET "
					+ "`CodAutor`=?, "
					+ "`CodCategoria`=?,  "
					+ "`CodEditora`=?, "
					+ "`DataPublicacao`=?, "
					+ "`Formato`=?, "
					+ "`ISBN`=?, "
					+ "`MargemLucro`=?, "
					+ "`NumeroPaginas`=?, "
					+ "`PrecoCusto`=?, "
					+ "`PrecoVenda`=?, "
					+ "`QtdeEmEstoque`=?, "
					+ "`Resumo`=?, "
					+ "`Sumario`=?, "
					+ "`Titulo`=?, "
					+ "`Imagem`=? "
					+ "WHERE  `ISBN`=?;";

			
			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, livro.getIdAutor());
			stmt.setInt(2, livro.getIdCategoriaLivro());
			stmt.setInt(3, livro.getIdEditora());
			stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
			stmt.setInt(5, livro.getFormato() );
			stmt.setInt(6,livro.getIsbn());
			stmt.setDouble(7, livro.getMargemLucro());
			stmt.setInt(8,livro.getNumeroPaginas());
			stmt.setDouble(9,livro.getPrecoCusto());
			stmt.setDouble(10, livro.getPrecoVenda());
			stmt.setInt(11, livro.getQtdeEmEstoque());
			stmt.setString(12, livro.getResumo());
			stmt.setString(13,livro.getSumario());
			stmt.setString(14,livro.getTituloLivro());
			stmt.setBytes(15, livro.getImagem());
			stmt.setInt(16,livro.getIsbn());
			
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

			String query = "DELETE FROM Livro WHERE ISBN = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	public Livro selectById(long codLivro) {
		Livro livro = new Livro();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro WHERE CodLivro = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, codLivro);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				stmt.setInt(1, livro.getIdAutor());
				stmt.setInt(2, livro.getIdCategoriaLivro());
				stmt.setInt(3, livro.getIdEditora());
				stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
				stmt.setInt(5, livro.getFormato());
				stmt.setInt(6, livro.getIsbn());
				stmt.setDouble(7, livro.getMargemLucro());
				stmt.setInt(8, livro.getNumeroPaginas());
				stmt.setDouble(9, livro.getPrecoCusto());
				stmt.setDouble(10, livro.getPrecoVenda());
				stmt.setInt(11, livro.getQtdeEmEstoque());
				stmt.setString(12, livro.getResumo());
				stmt.setString(13, livro.getTituloLivro());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return livro;
	}
	
	public Livro selectByIsbn(int isbn) {
		Livro livro = new Livro();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "select * from Livro " +
					"left outer join Autor ON Autor.CodAutor = Livro.CodAutor " +
					"left outer join Editora ON Editora.CodEditora = Livro.CodEditora " +
					"left outer join Categoria ON Categoria.CodCategoria = Livro.CodCategoria " +
					"where Livro.ISBN = ? ";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, isbn);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
					livro.setIsbn(rs.getInt("ISBN"));
				    livro.setTituloLivro(rs.getString("Titulo"));
					livro.setIdAutor(rs.getInt("CodAutor"));
					livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
					livro.setIdEditora(rs.getInt("CodEditora"));
					livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
					livro.setResumo(rs.getString("Resumo"));
					livro.setSumario(rs.getString("Sumario"));
					livro.setFormato(rs.getInt("Formato"));
					livro.setDataPublicacao(rs.getDate("DataPublicacao"));
					livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
					livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
					livro.setMargemLucro(rs.getDouble("MargemLucro"));
					livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
					livro.setImagem(livro.getImagem());
					livro.setNomeAutor(rs.getString(18));
					livro.setEditora(rs.getString(25));
					livro.setCategoriaLivro(rs.getString(36));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return livro;
	}
	
	public List<Livro> selectToFormPesquisa(
			String autor, String titulo, String editora, int categoria) {
		List<Livro> books = new ArrayList<Livro>();
		int validaAutor = 2147483646;
		int validaTitulo = 2147483646;
		int validaEditora = 2147483646;
		int validaCategoria = 2147483646;
		if(autor.length()>0) validaAutor = 0; 
		if(titulo.length()>0) validaTitulo = 0;	
		if(editora.length()>0) validaEditora = 0;
		if(categoria != 0) validaCategoria = 0;
		
		
		try {
			Connection con = JDBCUtil.getConnection();

			
			String query = "select * from Livro "
					+ "inner join Autor on Livro.CodAutor = Autor.CodAutor " 
					+ "inner join Editora on Livro.CodEditora = Editora.CodEditora "
					+ "WHERE (((Titulo LIKE ? OR ISBN < ?)) AND "
					+ "((Autor.Nome LIKE ? OR ISBN < ?)) AND "
					+ "((Editora.Nome LIKE ? OR ISBN < ?)) AND "
					+ "((Livro.CodCategoria = ? OR ISBN < ?)));";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + titulo + "%");
			stmt.setInt(2, validaTitulo);
			stmt.setString(3, "%" + autor +"%"  );
			stmt.setInt(4, validaAutor);
			stmt.setString(5, "%" + editora  +"%" );
			stmt.setInt(6, validaEditora);
			stmt.setInt(7, categoria);
			stmt.setInt(8, validaCategoria);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				
				livro.setIsbn(rs.getInt("ISBN"));
			    livro.setTituloLivro(rs.getString("Titulo"));
				livro.setIdAutor(rs.getInt("CodAutor"));
				livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
				livro.setIdEditora(rs.getInt("CodEditora"));
				livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
				livro.setResumo(rs.getString("Resumo"));
				livro.setSumario(rs.getString("Sumario"));
				livro.setFormato(rs.getInt("Formato"));
				livro.setDataPublicacao(rs.getDate("DataPublicacao"));
				livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
				livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
				livro.setMargemLucro(rs.getDouble("MargemLucro"));
				livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
				livro.setImagem(livro.getImagem());
				livro.setNomeAutor(rs.getString(18));
				
				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}
	
	
	
	public List<Livro> selectByAutor(String name) {
		List<Livro> books = new ArrayList<Livro>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro WHERE CodAutor LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Livro livro = new Livro();
				
				livro.setIsbn(rs.getInt("ISBN"));
			    livro.setTituloLivro(rs.getString("Titulo"));
				livro.setIdAutor(rs.getInt("CodAutor"));
				livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
				livro.setIdEditora(rs.getInt("CodEditora"));
				livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
				livro.setResumo(rs.getString("Resumo"));
				livro.setSumario(rs.getString("Sumario"));
				livro.setFormato(rs.getInt("Formato"));
				livro.setDataPublicacao(rs.getDate("DataPublicacao"));
				livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
				livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
				livro.setMargemLucro(rs.getDouble("MargemLucro"));
				livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
				livro.setImagem(livro.getImagem());
				
				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}

	public List<Livro> selectByNome(String name) {
		List<Livro> books = new ArrayList<Livro>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String query = "SELECT * FROM Livro WHERE Titulo LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, "%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Livro livro = new Livro();
				
				livro.setIsbn(rs.getInt("ISBN"));
			    livro.setTituloLivro(rs.getString("Titulo"));
				livro.setIdAutor(rs.getInt("CodAutor"));
				livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
				livro.setIdEditora(rs.getInt("CodEditora"));
				livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
				livro.setResumo(rs.getString("Resumo"));
				livro.setSumario(rs.getString("Sumario"));
				livro.setFormato(rs.getInt("Formato"));
				livro.setDataPublicacao(rs.getDate("DataPublicacao"));
				livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
				livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
				livro.setMargemLucro(rs.getDouble("MargemLucro"));
				livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
				livro.setImagem(livro.getImagem());
				
				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	
	public List<Livro> selectAll() {
		List<Livro> books = new ArrayList<Livro>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "select * from Livro " +
					"left outer join Autor ON Autor.CodAutor = Livro.CodAutor " +
					"left outer join Editora ON Editora.CodEditora = Livro.CodEditora " +
					"left outer join Categoria ON Categoria.CodCategoria = Livro.CodCategoria ";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Livro livro = new Livro();
				
				livro.setIsbn(rs.getInt("ISBN"));
			    livro.setTituloLivro(rs.getString("Titulo"));
				livro.setIdAutor(rs.getInt("CodAutor"));
				livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
				livro.setIdEditora(rs.getInt("CodEditora"));
				livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
				livro.setResumo(rs.getString("Resumo"));
				livro.setSumario(rs.getString("Sumario"));
				livro.setFormato(rs.getInt("Formato"));
				livro.setDataPublicacao(rs.getDate("DataPublicacao"));
				livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
				livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
				livro.setMargemLucro(rs.getDouble("MargemLucro"));
				livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
				livro.setImagem(ImagemFormater.imagemParaByte(ImagemFormater.bytesParaImagem(rs.getBytes("imagem")))   );
				livro.setNomeAutor(rs.getString(18));
				livro.setEditora(rs.getString(25));
				livro.setCategoriaLivro(rs.getString(36));

				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	


}
