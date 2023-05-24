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

/**
 *
 * @author zabal
 */
public class GuionBajo extends Expresion {
    
    public GuionBajo(String valor){
        setNombre(valor);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    @Override
    public Expresion clonar() {
        return new GuionBajo(this.getNombre());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor) {
        this.setNombre(valor);
        return this.clonar();
    }
    
}
