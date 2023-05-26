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
    }
    
        @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        //grafico += super.graficar("BREAK");
        return grafico;
    }
}
