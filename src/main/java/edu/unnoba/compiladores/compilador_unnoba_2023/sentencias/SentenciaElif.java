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
       
        Random random = new Random();
        
        String grafico = super.graficar(idPadre) + 
        expresion.graficar(miId);
        
        String idThenIf = "nodo_";
        idThenIf = idThenIf + random.nextInt(1000000000);
        grafico = grafico + miId + "--" + idThenIf + "\n" 
        + idThenIf + "[label=\"THEN" + "\"]\n";
        
        for(Sentencia sen : sentencias){
            grafico += sen.graficar(idThenIf);
        }
        

        
        return grafico;
    }

    @Override
    public String generarCodigo() {
       return "";
    }
}
