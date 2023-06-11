package edu.unnoba.compiladores.compilador_unnoba_2023.factor;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;


/**
 *
 * @author Nacho
 */
public class Entero extends Literal {
    
    private Integer valor;
    
    private EnteroAFlotante enteroAFlotante;

    public Entero(Integer valor) {
        setTipo(Tipo.INTEGER);
        this.valor = valor;
        setNombre("Integer");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Entero(Integer valor,EnteroAFlotante enteroAFlotante) {
        setTipo(Tipo.INTEGER);
        this.enteroAFlotante = enteroAFlotante;
        this.valor = valor;
        setNombre("Integer");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }


   @Override
    public Expresion clonar() {
        Entero enteroClonado= new Entero(this.valor);
        if (this.enteroAFlotante != null){
            enteroClonado= new Entero(this.valor, (EnteroAFlotante)this.enteroAFlotante.clonar());
        }
        return enteroClonado;
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Entero no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        if(tipo == Tipo.FLOAT){
            if (this.enteroAFlotante == null) this.enteroAFlotante = new EnteroAFlotante(this.clonar());
            this.enteroAFlotante.reemplazarExpresionIzquierda(valor, tipo);
        }else{
            this.enteroAFlotante = null;
        }
        return this.clonar();
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return true;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.getTipo();
    }

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = "";
        
        if(this.enteroAFlotante != null){
            grafico += enteroAFlotante.graficar(idPadre);
        }else{
            grafico += super.graficar(idPadre);
        }

        return grafico;
    }

    @Override
    public String generarCodigo(){
        String codigo = ""; 
        codigo += "%var"+getIdVar()+" = add i32 0, "+getValor()+"\n";
        if (this.enteroAFlotante != null){
            codigo += "%var"+this.enteroAFlotante.getIdVar()+" = sitofp i32 %var"+this.getIdVar()+" to double\n";
            this.setIdVar(this.enteroAFlotante.getIdVar());
            //codigo = this.enteroAFlotante.generarCodigo();
        }
        return codigo;
    }
    
}
