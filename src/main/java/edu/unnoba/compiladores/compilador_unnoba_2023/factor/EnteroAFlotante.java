
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

    @Override
    public Expresion clonar() {
        return new EnteroAFlotante(this.entero);
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        throw new UnsupportedOperationException("El EnteroAFlotante no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }

}
