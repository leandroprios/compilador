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
public class Continue extends Sentencia{
    
    private String idVarFor;
    
    public Continue(){
        setNombre("CONTINUE");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    public void setIdVarFor(String idVarFor){
        this.idVarFor = idVarFor;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        //grafico += super.graficar("CONTINUE");
        return grafico;
    }

    @Override
    public String generarCodigo() {
        String codigo =String.format("br label %%etiqIncreDecremFor%s\n", this.idVarFor);
        return codigo;    
    }
    
}
