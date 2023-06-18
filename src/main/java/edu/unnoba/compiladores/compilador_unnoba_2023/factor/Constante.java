package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

public abstract class Constante extends Expresion {
    
   private Tipo tipo;
    
    @Override
    public String graficar(String idPadre){
        this.setResultadoExpresion("%resultado"+ this.getIdVar());
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.getNombre(), this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }
}
