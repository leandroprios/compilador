package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.logicas;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.OperacionBinaria;

/**
 *
 * @author julianzabala
 */
public class Desigualdad extends OperacionBinaria{

    public Desigualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
    }
    
    
    @Override
    protected String getNombreOperacion() {
        return "!=";
    }
    
}
