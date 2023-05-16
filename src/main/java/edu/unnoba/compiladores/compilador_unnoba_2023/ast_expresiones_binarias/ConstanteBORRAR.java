package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public class ConstanteBORRAR extends Expresion {
    private final String valor;
    private Tipo tipo;
    

    public ConstanteBORRAR(String valor, Tipo tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getValor() {
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
