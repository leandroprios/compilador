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
public class SentenciaIf extends Sentencia{

    ArrayList<Sentencia> sentenciasIf;
    ArrayList<Sentencia> sentenciasElse;
    ArrayList<SentenciaElif> sentenciasElif;
    Expresion expresion;
    private String idVarFor;
    ArrayList<Filter> sentenciasFilter;

    
    
    public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
    /*public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion, Filter sentenciaFilter){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
        this.sentenciaFilter = sentenciaFilter;
    }*/
    
    
    
    public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion, ArrayList<SentenciaElif> sentenciasElif, ArrayList<Sentencia> sentenciasElse){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.sentenciasElse = sentenciasElse;
        this.sentenciasElif = sentenciasElif;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
    }
    
   /* public SentenciaIf(ArrayList<Sentencia> sentenciasIf, Expresion expresion, ArrayList<SentenciaElif> sentenciasElif, ArrayList<Sentencia> sentenciasElse,  Filter sentenciaFilter){
        setNombre("IF");
        this.sentenciasIf = sentenciasIf;
        this.expresion = expresion;
        this.sentenciasElse = sentenciasElse;
        this.sentenciasElif = sentenciasElif;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        this.IsExpresion = false;
        this.sentenciaFilter = sentenciaFilter;
    }*/
    
    public void setSentenciaArrayFilter(ArrayList<Filter> filters){
        this.sentenciasFilter= filters;
    }
    
    public ArrayList<Filter> getSentenciaArrayFilter(){
        return this.sentenciasFilter;
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
    
    public void setIdVarFor(String idVarFor){
        this.idVarFor = idVarFor;
    }
    
    public String getIdVarFor(){
        return this.idVarFor;
    }
    
    @Override
    public String graficar(String idPadre){
        final String miId = this.getId();
        
        String grafico;
        if(sentenciasFilter !=null){
            this.expresion = expresion.clonar();
            grafico = this.getGraficosFilterAsignacion(idPadre) + 
            super.graficar(idPadre) + 
            expresion.graficar(miId);
        }else{
            grafico = super.graficar(idPadre) + 
            expresion.graficar(miId);
        }
        
        Random random = new Random();

        String idThenIf = "nodo_";
        idThenIf = idThenIf + random.nextInt(1000000000);

        for (int i = 0; i<this.sentenciasIf.size() ; i++){
            Sentencia sen = this.sentenciasIf.get(i);
            if (sen.getEtiqueta().equals("Filter") && sen.IsExpresion==true){
                grafico += sen.graficar(miId);
            }else{
                grafico += sen.graficar(idThenIf);
            }
        }
        
        grafico = grafico + miId + "--" + idThenIf + "\n" 
        + idThenIf + "[label=\"THEN" + "\"]\n";
        
        if(this.sentenciasElif != null && !this.sentenciasElif.isEmpty()){
            for(SentenciaElif senElif : sentenciasElif){
                grafico += senElif.graficar(miId);
            }
        }

        if(this.sentenciasElse != null && !this.sentenciasElse.isEmpty()){
            String idElse = "nodo_";
            idElse = idElse + random.nextInt(1000000000);
            grafico += miId + "--" + idElse + "\n" 
            + idElse + "[label=\"ELSE" + "\"]\n";
            
            for(Sentencia senElse : sentenciasElse){
                grafico += senElse.graficar(idElse);
            }
        }
        
        
        return grafico;
    }
    
    public ArrayList<Filter> getSentenciasFilter() {
        return this.sentenciasFilter;
    }

    /*public void setSentenciaFilter(Filter filter) {
        this.sentenciaFilter = filter;
    }*/
    
    public ArrayList<Sentencia> getSentenciasIf() {
        return sentenciasIf;
    }

    public void setSentenciasIf(ArrayList<Sentencia> sentenciasIf) {
        this.sentenciasIf = sentenciasIf;
    }

    public ArrayList<Sentencia> getSentenciasElse() {
        return sentenciasElse;
    }

    public void setSentenciasElse(ArrayList<Sentencia> sentenciasElse) {
        this.sentenciasElse = sentenciasElse;
    }

    public ArrayList<SentenciaElif> getSentenciasElif() {
        return sentenciasElif;
    }

    public void setSentenciasElif(ArrayList<SentenciaElif> sentenciasElif) {
        this.sentenciasElif = sentenciasElif;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public String generarCodigo() {
        
        String codigo = "";
        Boolean tieneElse = this.sentenciasElse != null && !this.sentenciasElse.isEmpty();
        Boolean tieneElif = this.sentenciasElif != null && !this.sentenciasElif.isEmpty();
        
        
        
        if(this.getSentenciasFilter()!= null) codigo += this.getCodigoFilter();
        
        this.expresion.setLeerResultado(true);        

        codigo = codigo.concat(this.expresion.generarCodigo());
        
        this.expresion.setLeerResultado(false); 
        
        String siguienteIsIfEqualsFalse = "";
        
        if(tieneElif){
            siguienteIsIfEqualsFalse = "%etiqElif" + this.sentenciasElif.get(0).getIdVar();
        }else if(tieneElse){
            siguienteIsIfEqualsFalse = "%etiqThenElse" + this.getIdVar();
        }else{
            siguienteIsIfEqualsFalse = "%etiqEndIf" + this.getIdVar();
        }
        
        codigo = codigo.concat(String.format("br i1 %%resultadoLoad%s, label %%etiqThenIf%s, label %s\n", this.expresion.getIdVar(), getIdVar(), siguienteIsIfEqualsFalse));
        codigo = codigo.concat(String.format("etiqThenIf%s:\n", getIdVar()));
        for (Sentencia sentencia : sentenciasIf) {
            if (sentencia.getNombre().equals("BREAK")){
                ((Break)sentencia).setIdVarFor(this.getIdVarFor());
            }
            if (sentencia.getNombre().equals("CONTINUE")){
                ((Continue)sentencia).setIdVarFor(this.getIdVarFor());
            }
            codigo += sentencia.generarCodigo();
        }
        codigo = codigo.concat(String.format("br label %%etiqEndIf%s\n", getIdVar())); //salto de forma incondicional a la etiqueta etiqEndIf

        
        if(tieneElse || tieneElif){
                    
            if(tieneElif){

                for (int i = 0; i<this.sentenciasElif.size() ;i++) {
                    codigo = codigo.concat(String.format("etiqElif%s:\n", this.sentenciasElif.get(i).getIdVar()));

                    SentenciaElif sentElif = this.sentenciasElif.get(i);
                    
                    sentElif.setIdVarEndIf(this.getIdVar());

                    if (i + 1 == this.sentenciasElif.size()){ //NO TIENE MAS ELIF, 
                        if(tieneElse){ //si tiene ELSE, le digo al ELIF que el salto condicional por el FALSE es a la etiqueta  etiqThenElse
                            sentElif.setEtiquetaSiguiente(String.format("%%etiqThenElse%s", getIdVar()));
                        }else{ //NO tiene ELSE, le digo al ELIF que el salto condicional por el FALSE es a la etiqueta etiqEndIf
                            sentElif.setEtiquetaSiguiente(String.format("%%etiqEndIf%s", getIdVar()));
                        }
                        codigo += sentElif.generarCodigo();
                    }else{
                        SentenciaElif sentElifSiguiente = this.sentenciasElif.get(i+1); //obtengo el siguiente ELIF
                        String etiquetaSiguiente =String.format("%%etiqElif%s", sentElifSiguiente.getIdVar()); //obtengo la etiqueta del siguiente ELIF
                        
                        sentElif.setEtiquetaSiguiente(etiquetaSiguiente); //le paso la etiqueta del siguiente ELIF al actual ELIF
                        
                        codigo += sentElif.generarCodigo();
                    }
                }
            }

            if(tieneElse) {
                codigo = codigo.concat(String.format("etiqThenElse%s:\n", this.getIdVar()));
                for (Sentencia sentenciaELSE : sentenciasElse) {
                    if (sentenciaELSE.getNombre().equals("BREAK")){
                        ((Break)sentenciaELSE).setIdVarFor(this.getIdVarFor());
                    }
                    if (sentenciaELSE.getNombre().equals("CONTINUE")){
                        ((Continue)sentenciaELSE).setIdVarFor(this.getIdVarFor());
                    }
                    codigo = codigo.concat(sentenciaELSE.generarCodigo());
                }
                codigo = codigo.concat(String.format("br label %%etiqEndIf%s\n", this.getIdVar())); //salto de forma incondicional a la etiqueta etiqEndIf
            }
        }
        codigo = codigo.concat(String.format("etiqEndIf%s:\n", this.getIdVar()));

        return codigo;
    }
}
