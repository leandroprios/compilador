package edu.unnoba.compiladores.compilador_unnoba_2023.ast;

import java.util.ArrayList;

/**
 *
 * @author nacho torres
 */
public class CodeGeneratorHelper {
    
    private static int nextID = 0;
        
    private CodeGeneratorHelper(){}
    
    public static String getNewPointer(){
        StringBuilder ret = new StringBuilder();
        nextID+=1;
        ret.append(String.format("%s", nextID));
        return ret.toString();
    }
   
/*    public static String getNewPointer(){
        StringBuilder ret = new StringBuilder();
        nextID+=1;
        ret.append(String.format("%%ptro.%s", nextID));
        return ret.toString();
    }
  */  
    public static String getNewGlobalPointer(){
        StringBuilder ret = new StringBuilder();
        nextID+=1;
        ret.append(String.format("@gb.%s", nextID));
        return ret.toString();
    }
    
    public static String getNewTag(){
        StringBuilder ret = new StringBuilder();
        nextID+=1;
        ret.append(String.format("tag.%s", nextID));
        return ret.toString();
    }
    
    
}
