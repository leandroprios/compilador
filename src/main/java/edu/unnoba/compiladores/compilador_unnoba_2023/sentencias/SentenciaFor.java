/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.OperacionBinaria;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.IncrementoDecrementoFor;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julianzabala
 */
public class SentenciaFor extends Sentencia{
    Expresion operacion;
    Asignacion asignacion;
    IncrementoDecrementoFor expresionFor;
    ArrayList<Sentencia> sentencias;
    
    static Integer idDo = 1;
    
    public SentenciaFor(Expresion operacion, Asignacion asignacion, IncrementoDecrementoFor expresionFor, ArrayList<Sentencia> sentencias){
        setNombre("FOR");
        this.operacion = operacion;
        this.asignacion = asignacion;
        this.expresionFor = expresionFor;
        this.sentencias = sentencias;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        idDo = idDo + 1;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
        asignacion.graficar(miId) +
        expresionFor.graficar(miId) + 
        operacion.graficar(miId);
        
        Random random = new Random();
        
        String idDo = "nodo_";
        //idDo.hashCode() +
        idDo = idDo + random.nextInt(1000000000);
        //"nodo_" + this.hashCode();
        grafico = grafico + miId + "--" + idDo + "\n" 
        + idDo + "[label=\"DO" + "\"]\n";

        for(Sentencia sen : sentencias){
            grafico += sen.graficar(idDo);
        }
        return grafico;
    }
    
}
