package edu.unnoba.compiladores.compilador_unnoba_2023;

import java.util.Arrays;

class MiToken extends java_cup.runtime.Symbol{
    
    public final String nombre;
    public final int linea;
    public final int columna;
    public final Object valor;

    MiToken (String nombre) {
        this(nombre, null);
    }

    MiToken (String nombre, Object valor) {
        this(nombre, -1, -1, valor);
    }

    MiToken (String nombre, int linea, int columna) {
        this(nombre, linea, columna, null);
    }

    MiToken (String nombre, int linea, int columna, Object valor){
        super(Arrays.asList(MiParserSym.terminalNames).indexOf(nombre), linea, columna, valor);
        this.nombre = nombre;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public String toString() {
        String posicion = "";
        if (this.linea != -1 && this.columna != -1)
            posicion = " @ (L:" + this.linea + ", C:" + this.columna + ")";
        if (valor == null)
            return "[" + this.nombre + "]" + posicion;
        else
            return "[" + this.nombre + "] -> (" + this.valor + ")" + posicion;
    }
}
