package com.albino.visao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.albino.controle.GerenteLivrosController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LivroVisaoAdicionar extends JFrame {
    private JLabel labelCodigo;
    private JLabel labelNome;
    private JLabel labelAno;
    private JTextField fieldCodigo;
    private JTextField fieldNome;
    private JTextField fieldAno;
    private JButton buttonAdicionar;
    private JButton buttonLimpar;
    private JButton buttonFechar;

    public LivroVisaoAdicionar(){
        
        setLayout(new FlowLayout());

        labelAno = new JLabel("Ano:");
        labelCodigo = new JLabel("Codigo:");
        labelNome = new JLabel("Nome:");

        fieldAno = new JTextField(15);
        fieldCodigo = new JTextField(15);
        fieldNome = new JTextField(15);

        buttonAdicionar = new JButton("Adicionar");
        buttonFechar = new JButton("Fechar");
        buttonLimpar = new JButton("Limpar");

        ButtonHandler handler =  new ButtonHandler();

        buttonAdicionar.addActionListener(handler);
        buttonFechar.addActionListener(handler);
        buttonLimpar.addActionListener(handler);

        add(labelCodigo);
        add(fieldCodigo);
        add(labelNome);
        add(fieldNome);
        add(labelAno);
        add(fieldAno);

        add(buttonAdicionar);
        add(buttonLimpar);
        add(buttonFechar);
    }
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==buttonFechar) fecharJanela();

            else if (e.getSource()==buttonLimpar) limparCampos();

            else if(e.getSource()==buttonAdicionar) adicionarLivro();
        }

    }
    private void fecharJanela(){
        fieldAno.setText("");
        fieldNome.setText("");
        fieldCodigo.setText("");
        this.dispose();
    }
    private void limparCampos(){
        fieldCodigo.setText("");
        fieldNome.setText("");
        fieldAno.setText("");
    }

    private void adicionarLivro(){
        String nome =  fieldNome.getText();
		int codigo  =  Integer.parseInt( fieldCodigo.getText());
		String ano = fieldAno.getText();

		if(!GerenteLivrosController.INSTANCE.procuraCodigo(codigo)){
			GerenteLivrosController.INSTANCE.adicionaLivro(codigo, nome, ano);
			JOptionPane.showMessageDialog(this, "Item Adicionado");
		}
		else JOptionPane.showMessageDialog(this, "Já ha um item com este codigo");
    }
}
