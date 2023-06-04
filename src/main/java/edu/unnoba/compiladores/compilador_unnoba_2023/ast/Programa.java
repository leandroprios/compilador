
package edu.unnoba.compiladores.compilador_unnoba_2023.ast;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Nodo;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Declaracion;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Sentencia;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author julianzabala
 */
public class Programa extends Nodo {
    
    private ArrayList<Sentencia> sentencias;
    private ArrayList<ArrayList<Declaracion>> declaraciones;
    private Hashtable<String, Tipo> tablaSimbolos;


    public Programa(ArrayList<Sentencia> sentencias, Hashtable<String, Tipo> tablaSimbolos) {
        this.sentencias = sentencias;
        this.tablaSimbolos = tablaSimbolos;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Programa(ArrayList<Sentencia> sentencias, ArrayList<ArrayList<Declaracion>> declaraciones,Hashtable<String, Tipo> tablaSimbolos) {
        this.sentencias = sentencias;
        this.declaraciones = declaraciones;
        this.tablaSimbolos = tablaSimbolos;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }


    public String graficar(){
        StringBuilder codigo = new StringBuilder();
        codigo.append("graph G {");
        codigo.append(this.graficar(null));

        for(Sentencia sentencia : sentencias){
            codigo.append(sentencia.graficar(this.getId()));
        }


        codigo.append("}");
        return codigo.toString();
    }
    
    private String getTipo_llvm(Tipo tipo){
        return (tipo == Tipo.INTEGER) ? "i32" : ((tipo == Tipo.FLOAT) ? "double" : "i1");
    }
    
    
    
    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        
        codigo.append(";Programa: Prueba\n");
        codigo.append("source_filename = \"prueba.txt\"\n");
        codigo.append("target datalayout = \"e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n");
        codigo.append("target triple = \"x86_64-pc-windows-msvc19.16.27038\"\n\n");
        codigo.append("declare i32 @printf(i8*, ...)\n");
        codigo.append("\n");
        codigo.append("@.integer = private constant [4 x i8] c\"%d\\0A\\00\"\n");
        codigo.append("\n");
        codigo.append("define i32 @main(i32, i8**) {\n\t");
        
        
        tablaSimbolos.forEach((k, v) -> {
            codigo.append(String.format("@%s = global %s ", k.toString(), getTipo_llvm(v)));
            if(getTipo_llvm(v).equals("double")){
                codigo.append("0.0\n");
            }
            else{
                codigo.append("0\n");
            }
        });
        
        codigo.append("\n\n");
        codigo.append("define i32 @main(i32, i8**) {\n\t");
        
        
        StringBuilder codigoSentencia = new StringBuilder();
        
        for(Sentencia sentencia : sentencias){
            codigoSentencia.append(sentencia.generarCodigo());
        }
        
        codigo.append(codigoSentencia.toString().replaceAll("\n", "\n\t"));

        codigo.append("\n\tret i32 0\n");
        codigo.append("}");
        
        return codigo.toString();
    }

}
