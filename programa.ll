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
@_aux0 = global double 0.0

define i32 @main(i32, i8**) {
	store i32 %var230, i32* @var2
	%var231 = add i32 0, 3
	%var232 = icmp ne i32 %var230, %var231
	br i1 %var232, label %etiqThenIf280, label %etiqElif245
	etiqThenIf280:
	%var234 = load i32, i32* @var2
	%var235 = sitofp i32 %var234 to double
	store double %var235, double* @_aux0
	br label %etiqEndIf280
	etiqElif245:
	store i32 %var238, i32* @var3
	%var239 = add i32 0, 3
	%var240 = icmp ne i32 %var238, %var239
	br i1 %var240, label %etiqThenElif245, label %etiqElif254
	etiqThenElif245:
	%var242 = load i32, i32* @var3
	%var243 = sitofp i32 %var242 to double
	store double %var243, double* @_aux0
	br label %etiqEndIf280
	etiqElif254:
	store i32 %var247, i32* @var4
	%var248 = add i32 0, 3
	%var249 = icmp ne i32 %var247, %var248
	br i1 %var249, label %etiqThenElif254, label %etiqElif276
	etiqThenElif254:
	%var251 = load i32, i32* @var4
	%var252 = sitofp i32 %var251 to double
	store double %var252, double* @_aux0
	br label %etiqEndIf280
	etiqElif276:
	store double %var267, double* @var5
	%var271 = add i32 0, 3
	%var272 = fcmp one double %var267, %var271
	br i1 %var272, label %etiqThenElif276, label %etiqThenElse280
	etiqThenElif276:
	%var274 = load double, double* @var5
	store double %var274, double* @_aux0
	br label %etiqEndIf280
	etiqThenElse280:
	%var278 = load double, double* @_retornoFilterDefault
	store double %var278, double* @_aux0
	br label %etiqEndIf280
	etiqEndIf280:
	%var281 = load double, double* @_aux0
	store double %var281, double* @var5
	%var286 = load double, double* @var5
	%dest287 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var286)
	
	ret i32 0
}