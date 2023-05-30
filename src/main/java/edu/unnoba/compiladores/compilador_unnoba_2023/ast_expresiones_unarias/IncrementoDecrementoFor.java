package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones.Identificador;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
/**
 *
 * @author julianzabala
 */
public class IncrementoDecrementoFor  extends OperacionUnaria{
    
    
    public IncrementoDecrementoFor(Identificador identificador, String operacion, Tipo tipo) {
        super(operacion, identificador, tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    @Override
    public Expresion clonar() {
        return new IncrementoDecrementoFor((Identificador)this.getExpresion(),this.getNombre(),this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El IncrementoDecrementoFor no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
        @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = idPadre + "--" + ((Identificador)this.getExpresion()).getId() + "\n" +
        ((Identificador)this.getExpresion()).getId() + "[label=\"ID : " + ((Identificador)this.getExpresion()).getEtiqueta() + "\"]\n"
        + idPadre + "--" + this.getId() + "\n" 
        + this.getId() + "[label=\"" + this.getEtiqueta() + "\"]\n";
        return grafico;
    }
 
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.getTipo();
    }

}
