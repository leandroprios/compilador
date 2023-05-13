package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public class Constante extends Expresion {
    private final Object valor;
    private Tipo tipo;
    

    public Constante(Object valor, Tipo tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }
    
    @Override
    public Tipo getTipo() {
        return tipo;
    }
    
    @Override
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    

    @Override
    protected String getEtiqueta() {
        return String.format(String.format("Const %s", getValor()));
    }
}
