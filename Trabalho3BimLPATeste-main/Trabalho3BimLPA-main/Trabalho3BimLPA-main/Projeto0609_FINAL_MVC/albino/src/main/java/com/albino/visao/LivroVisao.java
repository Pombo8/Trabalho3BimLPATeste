package com.albino.visao;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.albino.controle.GerenteLivrosController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LivroVisao extends JFrame {
	private LivroVisaoAlterar alterar = new LivroVisaoAlterar();
	private LivroVisaoListar mostrar = new LivroVisaoListar();
	private LivroVisaoAdicionar adicionar = new LivroVisaoAdicionar();
	private LivroVisaoExcluir excluir = new LivroVisaoExcluir();
	private LivroVisaoBuscar buscar = new LivroVisaoBuscar();

	private JButton buttonAdd;
	private JButton buttonLista;
	private JButton buttonAlterar;
	private JButton buttonFechar;
	private JButton buttonBuscar;
	private JButton buttonExcluir;

	public LivroVisao(){
		super("Biblioteca Virtual");
		setLayout(new FlowLayout());
		ButtonHandler handler = new ButtonHandler();

		buttonAdd = new JButton("Adicionar");
		buttonLista = new JButton("Listar");
		buttonAlterar = new JButton("Alterar");
		buttonFechar = new JButton("Fechar");
		buttonBuscar = new JButton("Buscar");
		buttonExcluir = new JButton("Excluir");

		buttonAdd.addActionListener(handler);
		buttonLista.addActionListener(handler);
		buttonAlterar.addActionListener(handler);
		buttonFechar.addActionListener(handler);
		buttonExcluir.addActionListener(handler);
		buttonBuscar.addActionListener(handler);

		
		add(buttonAdd);
		add(buttonLista);
		add(buttonAlterar);
		add(buttonBuscar);
		add(buttonExcluir);

		add(buttonFechar);
		GerenteLivrosController.INSTANCE.cargaInicial();
		
	}
	
	
	private void eventoMostrar(String nomeBotao){
		/*String valores = controller.listaLivro();
		JOptionPane.showMessageDialog(this, String.format(valores));	*/
		mostrar.setVisible(true);
		mostrar.setResizable(false);
		mostrar.setSize(500,500);
		mostrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mostrar.setLocationRelativeTo(null);
	}

	
	
	private void adicionarLivro(){
		
		adicionar.setVisible(true);
		adicionar.setResizable(false);
		adicionar.setSize(500,500);
		adicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adicionar.setLocationRelativeTo(null);
	
	}
	private void eventoAlterar(){

		alterar.setVisible(true);
		alterar.setResizable(false);
		alterar.setSize(500,500);
		alterar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alterar.setLocationRelativeTo(null);
		
		
	}

	private void eventoFechar(){
		this.dispose();
	}
	private void eventoExcluir(){
		excluir.setVisible(true);
		excluir.setResizable(false);
		excluir.setSize(700,500);
		excluir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		excluir.setLocationRelativeTo(null);
	}
	private void eventoBuscar(){
		buscar.setVisible(true);
		buscar.setResizable(false);
		buscar.setSize(650,700);
		buscar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buscar.setLocationRelativeTo(null);
	}

	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonAdd) adicionarLivro();

			else if (e.getSource()==buttonLista) eventoMostrar(e.getActionCommand());

			else if(e.getSource()==buttonAlterar) eventoAlterar();

			else if(e.getSource()==buttonExcluir) eventoExcluir();

			else if(e.getSource()==buttonFechar) eventoFechar();
			
			else if(e.getSource()==buttonBuscar) eventoBuscar();

			
			
		}

	}

}
