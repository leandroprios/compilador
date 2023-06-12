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
	%var44 = add i1 0, 0
	store i1 %var44, i1* @varlogica
	%var49 = load i32, i32* @i
	%var50 = add i32 0, 0
	%var51 = icmp eq i32 %var49, %var50
	%varResultPuntero51 = alloca i1 
	store i1 %var51, i1* %varResultPuntero51
	br i1 %var51, label %etiqFinCondicionOr59, label %etiqCondicionDerechaOr59
	etiqCondicionDerechaOr59:
	%var52 = load i32, i32* @var1
	%var53 = add i32 0, 3
	%var54 = icmp eq i32 %var52, %var53
	%varResultPuntero54 = alloca i1 
	store i1 %var54, i1* %varResultPuntero54
	br i1 %var54, label %etiqCondicionDerechaAnd58, label %etiqFinCondicionAnd58
	etiqCondicionDerechaAnd58:
	%var55 = load i32, i32* @var2
	%var56 = add i32 0, 3
	%var57 = icmp eq i32 %var55, %var56
	store i1 %var54, i1* %varResultPuntero54
	br label %etiqFinCondicionAnd58
	etiqFinCondicionAnd58:
	%varResult57 = load i1, i1* %varResultPuntero54
	store i1 %var58, i1* %varResultPuntero51
	br label %etiqFinCondicionOr59
	etiqFinCondicionOr59:
	%varResult51 = load i1, i1* %varResultPuntero51
	br i1 %varResult51, label %etiqThenIf65, label %etiqEndIf65
	etiqThenIf65:
	%var60 = add i32 0, 2
	store i32 %var60, i32* @var2
	br label %etiqEndIf65
	etiqEndIf65:
	%var66 = load i32, i32* @var2
	%dest67 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var66)
	
	ret i32 0
}