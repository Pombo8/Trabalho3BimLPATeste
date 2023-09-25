package com.albino.modelo;

public class LivroVO {

	private int codigo;
	private String nome;
	private String ano;
	
	//Construtor com prontuario

	public LivroVO(int codigo, String nome, String ano) {
		this.codigo = codigo;
		this.ano = ano;
		this.nome = nome;

	}

	public int getCodigo() {
		return codigo;
	}

	
	public String getNome() {
		return nome;
	}
	public String getAno(){
		return ano;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAno(String ano){
		this.ano=ano;
	}

	
}

