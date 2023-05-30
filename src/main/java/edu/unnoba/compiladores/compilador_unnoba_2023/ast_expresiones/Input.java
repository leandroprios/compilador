 package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.factor.Constante;

/**
 *
 * @author Julian
 */
public class Input extends Expresion{
    public Input(Tipo tipo, String nombre){
        super.setNombre(nombre);
        super.setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    

    @Override
    public Expresion clonar() {
         return new Input(this.getTipo(), this.getNombre());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Input no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = idPadre + "--" + this.getId() + "\n" +
        this.getId() + "[label=\"" + this.getEtiqueta() + "<" +Tipo.toString(this.getTipo()) + ">" + "\"]\n";
        return grafico;
    }

    @Override
    public Tipo getTipoExpresionDerecha() {
        return getTipo();
    }
}
