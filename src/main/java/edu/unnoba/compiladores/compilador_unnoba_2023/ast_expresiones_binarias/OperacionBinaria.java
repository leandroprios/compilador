package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class OperacionBinaria extends Expresion {

    protected final Expresion izquierda;
    protected final Expresion derecha;

    public OperacionBinaria(Expresion izquierda, Expresion derecha, Tipo tipo) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        super.setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Expresion getIzquierda() {
        return izquierda;
    }

    public Expresion getDerecha() {
        return derecha;
    }


    @Override
    public String getEtiqueta() {
        return String.format("%s", this.getNombreOperacion());
    }

    protected abstract String getNombreOperacion();

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) +
                derecha.graficar(miId);
    }
    
    public abstract String get_llvm_op_code();

    public String get_llvm_arithmetic_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "fcmp" : "icmp";
    }
    
    @Override
    public String generarCodigo(){
        String codigo = "";
        String idVarIzquierda = this.getIzquierda().getIdVar();
        String idVarDerecha = this.getDerecha().getIdVar();
        if(get_llvm_op_code().equals("or")){
            codigo += getIzquierda().generarCodigo();
            codigo += "%varResultPuntero" + idVarIzquierda + " = alloca i1 \n";
            codigo += "store i1 %var" + idVarIzquierda  + ", i1* %varResultPuntero" + idVarIzquierda + "\n";
            codigo = codigo.concat("br i1 %var" + idVarIzquierda + ", label %etiqFinCondicionOr" + this.getIdVar() + ", label %etiqCondicionDerechaOr" + this.getIdVar() + "\n");
            codigo = codigo.concat(String.format("etiqCondicionDerechaOr%s:\n", this.getIdVar()));
            codigo += getDerecha().generarCodigo();
            codigo += "store i1 %var" + idVarDerecha  + ", i1* %varResultPuntero" + idVarIzquierda + "\n";
            codigo = codigo.concat(String.format("br label %%etiqFinCondicionOr%s\n", this.getIdVar()));
            codigo = codigo.concat(String.format("etiqFinCondicionOr%s:\n", this.getIdVar()));
            codigo += "%varResult" + idVarIzquierda + " = load i1, i1* %varResultPuntero" + idVarIzquierda + "\n";
            this.setIdVar("Result" + idVarIzquierda);
            
        }else if(get_llvm_op_code().equals("and")){
            codigo += getIzquierda().generarCodigo();
            codigo += "%varResultPuntero" + idVarIzquierda + " = alloca i1 \n";
            codigo += "store i1 %var" + idVarIzquierda  + ", i1* %varResultPuntero" + idVarIzquierda + "\n";
            codigo = codigo.concat("br i1 %var" + idVarIzquierda + ", label %etiqCondicionDerechaAnd" + this.getIdVar() + ", label %etiqFinCondicionAnd" + this.getIdVar() + "\n");
            codigo = codigo.concat(String.format("etiqCondicionDerechaAnd%s:\n", this.getIdVar()));
            codigo += getDerecha().generarCodigo();
            codigo += "store i1 %var" + idVarIzquierda  + ", i1* %varResultPuntero" + idVarIzquierda + "\n";
            codigo = codigo.concat(String.format("br label %%etiqFinCondicionAnd%s\n", this.getIdVar()));
            codigo = codigo.concat(String.format("etiqFinCondicionAnd%s:\n", this.getIdVar()));
            codigo += "%varResult" + idVarDerecha + " = load i1, i1* %varResultPuntero" + idVarIzquierda + "\n";
            this.setIdVar("Result" + idVarIzquierda);
        } 
        else{
            this.getIzquierda().setIdVar("Result" + idVarIzquierda);
            
            codigo += getIzquierda().generarCodigo();
            codigo += getDerecha().generarCodigo();
            codigo += "%var"+getIdVar()+" = "+get_llvm_op_code()+" "+get_llvm_type_code()+" %var"+getIzquierda().getIdVar()+", %var"+getDerecha().getIdVar()+"\n";
        }
       
        return codigo;
    }
}
