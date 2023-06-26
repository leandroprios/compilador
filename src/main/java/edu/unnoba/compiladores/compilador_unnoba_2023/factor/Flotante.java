package edu.unnoba.compiladores.compilador_unnoba_2023.factor;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Julian 
 */
public class Flotante extends Literal {
    private final Float valor;

    public Flotante(Float valor) {
        setTipo(Tipo.FLOAT);
        this.valor = valor;
        setNombre("Float");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public Expresion clonar() {
        return new Flotante(this.valor);
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Flotante no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Flotante no soporta reemplazar la expresion derecha."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String generarCodigo(){
        this.setResultadoExpresion("%resultado"+ this.getIdVar());
        return "%var"+getIdVar()+" = fadd double 0.0, "+getValor()+"\n";
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
