package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class OperacionBinaria extends Expresion {

    protected final Expresion izquierda;
    protected final Expresion derecha;

    public OperacionBinaria(Expresion izquierda, Expresion derecha, Tipo tipo) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        super.setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Expresion getIzquierda() {
        return izquierda;
    }

    public Expresion getDerecha() {
        return derecha;
    }


    @Override
    public String getEtiqueta() {
        return String.format("%s", this.getNombreOperacion());
    }

    protected abstract String getNombreOperacion();

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) +
                derecha.graficar(miId);
    }
}
