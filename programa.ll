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

@_aux1 = global i32 0
@_retornoFilterDefault = global i32 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@varlogica = global i1 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0
@_aux0 = global i32 0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	;entro al ASIGNACION 1134
	;entro al Identificador 1130
	%var1130 = load i32, i32* @_aux0
	store i32 %var1130, i32* @i
	br label %etiqForCondicion1161
	etiqForCondicion1161:
	;entro al Identificador 1135
	%var1135 = load i32, i32* @i
	%var1136 = add i32 0, 1
	;entro al Identificador 1137
	%var1137 = load i32, i32* @i
	%var1138 = add i32 0, 3
	%var1139 = icmp slt i32 %var1137, %var1138
	store i1 %var1139, i1* @resultado
	%resultadoLoad1139 = load i1, i1* @resultado
	br i1 %resultadoLoad1139, label %etiqCuerpoFor1161, label %etiqEndFor1161
	etiqCuerpoFor1161:
	%var1144= load i32, i32* @i
	%var1145 = add i32 0, 3
	%var1146 = icmp ne i32 %var1144, %var1145
	store i1 %var1146, i1* @resultado
	%resultadoLoad1146 = load i1, i1* @resultado
	br i1 %resultadoLoad1146, label %etiqThenIf1153, label %etiqThenElse1153
	etiqThenIf1153:
	;entro al ASIGNACION 1149
	;entro al Identificador 1148
	%var1148 = load i32, i32* @i
	store i32 %var1148, i32* @_aux1
	br label %etiqEndIf1153
	etiqThenElse1153:
	;entro al ASIGNACION 1152
	;entro al Identificador 1151
	%var1151 = load i32, i32* @_retornoFilterDefault
	store i32 %var1151, i32* @_aux1
	br label %etiqEndIf1153
	etiqEndIf1153:
	;entro al ASIGNACION 1158
	;entro al Identificador 1154
	%var1154 = load i32, i32* @_aux1
	store i32 %var1154, i32* @var4
	;entro al Identificador 1159
	%var1159 = load i32, i32* @var4
	%dest1160 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var1159)
	br label %etiqIncreDecremFor1161
	etiqIncreDecremFor1161:
	%var1161 = add i32 %var1135, %var1136
	store i32 %var1161, i32* @i
	br label %etiqForCondicion1161
	etiqEndFor1161:
	
	ret i32 0
}