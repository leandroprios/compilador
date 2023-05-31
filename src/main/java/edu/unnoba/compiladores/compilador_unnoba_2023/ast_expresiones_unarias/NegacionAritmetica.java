package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author julian
 */
public class NegacionAritmetica extends OperacionUnaria {
    private String operacion;
    
   public NegacionAritmetica(Expresion expresion, String operacion, Tipo tipo) {
        super("-", expresion, tipo);
        this.operacion = operacion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public Expresion clonar() {
        return new NegacionAritmetica(this.getExpresion().clonar(),this.getNombre(),this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.getExpresion().reemplazarExpresionIzquierda(valor, tipo);
        return this.clonar();  
    }

    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        this.getExpresion().reemplazarExpresionDerecha(valor, tipo);
        return this.clonar();  
    }
    
    
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.getTipo();
    }

}