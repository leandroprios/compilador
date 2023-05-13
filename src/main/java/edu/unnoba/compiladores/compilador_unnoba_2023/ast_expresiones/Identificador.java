package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Constante;



/**
 *
 * @author Julian
 */
public class Identificador extends Constante {
    
    private String nombreVar = "ID";

    public Identificador(Object valor, Tipo tipo) {
        super(valor, tipo);
    }

    public String getNombreVar() {
        return nombreVar;
    }

    public void setNombreVar(String nombreVar) {
        this.nombreVar = nombreVar;
    }

}

