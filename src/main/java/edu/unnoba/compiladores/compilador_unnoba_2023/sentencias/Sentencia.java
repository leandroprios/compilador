package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Nodo;

public abstract class Sentencia extends Nodo {
    public boolean IsExpresion; //lo utilizo para determinar si el filter se utilizo como una expresion
}
