;Programa: Prueba
source_filename = "Prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"


declare i32 @printf(i8*, ...)
declare i32 @puts(i8*)
declare i32 @scanf(i8* %0, ...)

@trueStr = private constant [6 x i8] c"true\0A\00"
@falseStr = private constant [7 x i8] c"false\0A\00"
define void @printBool(i1 %value) {
  %boolValue = zext i1 %value to i32
  br i1 %value, label %trueLabel, label %falseLabel
trueLabel:
  %formatStrTrue = getelementptr [6 x i8], [6 x i8]* @trueStr, i32 0, i32 0
  call i32 (i8*, ...) @printf(i8* %formatStrTrue, i32 %boolValue)
  br label %endLabel

falseLabel:
  %formatStrFalse = getelementptr [7 x i8], [7 x i8]* @falseStr, i32 0, i32 0
  call i32 (i8*, ...) @printf(i8* %formatStrFalse, i32 %boolValue)
  br label %endLabel

endLabel:
  ret void
}
@.integer = private constant [4 x i8] c"%d\0A\00"
@.float = private constant [5 x i8] c"%lf\0A\00"
@.int_read_format = unnamed_addr constant [3 x i8] c"%d\00"
@.double_read_format = unnamed_addr constant [4 x i8]  c"%lf\00"

@str167 = private constant [12 x i8] c"entro al if\00"
@varlogica2 = global i1 0
@_retornoFilterDefault0 = global i32 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogica = global i1 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0
@_aux0 = global i32 0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	;entro al ASIGNACION 144
	;entro al BOOLEAN 140
	%var140 = add i1 0, 1
	store i1 %var140, i1* @resultado
	%resultadoLoad140 = load i1, i1* @resultado
	store i1 %resultadoLoad140, i1* @varlogica
	;entro al ASIGNACION 149
	%var145 = add i32 0, 3
	store i32 %var145, i32* @var3
	%var155= load i32, i32* @var3
	%var156 = add i32 0, 3
	%var157 = icmp eq i32 %var155, %var156
	store i1 %var157, i1* @resultado
	%resultadoLoad157 = load i1, i1* @resultado
	br i1 %resultadoLoad157, label %etiqThenIf164, label %etiqThenElse164
	etiqThenIf164:
	;entro al ASIGNACION 160
	;entro al Identificador 159
	%var159 = load i32, i32* @var3
	store i32 %var159, i32* @_aux0
	br label %etiqEndIf164
	etiqThenElse164:
	;entro al ASIGNACION 163
	;entro al Identificador 162
	%var162 = load i32, i32* @_retornoFilterDefault0
	store i32 %var162, i32* @_aux0
	br label %etiqEndIf164
	etiqEndIf164:
	%var174 = add i32 0, 3
	;entro al Identificador 175
	%var175 = load i32, i32* @_aux0
	%var176 = icmp eq i32 %var174, %var175
	store i1 %var176, i1* @resultado
	%resultadoLoad176 = load i1, i1* @resultado
	br i1 %resultadoLoad176, label %etiqThenIf169, label %etiqEndIf169
	etiqThenIf169:
	%dest168 = call i32 @puts(i8* getelementptr ([12 x i8], [12 x i8] * @str167, i32 0, i32 0))
	br label %etiqEndIf169
	etiqEndIf169:
	
	ret i32 0
}