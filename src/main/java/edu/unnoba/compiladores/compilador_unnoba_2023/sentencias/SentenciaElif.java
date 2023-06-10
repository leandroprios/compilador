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
    
    private String etiquetaSiguiente;
    
    public SentenciaElif(ArrayList<Sentencia> sentencias, Expresion expresion){
        setNombre("ELIF");
        this.sentencias = sentencias;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public void setEtiquetaSiguiente(String etiqueta){
        this.etiquetaSiguiente =etiqueta;
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
    
    /*public String generarEtiqueta(){
        return String.format("etiqThenIf%s:\n", getIdVar());
    }*/

    @Override
    public String generarCodigo() {
       String codigo = this.expresion.generarCodigo();
        System.out.println("CODIGO DENTRO DEL ELIF "+String.format("br i1 %%var%s, label %%etiqThenElif%s, label %s\n", this.expresion.getIdVar(), getIdVar(), this.etiquetaSiguiente));
        codigo = codigo.concat(String.format("br i1 %%var%s, label %%etiqThenElif%s, label %s\n", this.expresion.getIdVar(), getIdVar(), this.etiquetaSiguiente));
        codigo = codigo.concat(String.format("etiqThenElif%s:\n", getIdVar()));
        for (Sentencia sentencia : sentencias) {
            codigo += sentencia.generarCodigo();
        }
        codigo = codigo.concat(String.format("br label %s\n", this.etiquetaSiguiente));
       return codigo;
    }
}
