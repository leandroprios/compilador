package edu.unnoba.compiladores.compilador_unnoba_2023.factor;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

/**
 *
 * @author Nacho
 */
public class Booleano extends Literal {
     private final Boolean valor;

    public Booleano(Boolean valor) {
        setTipo(Tipo.BOOLEAN);
        this.valor = valor;
        setNombre("Boolean");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public String toString() {        
        return valor.toString();
    }
}