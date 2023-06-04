/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;

/**
 *
 * @author julianzabala
 */
public class Break extends Sentencia{
    
    public Break(){
        setNombre("BREAK");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
        @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        //grafico += super.graficar("BREAK");
        return grafico;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
