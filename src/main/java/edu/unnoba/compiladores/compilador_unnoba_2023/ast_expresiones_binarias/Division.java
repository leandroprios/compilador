package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.GuionBajo;

public class Division extends OperacionBinaria {

    public Division(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "/";
    }

    @Override
    public Expresion clonar() {
        return new Division(this.izquierda.clonar(), this.derecha.clonar(), this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.izquierda.reemplazarExpresionIzquierda(valor,tipo);
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
    
    
    
    
}