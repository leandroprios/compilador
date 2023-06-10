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
	%var1231 = add i32 0, 3
	%var1235 = sitofp i32 %var1231 to double
	store double %var1235, double* @var6
	%var1237 = add i32 0, 1
	store i32 %var1237, i32* @i
	%var1242 = load i32, i32* @i
	%var1243 = add i32 0, 0
	%var1244 = icmp eq i32 %var1242, %var1243
	br i1 %var1244, label %etiqThenIf1261, label %etiqEndIf1261
	etiqThenIf1261:
	%var1245 = add i32 0, 2
	store i32 %var1245, i32* @var2
	%var1250 = load i32, i32* @i
	%var1251 = add i32 0, 1
	%var1252 = icmp eq i32 %var1250, %var1251
	br i1 %var1252, label %etiqThenElif1260, label %etiqEndIf1261
	
	etiqThenElif1260:
	%var1253 = add i32 0, 3
	store i32 %var1253, i32* @var2
	%var1258 = load i32, i32* @var2
	%dest1259 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var1258)
	br label %etiqEndIf1261
	
	etiqEndIf1261:
	%var1262 = load i32, i32* @var2
	%dest1263 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var1262)
	
	ret i32 0
}