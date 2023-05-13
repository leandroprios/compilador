package edu.unnoba.compiladores.compilador_unnoba_2023;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jflex.exceptions.GeneratorException;

public class Compilador_unnoba_2023 {

    private static final String path = "src/main/java/edu/unnoba/compiladores/compilador_unnoba_2023/";

    public static void main(String[] args) {
        generarLexer(new File(path+"lexicoCup.flex"));
        String[] param = new String[5];
        param[0] = "-destdir";
        param[1] = path;
        param[2] = "-parser";
        param[3] = "MiParser";
        param[4] = path+"parser.cup";
        generarParser(param);
    }

    public static void generarLexer(File file) {
        try {
            generateLexer(file);
            System.out.println("Archivo Generado");
        } catch (GeneratorException ex) {
            Logger.getLogger(Compilador_unnoba_2023.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void generarParser(String[] param){
        try {
            java_cup.Main.main(param);
        } catch (IOException ex) {
            Logger.getLogger(Compilador_unnoba_2023.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Compilador_unnoba_2023.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void generateLexer(File file) throws GeneratorException {
        jflex.generator.LexGenerator generator = new jflex.generator.LexGenerator(file);
        generator.generate();
    }

}
