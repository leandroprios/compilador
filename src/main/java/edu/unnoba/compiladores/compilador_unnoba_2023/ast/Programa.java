
package edu.unnoba.compiladores.compilador_unnoba_2023.ast;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Nodo;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Declaracion;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author julianzabala
 */
public class Programa extends Nodo {
    
    private ArrayList<Sentencia> sentencias;
    private ArrayList<ArrayList<Declaracion>> declaraciones;

    public Programa(ArrayList<Sentencia> sentencias) {
        this.sentencias = sentencias;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Programa(ArrayList<Sentencia> sentencias, ArrayList<ArrayList<Declaracion>> declaraciones) {
        this.sentencias = sentencias;
        this.declaraciones = declaraciones;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        for(Sentencia sentencia : sentencias){
            grafico += sentencia.graficar(this.getId());
        }
        
        if(declaraciones != null && !declaraciones.isEmpty()){
            for(ArrayList<Declaracion> declaracionesPrograma : declaraciones){
                for(Declaracion dec : declaracionesPrograma){ 
                    grafico += dec.graficar(this.getId());
                }
            }
        }
        
        return grafico;
    }
}
