package edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones;

import edu.unnoba.compiladores.compilador_unnoba_2023.ast.CodeGeneratorHelper;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast.Tipo;
import edu.unnoba.compiladores.compilador_unnoba_2023.ast_expresiones_binarias.Expresion;
import edu.unnoba.compiladores.compilador_unnoba_2023.exceptions.VarTypeNotEqualWithVarListTypes;
import edu.unnoba.compiladores.compilador_unnoba_2023.factor.Constante;



/**
 *
 * @author Julian
 */
public class Identificador extends Constante {
    
    private String nombreVar = "ID";

    public Identificador(String nombre, Tipo tipo) {
        setTipo(tipo);
        setNombre(nombre);
        setNombreVar(nombre);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getNombreVar() {
        return nombreVar;
    }

    public void setNombreVar(String nombreVar) {
        this.nombreVar = nombreVar;
    }
    
    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", super.getNombre(), getTipo().toString());
    }
    
    @Override
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.nombreVar, this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }

    @Override
    public Expresion clonar() {
        return new Identificador(this.getNombre(), this.getTipo());
    }

    @Override
    public Expresion reemplazarExpresionIzquierda(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("El Identificador no soporta reemplazar la expresion izquierda."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Expresion reemplazarExpresionDerecha(String valor, Tipo tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    @Override
    public boolean ComparacionFor(String var) {
        if(this.getNombre().equals(var)){
           return true;
        }else{
            return false;
        }
    }

    @Override
    public Tipo getTipoExpresionDerecha() {
       return getTipo();
    }
    
    @Override
    public String generarCodigo() {
        String codigo = "";
        this.setResultadoExpresion("%var" + this.getIdVar());    
        //String codigo = "%varResultadoCondicion" + this.getIdVar() +" = load "+get_llvm_type_code()+", "+get_llvm_type_code()+"* @"+getNombre()+"\n";
        codigo += "%var"+getIdVar()+" = load "+get_llvm_type_code()+", "+get_llvm_type_code()+"* @"+getNombre()+"\n";
        return codigo;
    }
    
    

}

