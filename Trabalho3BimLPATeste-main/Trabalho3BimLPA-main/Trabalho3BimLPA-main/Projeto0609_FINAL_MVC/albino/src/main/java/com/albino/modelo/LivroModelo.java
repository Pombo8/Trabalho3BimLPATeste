package com.albino.modelo;

import java.util.ArrayList;

public  class LivroModelo {
        private ArrayList<LivroVO> listaLivro = new ArrayList<LivroVO>();

        
        
        public String listarLivro() {
            String valor="||  CODIGO  ||      NOME      ||  ANO  ||\n";
            String valorprevio="";
            for(int i =0;i<listaLivro.size();i++){
                valorprevio = "\n|| Codigo:"+listaLivro.get(i).getCodigo()+" || Nome :"+listaLivro.get(i).getNome()+" || Ano:"+listaLivro.get(i).getAno()+" ||"; 
                valor = valor + valorprevio;
            }
            return valor;
        }
        
        // adicao ao arrayLista alunos
        public void adicionaLivro(int codigo,String nome, String ano) {
            
            LivroVO novoLivro = new LivroVO(codigo, nome,ano); 
            listaLivro.add(novoLivro);

    
        }
        public boolean procuraCodigo(int codigo){
            for(int i=0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getCodigo()==codigo) return true;
            }
            return false;
        }
        public String getNome(int codigo){
            for(int i=0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getCodigo()==codigo) return listaLivro.get(i).getNome();
            }
            
            return "";
        }
        public String getAno(int codigo){
            for(int i=0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getCodigo()==codigo) return listaLivro.get(i).getAno();
            }
            
            return "";
        }
        public void cargaInicial(){
            LivroVO novoLivro1 = new LivroVO(1, "Pequeno Principe","7000 A.C");
            LivroVO novoLivro2 = new LivroVO(2, "Biblia Sagrada", "1450 A.C - 100 D.C");
            LivroVO novoLivro3 = new LivroVO(3, "Caminho Para Casa", "2004 D.C");
            LivroVO novoLivro4 = new LivroVO(4, "JavaScript for Babies", "2016 D.C");

            listaLivro.add(novoLivro1);
            listaLivro.add(novoLivro2);
            listaLivro.add(novoLivro3);
            listaLivro.add(novoLivro4);
        }
        public void alterarLivro(int codigo, String nome, String ano){
            for(int i=0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getCodigo()==codigo){
                    listaLivro.get(i).setNome(nome);
                    listaLivro.get(i).setAno(ano);
                }
            }
        }
        public void excluirLivro(int codigo){
            for(int i=0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getCodigo()==codigo) listaLivro.remove(i);
            }
        }
        public String buscarLivros(String desc){
            String valor="||  CODIGO  ||      NOME      ||  ANO  ||\n";
            String valorprevio="";
            for(int i =0;i<listaLivro.size();i++){
                if(listaLivro.get(i).getNome().contains(desc)){
                    valorprevio = "\n|| Codigo:"+listaLivro.get(i).getCodigo()+" || Nome :"+listaLivro.get(i).getNome()+" || Ano:"+listaLivro.get(i).getAno()+" ||"; 
                    valor = valor + valorprevio;
                }
            }
            return valor;
        }
    }
