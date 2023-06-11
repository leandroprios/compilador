;Programa: Prueba
source_filename = "Prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"


declare i32 @printf(i8*, ...)
declare i32 @puts(i8*)
declare i32 @scanf(i8* %0, ...)

@.integer = private constant [4 x i8] c"%d\0A\00"
@.float = private constant [5 x i8] c"%lf\0A\00"
@.int_read_format = unnamed_addr constant [3 x i8] c"%d\00"
@.double_read_format = unnamed_addr constant [4 x i8]  c"%lf\00"

@varlogica2 = global i1 0
@_retornoFilterDefault = global i1 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogicaResultado = global i1 0
@varlogica = global i1 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0
@_aux0 = global i1 0

define i32 @main(i32, i8**) {
	%var115= load i1, i1* @varlogica
	%var116 = add i1 0, 1
	%var117 = icmp ne i1 %var115, %var116
	br i1 %var117, label %etiqThenIf124, label %etiqThenElse124
	etiqThenIf124:
	%var119 = load i1, i1* @varlogica
	store i1 %var119, i1* @_aux0
	br label %etiqEndIf124
	etiqThenElse124:
	%var122 = load i1, i1* @_retornoFilterDefault
	store i1 %var122, i1* @_aux0
	br label %etiqEndIf124
	etiqEndIf124:
	%var125 = load i1, i1* @_aux0
	store i1 %var125, i1* @varlogicaResultado
	%var130 = load i1, i1* @varlogicaResultado
	%dest131 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i1 %var130)
	
	ret i32 0
}