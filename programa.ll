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
	%var1304= load i32, i32* @var2
	%var1305 = add i32 0, 3
	%var1306 = icmp ne i32 %var1304, %var1305
	store i1 %var1306, i1* @resultado
	%resultadoLoad1306 = load i1, i1* @resultado
	br i1 %resultadoLoad1306, label %etiqThenIf1329, label %etiqElif1317
	etiqThenIf1329:
	;entro al ASIGNACION 1309
	;entro al Identificador 1308
	%var1308 = load i32, i32* @var2
	store i32 %var1308, i32* @_aux0
	br label %etiqEndIf1329
	etiqElif1317:
	%var1311= load i32, i32* @var3
	%var1312 = add i32 0, 3
	%var1313 = icmp ne i32 %var1311, %var1312
	store i1 %var1313, i1* @resultado
	%resultadoLoad1313 = load i1, i1* @resultado
	br i1 %resultadoLoad1313, label %etiqThenElif1317, label %etiqElif1325
	etiqThenElif1317:
	;entro al ASIGNACION 1316
	;entro al Identificador 1315
	%var1315 = load i32, i32* @var3
	store i32 %var1315, i32* @_aux0
	br label %etiqEndIf1329
	etiqElif1325:
	%var1319= load i32, i32* @var4
	%var1320 = add i32 0, 3
	%var1321 = icmp ne i32 %var1319, %var1320
	store i1 %var1321, i1* @resultado
	%resultadoLoad1321 = load i1, i1* @resultado
	br i1 %resultadoLoad1321, label %etiqThenElif1325, label %etiqThenElse1329
	etiqThenElif1325:
	;entro al ASIGNACION 1324
	;entro al Identificador 1323
	%var1323 = load i32, i32* @var4
	store i32 %var1323, i32* @_aux0
	br label %etiqEndIf1329
	etiqThenElse1329:
	;entro al ASIGNACION 1328
	;entro al Identificador 1327
	%var1327 = load i32, i32* @_retornoFilterDefault
	store i32 %var1327, i32* @_aux0
	br label %etiqEndIf1329
	etiqEndIf1329:
	;entro al ASIGNACION 1334
	;entro al Identificador 1330
	%var1330 = load i32, i32* @_aux0
	store i32 %var1330, i32* @i
	;entro al ASIGNACION 1353
	%var1351 = add i32 0, 0
	store i32 %var1351, i32* @i
	br label %etiqForCondicion1354
	etiqForCondicion1354:
	;entro al Identificador 1335
	%var1335 = load i32, i32* @i
	%var1336 = add i32 0, 1
	;entro al Identificador 1337
	%var1337 = load i32, i32* @i
	%var1338 = add i32 0, 3
	%var1339 = icmp slt i32 %var1337, %var1338
	store i1 %var1339, i1* @resultado
	%resultadoLoad1339 = load i1, i1* @resultado
	br i1 %resultadoLoad1339, label %etiqCuerpoFor1354, label %etiqEndFor1354
	etiqCuerpoFor1354:
	;entro al ASIGNACION 1346
	;entro al Identificador 1340
	%var1340 = load i32, i32* @var2
	;entro al Identificador 1341
	%var1341 = load i32, i32* @i
	%var1342 = add i32 %var1340, %var1341
	store i32 %var1342, i32* @var2
	;entro al Identificador 1347
	%var1347 = load i32, i32* @var2
	%dest1348 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var1347)
	;entro al Identificador 1349
	%var1349 = load i32, i32* @i
	%dest1350 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var1349)
	br label %etiqIncreDecremFor1354
	etiqIncreDecremFor1354:
	%var1354 = add i32 %var1335, %var1336
	store i32 %var1354, i32* @i
	br label %etiqForCondicion1354
	etiqEndFor1354:
	
	ret i32 0
}