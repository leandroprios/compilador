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
@resultado = global i1 0
define i32 @main(i32, i8**) {
	%var665 = add i32 0, 0
	store i32 %var665, i32* @i
	br label %etiqForCondicion691
	etiqForCondicion691:
	%var676 = load i32, i32* @i
	%var677 = add i32 0, 3
	%var678 = icmp slt i32 %var676, %var677
	store i1 %var678, i1* @resultado
	%resultadoLoad678 = load i1, i1* @resultado
	br i1 %resultadoLoad678, label %etiqCuerpoFor691, label %etiqEndFor691
	etiqCuerpoFor691:
	%var679 = add i32 0, 2
	%var680 = load i32, i32* @i
	%var681 = add i32 %var679, %var680
	store i32 %var681, i32* @var2
	%var686 = load i32, i32* @var2
	%dest687 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var686)
	br label %etiqEndFor691
	%var689 = load i32, i32* @i
	%dest690 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var689)
	br label %etiqIncreDecremFor691
	etiqIncreDecremFor691:
	%var670 = load i32, i32* @i
	%var671 = add i32 0, 1
	%var672 = add i32 %var670, %var671
	store i32 %var672, i32* @i
	br label %etiqForCondicion691
	etiqEndFor691:
	
	ret i32 0
}