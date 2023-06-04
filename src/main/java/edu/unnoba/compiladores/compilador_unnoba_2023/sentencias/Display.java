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
    
        @Override
    public String generarCodigo() {
        String codigo = "";
        switch (getDisplay().getTipo()){
            case INTEGER:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            case FLOAT:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            case BOOLEAN:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i1"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            /*default:
                codigo += "%dest"+getIdVar()+" = call i32 @puts(i8* getelementptr (["+(getCantidadDigitos()+1)+" x i8], ["+(getCantidadDigitos()+1)
                        +" x i8] * @str"+getDisplay().getIdVar()+", i32 0, i32 0))\n";
                break;*/
        }
        return codigo;
    }
    
}
