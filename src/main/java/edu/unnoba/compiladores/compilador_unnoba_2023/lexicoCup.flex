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
%class MiLexicoCup
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
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, this.yyline, this.yycolumn);
    }

    private Symbol symbol(int type, Object valor) {
        return new Symbol(type, this.yyline, this.yycolumn, valor);
    }

    private Symbol symbol(int type, int line, int column, Object valor) {
        if(type==32){
            if(valor.toString().length() <= cota_string){
                return new Symbol(type, line, column, valor);
            }else{
                throw new Error("El String supera la cantidad de caracteres permitidos");
            }
        }
        return new Symbol(type, line, column, valor);
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
  "_"                           { return new Symbol(MiParserSym.GUION_BAJO,yycolumn, yyline, yytext());}
  ":"                           { return new Symbol(MiParserSym.DOS_PUNTOS,yycolumn, yyline, yytext());}
  ","                           { return new Symbol(MiParserSym.COMA,yycolumn, yyline, yytext());}
  ";"                           { return new Symbol(MiParserSym.PUNTO_COMA,yycolumn, yyline, yytext());}
  /* Operadores Aritmeticos */
  "+"                           { return new Symbol(MiParserSym.OPERADOR_SUMA,yycolumn, yyline, yytext());}
  "-"                           { return new Symbol(MiParserSym.OPERADOR_RESTA,yycolumn, yyline, yytext()); }
  "*"                           { return new Symbol(MiParserSym.OPERADOR_MULTI,yycolumn, yyline, yytext()); }
  "/"                           { return new Symbol(MiParserSym.OPERADOR_DIV,yycolumn, yyline, yytext()); }
  "("                           { return new Symbol(MiParserSym.PARENTESIS_ABRE,yycolumn, yyline, yytext()); }
  ")"                           { return new Symbol(MiParserSym.PARENTESIS_CIERRA,yycolumn, yyline, yytext()); }
  "["                           { return new Symbol(MiParserSym.CORCHETE_ABRE,yycolumn, yyline, yytext()); }
  "]"                           { return new Symbol(MiParserSym.CORCHETE_CIERRA,yycolumn, yyline, yytext()); }

   /* Operadores Comparacion */
  "=="                            { return new Symbol(MiParserSym.OPERADOR_IGUAL,yycolumn, yyline, yytext()); }
  "!="                            { return new Symbol(MiParserSym.OPERADOR_DISTINTO,yycolumn, yyline, yytext()); }
  "<"                             { return new Symbol(MiParserSym.OPERADOR_MAYOR,yycolumn, yyline, yytext()); }
  "<="                            { return new Symbol(MiParserSym.OPERADOR_MAYOR_IGUAL,yycolumn, yyline, yytext()); }
  ">"                             { return new Symbol(MiParserSym.OPERADOR_MENOR,yycolumn, yyline, yytext()); }
  ">="                            { return new Symbol(MiParserSym.OPERADOR_MENOR_IGUAL,yycolumn, yyline, yytext()); }
 /* Operadores Logicos */
 and | AND                    { return new Symbol(MiParserSym.OPERADOR_AND,yycolumn, yyline, yytext()); }
 or | OR                      { return new Symbol(MiParserSym.OPERADOR_OR,yycolumn, yyline, yytext()); }
 not | NOT                    { return new Symbol(MiParserSym.OPERADOR_NOT,yycolumn, yyline, yytext()); }
 for | FOR                      { return new Symbol(MiParserSym.FOR,yycolumn, yyline, yytext()); }
 do | DO                        { return new Symbol(MiParserSym.DO,yycolumn, yyline, yytext()); }
 "{"                            { return new Symbol(MiParserSym.LLAVE_ABRE,yycolumn, yyline, yytext()); }
 "}"                            { return new Symbol(MiParserSym.LLAVE_CIERRA,yycolumn, yyline, yytext()); }
 "="                            { return new Symbol(MiParserSym.ASIGNACION,yycolumn, yyline, yytext()); }
 IF | if                        { return new Symbol(MiParserSym.IF,yycolumn, yyline, yytext()); }
 ELSE | else                    { return new Symbol(MiParserSym.ELSE,yycolumn, yyline, yytext()); }
 THEN | then                    { return new Symbol(MiParserSym.THEN,yycolumn, yyline, yytext()); }
 ELIF | elif                    { return new Symbol(MiParserSym.ELIF,yycolumn, yyline, yytext()); }
 end | END                      { return new Symbol(MiParserSym.END,yycolumn, yyline, yytext()); }
 break | BREAK                  { return new Symbol(MiParserSym.BREAK,yycolumn, yyline, yytext()); }
 continue | CONTINUE            { return new Symbol(MiParserSym.CONTINUE,yycolumn, yyline, yytext()); }

/* input */

INPUT_INT | input_int { return new Symbol(MiParserSym.INPUT_INT,yycolumn, yyline, yytext()); }
INPUT_FLOAT | input_float { return new Symbol(MiParserSym.INPUT_FLOAT,yycolumn, yyline, yytext()); }
INPUT_BOOLEAN | input_boolean { return new Symbol(MiParserSym.INPUT_BOOL,yycolumn, yyline, yytext()); }

 int | INT                      {return new Symbol(MiParserSym.INT_TYPE,yycolumn, yyline, yytext());}
 float | FLOAT                      {return new Symbol(MiParserSym.FLOAT_TYPE,yycolumn, yyline, yytext());}
 boolean | BOOLEAN                      {return new Symbol(MiParserSym.BOOLEAN_TYPE,yycolumn, yyline, yytext());}

/* Tipos de datos */
 filter| FILTER                { return new Symbol(MiParserSym.FILTER,yycolumn, yyline, yytext()); }

/* Entrada salida */
display|DISPLAY		{ return new Symbol(MiParserSym.DISPLAY,yycolumn, yyline, yytext()); }

/* Declaraciones */
DECLARE\.SECTION		{ return new Symbol(MiParserSym.DECLARE_SECTION,yycolumn, yyline, yytext()); }
ENDDECLARE\.SECTION             { return new Symbol(MiParserSym.END_DECLARE_SECTION,yycolumn, yyline, yytext()); }

/* Programa */
PROGRAM\.SECTION		{ return new Symbol(MiParserSym.PROGRAM_SECTION,yycolumn, yyline, yytext()); }
ENDPROGRAM\.SECTION             { return new Symbol(MiParserSym.END_PROGRAM_SECTION,yycolumn, yyline, yytext()); }

/* Tipos de datos */
 true | TRUE | false | FALSE    { return new Symbol(MiParserSym.CONST_BOOL,yycolumn, yyline, yytext()); }
 {intLiteral}                   { if( Integer.valueOf(yytext()) < cota_int ){
                                        return new Symbol(MiParserSym.CONST_INT,yycolumn, yyline, yytext());
                                  }
                                  else{
                                       throw new Error("Supera el entero determinado");
                                  }
                                }

{floatLiteral}                  {
                                  if(Float.valueOf(yytext()) < cota_float){
                                    return new Symbol(MiParserSym.CONST_FLOAT,yycolumn, yyline, yytext());
                                  }
                                 else{
                                    throw new Error("Supera el float determinado");
                                 }
                                }

  /* Variable */
  ([a-z|A-Z]+)\w{0,49}            {
                                    return new Symbol(MiParserSym.VAR,yycolumn, yyline, yytext()); }
 { WhiteSpace }                   { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return new Symbol(MiParserSym.STRING_LITERAL,yycolumn, yyline, yytext()); }
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
