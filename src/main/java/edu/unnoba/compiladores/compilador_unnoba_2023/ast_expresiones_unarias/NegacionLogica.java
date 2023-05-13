package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author julian
 */
public class NegacionLogica extends OperacionUnaria {
    
    public NegacionLogica(Expresion expresion) {
        super("NOT", expresion, Tipo.BOOLEAN);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
}
