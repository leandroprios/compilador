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

@str1215 = private constant [5 x i8] c"else\00"
@varlogica2 = global i1 0
@varlogica3 = global i1 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogica = global i1 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0

define i32 @main(i32, i8**) {
	%var1181 = add i1 0, 1
	store i1 %var1181, i1* @varlogica
	%var1186 = add i1 0, 1
	store i1 %var1186, i1* @varlogica2
	%var1191 = add i1 0, 0
	store i1 %var1191, i1* @varlogica3
	%resultadoOr1206 = alloca i1
	%resultadoOr1202 = alloca i1
	%var1196 = load i1, i1* @varlogica
	
	%resultadoOrLoad21202 = load i1, i1*%resultadoOr1202
	br i1 %resultadoOrLoad21202, label %etiqTrueCondicionIzquierdaOr1202, label %etiqFalseCondicionIzquierdaOr1202
	
	etiqFalseCondicionIzquierdaOr1202:
	%var1197 = load i1, i1* @varlogica2
	
	store i1 %var1197, i1*%resultadoOr1202
	br i1 %var1197, label %etiqTrueCondicionIzquierdaAnd1201, label %etiqFinAnd1201
	
	etiqTrueCondicionIzquierdaAnd1201:
	%var1198 = load i1, i1* @varlogica2
	%var1199 = load i1, i1* @varlogica3
	%var1200 = icmp ne i1 %var1198, %var1199
	store i1 %var1200, i1*%resultadoOr1202
	
	
	br label %etiqFinAnd1201
	etiqFinAnd1201:
	%resultadoOrLoad1201 = load i1, i1*%resultadoOr1202
	
	
	store i1 %resultadoOrLoad1201, i1*%resultadoOr1202
	br label %etiqFinOr1202
	etiqTrueCondicionIzquierdaOr1202:
	store i1 %var1196, i1*%resultadoOr1202
	
	
	br label %etiqFinOr1202
	
	
	etiqFinOr1202:
	%resultadoOrLoad1202 = load i1, i1*%resultadoOr1202
	;%resultadoOrLoad1202
	
	%resultadoOrLoad21206 = load i1, i1*%resultadoOr1206
	br i1 %resultadoOrLoad21206, label %etiqTrueCondicionIzquierdaOr1206, label %etiqFalseCondicionIzquierdaOr1206
	
	etiqFalseCondicionIzquierdaOr1206:
	%var1203 = load i1, i1* @varlogica
	%var1204 = load i1, i1* @varlogica2
	%var1205 = icmp eq i1 %var1203, %var1204
	
	store i1 %var1205, i1*%resultadoOr1206
	br label %etiqFinOr1206
	etiqTrueCondicionIzquierdaOr1206:
	store i1 %resultadoOrLoad1202, i1*%resultadoOr1206
	
	
	br label %etiqFinOr1206
	
	
	etiqFinOr1206:
	%resultadoOrLoad1206 = load i1, i1*%resultadoOr1206
	;%resultadoOrLoad1206
	br i1 %resultadoOrLoad1206, label %etiqThenIf1217, label %etiqThenElse1217
	etiqThenIf1217:
	%var1207 = add i32 0, 5
	%var1211 = sitofp i32 %var1207 to double
	store double %var1211, double* @var5
	%var1213 = load double, double* @var5
	%dest1214 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var1213)
	br label %etiqEndIf1217
	etiqThenElse1217:
	%dest1216 = call i32 @puts(i8* getelementptr ([5 x i8], [5 x i8] * @str1215, i32 0, i32 0))
	br label %etiqEndIf1217
	etiqEndIf1217:
	
	ret i32 0
}