package br.com.edu.livraria.entity;

import java.io.Serializable;
import java.util.Date;

public class Autor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6280773660168205595L;
	private long id;
	private String nomeAutor;
	private Date dataNasc;
	private Date dataFalesc;
	private String localNascimento;
	private String localMorte;
	private String biografia;
	
	
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Autor(long id, String nomeAutor, Date dataNasc, Date dataFalesc, String localNascimento, String localMorte,
			String biografia) {
		super();
		this.id = id;
		this.nomeAutor = nomeAutor;
		this.dataNasc = dataNasc;
		this.dataFalesc = dataFalesc;
		this.localNascimento = localNascimento;
		this.localMorte = localMorte;
		this.biografia = biografia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Date getDataFalesc() {
		return dataFalesc;
	}
	public void setDataFalesc(Date dataFalesc) {
		this.dataFalesc = dataFalesc;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getLocalMorte() {
		return localMorte;
	}
	public void setLocalMorte(String localMorte) {
		this.localMorte = localMorte;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	

}
