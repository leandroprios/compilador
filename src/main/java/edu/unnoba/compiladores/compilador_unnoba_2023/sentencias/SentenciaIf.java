/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Filter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julianzabala
 */
public class SentenciaIf extends Sentencia{

    ArrayList<Sentencia> sentenciasIf;
    ArrayList<Sentencia> sentenciasElse;
    ArrayList<SentenciaElif> sentenciasElif;
    Expresion expresion;
    
    public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion, ArrayList<SentenciaElif> sentenciasElif, ArrayList<Sentencia> sentenciasElse){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.sentenciasElse = sentenciasElse;
        this.sentenciasElif = sentenciasElif;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
        expresion.graficar(miId);
        
        Random random = new Random();

        String idThenIf = "nodo_";
        idThenIf = idThenIf + random.nextInt(1000000000);

        for (int i = 0; i<this.sentenciasIf.size() ; i++){
            Sentencia sen = this.sentenciasIf.get(i);
            if (sen.getEtiqueta().equals("Filter") && sen.IsExpresion==true){
                grafico += sen.graficar(miId);
            }else{
                grafico += sen.graficar(idThenIf);
            }
        }
        
        grafico = grafico + miId + "--" + idThenIf + "\n" 
        + idThenIf + "[label=\"THEN" + "\"]\n";
        
        if(this.sentenciasElif != null && !this.sentenciasElif.isEmpty()){
            for(SentenciaElif senElif : sentenciasElif){
                grafico += senElif.graficar(miId);
            }
        }
        
        if(this.sentenciasElse != null && !this.sentenciasElse.isEmpty()){
            String idElse = "nodo_";
            idElse = idElse + random.nextInt(1000000000);
            grafico = grafico + miId + "--" + idElse + "\n" 
            + idElse + "[label=\"ELSE" + "\"]\n";
            
            for(Sentencia senElse : sentenciasElse){
                grafico += senElse.graficar(idElse);
            }
        }
        
        
        return grafico;
    }
    
    public ArrayList<Sentencia> getSentenciasIf() {
        return sentenciasIf;
    }

    public void setSentenciasIf(ArrayList<Sentencia> sentenciasIf) {
        this.sentenciasIf = sentenciasIf;
    }

    public ArrayList<Sentencia> getSentenciasElse() {
        return sentenciasElse;
    }

    public void setSentenciasElse(ArrayList<Sentencia> sentenciasElse) {
        this.sentenciasElse = sentenciasElse;
    }

    public ArrayList<SentenciaElif> getSentenciasElif() {
        return sentenciasElif;
    }

    public void setSentenciasElif(ArrayList<SentenciaElif> sentenciasElif) {
        this.sentenciasElif = sentenciasElif;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        Boolean tieneElse = !this.sentenciasElse.isEmpty();
        Boolean tieneElif = !this.sentenciasElif.isEmpty();
        
        codigo = codigo.concat(this.expresion.generarCodigo());
        
        codigo = codigo.concat(String.format("br i1 %%var%s, label %%etiqThenIf%s, label %%etiqEndIf%s\n", this.expresion.getIdVar(), getIdVar(), getIdVar()));
        codigo = codigo.concat(String.format("etiqThenIf%s:\n", getIdVar()));
        for (Sentencia sentencia : sentenciasIf) {
            codigo += sentencia.generarCodigo();
        }
        
        /*if (!tieneElse && !tieneElif){ //no tiene else y no tiene elif
            codigo = codigo.concat(String.format("br i1 %%var%s, label %%etiqThenIf%s, label %%etiqEndIf%s\n", this.expresion.getIdVar(), getIdVar(), getIdVar()));
            codigo = codigo.concat(String.format("etiqThenIf%s:\n", getIdVar()));
            for (Sentencia sentencia : sentenciasIf) {
                codigo += sentencia.generarCodigo();
            }
        }*/
        if(tieneElse || tieneElif){
            
       // codigo = codigo.concat(String.format("br i1 %%var%s, label %%etiqthenElif%s, label %%etiqelif%s\n", this.expresion.getIdVar(), getIdVar(), getIdVar()));
        
            if(tieneElif){
                for (int i = 0; i<this.sentenciasElif.size() ;i++) {
                    SentenciaElif sentencia = this.sentenciasElif.get(i);
                    
                    if (i + 1 == this.sentenciasElif.size()){ //NO TIENE MAS ELIF
                        //codigo = codigo.concat(String.format("br i1 %%var%s, label %%etiqthenElif%s, label %%etiqelif%s\n", this.expresion.getIdVar(), getIdVar(), getIdVar()));
                        
                        if(tieneElse){
                            //salto al else incondicional al else
                            sentencia.setEtiquetaSiguiente(String.format("%%etiqThenElse%s\n", getIdVar()));
                            //codigo = codigo.concat(String.format("br label %%etiqEndElse%s\n", getIdVar()));
                        }else{
                            sentencia.setEtiquetaSiguiente(String.format("%%etiqEndIf%s\n", getIdVar()));
                            
                            //codigo = codigo.concat(String.format("br label %%etiqEndIf%s\n", getIdVar()));
                        }
                     
                        codigo += sentencia.generarCodigo();
                    }else{
                        SentenciaElif sentenciaSiguiente = this.sentenciasElif.get(i+1);
                        String etiquetaSiguiente = sentenciaSiguiente.getIdVar();
                        sentencia.setEtiquetaSiguiente(etiquetaSiguiente);
                        //apilarEtiqueta(String.format("br label %%etfinif%s\n", getIdVar()));
                        //salto a la etiqueta del siguiente elif
                        //codigo = codigo.concat(String.format("br label %%etfinif%s\n", getIdVar()));
                        codigo += sentencia.generarCodigo();
                    }
                }
            }

            if(tieneElse) codigo = codigo.concat(String.format("etiqThenElse%s:\n", getIdVar()));

            if (tieneElse && !tieneElif){ // tiene 

                codigo = codigo.concat(String.format("br label %%etiqThenElse%s\n", getIdVar()));
                for (Sentencia sentenciaELSE : sentenciasElse) {
                    codigo = codigo.concat(sentenciaELSE.generarCodigo());
                }
                codigo = codigo.concat(String.format("br label %%etiqEndIf%s\n", getIdVar()));
            }
        
        }
        codigo = codigo.concat(String.format("etiqEndIf%s:\n", getIdVar()));

        return codigo;
    }
}
