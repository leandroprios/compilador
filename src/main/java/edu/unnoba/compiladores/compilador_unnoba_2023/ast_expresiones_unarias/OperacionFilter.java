/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author zabal
 */
public class OperacionFilter extends OperacionUnaria {

    Expresion expresion;
    public OperacionFilter(Expresion expresion) {
        super("_", expresion, Tipo.BOOLEAN);
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    @Override
    public Expresion clonar() {
        return new OperacionFilter(this.getExpresion());
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        throw new UnsupportedOperationException("El OperacionFilter no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
}
