package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author julian
 */
public class NegacionLogica extends OperacionUnaria {
    
    public NegacionLogica(Expresion expresion) {
        super("NOT", expresion, Tipo.BOOLEAN);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    @Override
    public Expresion clonar() {
       return new NegacionLogica(this.getExpresion().clonar());
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
    
    @Override
    public String get_llvm_op_code() {
        return "xor";
    }
    
    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();     
        resultado.append(this.getExpresion().generarCodigo());
        resultado.append(String.format("%%var%s = xor i1 %%var%s, 1\n", getIdVar(), getExpresion().getIdVar()));
        return resultado.toString();
    }  

    
}
