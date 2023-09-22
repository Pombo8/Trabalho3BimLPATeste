package com.albino.controle;

import java.util.Scanner;
import com.albino.modelo.LivroModelo;

public enum GerenteLivrosController {
	INSTANCE;
	LivroModelo a = new LivroModelo();

    public void adicionaLivro(int codigo,String nome, String ano){
		a.adicionaLivro(codigo, nome, ano);
	}
	public String listaLivro(){
		String valores= a.listarLivro();
		return valores;
		
	}
	public  boolean procuraCodigo(int codigo){
		return a.procuraCodigo(codigo);
	}
	public String getNome(int codigo){
		return a.getNome(codigo);
	}
	public String getAno(int codigo){
		return a.getAno(codigo);
	}
	public void cargaInicial(){
		a.cargaInicial();
	}		
}
