package edu.unnoba.compiladores.compilador_unnoba_2023.factor;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

/**
 *
 * @author Julian 
 */
public class Flotante extends Literal {
    private final Float valor;

    public Flotante(Float valor) {
        setTipo(Tipo.FLOAT);
        this.valor = valor;
        setNombre("Float");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
