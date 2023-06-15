package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class Expresion extends Nodo {
    
    private String resultadoExpresion; 
    
    private String llamadoDesdeExpresion; //guarda el nombre de la variable de llvm
    
    private String ir_ref;

    public Expresion() {
    }
    
    public String getIr_ref() {
        return ir_ref;
    }

    public void setIr_ref(String ir_ref) {
        this.ir_ref = ir_ref;
    }
    
    public String getValorConstante(){
        String retorno = "";
        if(getNombre() != null){
            retorno = this.getNombreResultadoComparacion()+" = load "+get_llvm_type_code()+", "+get_llvm_type_code()+"* @"+getNombre()+"\n";
        }else{
            
            retorno = "store i1 %var_resultado, i1* " + this.getIdVar();
        }
        return retorno;
    }
    
    public String getNombreResultadoComparacion(){
        return "%varResult" + this.getIdVar();
    }
    
    public String getResultadoComparacion(){
        return this.getNombreResultadoComparacion() +" = add i1 0, 0\n";
    }
    
    public void setResultadoExpresion(String resultadoExpresion){
        this.resultadoExpresion = resultadoExpresion;
    }
    
    public String getResultadoExpresion(){
        return this.resultadoExpresion;
    }
    
    public void setllamadoDesdeExpresion(String llamadoDesdeExpresion){
        this.llamadoDesdeExpresion = llamadoDesdeExpresion;
    }
    
    public String getllamadoDesdeExpresion(){
        return this.llamadoDesdeExpresion;
    }

     public abstract Expresion clonar();
     
     public abstract Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo);
     
    public abstract Expresion reemplazarExpresionDerecha(String valor, Tipo tipo);

     
    public abstract Tipo getTipoExpresionDerecha();
    
    public abstract boolean ComparacionFor(String var);
}
