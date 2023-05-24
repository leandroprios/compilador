package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.GuionBajo;

public class Multiplicacion extends OperacionBinaria {

    public Multiplicacion(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "*";
    }

    @Override
    public Expresion clonar() {
        return new Multiplicacion(this.izquierda.clonar(), this.derecha.clonar(), this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        this.izquierda.reemplazarExpresionIzquierda(valor);
        return this.clonar();
    }
    
    
    
}
