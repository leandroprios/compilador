package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;

public abstract class  Nodo {
    private String nombre;
    private String idVar;
    private Tipo tipo;

    public Nodo() {}

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public String get_llvm_type_code() {
        return getTipo().equals(Tipo.FLOAT) ? "double" : (getTipo().equals(Tipo.INTEGER) ? "i32" : "i1");
    }

    public String getId() {
        return "nodo_" + this.hashCode();
    }

    public String getEtiqueta() {
        if (this.nombre != null) {
            return this.nombre;
        }
        final String name = this.getClass().getName();
        final int pos = name.lastIndexOf('.') + 1;
        return name.substring(pos);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdVar() {
        return idVar;
    }

    public void setIdVar(String idVar) {
        this.idVar = idVar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s\"]\n", this.getId(), this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }

    public abstract String generarCodigo();
}