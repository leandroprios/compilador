/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import java.util.ArrayList;

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
        String grafico = super.graficar(idPadre) + 
        expresion.graficar(miId);

        for(Sentencia sen : sentenciasIf){
            grafico += sen.graficar(miId);
        }
        
        if(sentenciasElse != null && !sentenciasElse.isEmpty()){
            for(Sentencia sen : sentenciasIf){
                grafico += sen.graficar(miId);
            }
        }
        return grafico;
    }
}
