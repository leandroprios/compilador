/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.OperacionUnaria;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.SentenciaIf;

/**
 *
 * @author zabal
 */
public class Filter extends OperacionUnaria {
    SentenciaIf sentenciaIf;

    public Filter(SentenciaIf sentenciaIf) {
        super("FILTER", sentenciaIf.getExpresion(),Tipo.BOOLEAN);
        this.sentenciaIf=sentenciaIf;
    }
    
    public SentenciaIf getSentenciaIf() {
        return sentenciaIf;
    }

    public void setSentenciaIf(SentenciaIf sentenciaIf) {
        this.sentenciaIf = sentenciaIf;
    }
    
    

    
    
}
