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
        this.setNombre("OR");

    }
    
    @Override
    public String getNombreOperacion() {
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
        codigo += ";entro al OR " + this.getIdVar() + "\n";
        
        this.setResultadoExpresion("%resultadoLoad"+ this.getIdVar());
        this.getIzquierda().setLeerResultado(true);
        this.getDerecha().setLeerResultado(false);

        
        codigo += getIzquierda().generarCodigo();
        codigo += "\n";
       
        
        codigo = codigo.concat("br i1 " + this.getIzquierda().getResultadoExpresion()+ ", label %etiqFinOr" + this.getIdVar() + ", label %etiqFalseCondicionIzquierdaOr" + this.getIdVar() + "\n");
        codigo += "\n";
        
        codigo = codigo.concat(String.format("etiqFalseCondicionIzquierdaOr%s:\n", this.getIdVar())); 
        codigo += getDerecha().generarCodigo();
        codigo += "\n";
        
        codigo = codigo.concat(String.format("br label %%etiqFinOr%s\n", this.getIdVar()));  
        codigo += "\n";     
        codigo = codigo.concat(String.format("etiqFinOr%s:\n", this.getIdVar()));
        
        codigo += "%resultadoLoad"+ this.getIdVar()+  " = load i1, i1* @resultado\n";
  
        codigo += "\n";
        return codigo;
    }

    @Override
    public String get_llvm_name() {
        return llvm_name;
    }
    
}