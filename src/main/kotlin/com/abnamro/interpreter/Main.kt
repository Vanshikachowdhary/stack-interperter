//package com.abnamro.interpreter
//
//fun main(){
//
//    val x =5
//    val s = $$"""Hello \n world
//        somethingggg $x $$x $$$
//    """
//    println(s)
//    val s2 = "Hello \\n world"
//    println(s2)
//
//    val regex = Regex("([A-Z]_[A-Z]+)\\((\\d+)\\)")
//    val op = regex.find("I_LOAD(5)")?.groupValues[1]
//    val value = regex.find("I_LOAD(5)")?.groupValues[2]
//    println(op)
//
////    val regex = Regex("([A-Z]_[A-Z]+)\\((\\d+)\\)")
////    val opName = regex.find(stringInstruction)?.groupValues[1]
////    val value = regex.find(stringInstruction)?.groupValues[2]
////    stringInstruction.substringAfter("(").substringBefore(")")
////    stringInstruction.substringBefore("(")
//
//
//    val factory = InstructionFactory()
//    factory.runInstructions("I_LOAD(5),I_LOAD(8),I_ADD,I_PRINT")
//    println("****************************************************************")
//
//    factory.runInstructions("I_LOAD(5),I_LOAD(8),I_SUBTRACT,I_PRINT")
//    println("****************************************************************")
//
//    factory.runInstructions("L_LOAD(5),L_LOAD(8),L_ADD,L_PRINT")
//    println("****************************************************************")
//
//    factory.runInstructions("L_LOAD(5),L_LOAD(8),L_SUBTRACT,L_PRINT")
//    println("****************************************************************")
//
//////    fib(4)
////    val routine = Routine(
////        "fibonacci",
////        listOf("I_LOAD(4)","I_LOAD(2)","I_LESS_THAN",),
////        1
////    )
//
//
//
//
//
//
//
//
//
////    factory.runInstructions("L_PRINT")
////    val listOfInstruction = listOf("LOAD 8","LOAD 4","LOAD 3","ADD","ADD","PRINT")
////    val number: Long =353564382912
////    val firstpart = (number shr 32).toInt()
////    val secondpart = (number and Int.MAX_VALUE.toLong()).toInt()
//
////    val returnog = (firstpart.toLong() shl 32) or (secondpart.toLong() and 0xFFFFFFFFL)
////    print("""
////        original number: $number
////        secondpart: $secondpart
////        firstpart: $firstpart
////        returnog: $returnog
////    """.trimIndent())
//
////    1 and 2
////    2 xor 3
////    0b0001000 shl 2
////    0b10110101 and 0b10110101
////    0b10110101 and 0b00000000
//////load_l load_i
////    0b10110101
////    var first = 0b1011
////    var second = 0b0000101
////
//////    0b10110000
////    var org = (first shl 4 ) or second
//}
