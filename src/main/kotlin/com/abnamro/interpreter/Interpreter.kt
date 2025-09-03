package com.abnamro.interpreter

import java.util.*

class Interpreter {
    public val allRoutines = mutableMapOf<String, Routine>()
    val instructionFactory = InstructionFactory()
    val callStack = Stack<StackFrame>()

    fun parseRoutine(input: String): Routine {
        val actualInstruction = mutableListOf<InstructionType>()
        val inputAsList = input.lines().map { it.trim() }.filter { it.isNotEmpty() }
        val functionName = inputAsList[0].substringAfter("fun").trim()
        val numArgument = inputAsList[1].substringAfter("arguments=").trim().toInt()
        val routineInstructions = inputAsList.drop(2)

        for (routineInstruction in routineInstructions) {
                actualInstruction.add(instructionFactory.parseInstructions(routineInstruction))
        }
        return Routine(functionName, actualInstruction,numArgument)
    }

    fun loadRoutines(input: List<String>) {
        for (routineStr in input) {
            val routine = parseRoutine(routineStr)
            allRoutines[routine.functionName] = routine
        }
    }

    fun executeRoutine(routine: Routine) {
        val frame = StackFrame(routine)
        callStack.push(frame)
        routine.operations.forEach { operation -> operation.execute(frame) }

    }


//    fun startExecution(functionName: String): Unit {
//        val routine = allRoutines[functionName]?:throw Exception("$functionName is not found")
//        callStack.push(StackFrame(functionName))
////        executeRoutine(routine)
//        }

//    fun executeRoutine(routine: Routine) {
//        val currentFrame = callStack.peek()
//        for (instr in routine.operations) {
//            when (instr) {
//                is InstructionType.
//                else -> {
//                    instructionFactory.executeInstructions(instr)
//
//                }
//            }
//
//}
}


val addMethodBytecode = """
    fun add
    arguments=2
    I_LOAD(5)
    I_LOAD(8)
    I_ADD
    I_PRINT
    """
val mainMethodBytecode = """
    fun main
    I_Load()
    fun add
    """

fun main() {
    val myWholeCodeBase = listOf(addMethodBytecode, mainMethodBytecode)
    val interpreter = Interpreter()
    interpreter.loadRoutines(myWholeCodeBase)
//    interpreter.startExecution("add")
}
