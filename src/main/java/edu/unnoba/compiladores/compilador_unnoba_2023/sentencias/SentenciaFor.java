/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.OperacionBinaria;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_unarias.IncrementoDecrementoFor;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julianzabala
 */
public class SentenciaFor extends Sentencia{
    Expresion operacion;
    Asignacion asignacion;
    IncrementoDecrementoFor expresionFor;
    ArrayList<Sentencia> sentencias;
    
    
    public SentenciaFor(Expresion operacion, Asignacion asignacion, IncrementoDecrementoFor expresionFor, ArrayList<Sentencia> sentencias){
        setNombre("FOR");
        this.operacion = operacion;
        this.asignacion = asignacion;
        this.expresionFor = expresionFor;
        this.sentencias = sentencias;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
        asignacion.graficar(miId) +
        expresionFor.graficar(miId) + 
        operacion.graficar(miId);
        
        Random random = new Random();
        
        String idDo = "nodo_";
        idDo = idDo + random.nextInt(1000000000);
        grafico = grafico + miId + "--" + idDo + "\n" 
        + idDo + "[label=\"DO" + "\"]\n";

        for(Sentencia sen : sentencias){
            grafico += sen.graficar(idDo);
        }
        return grafico;
    }
    
    public String generarCodigoRepetidoInBucle(int contador){
        String codigo = "";
        codigo = codigo.concat(this.operacion.generarCodigo());
        codigo = codigo.concat("br i1 %var" + this.operacion.getIdVar() + ", label %etiqDoFor" + this.getIdVar() + contador + ", label %etiqEndFor" + this.getIdVar() + contador + "\n");
        codigo = codigo.concat("etiqDoFor" + this.getIdVar() + "\n");
        codigo = codigo.concat(this.expresionFor.generarCodigo());
        if(this.expresionFor.getOperacion().equals("++")){
            codigo = codigo.concat("%var"+this.getIdVar() + " = add i32 @"+ this.asignacion.getIdent().getNombreVar() + " %var" + this.expresionFor.getIdVar()+"\n");
        }else{
            codigo = codigo.concat("%var"+this.getIdVar() + " = sub i32 @"+ this.asignacion.getIdent().getNombreVar() + " %var" + this.expresionFor.getIdVar()+"\n");
        }
        
        return codigo;
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        
        codigo = codigo.concat(this.asignacion.generarCodigo());
        
        codigo = codigo.concat(String.format("br label %%etiqForCondicion%s\n", this.getIdVar()));
        codigo = codigo.concat("etiqForCondicion" + this.getIdVar() + ":\n");
        codigo = codigo.concat(this.expresionFor.generarCodigo());
       
        codigo = codigo.concat(this.operacion.generarCodigo());


        codigo = codigo.concat("br i1 %var" + this.operacion.getIdVar() + ", label %etiqCuerpoFor" + this.getIdVar() + ", label %etiqEndFor" + this.getIdVar() + "\n");
        codigo = codigo.concat("etiqCuerpoFor" + this.getIdVar() + ":\n");
        for(Sentencia s : this.sentencias){
            if (s.getNombre().equals("BREAK")){
                ((Break)s).setIdVarFor(this.getIdVar());
            }
            if (s.getNombre().equals("CONTINUE")){
                ((Continue)s).setIdVarFor(this.getIdVar());
            }
            codigo = codigo.concat(s.generarCodigo());
        }
        
        
        codigo +=String.format("br label %%etiqIncreDecremFor%s\n", this.getIdVar());
        
        codigo = codigo.concat("etiqIncreDecremFor" + this.getIdVar() + ":\n");

        if(this.expresionFor.getOperacion().equals("++")){
            codigo = codigo.concat("%var"+this.getIdVar() + " = add i32 %var"+ this.expresionFor.getExpresion().getIdVar() + ", %var" + this.expresionFor.getIdVar()+"\n");
        }else{
            codigo = codigo.concat("%var"+this.getIdVar() + " = sub i32 %var"+ this.expresionFor.getExpresion().getIdVar() + ", %var" + this.expresionFor.getIdVar()+"\n");
        }
        codigo = codigo.concat("store " +  this.asignacion.getIdent().get_llvm_type_code() + " %var"+ this.getIdVar() + ", " + this.asignacion.getIdent().get_llvm_type_code() + "* @" + this.asignacion.getIdent().getNombreVar() + "\n");
        
        codigo = codigo.concat(String.format("br label %%etiqForCondicion%s\n", this.getIdVar()));
        codigo = codigo.concat("etiqEndFor" + this.getIdVar() + ":\n");
        
        return codigo;
    }
    
}
