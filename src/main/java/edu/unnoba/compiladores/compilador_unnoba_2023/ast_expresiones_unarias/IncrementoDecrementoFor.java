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


    @Override
    public Expresion clonar() {
        return new IncrementoDecrementoFor(this.getExpresion(),this.getNombre(),this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        throw new UnsupportedOperationException("El IncrementoDecrementoFor no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    

}
