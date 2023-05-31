/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.OperacionUnaria;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Sentencia;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.SentenciaIf;

/**
 *
 * @author zabal
 */
public class Filter extends Sentencia {
    SentenciaIf sentenciaIf;
    
   
    public Filter(SentenciaIf sentenciaIf, Tipo tipo) {
        this.sentenciaIf=sentenciaIf;
    }
     
    public SentenciaIf getSentenciaIf() {
        return sentenciaIf;
    }

    public void setSentenciaIf(SentenciaIf sentenciaIf) {
        this.sentenciaIf = sentenciaIf;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
        sentenciaIf.graficar(miId);
        return grafico;
    }
}
