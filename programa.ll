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

@str763 = private constant [12 x i8] c"entro al if\00"
@str844 = private constant [12 x i8] c"entro al if\00"
@str887 = private constant [14 x i8] c"entro al elif\00"
@var1 = global i32 0
@var2 = global i32 0
@var3 = global i32 0
@var4 = global i32 0
@var5 = global double 0.0
@var6 = global double 0.0
@var8 = global double 0.0
@i = global i32 0
@_aux0 = global i1 0
@_aux1 = global i1 0
@varlogica = global i1 0
@_aux2 = global i1 0
@_aux3 = global i32 0
@_aux4 = global i1 0
@_aux5 = global i1 0
@_aux6 = global i1 0
@_aux7 = global i1 0
@_retornoFilterDefault0 = global i1 0
@varlogica2 = global i1 0
@_retornoFilterDefault1 = global i1 0
@_retornoFilterDefault2 = global i1 0
@_retornoFilterDefault3 = global i32 0
@_retornoFilterDefault4 = global i1 0
@_retornoFilterDefault5 = global i1 0
@_retornoFilterDefault6 = global i1 0
@_retornoFilterDefault7 = global i1 0
@resultado = global i1 0
define i32 @main(i32, i8**) {
	;entro al ASIGNACION 707
	%var703 = add i32 0, 3
	store i32 %var703, i32* @var3
	;entro al ASIGNACION 713
	%var708 = add i32 0, 1
	%var709 = sub i32 0, %var708
	store i1 %var709 , i1* @resultado
	%resultadoLoad709 = load i1, i1* @resultado
	store i32 %var709, i32* @var2
	;entro al ASIGNACION 718
	;entro al BOOLEAN 714
	%var714 = add i1 0, 0
	store i1 %var714, i1* @resultado
	%resultadoLoad714 = load i1, i1* @resultado
	store i1 %resultadoLoad714, i1* @varlogica
	;entro al ASIGNACION 724
	;entro al BOOLEAN 719
	%var719 = add i1 0, 1
	store i1 %var719, i1* @resultado
	%var720 = xor i1 %var719, 1
	store i1 %var720 , i1* @resultado
	%resultadoLoad720 = load i1, i1* @resultado
	store i1 %resultadoLoad720, i1* @varlogica
	;entro al Identificador 725
	%var725 = load i1, i1* @varlogica
	store i1 %var725, i1* @resultado
	%resultadoLoad725 = load i1, i1* @resultado
	call void @printBool(i1 %resultadoLoad725)
	%var731= load i1, i1* @varlogica
	;entro al BOOLEAN 732
	%var732 = add i1 0, 1
	store i1 %var732, i1* @resultado
	%var733 = icmp eq i1 %var731, %var732
	store i1 %var733, i1* @resultado
	%resultadoLoad733 = load i1, i1* @resultado
	br i1 %resultadoLoad733, label %etiqThenIf740, label %etiqThenElse740
	etiqThenIf740:
	;entro al ASIGNACION 736
	;entro al Identificador 735
	%var735 = load i1, i1* @varlogica
	store i1 %var735, i1* @resultado
	%resultadoLoad735 = load i1, i1* @resultado
	store i1 %resultadoLoad735, i1* @_aux0
	br label %etiqEndIf740
	etiqThenElse740:
	;entro al ASIGNACION 739
	;entro al Identificador 738
	%var738 = load i1, i1* @_retornoFilterDefault0
	store i1 %var738, i1* @resultado
	%resultadoLoad738 = load i1, i1* @resultado
	store i1 %resultadoLoad738, i1* @_aux0
	br label %etiqEndIf740
	etiqEndIf740:
	;entro al ASIGNACION 745
	;entro al Identificador 741
	%var741 = load i1, i1* @_aux0
	store i1 %var741, i1* @resultado
	%resultadoLoad741 = load i1, i1* @resultado
	store i1 %resultadoLoad741, i1* @varlogica2
	;entro al BOOLEAN 746
	%var746 = add i1 0, 0
	store i1 %var746, i1* @resultado
	;entro al Identificador 761
	%var761 = load i1, i1* @_aux1
	store i1 %var761, i1* @resultado
	%var762 = icmp eq i1 %var746, %var761
	store i1 %var762, i1* @resultado
	%resultadoLoad762 = load i1, i1* @resultado
	br i1 %resultadoLoad762, label %etiqThenIf915, label %etiqEndIf915
	etiqThenIf915:
	%dest764 = call i32 @puts(i8* getelementptr ([12 x i8], [12 x i8] * @str763, i32 0, i32 0))
	%var769= load i1, i1* @varlogica
	;entro al BOOLEAN 770
	%var770 = add i1 0, 1
	store i1 %var770, i1* @resultado
	%var771 = icmp eq i1 %var769, %var770
	store i1 %var771, i1* @resultado
	%resultadoLoad771 = load i1, i1* @resultado
	br i1 %resultadoLoad771, label %etiqThenIf778, label %etiqThenElse778
	etiqThenIf778:
	;entro al ASIGNACION 774
	;entro al Identificador 773
	%var773 = load i1, i1* @varlogica
	store i1 %var773, i1* @resultado
	%resultadoLoad773 = load i1, i1* @resultado
	store i1 %resultadoLoad773, i1* @_aux2
	br label %etiqEndIf778
	etiqThenElse778:
	;entro al ASIGNACION 777
	;entro al Identificador 776
	%var776 = load i1, i1* @_retornoFilterDefault2
	store i1 %var776, i1* @resultado
	%resultadoLoad776 = load i1, i1* @resultado
	store i1 %resultadoLoad776, i1* @_aux2
	br label %etiqEndIf778
	etiqEndIf778:
	;entro al ASIGNACION 783
	;entro al Identificador 779
	%var779 = load i1, i1* @_aux2
	store i1 %var779, i1* @resultado
	%resultadoLoad779 = load i1, i1* @resultado
	store i1 %resultadoLoad779, i1* @varlogica2
	;entro al ASIGNACION 810
	;entro al Identificador 806
	%var806 = load i32, i32* @_aux3
	store i32 %var806, i32* @i
	br label %etiqForCondicion914
	etiqForCondicion914:
	;entro al Identificador 811
	%var811 = load i32, i32* @i
	%var812 = add i32 0, 1
	;entro al Identificador 813
	%var813 = load i32, i32* @i
	%var814 = add i32 0, 3
	%var815 = icmp slt i32 %var813, %var814
	store i1 %var815, i1* @resultado
	%resultadoLoad815 = load i1, i1* @resultado
	br i1 %resultadoLoad815, label %etiqCuerpoFor914, label %etiqEndFor914
	etiqCuerpoFor914:
	;entro al ASIGNACION 822
	%var816 = add i32 0, 2
	;entro al Identificador 817
	%var817 = load i32, i32* @i
	%var818 = add i32 %var816, %var817
	store i32 %var818, i32* @var2
	;entro al Identificador 823
	%var823 = load i32, i32* @var2
	%dest824 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var823)
	%var830= load i1, i1* @varlogica
	;entro al BOOLEAN 831
	%var831 = add i1 0, 1
	store i1 %var831, i1* @resultado
	%var832 = icmp eq i1 %var830, %var831
	store i1 %var832, i1* @resultado
	%resultadoLoad832 = load i1, i1* @resultado
	br i1 %resultadoLoad832, label %etiqThenIf839, label %etiqThenElse839
	etiqThenIf839:
	;entro al ASIGNACION 835
	;entro al Identificador 834
	%var834 = load i1, i1* @varlogica
	store i1 %var834, i1* @resultado
	%resultadoLoad834 = load i1, i1* @resultado
	store i1 %resultadoLoad834, i1* @_aux4
	br label %etiqEndIf839
	etiqThenElse839:
	;entro al ASIGNACION 838
	;entro al Identificador 837
	%var837 = load i1, i1* @_retornoFilterDefault4
	store i1 %var837, i1* @resultado
	%resultadoLoad837 = load i1, i1* @resultado
	store i1 %resultadoLoad837, i1* @_aux4
	br label %etiqEndIf839
	etiqEndIf839:
	;entro al AND 931
	;entro al BOOLEAN 927
	%var927 = add i1 0, 1
	store i1 %var927, i1* @resultado
	;entro al Identificador 928
	%var928 = load i1, i1* @_aux4
	store i1 %var928, i1* @resultado
	%var929 = icmp eq i1 %var927, %var928
	store i1 %var929, i1* @resultado
	%resultadoLoad929 = load i1, i1* @resultado
	
	br i1 %resultadoLoad929, label %etiqTrueCondicionIzquierdaAnd931, label %etiqFinAnd931
	
	etiqTrueCondicionIzquierdaAnd931:
	;entro al Identificador 930
	%var930 = load i1, i1* @varlogica
	store i1 %var930, i1* @resultado
	%resultadoLoad930 = load i1, i1* @resultado
	
	br label %etiqFinAnd931
	etiqFinAnd931:
	
	%resultadoLoad931 = load i1, i1* @resultado
	
	br i1 %resultadoLoad931, label %etiqThenIf867, label %etiqElif889
	etiqThenIf867:
	%dest845 = call i32 @puts(i8* getelementptr ([12 x i8], [12 x i8] * @str844, i32 0, i32 0))
	%var850= load i1, i1* @varlogica
	;entro al BOOLEAN 851
	%var851 = add i1 0, 0
	store i1 %var851, i1* @resultado
	%var852 = icmp eq i1 %var850, %var851
	store i1 %var852, i1* @resultado
	%resultadoLoad852 = load i1, i1* @resultado
	br i1 %resultadoLoad852, label %etiqThenIf859, label %etiqThenElse859
	etiqThenIf859:
	;entro al ASIGNACION 855
	;entro al Identificador 854
	%var854 = load i1, i1* @varlogica
	store i1 %var854, i1* @resultado
	%resultadoLoad854 = load i1, i1* @resultado
	store i1 %resultadoLoad854, i1* @_aux5
	br label %etiqEndIf859
	etiqThenElse859:
	;entro al ASIGNACION 858
	;entro al Identificador 857
	%var857 = load i1, i1* @_retornoFilterDefault5
	store i1 %var857, i1* @resultado
	%resultadoLoad857 = load i1, i1* @resultado
	store i1 %resultadoLoad857, i1* @_aux5
	br label %etiqEndIf859
	etiqEndIf859:
	;entro al ASIGNACION 864
	;entro al Identificador 860
	%var860 = load i1, i1* @_aux5
	store i1 %var860, i1* @resultado
	%resultadoLoad860 = load i1, i1* @resultado
	store i1 %resultadoLoad860, i1* @varlogica2
	;entro al Identificador 865
	%var865 = load i1, i1* @varlogica2
	store i1 %var865, i1* @resultado
	%resultadoLoad865 = load i1, i1* @resultado
	call void @printBool(i1 %resultadoLoad865)
	br label %etiqEndIf867
	etiqElif889:
	%var873= load i1, i1* @varlogica
	;entro al BOOLEAN 874
	%var874 = add i1 0, 1
	store i1 %var874, i1* @resultado
	%var875 = icmp eq i1 %var873, %var874
	store i1 %var875, i1* @resultado
	%resultadoLoad875 = load i1, i1* @resultado
	br i1 %resultadoLoad875, label %etiqThenIf882, label %etiqThenElse882
	etiqThenIf882:
	;entro al ASIGNACION 878
	;entro al Identificador 877
	%var877 = load i1, i1* @varlogica
	store i1 %var877, i1* @resultado
	%resultadoLoad877 = load i1, i1* @resultado
	store i1 %resultadoLoad877, i1* @_aux6
	br label %etiqEndIf882
	etiqThenElse882:
	;entro al ASIGNACION 881
	;entro al Identificador 880
	%var880 = load i1, i1* @_retornoFilterDefault6
	store i1 %var880, i1* @resultado
	%resultadoLoad880 = load i1, i1* @resultado
	store i1 %resultadoLoad880, i1* @_aux6
	br label %etiqEndIf882
	etiqEndIf882:
	;entro al OR 936
	;entro al BOOLEAN 932
	%var932 = add i1 0, 0
	store i1 %var932, i1* @resultado
	;entro al Identificador 933
	%var933 = load i1, i1* @_aux6
	store i1 %var933, i1* @resultado
	%var934 = icmp eq i1 %var932, %var933
	store i1 %var934, i1* @resultado
	%resultadoLoad934 = load i1, i1* @resultado
	
	br i1 %resultadoLoad934, label %etiqFinOr936, label %etiqFalseCondicionIzquierdaOr936
	
	etiqFalseCondicionIzquierdaOr936:
	;entro al Identificador 935
	%var935 = load i1, i1* @varlogica
	store i1 %var935, i1* @resultado
	
	br label %etiqFinOr936
	
	etiqFinOr936:
	%resultadoLoad936 = load i1, i1* @resultado
	
	br i1 %resultadoLoad936, label %etiqThenElif889, label %etiqEndIf867
	etiqThenElif889:
	%dest888 = call i32 @puts(i8* getelementptr ([14 x i8], [14 x i8] * @str887, i32 0, i32 0))
	br label %etiqEndIf867
	etiqEndIf867:
	%var894= load i1, i1* @varlogica
	;entro al BOOLEAN 895
	%var895 = add i1 0, 1
	store i1 %var895, i1* @resultado
	%var896 = icmp eq i1 %var894, %var895
	store i1 %var896, i1* @resultado
	%resultadoLoad896 = load i1, i1* @resultado
	br i1 %resultadoLoad896, label %etiqThenIf903, label %etiqThenElse903
	etiqThenIf903:
	;entro al ASIGNACION 899
	;entro al Identificador 898
	%var898 = load i1, i1* @varlogica
	store i1 %var898, i1* @resultado
	%resultadoLoad898 = load i1, i1* @resultado
	store i1 %resultadoLoad898, i1* @_aux7
	br label %etiqEndIf903
	etiqThenElse903:
	;entro al ASIGNACION 902
	;entro al Identificador 901
	%var901 = load i1, i1* @_retornoFilterDefault7
	store i1 %var901, i1* @resultado
	%resultadoLoad901 = load i1, i1* @resultado
	store i1 %resultadoLoad901, i1* @_aux7
	br label %etiqEndIf903
	etiqEndIf903:
	;entro al ASIGNACION 908
	;entro al Identificador 904
	%var904 = load i1, i1* @_aux7
	store i1 %var904, i1* @resultado
	%resultadoLoad904 = load i1, i1* @resultado
	store i1 %resultadoLoad904, i1* @varlogica2
	;entro al Identificador 909
	%var909 = load i1, i1* @varlogica2
	store i1 %var909, i1* @resultado
	%resultadoLoad909 = load i1, i1* @resultado
	call void @printBool(i1 %resultadoLoad909)
	br label %etiqEndFor914
	;entro al Identificador 912
	%var912 = load i32, i32* @i
	%dest913 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var912)
	br label %etiqIncreDecremFor914
	etiqIncreDecremFor914:
	%var914 = add i32 %var811, %var812
	store i32 %var914, i32* @i
	br label %etiqForCondicion914
	etiqEndFor914:
	br label %etiqEndIf915
	etiqEndIf915:
	
	ret i32 0
}