package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.GuionBajo;

public class Multiplicacion extends OperacionBinaria {

    public Multiplicacion(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    public String getNombreOperacion() {
        return "*";
    }

    @Override
    public Expresion clonar() {
        return new Multiplicacion(this.izquierda.clonar(), this.derecha.clonar(), this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.izquierda.reemplazarExpresionIzquierda(valor,tipo);
        return this.clonar();
    }
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        this.derecha.reemplazarExpresionDerecha(valor,tipo);
        return this.clonar();    
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.derecha.getTipoExpresionDerecha();
    }
    
    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fmul" : "mul";
    }
    
    @Override
    public String get_llvm_name() {
        return llvm_name;
    }
    
    @Override
    public String getNombreIz() {
        return this.getIzquierda().getNombreIz();
    }
    
    @Override
    public String getNombreDe() {
        return this.getDerecha().getNombreDe();
    }
    
    @Override
    public boolean isOperacionBinaria() {
        return true;
    }
    
    
}
