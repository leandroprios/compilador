
package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;


/**
 *
 * @author Julian
 */
public class EnteroAFlotante extends Expresion {
    
    private Expresion entero;

    public EnteroAFlotante(Expresion entero){
        setEntero(entero);
        setTipo(Tipo.FLOAT);
        setNombre("IntegerToFloat");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Expresion getEntero() {
        return entero;
    }
    public void setEntero(Expresion entero) {
        this.entero = entero;
    }

    public String graficar(String idPadre){
        String graph = super.graficar(idPadre);
        graph += getEntero().graficar(getId());
        return graph;
    }

}
