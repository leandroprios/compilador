/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
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
    }
    
    public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion, ArrayList<SentenciaElif> sentenciasElif, ArrayList<Sentencia> sentenciasElse){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.sentenciasElse = sentenciasElse;
        this.sentenciasElif = sentenciasElif;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        //Then thenIf = new Then("THEN");
        String grafico = super.graficar(idPadre) + 
        expresion.graficar(miId);
        
        Random random = new Random();
        
        String idThenIf = "nodo_";
        idThenIf = idThenIf + random.nextInt(1000000000);
        grafico = grafico + miId + "--" + idThenIf + "\n" 
        + idThenIf + "[label=\"THEN" + "\"]\n";


        for(Sentencia sen : sentenciasIf){
            grafico += sen.graficar(idThenIf);
        }
        
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
}
