/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unnoba.compiladores.compilador_unnoba_2023.sentencias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Filter;
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
    ArrayList<Filter> sentenciaFilter;
    ArrayList<Filter> sentenciaFilterComparacion;

    
    
    
    public SentenciaFor(Expresion operacion, Asignacion asignacion, IncrementoDecrementoFor expresionFor, ArrayList<Sentencia> sentencias){
        setNombre("FOR");
        this.operacion = operacion;
        this.asignacion = asignacion;
        this.expresionFor = expresionFor;
        this.sentencias = sentencias;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    public void setFilterAsignacion(ArrayList<Filter> filters){
        this.sentenciaFilter = filters;
    }
    
    
    public void setFilterComparacion(ArrayList<Filter> filters){
        this.sentenciaFilterComparacion = filters;
    }
    
    
    
    public String getGraficosFilterAsignacion(String idPadre){
        String grafico = "";
        for (Filter filter : this.sentenciaFilter) {
            grafico += filter.graficar(idPadre);
        }
        return grafico;
    }
    
    public String getGraficosFilterComparacion(String idPadre){
        String grafico = "";
        for (Filter filter : this.sentenciaFilterComparacion) {
            grafico += filter.graficar(idPadre);
        }
        return grafico;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        String grafico;
        if(sentenciaFilter !=null){
            grafico =  this.getGraficosFilterAsignacion(idPadre);
            if(this.sentenciaFilterComparacion !=null && !this.sentenciaFilterComparacion.isEmpty()) grafico += this.getGraficosFilterComparacion(idPadre);
            grafico += super.graficar(idPadre) +
            asignacion.graficar(miId) +
            expresionFor.graficar(miId);
            //if(this.sentenciaFilterComparacion !=null && !this.sentenciaFilterComparacion.isEmpty()) grafico += this.getGraficosFilterComparacion(miId);
            grafico +=operacion.graficar(miId);
        }else{
            grafico = "";
            if(this.sentenciaFilterComparacion !=null && !this.sentenciaFilterComparacion.isEmpty()) grafico += this.getGraficosFilterComparacion(idPadre);
            grafico += super.graficar(idPadre) + 
            asignacion.graficar(miId) +
            expresionFor.graficar(miId);
            //if(this.sentenciaFilterComparacion !=null && !this.sentenciaFilterComparacion.isEmpty()) grafico += this.getGraficosFilterComparacion(miId);
            grafico +=operacion.graficar(miId);
        }
       
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
    
    public String getCodigoFilter(){
        String codigo = "";
        for (Filter filter : this.sentenciaFilter) {
            codigo += filter.generarCodigo();
        }
        return codigo;
    }
    
    public String getCodigoFilterComparacion(){
        String codigo = "";
        for (Filter filter : this.sentenciaFilterComparacion) {
            codigo += filter.generarCodigo();
        }
        return codigo;
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        if(sentenciaFilter !=null) codigo += this.getCodigoFilter();
        codigo = codigo.concat(this.asignacion.generarCodigo());
        codigo = codigo.concat(String.format("br label %%etiqForCondicion%s\n", this.getIdVar()));
        codigo = codigo.concat("etiqForCondicion" + this.getIdVar() + ":\n");
        if(sentenciaFilterComparacion !=null) codigo += this.getCodigoFilterComparacion();
        this.operacion.setLeerResultado(true);
        codigo = codigo.concat(this.operacion.generarCodigo());
        this.operacion.setLeerResultado(false);
        codigo = codigo.concat("br i1 " + this.operacion.getResultadoExpresion() + ", label %etiqCuerpoFor" + this.getIdVar() + ", label %etiqEndFor" + this.getIdVar() + "\n");
        codigo = codigo.concat("etiqCuerpoFor" + this.getIdVar() + ":\n");
        for(Sentencia s : this.sentencias){
            if (s.getNombre().equals("BREAK")){
                ((Break)s).setIdVarFor(this.getIdVar());
            }
            if (s.getNombre().equals("CONTINUE")){
                ((Continue)s).setIdVarFor(this.getIdVar());
            }
            if(s.getNombre().equals("IF")){
                ((SentenciaIf)s).setIdVarFor(this.getIdVar());
            }
            codigo = codigo.concat(s.generarCodigo());
        }
        
        
        codigo +=String.format("br label %%etiqIncreDecremFor%s\n", this.getIdVar());
        
        codigo = codigo.concat("etiqIncreDecremFor" + this.getIdVar() + ":\n");

        codigo += this.expresionFor.generarCodigo();
        
        codigo = codigo.concat(String.format("br label %%etiqForCondicion%s\n", this.getIdVar()));
        codigo = codigo.concat("etiqEndFor" + this.getIdVar() + ":\n");
        
        return codigo;
    }
    
}
