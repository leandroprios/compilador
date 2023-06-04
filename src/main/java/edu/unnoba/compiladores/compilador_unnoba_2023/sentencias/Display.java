package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Julian
 */
public class Display extends Sentencia{
    
    private Expresion display;
   
    public Display(Expresion display){
        setNombre("DISPLAY");
        this.display = display;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }   

    public Expresion getDisplay() {
        return display;
    }

    public void setDisplay(Expresion display) {
        this.display = display;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += display.graficar(getId());
        return grafico;
    }   
    
}
