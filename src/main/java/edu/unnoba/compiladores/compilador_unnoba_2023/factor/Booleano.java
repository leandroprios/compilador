package edu.unnoba.compiladores.compilador_unnoba_2023.factor;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Nacho
 */
public class Booleano extends Literal {
     private final Boolean valor;

    public Booleano(Boolean valor) {
        setTipo(Tipo.BOOLEAN);
        this.valor = valor;
        setNombre("Boolean");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public String toString() {        
        return valor.toString();
    }

    @Override
    public Expresion clonar() {
        return new Booleano(this.valor);
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Booleano no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        return this.getTipo();
    }

    @Override
    public String generarCodigo(){
        String codigo = ";entro al BOOLEAN " + this.getIdVar() + "\n";
        codigo += (getValor()) ? "%var"+this.getIdVar()+" = add i1 0, 1\n" : "%var"+this.getIdVar()+" = add i1 0, 0\n";
        codigo += "store i1 %var"+this.getIdVar()  + ", i1* @resultado\n";
        this.setResultadoExpresion("%var"+this.getIdVar());
        if(this.getLeerResultado()) {
            codigo += "%resultadoLoad"+ this.getIdVar()+  " = load i1, i1* @resultado\n";
            this.setResultadoExpresion("%resultadoLoad"+ this.getIdVar());
        }
        return codigo;
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