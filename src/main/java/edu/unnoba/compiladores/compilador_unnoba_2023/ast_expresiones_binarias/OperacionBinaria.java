package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class OperacionBinaria extends Expresion {
    

    protected final Expresion izquierda;
    protected final Expresion derecha;
    
    protected String llvm_name = "%var" + this.getIdVar();

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

    public abstract String getNombreOperacion();

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) +
                derecha.graficar(miId);
    }
    
    public abstract String get_llvm_op_code();
    
    public abstract String get_llvm_name();
    
    public String get_llvm_arithmetic_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "fcmp" : "icmp";
    }
    
    @Override
    public String generarCodigo(){
        this.setResultadoExpresion("%var"+this.getIdVar());
        String codigo = "";
        codigo += getIzquierda().generarCodigo();   
        codigo += getDerecha().generarCodigo();
        codigo += "%var"+getIdVar()+" = "+get_llvm_op_code()+" "+get_llvm_type_code()+" %var"+getIzquierda().getIdVar()+", %var"+getDerecha().getIdVar()+"\n";
        if(get_llvm_type_code().equals("i1")) codigo += "store i1 %var"+this.getIdVar()  + ", i1* @resultado\n";
        return codigo;
    }
}
