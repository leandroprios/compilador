
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

/**
 *
 * @author Julian
 */
public class Impresion extends Nodo{
    
    private final Expresion expresion;
    
    public Impresion(Expresion expresion){
        this.expresion = expresion;
    }
    
    public String graficar() {
        // Acá se dispara la invocación a los métodos graficar() de los nodos.
        // Como la Impresion no tiene padre, se inicia pasando null.  
        StringBuilder resultado = new StringBuilder();
        resultado.append("graph G {");
        resultado.append(this.graficar(null));
        resultado.append(this.expresion.graficar(this.getId()));
        resultado.append("}");
        return resultado.toString();
    }
    
}
