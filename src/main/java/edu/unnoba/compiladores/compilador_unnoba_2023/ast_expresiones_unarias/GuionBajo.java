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
    
        
    public GuionBajo(String valor,EnteroAFlotante enteroAFlotante, Tipo tipo, String nombreVar){
        setNombre(valor);
        this.enteroAFlotante = enteroAFlotante;
        this.nombreVar = nombreVar;
        setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public GuionBajo(String valor, Tipo tipo, String nombreVar){
        setNombre(valor);
        this.enteroAFlotante = null;
        this.nombreVar = nombreVar;
        setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }


    @Override
    public Expresion clonar() {
        GuionBajo nuevoGuionBajo = new GuionBajo(this.getNombre(), this.getTipo(), this.nombreVar);
        if(this.enteroAFlotante != null){
            nuevoGuionBajo = new GuionBajo(this.getNombre(), (EnteroAFlotante)this.enteroAFlotante.clonar(),this.getTipo(), this.nombreVar);
        }
        return nuevoGuionBajo;
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.setNombre("ID : "+ valor + " \n <" + Tipo.toString(tipo) + ">" );
        this.setTipo(tipo);
        this.nombreVar = valor;
        //if(this.getTipo() == Tipo.FLOAT){
        if(tipo == Tipo.INTEGER && this.getTipo() == Tipo.FLOAT){
            if (this.enteroAFlotante == null) this.enteroAFlotante = new EnteroAFlotante(this.clonar());
            this.enteroAFlotante.reemplazarExpresionIzquierda(valor, tipo);
        }else{
            this.enteroAFlotante = null;
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

    @Override
    public String generarCodigo() {
        String codigo = "";
        if (this.enteroAFlotante != null){
            codigo = this.enteroAFlotante.generarCodigo();
            codigo += "%var"+getIdVar()+" = sitofp i32 %var"+this.enteroAFlotante.getIdVar()+" to double\n";
        }else{
            codigo += "store "+this.get_llvm_type_code()+" %var"+this.getIdVar()+", "+this.get_llvm_type_code()+"* @"+this.nombreVar+"\n";
        }
        
        return codigo;
       
       

        //return "%var"+getIdVar()+" = load "+get_llvm_type_code()+", "+get_llvm_type_code()+"* @"+getNombre()+"\n";

        //return "";
    }
    
    
    
}
