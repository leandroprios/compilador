package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

/**
 *
 * @author facundo
 */
public abstract class Literal extends Constante {
    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", this, getTipo());
    }
}
