package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.factor.Constante;



/**
 *
 * @author Julian
 */
public class Identificador extends Constante {
    
    private String nombreVar = "ID";

    public Identificador(String nombre, Tipo tipo) {
        setTipo(tipo);
        setNombre(nombre);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getNombreVar() {
        return nombreVar;
    }

    public void setNombreVar(String nombreVar) {
        this.nombreVar = nombreVar;
    }
    
    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", super.getNombre(), getTipo().toString());
    }
    
    @Override
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.nombreVar, this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }

    @Override
    public Expresion clonar() {
        return new Identificador(this.getNombre(), this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        throw new UnsupportedOperationException("El Identificador no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}

