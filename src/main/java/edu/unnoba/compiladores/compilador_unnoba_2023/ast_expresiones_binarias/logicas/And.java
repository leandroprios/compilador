package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.logicas;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.OperacionBinaria;

/**
 *
 * @author julianzabala
 */
public class And extends OperacionBinaria{
    
    //private String resultadoExpresion; //guarda el nombre de la variable de llvm
    
    public And(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
        this.setNombre("AND");
    }
    

    
    @Override
    protected String getNombreOperacion() {
        return "AND";
    }
    
    @Override
    public Expresion clonar() {
        return new And(this.izquierda.clonar(), this.derecha.clonar());
    }
    
    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        return this.izquierda.reemplazarExpresionIzquierda(valor, tipo);
    }

    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
       this.derecha.reemplazarExpresionDerecha(valor, tipo);
       return this.clonar();
    }
    
    @Override
    public boolean ComparacionFor(String var) {
        return false;
    }
    
    @Override
    public Tipo getTipoExpresionDerecha() {
        return this.derecha.getTipoExpresionDerecha();
    }

    
    @Override
    public String get_llvm_op_code() {
        return "and";
    }
    
    @Override
    public String generarCodigo(){
        this.setResultadoExpresion("%resultadoLoad"+ this.getIdVar());

        String codigo = "";
        codigo += ";entro al AND " + this.getIdVar() + "\n";
        this.getIzquierda().setLeerResultado(true);
        this.getDerecha().setLeerResultado(true);

        codigo += getIzquierda().generarCodigo();
        codigo += "\n";
        codigo = codigo.concat("br i1 " + this.getIzquierda().getResultadoExpresion()+ ", label %etiqTrueCondicionIzquierdaAnd" + this.getIdVar() + ", label %etiqFinAnd" + this.getIdVar() + "\n");
        
        codigo += "\n";         
        codigo = codigo.concat(String.format("etiqTrueCondicionIzquierdaAnd%s:\n", this.getIdVar()));
 
        codigo += getDerecha().generarCodigo();
        codigo += "\n";
        

        codigo = codigo.concat(String.format("br label %%etiqFinAnd%s\n", this.getIdVar()));
        codigo = codigo.concat(String.format("etiqFinAnd%s:\n", this.getIdVar()));
        
        codigo += "\n";
        if(this.getLeerResultado()) codigo += "%resultadoLoad"+ this.getIdVar()+  " = load i1, i1* @resultado\n";
        codigo += "\n";
        
        return codigo;
    }
    
    @Override
    public String get_llvm_name() {
        return llvm_name;
    }

}
