package com.albino.visao;
import com.albino.controle.GerenteLivrosController;

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
    private JButton buttonLimpar;
    private JButton buttonFechar;
    private JButton buttonAlterar;
    private JButton buttonBuscar;
    

    public LivroVisaoAlterar(){
        initComponents();
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
            
            if(e.getSource()==buttonFechar) fechaJanela();

            else if(e.getSource()==buttonLimpar) limpaAcao();

            else if(e.getSource()==buttonBuscar) buscaAcao();

            else if(e.getSource()==buttonAlterar) alterarAcao();
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
        if(GerenteLivrosController.INSTANCE.procuraCodigo(codigo)){
            int input = JOptionPane.showConfirmDialog(this, "Excluir o item ?","Confirme", JOptionPane.OK_CANCEL_OPTION);
            if(input==0){
                GerenteLivrosController.INSTANCE.alterarLivro(codigo, nome, ano);
                JOptionPane.showMessageDialog(this, "Item alterado com sucesso");
            }
            else{
                JOptionPane.showMessageDialog(this, "Alteracao cancelada");
            }
            
        }
        else JOptionPane.showMessageDialog(this, "Nao ha item com este codigo");
    }
    private void initComponents() {
        ButtonHandler handler = new ButtonHandler();
        labelTitulo = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldCodigo = new javax.swing.JTextField();
        fieldAno = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitulo.setText("Biblioteca - Alterar");

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigo.setText("Codigo");

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNome.setText("Nome");

        labelAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelAno.setText("Ano");



        buttonBuscar.setText("BUSCAR");
        buttonBuscar.addActionListener(handler);


        buttonAlterar.setText("ALTERAR");
        buttonAlterar.addActionListener(handler);

        buttonFechar.setText("FECHAR");
        buttonFechar.addActionListener(handler);

        buttonLimpar.setText("LIMPAR");
        buttonLimpar.addActionListener(handler);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldCodigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldAno))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldNome))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(143, Short.MAX_VALUE)
                        .addComponent(labelTitulo)
                        .addGap(25, 25, 25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscar)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(buttonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLimpar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>   
}
