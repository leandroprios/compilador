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
@varlogica2 = global i1 0
@varlogica3 = global i1 0
@_retornoFilterDefault0 = global i32 0
@_retornoFilterDefault1 = global i32 0
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@i = global i32 0
@var4 = global i32 0
@varlogica = global i1 0
@var5 = global i32 0
@var6 = global double 0.0
@_aux0 = global i32 0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	;entro al ASIGNACION 451
	%var447 = add i32 0, 4
	store i32 %var447, i32* @i
	br label %etiqForCondicion495
	etiqForCondicion495:
	;entro al Identificador 452
	%var452 = load i32, i32* @i
	%var453 = add i32 0, 1
	;entro al Identificador 454
	%var454 = load i32, i32* @i
	%var455 = add i32 0, 2
	%var456 = icmp sgt i32 %var454, %var455
	store i1 %var456, i1* @resultado
	%resultadoLoad456 = load i1, i1* @resultado
	br i1 %resultadoLoad456, label %etiqCuerpoFor495, label %etiqEndFor495
	etiqCuerpoFor495:
	%var461= load i32, i32* @var2
	%var462 = add i32 0, 3
	%var463 = icmp ne i32 %var461, %var462
	store i1 %var463, i1* @resultado
	%resultadoLoad463 = load i1, i1* @resultado
	br i1 %resultadoLoad463, label %etiqThenIf470, label %etiqThenElse470
	etiqThenIf470:
	;entro al ASIGNACION 466
	;entro al Identificador 465
	%var465 = load i32, i32* @var2
	store i32 %var465, i32* @_aux0
	br label %etiqEndIf470
	etiqThenElse470:
	;entro al ASIGNACION 469
	;entro al Identificador 468
	%var468 = load i32, i32* @_retornoFilterDefault0
	store i32 %var468, i32* @_aux0
	br label %etiqEndIf470
	etiqEndIf470:
	;entro al ASIGNACION 475
	;entro al Identificador 471
	%var471 = load i32, i32* @_aux0
	store i32 %var471, i32* @var1
	%var480= load i32, i32* @var2
	%var481 = add i32 0, 3
	%var482 = icmp ne i32 %var480, %var481
	store i1 %var482, i1* @resultado
	%resultadoLoad482 = load i1, i1* @resultado
	br i1 %resultadoLoad482, label %etiqThenIf489, label %etiqThenElse489
	etiqThenIf489:
	;entro al ASIGNACION 485
	;entro al Identificador 484
	%var484 = load i32, i32* @var2
	store i32 %var484, i32* @_aux1
	br label %etiqEndIf489
	etiqThenElse489:
	;entro al ASIGNACION 488
	;entro al Identificador 487
	%var487 = load i32, i32* @_retornoFilterDefault1
	store i32 %var487, i32* @_aux1
	br label %etiqEndIf489
	etiqEndIf489:
	;entro al ASIGNACION 494
	;entro al Identificador 490
	%var490 = load i32, i32* @_aux1
	store i32 %var490, i32* @var2
	br label %etiqIncreDecremFor495
	etiqIncreDecremFor495:
	%var495 = sub i32 %var452, %var453
	store i32 %var495, i32* @i
	br label %etiqForCondicion495
	etiqEndFor495:
	
	ret i32 0
}