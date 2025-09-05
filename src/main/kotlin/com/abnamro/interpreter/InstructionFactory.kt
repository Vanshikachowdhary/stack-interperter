package com.abnamro.interpreter


class InstructionFactory {
     fun parseInstructions(input: String): InstructionType {
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
                "I_RETURN" -> Instructions.I_Return

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
