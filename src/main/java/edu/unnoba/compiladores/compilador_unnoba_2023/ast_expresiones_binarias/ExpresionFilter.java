package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public class ExpresionFilter extends OperacionBinaria{


    public ExpresionFilter(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "expresion Filter";
    }

    @Override
    public Expresion clonar() {
        return new ExpresionFilter(this.izquierda, this.derecha, this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        if(this.izquierda.getIdVar()=="_"){
            this.izquierda.setIdVar(valor);
        }else{
            this.izquierda.reemplazarExpresionIzquierda(valor);
        }
        return this.clonar(); 
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    
}
