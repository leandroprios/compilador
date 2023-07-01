package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.sentencias.Asignacion;
/**
 *
 * @author julianzabala
 */
public class IncrementoDecrementoFor  extends Expresion{
    
    private String operacion;
    private Asignacion asignacion;

    public IncrementoDecrementoFor(Asignacion asignacion) {
        this.setOperacion(operacion);
        this.setNombre(operacion);
        this.setAsignacion(asignacion);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public void setAsignacion(Asignacion asignacion){
        this.asignacion = asignacion;
    }
    
    public Asignacion getAsignacion(){
        return this.asignacion;
    }
    
    public void setOperacion(String operacion){
        this.operacion = operacion;
    }
    
    public String getOperacion(){
        return this.operacion;
    }

    public Expresion clonar() {
        return new IncrementoDecrementoFor((Asignacion)this.getAsignacion());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El IncrementoDecrementoFor no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El IncrementoDecrementoFor no soporta reemplazar la expresion derecha."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
        @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = asignacion.graficar(idPadre);
        return grafico;
    }
 
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.getTipo();
    }

    
    @Override
    public String generarCodigo() {
        String codigo = this.getAsignacion().generarCodigo();
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
