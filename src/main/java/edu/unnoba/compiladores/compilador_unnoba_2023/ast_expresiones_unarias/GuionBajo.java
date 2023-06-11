/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.factor.EnteroAFlotante;

/**
 *
 * @author zabal
 */
public class GuionBajo extends Expresion {
    
    private EnteroAFlotante enteroAFlotante;
    private String nombreVar;
    private Tipo tipoVar;
    
        
    public GuionBajo(String valor,EnteroAFlotante enteroAFlotante, Tipo tipo, String nombreVar, Tipo tipoVar){
        setNombre(valor);
        this.enteroAFlotante = enteroAFlotante;
        this.nombreVar = nombreVar;
        this.tipoVar = tipoVar;
        this.setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public GuionBajo(String valor, Tipo tipo, String nombreVar, Tipo tipoVar){
        setNombre(valor);
        this.enteroAFlotante = null;
        this.nombreVar = nombreVar;
        this.tipoVar = tipoVar;
        this.setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }


    @Override
    public Expresion clonar() {
        GuionBajo nuevoGuionBajo = new GuionBajo(this.getNombre(), this.getTipo(), this.nombreVar, this.tipoVar);
        if(this.enteroAFlotante != null){
            nuevoGuionBajo = new GuionBajo(this.getNombre(), (EnteroAFlotante)this.enteroAFlotante.clonar(),this.getTipo(), this.nombreVar, this.tipoVar);
        }
        return nuevoGuionBajo;
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.setNombre("ID : "+ valor + " \n <" + Tipo.toString(tipo) + ">" );
        this.nombreVar = valor;
        //if(this.getTipo() == Tipo.FLOAT){
        this.tipoVar = tipo;
        if(tipo == Tipo.INTEGER && (this.getTipo() == Tipo.FLOAT || this.getTipo()==Tipo.UNKNOWN)){
            
            this.setTipo(Tipo.FLOAT);
            if (this.enteroAFlotante == null) this.enteroAFlotante = new EnteroAFlotante(this.clonar());
            this.enteroAFlotante.reemplazarExpresionIzquierda(valor, tipo);
        }else{
            this.enteroAFlotante = null;
            this.setTipo(tipo);
        }
        return this.clonar();
    }
    
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El GuionBajo no soporta reemplazar la expresion derecha."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return Tipo.UNKNOWN;
    }

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = "";
        if(this.enteroAFlotante != null){
            grafico = enteroAFlotante.graficar(idPadre);
        }else{
            grafico += super.graficar(idPadre);
        }

        return grafico;
    }
    
    public String get_llvm_type_var() {
        return this.tipoVar.equals(Tipo.FLOAT) ? "double" : (this.tipoVar.equals(Tipo.INTEGER) ? "i32" : "i1");
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        
        if (this.enteroAFlotante == null){
            codigo += "%var" + this.getIdVar() + "= load " + this.get_llvm_type_var() + ", " +this.get_llvm_type_var() + "* @"+this.nombreVar+"\n" ;
        }else{
            //codigo += "%var" + this.getIdVar() + "= alloca i32\n"; 
            codigo += this.enteroAFlotante.generarCodigo();
            this.setIdVar(this.enteroAFlotante.getIdVar());
            //codigo += "%var"+getIdVar()+" = sitofp i32 %var"+this.enteroAFlotante.getIdVar()+" to double\n";
        }/*else{
            //codigo += "%var" + this.getIdVar() + " = alloca " + this.get_llvm_type_code() + "\n"; 
            codigo += "%var" + this.getIdVar() + " load " + this.get_llvm_type_code() + "," +this.get_llvm_type_code() + "@"+this.nombreVar+"\n" ;
            
            //codigo += "store "+this.get_llvm_type_code()+" %var"+this.getIdVar()+", "+this.get_llvm_type_code()+"* @"+this.nombreVar+"\n";
        }*/
        
        return codigo;
    }
    
    
    
}
