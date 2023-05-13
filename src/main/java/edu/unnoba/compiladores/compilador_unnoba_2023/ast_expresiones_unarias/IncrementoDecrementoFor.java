package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author julianzabala
 */
public class IncrementoDecrementoFor  extends OperacionUnaria{
    
    public IncrementoDecrementoFor(Expresion expresion, String operacion, Tipo tipo) {
        super(operacion, expresion, tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    

}
