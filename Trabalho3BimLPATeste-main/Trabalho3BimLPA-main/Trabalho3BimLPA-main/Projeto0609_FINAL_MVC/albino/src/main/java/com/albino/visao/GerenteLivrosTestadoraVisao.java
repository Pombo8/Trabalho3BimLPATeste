package com.albino.visao;

import javax.swing.JFrame;

public class GerenteLivrosTestadoraVisao {
	public static void main(String[] args) {

		LivroVisao g = new LivroVisao();
		g.setVisible(true);
		g.setResizable(false);
		g.setSize(500,150);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setLocationRelativeTo(null);
	}

}
