package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;


/**
 *
 * @author Nacho
 */
public class Entero extends Literal {
    
    private Integer valor;

    public Entero(Integer valor) {
        setTipo(Tipo.INTEGER);
        this.valor = valor;
        setNombre("Integer");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
