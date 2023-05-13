 package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Julian
 */
public class Input extends Expresion{
    
    public Input(Tipo tipo){
        setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
}
