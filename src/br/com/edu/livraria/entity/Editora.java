package br.com.edu.livraria.entity;

import java.io.Serializable;

public class Editora implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7897949347491217870L;
	private long id;
	private String nome;
	private String lograd;
	private String num;
	private String compl;
	private String bairro;
	private String cidade;
	private String uf;
	private String tel;
	private int CNPJ;
	
	
	public Editora(long id, String nome, String lograd, String num, String compl, String bairro, String cidade,
			String uf, String tel, int cNPJ) {
		super();
		this.id = id;
		this.nome = nome;
		this.lograd = lograd;
		this.num = num;
		this.compl = compl;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.tel = tel;
		CNPJ = cNPJ;
	}
	public Editora() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLograd() {
		return lograd;
	}
	public void setLograd(String lograd) {
		this.lograd = lograd;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCompl() {
		return compl;
	}
	public void setCompl(String compl) {
		this.compl = compl;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	
	

}
