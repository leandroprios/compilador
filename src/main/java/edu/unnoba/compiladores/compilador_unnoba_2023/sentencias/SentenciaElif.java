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
public class SentenciaElif extends Sentencia {
    ArrayList<Sentencia> sentencias;
    Expresion expresion;
    
    public SentenciaElif(ArrayList<Sentencia> sentencias, Expresion expresion){
        setNombre("ELIF");
        this.sentencias = sentencias;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
        expresion.graficar(miId);

        for(Sentencia sen : sentencias){
            grafico += sen.graficar(miId);
        }
        
        return grafico;
    }
}
