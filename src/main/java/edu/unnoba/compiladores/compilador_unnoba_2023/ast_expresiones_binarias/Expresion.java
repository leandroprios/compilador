package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class Expresion extends Nodo {

     public abstract Expresion clonar();
     
     public abstract Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo);
     
    public abstract Expresion reemplazarExpresionDerecha(String valor, Tipo tipo);

     
    public abstract Tipo getTipoExpresionDerecha();
    
    public abstract boolean ComparacionFor(String var);
}
