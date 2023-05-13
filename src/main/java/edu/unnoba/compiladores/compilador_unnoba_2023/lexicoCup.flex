/* JFlex example: partial Java language lexer specification */
package edu.unnoba.compiladores.compilador_unnoba_2023;

import java.util.ArrayList;
import java_cup.runtime.*;
import java_cup.sym;

/**
 * This class is a simple example lexer.
 */
%%

%public
%class MiLexico
%cup
%full
%line
%char

%{
    /*************************************************************************
    * En esta sección se puede incluir código que se copiará textualmente
    * como parte de la definición de la clase del analizador léxico.
    * Típicamente serán variables de instancia o nuevos métodos de la clase.
    *************************************************************************/
    int string_yyline = 0;
    int string_yycolumn = 0;
    int count_comentario = 0;
    int cota_string = 100;
    int cota_int = 1000000;
    float cota_float = 1000000.0f;
    int cotaString = 100;
    StringBuffer string = new StringBuffer();

    private MiToken token(String nombre) {
        return new MiToken(nombre, this.yyline, this.yycolumn);
    }

    private MiToken token(String nombre, Object valor) {
        return new MiToken(nombre, this.yyline, this.yycolumn, valor);
    }

    private MiToken token(String nombre, int line, int column, Object valor) {
        if(nombre.equals("STRING_LITERAL")){
            if(valor.toString().length() <= cotaString){
                return new MiToken(nombre, line, column, valor);
            }else{
                throw new Error("Supera la cantidad de caracteres permitidos");
            }
            
        }
        return new MiToken(nombre, line, column, valor);
    }

%}
LineTerminator = \r|\n|\r\n
SimpleComment = #.*{LineTerminator}?
WhiteSpace =  \s | \r|\n|\r\n} | [\t\f]

intLiteral = \d+
floatLiteral = \d+\.\d* | \.\d+

%state STRING
%state Comentario

%%
<Comentario>{
"\(\*" {count_comentario+=1;}
"\*\)" {count_comentario-=1;
      if (count_comentario==0){
          yybegin(YYINITIAL);
      }}
<<EOF>> {
          { throw new Error("Comentario no balanceado");}
      }
[^] {    }
}

<YYINITIAL> {


 "\(\*" {yybegin(Comentario);
          count_comentario+=1;

      }
  "\*\)" { throw new Error("Comentario no balanceado");}

  \"  {  string.setLength(0);
          yybegin(STRING);
          string_yyline = this.yyline;
          string_yycolumn = this.yycolumn; }

 { SimpleComment }               { /*ignore*/ }
  "_"                           { return new MiToken("GUION_BAJO", yytext());}
  ":"                           { return new MiToken("DOS_PUNTOS", yytext());}
  ","                           { return new MiToken("COMA", yytext());}
  ";"                           { return new MiToken("PUNTO_COMA", yytext());}
  /* Operadores Aritmeticos */
  "+"                           { return new MiToken("OPERADOR_SUMA", yytext());}
  "-"                           { return new MiToken("OPERADOR_RESTA", yytext()); }
  "*"                           { return new MiToken("OPERADOR_MULTI", yytext()); }
  "/"                           { return new MiToken("OPERADOR_DIV", yytext()); }
  "("                           { return new MiToken("PARENTESIS_ABRE", yytext()); }
  ")"                           { return new MiToken("PARENTESIS_CIERRA", yytext()); }
  "["                           { return new MiToken("CORCHETE_ABRE", yytext()); }
  "]"                           { return new MiToken("CORCHETE_CIERRA", yytext()); }

   /* Operadores Comparacion */
  "=="                            { return new MiToken("OPERADOR_IGUAL", yytext()); }
  "!="                            { return new MiToken("OPERADOR_DISTINTO", yytext()); }
  "<"                             { return new MiToken("OPERADOR_MAYOR", yytext()); }
  "<="                            { return new MiToken("OPERADOR_MAYOR_IGUAL", yytext()); }
  ">"                             { return new MiToken("OPERADOR_MENOR", yytext()); }
  ">="                            { return new MiToken("OPERADOR_MENOR_IGUAL", yytext()); }
 /* Operadores Logicos */
 and | AND                    { return new MiToken("OPERADOR_AND", yytext()); }
 or | OR                      { return new MiToken("OPERADOR_OR", yytext()); }
 not | NOT                    { return new MiToken("OPERADOR_NOT", yytext()); }
 for | FOR                      { return new MiToken("FOR", yytext()); }
 do | DO                        { return new MiToken("DO", yytext()); }
 "{"                            { return new MiToken("LLAVE_ABRE", yytext()); }
 "}"                            { return new MiToken("LLAVE_CIERRA", yytext()); }
 "="                            { return new MiToken("ASIGNACION", yytext()); }
 IF | if                        { return new MiToken("IF", yytext()); }
 ELSE | else                    { return new MiToken("ELSE", yytext()); }
 THEN | then                    { return new MiToken("THEN", yytext()); }
 ELIF | elif                    { return new MiToken("ELIF", yytext()); }
 end | END                      { return new MiToken("END", yytext()); }
 break | BREAK                  { return new MiToken("BREAK", yytext()); }
 continue | CONTINUE            { return new MiToken("CONTINUE", yytext()); }

/* input */

INPUT_INT | input_int { return new MiToken("INPUT_INT", yytext()); }
INPUT_FLOAT | input_float { return new MiToken("INPUT_FLOAT", yytext()); }
INPUT_BOOLEAN | input_boolean { return new MiToken("INPUT_BOOL", yytext()); }

 int | INT                      {return new MiToken("INT_TYPE", yytext());}
 float | FLOAT                      {return new MiToken("FLOAT_TYPE", yytext());}
 boolean | BOOLEAN                      {return new MiToken("BOOLEAN_TYPE", yytext());}

/* Tipos de datos */
 filter| FILTER                { return new MiToken("FILTER", yytext()); }

/* Entrada salida */
display|DISPLAY		{ return new MiToken("DISPLAY", yytext()); }

/* Declaraciones */
DECLARE\.SECTION		{ return new MiToken("DECLARE_SECTION", yytext()); }
ENDDECLARE\.SECTION             { return new MiToken("END_DECLARE_SECTION", yytext()); }

/* Programa */
PROGRAM\.SECTION		{ return new MiToken("PROGRAM_SECTION", yytext()); }
ENDPROGRAM\.SECTION             { return new MiToken("END_PROGRAM_SECTION", yytext()); }

/* Tipos de datos */
 true | TRUE | false | FALSE    { return new MiToken("CONST_BOOL", yytext()); }
 {intLiteral}                   { if( Integer.valueOf(yytext()) < cota_int ){
                                        return new MiToken("CONST_INT", yytext());
                                  }
                                  else{
                                       throw new Error("Supera el entero determinado");
                                  }
                                }

{floatLiteral}                  {
                                  if(Float.valueOf(yytext()) < cota_float){
                                    return new MiToken("CONST_FLOAT", yytext());
                                  }
                                 else{
                                    throw new Error("Supera el float determinado");
                                 }
                                }

  /* Variable */
  ([a-z|A-Z]+)\w{0,49}            {
                                    return new MiToken("VAR", yytext()); }
 { WhiteSpace }                   { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return new MiToken("STRING_LITERAL", string_yyline, string_yycolumn, string.toString()); }
  \\\"                           { string.append('\"'); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }
  \\r                            { string.append('\r'); }
  \\                             { string.append('\\'); }

  <<EOF>>                        { throw new Error("String no balanceado"); }
  [^]                            { string.append( yytext() ); }
}

/* error fallback */
[^]                              { throw new Error("Caracter ilegal <"+yytext()+"> "); }
