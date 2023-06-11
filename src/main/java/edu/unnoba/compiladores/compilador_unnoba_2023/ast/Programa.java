
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
    private ArrayList<String> valoresString;


    public Programa(ArrayList<Sentencia> sentencias, Hashtable<String, Tipo> tablaSimbolos, ArrayList<String> valoresString) {
        this.sentencias = sentencias;
        this.tablaSimbolos = tablaSimbolos;
        this.valoresString = valoresString;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Programa(ArrayList<Sentencia> sentencias, ArrayList<ArrayList<Declaracion>> declaraciones,Hashtable<String, Tipo> tablaSimbolos, ArrayList<String> valoresString) {
        this.sentencias = sentencias;
        this.declaraciones = declaraciones;
        this.tablaSimbolos = tablaSimbolos;
        this.valoresString = valoresString;
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
        codigo.append("source_filename = \"Prueba.txt\"\n");
        codigo.append("target datalayout = \"e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n");
        codigo.append("target triple = \"x86_64-pc-windows-msvc19.16.27038\"\n\n");
        codigo.append("\n");
        codigo.append("declare i32 @printf(i8*, ...)\n");
        codigo.append("declare i32 @puts(i8*)\n");
        codigo.append("declare i32 @scanf(i8* %0, ...)\n");
        codigo.append("\n");
        
        //ejemplos para mostrar errores en el programa
        /*codigo.append("@str.cantinsuficiente = private constant [47 x i8] c\"La lista tiene menos elementos que el indicado\\00\"\n");
        codigo.append("@str.cantidadimpares = private constant [57 x i8] c\"No existen suficientes elementos impares para el calculo\\00\"\n");*/
        /*codigo.append("@.trueString = private constant [5 x i8] c\"true\\00\"\n");
        codigo.append("@.falseString = private constant [6 x i8] c\"false\\00\"\n");*/
        
        codigo.append("@.integer = private constant [4 x i8] c\"%d\\0A\\00\"\n");
        codigo.append("@.float = private constant [5 x i8] c\"%lf\\0A\\00\"\n");
        codigo.append("@.int_read_format = unnamed_addr constant [3 x i8] c\"%d\\00\"\n");
        codigo.append("@.double_read_format = unnamed_addr constant [4 x i8]  c\"%lf\\00\"\n");
        codigo.append("\n");
        
        for(String str : valoresString){
            codigo.append(str);
        }
        
        tablaSimbolos.forEach((k, v) -> {
            codigo.append(String.format("@%s = global %s ", k, getTipo_llvm(v)));
            if(getTipo_llvm(v).equals("double")){
                codigo.append("0.0\n");
            }
            else{
                codigo.append("0\n");
            }
        });
        
        codigo.append("\n");
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
