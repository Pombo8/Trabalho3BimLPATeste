package com.albino.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.albino.controle.GerenteLivrosController;

public class LivroVisaoBuscar extends JFrame{
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonFechar;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration         

    public LivroVisaoBuscar(){
        initComponents();
    }
    
    private void initComponents() {
        ButtonHandler handler = new ButtonHandler();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        buttonBuscar = new javax.swing.JButton();
        fieldNome = new javax.swing.JTextField();
        buttonLimpar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        buttonBuscar.setText("BUSCAR");
        buttonBuscar.addActionListener(handler);

        buttonLimpar.setText("LIMPAR");
        buttonLimpar.addActionListener(handler);

        buttonFechar.setText("FECHAR");
        buttonFechar.addActionListener(handler);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(buttonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                    .addComponent(fieldNome))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold> 

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==buttonFechar) acaoFechar();
            else if(e.getSource()==buttonLimpar) acaoLimpar();
            else if (e.getSource()==buttonBuscar) acaoBuscar();
        }
        
    }
    private void acaoFechar(){
        textArea.setText("");
        this.dispose();
    }
    private void acaoLimpar(){
        textArea.setText("");
    }
    private void acaoBuscar(){
        String desc = fieldNome.getText().trim();
        String result = GerenteLivrosController.INSTANCE.buscarLivros(desc);
        textArea.setText(result);
    }
}

