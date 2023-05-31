package edu.unnoba.compiladores.compilador_unnoba_2023.ast;

/**
 *
 * @author Julian
 */
public enum Tipo {
    BOOLEAN,
    INTEGER,
    FLOAT,
    UNKNOWN;
    
    public static Tipo getTipoDato(String tipoStr) {
        
        switch (tipoStr.toUpperCase()){
            case "BOOLEAN":
                return Tipo.BOOLEAN;
            case "INTEGER":
                return Tipo.INTEGER;
            case "FLOAT":
                return Tipo.FLOAT;
        }
        return Tipo.UNKNOWN;
    }
    
    public static String toString(Tipo tipo) {
        
        switch (tipo){
            case BOOLEAN:
                return "BOOLEAN";
            case INTEGER:
                return "INTEGER";
            case FLOAT :
                return "FLOAT";
            default : 
                return "UNKNOWN";   
        }
        //return "UNKNOWN";
    }
}
