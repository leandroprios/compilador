package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;

/**
 *
 * @author julian
 */
public class NegacionAritmetica extends OperacionUnaria {
    private String operacion;
    
   public NegacionAritmetica(Expresion expresion, String operacion, Tipo tipo) {
        super("-", expresion, tipo);
        this.operacion = operacion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public Expresion clonar() {
        return new NegacionAritmetica(this.getExpresion().clonar(),this.getNombre(),this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.getExpresion().reemplazarExpresionIzquierda(valor, tipo);
        return this.clonar();  
    }

    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        this.getExpresion().reemplazarExpresionDerecha(valor, tipo);
        return this.clonar();  
    }
    
    
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.getTipo();
    }
    
        
    @Override
    public String generarCodigo(){
        this.setResultadoExpresion("%var"+ this.getIdVar());
        StringBuilder codigo = new StringBuilder();     
        codigo.append(this.getExpresion().generarCodigo());
        if(getExpresion().getTipo() == Tipo.INTEGER){
            codigo.append(String.format("%%var%s = %s %s 0, %%var%s\n", this.getIdVar(), this.getOperacion(), this.get_llvm_type_code(), this.getExpresion().getIdVar()));
        }else if(getTipo() == Tipo.FLOAT){
            codigo.append(String.format("%%var%s = %s %s 0.0,%%var%s\n", this.getIdVar(), this.getOperacion(), this.get_llvm_type_code(), this.getExpresion().getIdVar()));
        }
        //codigo.append(String.format("store i1 %%var%s , i1* @resultado\n",this.getIdVar()));
        if(this.getLeerResultado()) {
            codigo.append(String.format("%%resultadoLoad%s = load i1, i1* @resultado\n",this.getIdVar()));
            this.setResultadoExpresion("%resultadoLoad"+ this.getIdVar());
        }
        
        return codigo.toString();
    }

    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fsub" : "sub";
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
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + this.getExpresion().graficar(miId);
        return grafico;
    }
    
}