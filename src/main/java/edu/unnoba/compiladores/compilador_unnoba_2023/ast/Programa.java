
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


    public String graficar(){
        StringBuilder resultado = new StringBuilder();
        resultado.append("graph G {");
        resultado.append(this.graficar(null));

        for(Sentencia sentencia : sentencias){
            resultado.append(sentencia.graficar(this.getId()));
        }


        resultado.append("}");
        return resultado.toString();
    }
    
    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        for(Sentencia sentencia : sentencias){
            codigo.append(sentencia.generarCodigo());
        }
        
        return codigo.toString();
    }

}
