;Programa: Prueba
source_filename = "prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"

declare i32 @printf(i8*, ...)

@.integer = private constant [4 x i8] c"%d\0A\00"

define i32 @main(i32, i8**) {
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
	%var%ptro.525 = add i1 0, 0
	store i1 %var%ptro.525, i1* @varlogica
	%var%ptro.530 = add i32 0, 3
	%var%ptro.534 = sitofp i32 %var%ptro.530 to double
	store double %var%ptro.534, double* @var6
	
	ret i32 0
}