package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Julian
 */
public class StringLiteral extends Literal{
    private final String valor;

    public StringLiteral(String valor) {
        this.valor = valor;
        setNombre("String");
        setTipo(Tipo.UNKNOWN);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public Expresion clonar() {
        return new StringLiteral(this.valor);
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El StringLiteral no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Booleano no soporta reemplazar la expresion derecha."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return Tipo.UNKNOWN;
    }

    
        @Override
    public String generarCodigo() {
        this.setResultadoExpresion("%resultado"+ this.getIdVar());
        StringBuilder codigo = new StringBuilder();
        codigo.append(String.format("@str%1$s = private constant [%2$s x i8] c\"%3$s\\00\"\n", 
                getIdVar(), (getValor().length()+1), getValor()));
        return codigo.toString();
    }
    
    @Override
    public String getNombreIz() {
        return this.getNombre();
    }
    
    @Override
    public String getNombreDe() {
        return this.getNombre();
    }
    
    @Override
    public boolean isOperacionBinaria() {
        return false;
    }
    
}
