package br.com.edu.livraria.entity;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;

public class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2257449091950892927L;
	private int id;
	private int idAutor;
	private int idCategoriaLivro;
	private int idEditora;
	private String nomeAutor;
	private String categoriaLivro;
	private String editora;

	private int isbn;
	private String tituloLivro;
	private Date dataPublicacao;
	private int formato;
	private int numeroPaginas;
	private String sumario;
	private String resumo;
	private double precoCusto;
	private double precoVenda;
	private double margemLucro;
	private int qtdeEmEstoque;
	private byte[] imagem;
	
	public Livro(int id, int idAutor, int idCategoriaLivro, int idEditora, String nomeAutor, String categoriaLivro,
			String editora, int isbn, String tituloLivro, Date dataPublicacao, int formato, int numeroPaginas,
			String sumario, String resumo, double precoCusto, double precoVenda, double margemLucro, int qtdeEmEstoque,
			byte[] imagem) {
		super();
		this.id = id;
		this.idAutor = idAutor;
		this.idCategoriaLivro = idCategoriaLivro;
		this.idEditora = idEditora;
		this.nomeAutor = nomeAutor;
		this.categoriaLivro = categoriaLivro;
		this.editora = editora;
		this.isbn = isbn;
		this.tituloLivro = tituloLivro;
		this.dataPublicacao = dataPublicacao;
		this.formato = formato;
		this.numeroPaginas = numeroPaginas;
		this.sumario = sumario;
		this.resumo = resumo;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.margemLucro = margemLucro;
		this.qtdeEmEstoque = qtdeEmEstoque;
		this.imagem = imagem;
	}

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdCategoriaLivro() {
		return idCategoriaLivro;
	}

	public void setIdCategoriaLivro(int idCategoriaLivro) {
		this.idCategoriaLivro = idCategoriaLivro;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getCategoriaLivro() {
		return categoriaLivro;
	}

	public void setCategoriaLivro(String categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public int getQtdeEmEstoque() {
		return qtdeEmEstoque;
	}

	public void setQtdeEmEstoque(int qtdeEmEstoque) {
		this.qtdeEmEstoque = qtdeEmEstoque;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

}

		
