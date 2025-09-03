package com.abnamro.interpreter

import java.util.Stack


class InstructionFactory {

//    fun runInstructions(stringInstructions: String) {
//        parseInstructions(stringInstructions).maxStackSize().also { println("Max Stack Size:${it}") }
//        parseInstructions(stringInstructions).executeInstructions()
//    }

     fun parseInstructions(input: String): InstructionType {
//        val actualInstructions = mutableListOf<InstructionType>()
////        val stringInstructions = input.split(",")
//
//        for (stringInstruction in input) {
//INVOKE SUB I_LOAD(5)
            val l = input.split(" ")
            val value = l.getOrNull(1)
            val opName = l.getOrNull(0)
            return when (opName) {
                "I_LOAD" -> Instructions.I_Load(value!!.toInt())
                "L_LOAD" -> Instructions.L_Load(value!!.toLong())
                "I_ADD" -> Instructions.I_Add
                "L_ADD" -> Instructions.L_Add
                "I_SUBTRACT" -> Instructions.I_Subtract
                "L_SUBTRACT" -> Instructions.L_Subtract
                "I_PRINT" -> Instructions.I_Print
                "L_PRINT" -> Instructions.L_Print
                "I_EQUALS" -> Instructions.I_Equals
                "INVOKE" -> Instructions.Invoke(value!!)

                else -> throw Exception("$input is not a valid instruction")
            }

    }

    private fun List<InstructionType>.maxStackSize(): Int {
        var currentSize = 0
        var maxSize = 0
        for (instruction in this) {
            currentSize += instruction.stackEffect()
            if (currentSize > maxSize) maxSize = currentSize
        }
        return maxSize
    }
}
