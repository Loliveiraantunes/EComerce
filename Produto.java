package me.leo;

public class Produto {

	String nome ="";
	double preco = 0;
	String categorias = "";
	
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public String getCategorias() {
		return categorias;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	
}
