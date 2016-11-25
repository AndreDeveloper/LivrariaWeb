package br.com.edu.livraria.entity;



import java.io.Serializable;

import javax.swing.ImageIcon;

public class ItemCarrinho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3129022962517909840L;
	private ImageIcon imagem;
	private Livro livro;
	private int quantidade;
	private double subTotal;
	
	
	

	public ImageIcon getImagem() {
		return imagem;
	}
	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
		this.subTotal = livro.getPrecoVenda() * this.quantidade;
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.subTotal = livro.getPrecoVenda() * quantidade;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "ItemCarrinhoEntity [imagem=" + imagem + ", livro=" + livro.getTituloLivro() + 
				", quantidade=" + quantidade
				+ ", subTotal=" + subTotal + "]";
	}
	
	
}
