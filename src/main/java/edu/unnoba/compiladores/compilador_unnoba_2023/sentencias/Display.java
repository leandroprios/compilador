package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author Julian
 */
public class Display extends Sentencia{
    
    private Expresion display;
   
    private Integer cantidadDigitos;
    
    public Display(Expresion display, Integer cantidadDigitos){
        setNombre("DISPLAY");
        this.display = display;
        this.cantidadDigitos= cantidadDigitos;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Display(Expresion display){
        setNombre("DISPLAY");
        this.display = display;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
        this.cantidadDigitos = 0;
    }   

    public Expresion getDisplay() {
        return display;
    }

    public void setDisplay(Expresion display) {
        this.display = display;
    }
    
    public Integer getCantidadDigitos() {
        return cantidadDigitos;
    }
    
    public void setCantidadDigitos(Integer cantidadDigitos) {
        this.cantidadDigitos = cantidadDigitos;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += display.graficar(getId());
        return grafico;
    }
    
        @Override
    public String generarCodigo() {
        this.display.setResultadoExpresion("%resultado"+ this.getIdVar());
        this.display.setllamadoDesdeExpresion(this.getNombre());
        this.display.setLeerResultado(true);

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
                codigo +="call void @printBool(i1 %var" + getDisplay().getIdVar() + ")\n"; //llamo a la funcion
                break;
            default:
                codigo += "%dest"+getIdVar()+" = call i32 @puts(i8* getelementptr (["+(getCantidadDigitos()+1)+" x i8], ["+(getCantidadDigitos()+1)
                        +" x i8] * @str"+getDisplay().getIdVar()+", i32 0, i32 0))\n";
                break;
        }
        this.display.setLeerResultado(false);
        return codigo;
    }
    
}
