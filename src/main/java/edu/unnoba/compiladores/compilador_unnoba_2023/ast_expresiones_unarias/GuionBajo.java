/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.ExpresionFilter;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.logicas.Or;
import edu.unnoba.compiladores.compilador_unnoba_2023.factor.EnteroAFlotante;

/**
 *
 * @author zabal
 */
public class GuionBajo extends Expresion {
    
    private EnteroAFlotante enteroAFlotante;
    
        
    public GuionBajo(String valor,EnteroAFlotante enteroAFlotante){
        setNombre(valor);
        this.enteroAFlotante = enteroAFlotante;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public GuionBajo(String valor){
        setNombre(valor);
        this.enteroAFlotante = null;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }


    @Override
    public Expresion clonar() {
        GuionBajo nuevoGuionBajo = new GuionBajo(this.getNombre());
        if(this.enteroAFlotante != null){
            nuevoGuionBajo = new GuionBajo(this.getNombre(), this.enteroAFlotante);
        }
        return nuevoGuionBajo;
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        this.setNombre("ID : "+ valor + " \n <" + Tipo.toString(tipo) + ">" );
        if(tipo == Tipo.INTEGER && this.getTipo() == Tipo.FLOAT){
            System.out.println("entro al if  " + Tipo.toString(tipo));
            this.enteroAFlotante = new EnteroAFlotante(this.clonar());
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
    
    
    
}
