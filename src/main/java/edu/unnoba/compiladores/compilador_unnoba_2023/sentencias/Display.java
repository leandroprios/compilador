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
                
                /*codigo += "%formatString = alloca [6 x i8]\n";
                codigo +="%trueString = alloca [5 x i8]\n";
                codigo +="%falseString = alloca [6 x i8]\n";
  
                //Formato de la cadena para imprimir
                codigo +="%format = c\"%s\\0\"\n";
                codigo +="store [6 x i8] c\"%s\\0\", [6 x i8]* %formatString\n";
  
                //Cadenas para "verdadero" y "falso"
                codigo +="store [5 x i8] c\"true\\0\", [5 x i8]* %trueString\n";
                codigo +="store [6 x i8] c\"false\\0\", [6 x i8]* %falseString\n";
  
                //Selección de cadena según el valor booleano
                codigo+="%selectedString = select i1 "+getDisplay().getIdVar()+", [5 x i8]* %trueString, [6 x i8]* %falseString\n";

                codigo += "call i32 (i8*, ...) @printf(i8* getelementptr ([6 x i8], [6 x i8]* %formatString, i32 0, i32 0), i8* getelementptr ([0 x i8], [0 x i8]* %selectedString, i32 0, i32 0))\n";
                */
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i1"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            default:
                codigo += "%dest"+getIdVar()+" = call i32 @puts(i8* getelementptr (["+(getCantidadDigitos()+1)+" x i8], ["+(getCantidadDigitos()+1)
                        +" x i8] * @str"+getDisplay().getIdVar()+", i32 0, i32 0))\n";
                break;
        }
        return codigo;
    }
    
}
