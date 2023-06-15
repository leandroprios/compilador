/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.logicas;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.OperacionBinaria;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.GuionBajo;

/**
 *
 * @author julianzabala
 */
public class Or extends OperacionBinaria{

    //private String resultadoExpresion; //guarda el nombre de la variable de llvm

    public Or(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
        this.setResultadoExpresion("%varResultadoCondicion" + this.getIdVar());
    }
    
    @Override
    protected String getNombreOperacion() {
        return "OR";
    }
    
    @Override
    public Expresion clonar() {
        return new Or(this.izquierda.clonar(),this.derecha.clonar());
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.izquierda.reemplazarExpresionIzquierda(valor,tipo);
        return this.izquierda.clonar();
    }
    
     @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
       this.derecha.reemplazarExpresionDerecha(valor, tipo);
       return this.clonar();
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.derecha.getTipoExpresionDerecha();
    }
    
    @Override
    public String get_llvm_op_code() {
        return "or";
    }

    @Override
    public String generarCodigo(){
        String codigo = "";
         codigo += "%resultadoOr"+ this.getIdVar() +  " = alloca i1\n";
        //le paso el resultado de toda la expresion OR a la expresion IZ
        this.getIzquierda().setResultadoExpresion("%var" + this.getIdVar());
        this.getIzquierda().setllamadoDesdeExpresion(this.getIdVar());

        codigo += getIzquierda().generarCodigo();
        this.setResultadoExpresion(this.getIzquierda().getResultadoExpresion());
        codigo += "\n";
       
        
        codigo = codigo.concat("br i1 " + this.getIzquierda().getResultadoExpresion() + ", label %etiqTrueCondicionIzquierdaOr" + this.getIdVar() + ", label %etiqFalseCondicionIzquierdaOr" + this.getIdVar() + "\n");
        //codigo += "%resultadoOrLoad2"+ this.getIdVar() +  " = load i1, i1*%resultadoOr" + this.getIdVar() +  "\n";

        
        //codigo = codigo.concat("br i1 %resultadoOrLoad2"+ this.getIdVar() + ", label %etiqTrueCondicionIzquierdaOr" + this.getIdVar() + ", label %etiqFalseCondicionIzquierdaOr" + this.getIdVar() + "\n");

        codigo += "\n";
        
        //this.getDerecha().setResultadoExpresion(this.getIdVar());
        
        this.getDerecha().setllamadoDesdeExpresion(this.getIdVar());
        
        codigo = codigo.concat(String.format("etiqFalseCondicionIzquierdaOr%s:\n", this.getIdVar())); 
        codigo += getDerecha().generarCodigo();
        codigo += "\n";
        //codigo += "store i1 "+ this.getDerecha().getResultadoExpresion()  + ", i1*%resultadoOr" + this.getIdVar() +  "\n";
        codigo += "store i1 "+ this.getDerecha().getResultadoExpresion()  + ", i1*%resultadoOr" + this.getIdVar() +  "\n";

        
        codigo = codigo.concat(String.format("br label %%etiqFinOr%s\n", this.getIdVar()));

        
        codigo = codigo.concat(String.format("etiqTrueCondicionIzquierdaOr%s:\n", this.getIdVar()));
        codigo += "store i1 "+ this.getIzquierda().getResultadoExpresion()  + ", i1*%resultadoOr" + this.getIdVar() +  "\n";
        
        codigo += "\n";    
        
        //this.setResultadoExpresion(this.getDerecha().getResultadoExpresion());

        codigo += "\n";
        
        
        codigo = codigo.concat(String.format("br label %%etiqFinOr%s\n", this.getIdVar()));
        codigo += "\n";
                
        codigo += "\n";
                
        codigo = codigo.concat(String.format("etiqFinOr%s:\n", this.getIdVar()));
        
        codigo += "%resultadoOrLoad"+ this.getIdVar() +  " = load i1, i1*%resultadoOr" + this.getIdVar() +  "\n";

        this.setResultadoExpresion("%resultadoOrLoad"+ this.getIdVar());

        codigo+= ";" + this.getResultadoExpresion();
        this.setIdVar(this.getResultadoExpresion());
  
        codigo += "\n";
        
        return codigo;
    }

    @Override
    public String get_llvm_name() {
        return llvm_name;
    }
    
}