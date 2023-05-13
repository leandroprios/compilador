package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones.Identificador;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;


public class Asignacion extends Sentencia {
    
   private Identificador ident;
    private Expresion expresion;

    public Asignacion(Identificador ident, Expresion e) {
        setNombre("=");
        this.ident = ident;
        this.expresion = e;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Identificador getIdent() {
        return ident;
    }

    public void setIdent(Identificador ident) {
        this.ident = ident;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += ident.graficar(getId());
        grafico += expresion.graficar(getId());
        return grafico;
    }
}
