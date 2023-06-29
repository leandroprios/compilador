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

@varlogica2 = global i1 0
@varlogica3 = global i1 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@var4 = global i32 0
@varlogica = global i1 0
@var5 = global i32 0
@var6 = global double 0.0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	;entro al ASIGNACION 212
	;entro al Identificador 206
	%var206 = load i32, i32* @i
	%var207 = add i32 0, 1
	%var208 = sub i32 %var206, %var207
	store i32 %var208, i32* @i
	;entro al ASIGNACION 217
	%var213 = add i32 0, 4
	store i32 %var213, i32* @i
	br label %etiqForCondicion225
	etiqForCondicion225:
	;entro al Identificador 218
	%var218 = load i32, i32* @i
	%var219 = add i32 0, 1
	;entro al Identificador 220
	%var220 = load i32, i32* @i
	%var221 = add i32 0, 2
	%var222 = icmp sgt i32 %var220, %var221
	store i1 %var222, i1* @resultado
	%resultadoLoad222 = load i1, i1* @resultado
	br i1 %resultadoLoad222, label %etiqCuerpoFor225, label %etiqEndFor225
	etiqCuerpoFor225:
	;entro al Identificador 223
	%var223 = load i32, i32* @i
	%dest224 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var223)
	br label %etiqIncreDecremFor225
	etiqIncreDecremFor225:
	%var225 = sub i32 %var218, %var219
	store i32 %var225, i32* @i
	br label %etiqForCondicion225
	etiqEndFor225:
	
	ret i32 0
}