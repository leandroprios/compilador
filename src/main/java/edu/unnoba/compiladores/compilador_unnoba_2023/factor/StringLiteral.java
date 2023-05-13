package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;

/**
 *
 * @author Julian
 */
public class StringLiteral extends Literal{
    private final String valor;

    public StringLiteral(String valor) {
        this.valor = valor;
        setNombre("String");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
