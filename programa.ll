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

@str511 = private constant [19 x i8] c"inicio de programa\00"
@str513 = private constant [26 x i8] c"ingrese un numero entero:\00"
@str522 = private constant [25 x i8] c"ingrese un numero float:\00"
@str531 = private constant [21 x i8] c"ingrese un booleano:\00"
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
	%dest512 = call i32 @puts(i8* getelementptr ([19 x i8], [19 x i8] * @str511, i32 0, i32 0))
	%dest514 = call i32 @puts(i8* getelementptr ([26 x i8], [26 x i8] * @str513, i32 0, i32 0))
	%temp515 = alloca i32
	%dest515 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i32* %temp515)
	%var515 = load i32, i32* %temp515
	store i32 %var515, i32* @var1
	%var520 = load i32, i32* @var1
	%dest521 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var520)
	%dest523 = call i32 @puts(i8* getelementptr ([25 x i8], [25 x i8] * @str522, i32 0, i32 0))
	%temp524 = alloca double
	%dest524 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.double_read_format, i64 0, i64 0), double* %temp524)
	%var524 = load double, double* %temp524
	store double %var524, double* @var5
	%var529 = load double, double* @var5
	%dest530 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var529)
	%dest532 = call i32 @puts(i8* getelementptr ([21 x i8], [21 x i8] * @str531, i32 0, i32 0))
	%temp533 = alloca i1
	%dest533 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i1* %temp533)
	%var533 = load i1, i1* %temp533
	store i1 %var533, i1* @varlogica
	%var538 = load i1, i1* @varlogica
	%dest539 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i1 %var538)
	
	ret i32 0
}