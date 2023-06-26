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
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Input no soporta reemplazar la expresion derecha."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    private String getTipo_llvm(Tipo tipo){
        return (tipo == Tipo.INTEGER) ? "i32" : ((tipo == Tipo.FLOAT) ? "double" : "i1");
    }
    
    @Override
    public String generarCodigo(){
        this.setResultadoExpresion("%resultado"+ this.getIdVar());

        StringBuilder codigo = new StringBuilder();
        codigo.append(String.format("%%temp%s = alloca %s\n", getIdVar(), getTipo_llvm(getTipo())));
        if(getTipo()==Tipo.INTEGER){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i32* %%temp%s)\n", getIdVar(), getIdVar()));
        }else if(getTipo()==Tipo.FLOAT){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.double_read_format, i64 0, i64 0), double* %%temp%s)\n", getIdVar(), getIdVar()));
        }
        else if(getTipo()==Tipo.BOOLEAN){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i1* %%temp%s)\n", getIdVar(), getIdVar()));
        }
        codigo.append(String.format("%%var%s = load %s, %s* %%temp%s\n", getIdVar(), getTipo_llvm(getTipo()), getTipo_llvm(getTipo()), getIdVar()));
        return codigo.toString();
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
