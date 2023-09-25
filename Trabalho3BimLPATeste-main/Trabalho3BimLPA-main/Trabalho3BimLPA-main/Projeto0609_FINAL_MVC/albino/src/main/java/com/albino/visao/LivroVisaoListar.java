package com.albino.visao;

import com.albino.controle.GerenteLivrosController;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroVisaoListar extends JFrame {
    private JButton buttonFechar;
    private JButton buttonListar;
    private JButton buttonLimpar;
    private JTextArea textArea;
    
    public LivroVisaoListar(){
        setLayout(new FlowLayout());
        ButtonHandler handler = new ButtonHandler();

        textArea = new JTextArea(20,40);
        buttonFechar = new JButton("Fechar");
        buttonLimpar = new JButton("Limpar");
        buttonListar = new JButton("Listar");

        buttonFechar.addActionListener(handler);
        buttonLimpar.addActionListener(handler);
        buttonListar.addActionListener(handler);

       
        add(textArea);
        add(buttonListar);
        add(buttonLimpar);
        add(buttonFechar);
    }

    private void fecharJanela(){
        textArea.setText("");      
        this.dispose();
    }
    private void limparCampo(){
        textArea.setText("");
    }
    private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonFechar) fecharJanela();
            
            else if(e.getSource()==buttonLimpar) limparCampo();

            else if(e.getSource()==buttonListar) listarLivros();
			
		}

	}
    private void listarLivros(){
        String valores = GerenteLivrosController.INSTANCE.listaLivro();
        textArea.setText(valores);
    }
}
