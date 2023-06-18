package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class Expresion extends Nodo {
    
    private String resultadoExpresion; 
    
    private String idVarInicialExpresion;
    
    private String idVarAnterior;
    
    private String llamadoDesdeExpresion; //guarda el nombre de la variable de llvm
    
    private boolean leerResultado = false; //le avisa a las expresiones si tienen que leer el resultado
    
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
    
    public void setIdVarAnterior(String idVarAnterior){
        this.idVarAnterior = idVarAnterior;
    }
    
    public String getIdVarAnterior(){
        return this.idVarAnterior;
    }
    
    public void setIdVarInicialExpresion(String idVarInicialExpresion){
        this.idVarInicialExpresion = idVarInicialExpresion;
    }
    
    public String getIdVarInicialExpresion(){
        return this.idVarInicialExpresion;
    }
    
    public void setllamadoDesdeExpresion(String llamadoDesdeExpresion){
        this.llamadoDesdeExpresion = llamadoDesdeExpresion;
    }
    
    public String getllamadoDesdeExpresion(){
        return this.llamadoDesdeExpresion;
    }
    
    public void setLeerResultado(boolean leerResultado){
        this.leerResultado = leerResultado;
    }
    
    public boolean getLeerResultado(){
        return this.leerResultado;
    }
    
    public boolean isExpresionLogica(){
        boolean retorno = false;
        if(this.getNombre().equals("OR") || this.getNombre().equals("AND") || this.getNombre().equals("NOT") 
        || this.getNombre().equals("!=") || this.getNombre().equals("==")){
            retorno = true;
        }
        return retorno;
    }

     public abstract Expresion clonar();
     
    public abstract Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo);
     
    public abstract Expresion reemplazarExpresionDerecha(String valor, Tipo tipo);

     
    public abstract Tipo getTipoExpresionDerecha();
    
    public abstract boolean ComparacionFor(String var);
}
