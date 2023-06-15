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
        this.setResultadoExpresion("%varResultadoCondicion" + this.getIdVar());
        this.setllamadoDesdeExpresion("");
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
        String codigo = "";
        
        if(this.getllamadoDesdeExpresion().equals("")){
            this.setllamadoDesdeExpresion(this.getIdVar());
            codigo += "%resultadoOr" + this.getIdVar() +  " = alloca i1\n";
        }
        
        
        this.getIzquierda().setResultadoExpresion("%var" + this.getIdVar());
        this.getIzquierda().setllamadoDesdeExpresion(this.getIdVar());

        codigo += getIzquierda().generarCodigo();
        codigo += "\n";
        
        codigo += "store i1 "+ this.getIzquierda().getResultadoExpresion()  + ", i1*%resultadoOr" + this.getllamadoDesdeExpresion() +  "\n";
        

        this.setResultadoExpresion(this.getIzquierda().getResultadoExpresion());
        

        
        //codigo = codigo.concat("br i1 %resultadoOrLoad2"+ this.getIdVar() + ", label %etiqTrueCondicionIzquierdaAnd" + this.getIdVar() + ", label %etiqFinAnd" + this.getIdVar() + "\n");

        codigo = codigo.concat("br i1 " + this.getIzquierda().getResultadoExpresion() + ", label %etiqTrueCondicionIzquierdaAnd" + this.getIdVar() + ", label %etiqFinAnd" + this.getIdVar() + "\n");
        codigo += "\n";
                
        codigo = codigo.concat(String.format("etiqTrueCondicionIzquierdaAnd%s:\n", this.getIdVar()));
 
        this.getDerecha().setllamadoDesdeExpresion(this.getIdVar());

        codigo += getDerecha().generarCodigo();
        
        codigo += "store i1 "+ this.getDerecha().getResultadoExpresion()  + ", i1*%resultadoOr" + this.getllamadoDesdeExpresion() +  "\n";

        //codigo += "%resultadoOrLoad2"+ this.getIdVar() +  " = load i1, i1*%resultadoOr" + this.getllamadoDesdeExpresion() +  "\n";

        
        codigo += "\n";
        

        this.setResultadoExpresion(this.getDerecha().getResultadoExpresion());
        
        codigo += "\n";

        codigo = codigo.concat(String.format("br label %%etiqFinAnd%s\n", this.getIdVar()));
        
        codigo = codigo.concat(String.format("etiqFinAnd%s:\n", this.getIdVar()));
        
        codigo += "%resultadoOrLoad"+ this.getIdVar() +  " = load i1, i1*%resultadoOr" + this.getllamadoDesdeExpresion() +  "\n";

        
        
        this.setResultadoExpresion("%resultadoOrLoad"+ this.getIdVar());

        this.setIdVar(this.getResultadoExpresion());
        
        //this.setIdVar(this.getResultadoExpresion());
        //this.setIdVar("%resultadoOr" + this.getllamadoDesdeExpresion());
        
        codigo += "\n";
        return codigo;
    }
    
    @Override
    public String get_llvm_name() {
        return llvm_name;
    }

}
