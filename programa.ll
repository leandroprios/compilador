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

@str443 = private constant [25 x i8] c"Ingrese un boolean (1/0)\00"
@str486 = private constant [9 x i8] c"AND TRUE\00"
@str491 = private constant [8 x i8] c"OR TRUE\00"
@str494 = private constant [15 x i8] c"AND y OR FALSE\00"
@varlogica2 = global i1 0
@varlogica3 = global i1 0
@_retornoFilterDefault = global i32 0
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
	%dest444 = call i32 @puts(i8* getelementptr ([25 x i8], [25 x i8] * @str443, i32 0, i32 0))
	;entro al ASIGNACION 449
	%temp445 = alloca i1
	%dest445 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i1* %temp445)
	%var445 = load i1, i1* %temp445
	store i1 %var445, i1* @varlogica3
	;entro al Identificador 450
	%var450 = load i1, i1* @varlogica3
	store i1 %var450, i1* @resultado
	%resultadoLoad450 = load i1, i1* @resultado
	call void @printBool(i1 %var450)
	;entro al ASIGNACION 456
	;entro al BOOLEAN 452
	%var452 = add i1 0, 1
	store i1 %var452, i1* @resultado
	%resultadoLoad452 = load i1, i1* @resultado
	store i1 %var452, i1* @varlogica
	;entro al ASIGNACION 461
	;entro al BOOLEAN 457
	%var457 = add i1 0, 0
	store i1 %var457, i1* @resultado
	%resultadoLoad457 = load i1, i1* @resultado
	store i1 %var457, i1* @varlogica2
	;entro al ASIGNACION 481
	%var479 = add i32 0, 0
	store i32 %var479, i32* @i
	br label %etiqForCondicion482
	etiqForCondicion482:
	;entro al Identificador 462
	%var462 = load i32, i32* @i
	%var463 = add i32 0, 1
	;entro al Identificador 464
	%var464 = load i32, i32* @i
	%var465 = add i32 0, 3
	%var466 = icmp slt i32 %var464, %var465
	store i1 %var466, i1* @resultado
	%resultadoLoad466 = load i1, i1* @resultado
	br i1 %resultadoLoad466, label %etiqCuerpoFor482, label %etiqEndFor482
	etiqCuerpoFor482:
	;entro al ASIGNACION 471
	;entro al Identificador 467
	%var467 = load i32, i32* @i
	store i32 %var467, i32* @var2
	;entro al Identificador 472
	%var472 = load i32, i32* @i
	%var473 = add i32 0, 1
	%var474 = icmp eq i32 %var472, %var473
	store i1 %var474, i1* @resultado
	%resultadoLoad474 = load i1, i1* @resultado
	br i1 %resultadoLoad474, label %etiqThenIf476, label %etiqEndIf476
	etiqThenIf476:
	br label %etiqIncreDecremFor482
	br label %etiqEndIf476
	etiqEndIf476:
	;entro al Identificador 477
	%var477 = load i32, i32* @var2
	%dest478 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var477)
	br label %etiqIncreDecremFor482
	etiqIncreDecremFor482:
	%var482 = add i32 %var462, %var463
	store i32 %var482, i32* @i
	br label %etiqForCondicion482
	etiqEndFor482:
	;entro al AND 485
	;entro al Identificador 483
	%var483 = load i1, i1* @varlogica
	store i1 %var483, i1* @resultado
	%resultadoLoad483 = load i1, i1* @resultado
	
	br i1 %resultadoLoad483, label %etiqTrueCondicionIzquierdaAnd485, label %etiqFinAnd485
	
	etiqTrueCondicionIzquierdaAnd485:
	;entro al Identificador 484
	%var484 = load i1, i1* @varlogica2
	store i1 %var484, i1* @resultado
	%resultadoLoad484 = load i1, i1* @resultado
	
	br label %etiqFinAnd485
	etiqFinAnd485:
	
	%resultadoLoad485 = load i1, i1* @resultado
	
	br i1 %resultadoLoad485, label %etiqThenIf496, label %etiqElif493
	etiqThenIf496:
	%dest487 = call i32 @puts(i8* getelementptr ([9 x i8], [9 x i8] * @str486, i32 0, i32 0))
	br label %etiqEndIf496
	etiqElif493:
	;entro al OR 490
	;entro al Identificador 488
	%var488 = load i1, i1* @varlogica
	store i1 %var488, i1* @resultado
	%resultadoLoad488 = load i1, i1* @resultado
	
	br i1 %resultadoLoad488, label %etiqFinOr490, label %etiqFalseCondicionIzquierdaOr490
	
	etiqFalseCondicionIzquierdaOr490:
	;entro al Identificador 489
	%var489 = load i1, i1* @varlogica2
	store i1 %var489, i1* @resultado
	
	br label %etiqFinOr490
	
	etiqFinOr490:
	%resultadoLoad490 = load i1, i1* @resultado
	
	br i1 %resultadoLoad490, label %etiqThenElif493, label %etiqThenElse496
	etiqThenElif493:
	%dest492 = call i32 @puts(i8* getelementptr ([8 x i8], [8 x i8] * @str491, i32 0, i32 0))
	br label %etiqEndIf496
	etiqThenElse496:
	%dest495 = call i32 @puts(i8* getelementptr ([15 x i8], [15 x i8] * @str494, i32 0, i32 0))
	br label %etiqEndIf496
	etiqEndIf496:
	;entro al ASIGNACION 501
	%var497 = add i32 0, 3
	store i32 %var497, i32* @var2
	;entro al ASIGNACION 506
	%var502 = add i32 0, 3
	store i32 %var502, i32* @var3
	;entro al ASIGNACION 511
	%var507 = add i32 0, 4
	store i32 %var507, i32* @var4
	;entro al ASIGNACION 516
	%var512 = add i32 0, 3
	store i32 %var512, i32* @var5
	%var521= load i32, i32* @var2
	%var522 = add i32 0, 3
	%var523 = icmp ne i32 %var521, %var522
	store i1 %var523, i1* @resultado
	%resultadoLoad523 = load i1, i1* @resultado
	br i1 %resultadoLoad523, label %etiqThenIf554, label %etiqElif534
	etiqThenIf554:
	;entro al ASIGNACION 526
	;entro al Identificador 525
	%var525 = load i32, i32* @var2
	store i32 %var525, i32* @_aux0
	br label %etiqEndIf554
	etiqElif534:
	%var528= load i32, i32* @var3
	%var529 = add i32 0, 3
	%var530 = icmp ne i32 %var528, %var529
	store i1 %var530, i1* @resultado
	%resultadoLoad530 = load i1, i1* @resultado
	br i1 %resultadoLoad530, label %etiqThenElif534, label %etiqElif542
	etiqThenElif534:
	;entro al ASIGNACION 533
	;entro al Identificador 532
	%var532 = load i32, i32* @var3
	store i32 %var532, i32* @_aux0
	br label %etiqEndIf554
	etiqElif542:
	%var536= load i32, i32* @var4
	%var537 = add i32 0, 3
	%var538 = icmp ne i32 %var536, %var537
	store i1 %var538, i1* @resultado
	%resultadoLoad538 = load i1, i1* @resultado
	br i1 %resultadoLoad538, label %etiqThenElif542, label %etiqElif550
	etiqThenElif542:
	;entro al ASIGNACION 541
	;entro al Identificador 540
	%var540 = load i32, i32* @var4
	store i32 %var540, i32* @_aux0
	br label %etiqEndIf554
	etiqElif550:
	%var544= load i32, i32* @var5
	%var545 = add i32 0, 3
	%var546 = icmp ne i32 %var544, %var545
	store i1 %var546, i1* @resultado
	%resultadoLoad546 = load i1, i1* @resultado
	br i1 %resultadoLoad546, label %etiqThenElif550, label %etiqThenElse554
	etiqThenElif550:
	;entro al ASIGNACION 549
	;entro al Identificador 548
	%var548 = load i32, i32* @var5
	store i32 %var548, i32* @_aux0
	br label %etiqEndIf554
	etiqThenElse554:
	;entro al ASIGNACION 553
	;entro al Identificador 552
	%var552 = load i32, i32* @_retornoFilterDefault
	store i32 %var552, i32* @_aux0
	br label %etiqEndIf554
	etiqEndIf554:
	;entro al ASIGNACION 559
	;entro al Identificador 555
	%var555 = load i32, i32* @_aux0
	store i32 %var555, i32* @var1
	;entro al Identificador 560
	%var560 = load i32, i32* @var1
	%dest561 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var560)
	
	ret i32 0
}