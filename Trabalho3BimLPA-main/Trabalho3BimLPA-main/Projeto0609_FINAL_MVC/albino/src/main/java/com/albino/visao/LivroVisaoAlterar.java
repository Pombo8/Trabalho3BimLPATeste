package com.albino.visao;
import com.albino.controle.GerenteLivrosController;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroVisaoAlterar extends JFrame {
    private JLabel labelCodigo;
    private JLabel labelNome;
    private JLabel labelAno;
    private JLabel labelTitulo;
    private JTextField fieldAno;
    private JTextField fieldCodigo;
    private JTextField fieldNome;
    private JButton buttonLimpa;
    private JButton buttonFecha;
    private JButton buttonAltera;
    private JButton buttonBusca;
    

    public LivroVisaoAlterar(){
        
        setLayout(new FlowLayout());
        ButtonHandler handler = new ButtonHandler();
        
        labelCodigo = new JLabel("Codigo:");
        labelAno = new JLabel("Ano:");
        labelNome = new JLabel("Nome:");
        labelTitulo = new JLabel("VALORES");

        fieldAno = new JTextField(20);
        fieldCodigo = new JTextField(15);
        fieldNome = new JTextField(20);

        buttonFecha = new JButton("Fechar");
        buttonAltera = new JButton("Alterar");
        buttonBusca = new JButton("Buscar");
        buttonLimpa = new JButton("Limpa");

        buttonFecha.addActionListener(handler);
        buttonAltera.addActionListener(handler);
        buttonBusca.addActionListener(handler);
        buttonLimpa.addActionListener(handler);


        add(labelCodigo);
        add(fieldCodigo);
        add(buttonBusca);
        add(labelTitulo);
        add(labelNome);
        add(fieldNome);
        add(labelAno);
        add(fieldAno);
        add(buttonAltera);
        add(buttonFecha);
        add(buttonLimpa);

    }
    private void fechaJanela(){
        fieldAno.setText("");
        fieldNome.setText("");
        fieldCodigo.setText("");

        this.dispose();
    }
    private void limpaAcao(){
        fieldAno.setText("");
        fieldNome.setText("");
        fieldCodigo.setText("");
    }
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==buttonFecha) fechaJanela();

            else if(e.getSource()==buttonLimpa) limpaAcao();

            else if(e.getSource()==buttonBusca) buscaAcao();

            else if(e.getSource()==buttonAltera) alterarAcao();
        }

    }
    private void buscaAcao(){
        int codigo = Integer.parseInt( fieldCodigo.getText());
        if(GerenteLivrosController.INSTANCE.procuraCodigo(codigo)){
            fieldNome.setText(GerenteLivrosController.INSTANCE.getNome(codigo));
            fieldAno.setText(GerenteLivrosController.INSTANCE.getAno(codigo));
        }
        else {
            JOptionPane.showMessageDialog(this,"Nao ha Livro com este codigo, Selecione outro");
            fieldAno.setText("");
            fieldNome.setText("");
        }
    }
    private void alterarAcao(){
        int codigo = Integer.parseInt(fieldCodigo.getText().trim());
        String nome = fieldNome.getText().trim();
        String ano = fieldAno.getText().trim();
        if(GerenteLivrosController.INSTANCE.alterarLivro(codigo,nome,ano)){
            JOptionPane.showMessageDialog(this, "Item alterado com sucesso");
        }
        else JOptionPane.showMessageDialog(this, "Nao ha item com este codigo");
    }
}
