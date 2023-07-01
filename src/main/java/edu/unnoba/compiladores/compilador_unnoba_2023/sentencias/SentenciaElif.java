/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Filter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julianzabala
 */
public class SentenciaElif extends Sentencia {
    ArrayList<Sentencia> sentencias;
    Expresion expresion;
    
    private String etiquetaSiguiente;
    private String idVarEndIf;
    
    private String idVarFor;
    ArrayList<Filter> sentenciasFilter;

    
    public SentenciaElif(ArrayList<Sentencia> sentencias, Expresion expresion){
        setNombre("ELIF");
        this.sentencias = sentencias;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public void setSentenciaArrayFilter(ArrayList<Filter> filters){
        this.sentenciasFilter= filters;
    }
    
    public String getGraficosFilterAsignacion(String idPadre){
        String grafico = "";
        for (Filter filter : this.sentenciasFilter) {
            grafico += filter.graficar(idPadre);
        }
        return grafico;
    }
    
    public String getCodigoFilter(){
        String codigo = "";
        for (Filter filter : this.sentenciasFilter) {
            codigo += filter.generarCodigo();
        }
        return codigo;
    }
    
    public void setEtiquetaSiguiente(String etiqueta){
        this.etiquetaSiguiente =etiqueta;
    }
    
    public void setIdVarEndIf(String idVarEndIf){
        this.idVarEndIf =idVarEndIf;
    }
    
    
    public void setIdVarFor(String idVarFor){
        this.idVarFor = idVarFor;
    }
    
    public String getIdVarFor(){
        return this.idVarFor;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
       
        Random random = new Random();
        String grafico;
        if(sentenciasFilter !=null && !sentenciasFilter.isEmpty()){
            this.expresion = expresion.clonar();
            grafico = this.getGraficosFilterAsignacion(idPadre) +
            super.graficar(idPadre) +
            expresion.graficar(miId);
        }else{
            grafico = super.graficar(idPadre) + 
            expresion.graficar(miId);
        }
        
        String idThenIf = "nodo_";
        idThenIf = idThenIf + random.nextInt(1000000000);
        grafico = grafico + miId + "--" + idThenIf + "\n" 
        + idThenIf + "[label=\"THEN" + "\"]\n";
        
        for(Sentencia sen : sentencias){
            grafico += sen.graficar(idThenIf);
        }
        

        
        return grafico;
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        
        if(sentenciasFilter !=null && !sentenciasFilter.isEmpty())codigo += this.getCodigoFilter();

        this.expresion.setLeerResultado(true);
        codigo += this.expresion.generarCodigo();
        this.expresion.setLeerResultado(false);
        codigo = codigo.concat(String.format("br i1 %%resultadoLoad%s, label %%etiqThenElif%s, label %s\n", this.expresion.getIdVar(), getIdVar(), this.etiquetaSiguiente));
        codigo = codigo.concat(String.format("etiqThenElif%s:\n", getIdVar()));

        for (Sentencia sentencia : sentencias) {
            if (sentencia.getNombre().equals("BREAK")){
                ((Break)sentencia).setIdVarFor(this.getIdVarFor());
            }
            if (sentencia.getNombre().equals("CONTINUE")){
                ((Continue)sentencia).setIdVarFor(this.getIdVarFor());
            }
            codigo += sentencia.generarCodigo();
        }
        codigo = codigo.concat(String.format("br label %%etiqEndIf%s\n", this.idVarEndIf));
       return codigo;
    }
}
