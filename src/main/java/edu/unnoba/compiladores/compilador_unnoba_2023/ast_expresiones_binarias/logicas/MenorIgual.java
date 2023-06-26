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
public class MenorIgual extends OperacionBinaria{

    public MenorIgual(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
    }
    
    @Override
    public String getNombreOperacion() {
        return "<=";
    }
    
    @Override
    public Expresion clonar() {
        return new MenorIgual(this.izquierda.clonar(), this.derecha.clonar());
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.izquierda.reemplazarExpresionIzquierda(valor,tipo);
        return this.clonar();

    }
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
       this.derecha.reemplazarExpresionDerecha(valor, tipo);
       return this.clonar();
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return this.izquierda.ComparacionFor(var);
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.derecha.getTipoExpresionDerecha();
    }
    
    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "ole" : "sle";
    }

    @Override
    public String get_llvm_type_code(){
        return getIzquierda().getTipo().equals(Tipo.INTEGER) ? "i32" : "double";
    }

    @Override
    public String generarCodigo(){
        this.setResultadoExpresion("%var"+ this.getIdVar());
        String codigo = getIzquierda().generarCodigo();
        codigo += getDerecha().generarCodigo();
        codigo += "%var"+getIdVar()+" = "+get_llvm_arithmetic_op_code()+" "+get_llvm_op_code()+" "+get_llvm_type_code()+" %var"+getIzquierda().getIdVar()+", %var"+getDerecha().getIdVar()+"\n";
        codigo += "store i1 %var"+this.getIdVar()  + ", i1* @resultado\n";
        if(this.getLeerResultado()) {
            codigo += "%resultadoLoad"+ this.getIdVar()+  " = load i1, i1* @resultado\n";
            this.setResultadoExpresion("%resultadoLoad"+ this.getIdVar());
        }
        return codigo;
    }
    
    @Override
    public String get_llvm_name() {
        return llvm_name;
    }
    
    @Override
    public String getNombreIz() {
        return this.getIzquierda().getNombreIz();
    }
    
    @Override
    public String getNombreDe() {
        return this.getDerecha().getNombreDe();
    }
    
    @Override
    public boolean isOperacionBinaria() {
        return true;
    }
    
}
