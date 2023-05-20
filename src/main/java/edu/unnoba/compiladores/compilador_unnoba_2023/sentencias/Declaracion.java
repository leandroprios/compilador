package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones.Identificador;


public class Declaracion extends Sentencia {
    private Identificador ident;
    private Tipo tipo;
    
    public Declaracion(Tipo tipo, Identificador ident){
        this.tipo = tipo;
        this.ident = ident;
    }

    public Identificador getIdent() {
        return ident;
    }

    public void setIdent(Identificador ident) {
        this.ident = ident;
    }

    @Override
    public Tipo getTipo() {
        return ident.getTipo();
    }

    @Override
    public void setTipo(Tipo tipo) {
        ident.setTipo(tipo);
    }

    @Override
    public String toString() {
        return ident.toString();
    }

    @Override
    public String getEtiqueta() {
        return getClass().getSimpleName();
    }


    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += ident.graficar(getId());
        return grafico;
    }
}
