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

@str282 = private constant [21 x i8] c"filter del if = true\00"
@str309 = private constant [34 x i8] c"filter del elif = true por el NOT\00"
@str312 = private constant [5 x i8] c"else\00"
@_aux1 = global i1 0
@varlogica2 = global i1 0
@varlogica3 = global i1 0
@_retornoFilterDefault0 = global i1 0
@_retornoFilterDefault1 = global i1 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogica = global i1 0
@var4 = global i32 0
@j = global i32 0
@var5 = global i32 0
@var6 = global double 0.0
@_aux0 = global i1 0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	%var249 = add i1 0, 1
	store i1 %var249, i1* @resultado
	%resultadoLoad249 = load i1, i1* @resultado
	store i1 %resultadoLoad249, i1* @varlogica
	%var254 = load i1, i1* @varlogica
	store i1 %var254, i1* @resultado
	%resultadoLoad254 = load i1, i1* @resultado
	store i1 %resultadoLoad254, i1* @varlogica2
	%var263= load i1, i1* @varlogica2
	%var264 = add i1 0, 0
	store i1 %var264, i1* @resultado
	%var265 = icmp eq i1 %var263, %var264
	store i1 %var265, i1* @resultado
	%resultadoLoad265 = load i1, i1* @resultado
	br i1 %resultadoLoad265, label %etiqThenIf280, label %etiqElif276
	etiqThenIf280:
	%var267 = load i1, i1* @varlogica2
	store i1 %var267, i1* @resultado
	%resultadoLoad267 = load i1, i1* @resultado
	store i1 %resultadoLoad267, i1* @_aux0
	br label %etiqEndIf280
	etiqElif276:
	%var270= load i1, i1* @varlogica
	%var271 = add i1 0, 0
	store i1 %var271, i1* @resultado
	%var272 = icmp eq i1 %var270, %var271
	store i1 %var272, i1* @resultado
	%resultadoLoad272 = load i1, i1* @resultado
	br i1 %resultadoLoad272, label %etiqThenElif276, label %etiqThenElse280
	etiqThenElif276:
	%var274 = load i1, i1* @varlogica
	store i1 %var274, i1* @resultado
	%resultadoLoad274 = load i1, i1* @resultado
	store i1 %resultadoLoad274, i1* @_aux0
	br label %etiqEndIf280
	etiqThenElse280:
	%var278 = load i1, i1* @_retornoFilterDefault0
	store i1 %var278, i1* @resultado
	%resultadoLoad278 = load i1, i1* @resultado
	store i1 %resultadoLoad278, i1* @_aux0
	br label %etiqEndIf280
	etiqEndIf280:
	%var318 = load i1, i1* @_aux0
	store i1 %var318, i1* @resultado
	%resultadoLoad318 = load i1, i1* @resultado
	br i1 %resultadoLoad318, label %etiqThenIf284, label %etiqElif311
	etiqThenIf284:
	%dest283 = call i32 @puts(i8* getelementptr ([21 x i8], [21 x i8] * @str282, i32 0, i32 0))
	br label %etiqEndIf284
	etiqElif311:
	%var289= load i1, i1* @varlogica2
	%var290 = add i1 0, 0
	store i1 %var290, i1* @resultado
	%var291 = icmp eq i1 %var289, %var290
	store i1 %var291, i1* @resultado
	%resultadoLoad291 = load i1, i1* @resultado
	br i1 %resultadoLoad291, label %etiqThenIf306, label %etiqElif302
	etiqThenIf306:
	%var293 = load i1, i1* @varlogica2
	store i1 %var293, i1* @resultado
	%resultadoLoad293 = load i1, i1* @resultado
	store i1 %resultadoLoad293, i1* @_aux1
	br label %etiqEndIf306
	etiqElif302:
	%var296= load i1, i1* @varlogica
	%var297 = add i1 0, 0
	store i1 %var297, i1* @resultado
	%var298 = icmp eq i1 %var296, %var297
	store i1 %var298, i1* @resultado
	%resultadoLoad298 = load i1, i1* @resultado
	br i1 %resultadoLoad298, label %etiqThenElif302, label %etiqThenElse306
	etiqThenElif302:
	%var300 = load i1, i1* @varlogica
	store i1 %var300, i1* @resultado
	%resultadoLoad300 = load i1, i1* @resultado
	store i1 %resultadoLoad300, i1* @_aux1
	br label %etiqEndIf306
	etiqThenElse306:
	%var304 = load i1, i1* @_retornoFilterDefault1
	store i1 %var304, i1* @resultado
	%resultadoLoad304 = load i1, i1* @resultado
	store i1 %resultadoLoad304, i1* @_aux1
	br label %etiqEndIf306
	etiqEndIf306:
	%var319 = load i1, i1* @_aux1
	store i1 %var319, i1* @resultado
	%var320 = xor i1 %var319, 1
	store i1 %var320 , i1* @resultado
	%resultadoLoad320 = load i1, i1* @resultado
	br i1 %resultadoLoad320, label %etiqThenElif311, label %etiqThenElse284
	etiqThenElif311:
	%dest310 = call i32 @puts(i8* getelementptr ([34 x i8], [34 x i8] * @str309, i32 0, i32 0))
	br label %etiqEndIf284
	etiqThenElse284:
	%dest313 = call i32 @puts(i8* getelementptr ([5 x i8], [5 x i8] * @str312, i32 0, i32 0))
	br label %etiqEndIf284
	etiqEndIf284:
	
	ret i32 0
}