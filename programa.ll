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

@str133 = private constant [43 x i8] c"ingrese un booleano (1: true y 0 :false ):\00"
@str142 = private constant [17 x i8] c"fin del programa\00"
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogica = global i1 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	%dest134 = call i32 @puts(i8* getelementptr ([43 x i8], [43 x i8] * @str133, i32 0, i32 0))
	;entro al ASIGNACION 139
	%temp135 = alloca i1
	%dest135 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i1* %temp135)
	%resultadoLoad135 = load i1, i1* %temp135
	store i1 %resultadoLoad135, i1* @varlogica
	;entro al Identificador 140
	%var140 = load i1, i1* @varlogica
	store i1 %var140, i1* @resultado
	%resultadoLoad140 = load i1, i1* @resultado
	call void @printBool(i1 %resultadoLoad140)
	%dest143 = call i32 @puts(i8* getelementptr ([17 x i8], [17 x i8] * @str142, i32 0, i32 0))
	
	ret i32 0
}