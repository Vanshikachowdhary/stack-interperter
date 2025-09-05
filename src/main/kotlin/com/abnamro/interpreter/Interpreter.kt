package com.abnamro.interpreter

import java.util.Stack

class Interpreter {
    val allRoutines = mutableMapOf<String, Routine>()
    private val instructionFactory = InstructionFactory()
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
        return Routine(functionName, actualInstruction, numArgument)
    }

    fun loadRoutines(input: List<String>) {
        for (routineStr in input) {
            val routine = parseRoutine(routineStr)
            allRoutines[routine.functionName] = routine
        }
    }

    fun executeRoutine(routine: Routine, args: List<Int> = emptyList()) {
        val frame = StackFrame(routine)
        callStack.push(frame)

        args.forEach { frame.operandStack.add(it) }

        routine.operations.forEach { operation ->
            if (operation is Instructions.Invoke) {
                val routine = allRoutines[operation.functionName]
                    ?: throw IllegalArgumentException("$operation is not a valid routine")

                val arguments = (0..<routine.numArguments).map { frame.operandStack.pop() }

                executeRoutine(routine, arguments)
                val returnValue = callStack.pop().returnVal
                frame.operandStack.add(returnValue)
            }
            else operation.execute(frame)
        }
        //    TODO() = initial method frame is still on the stack
    }
}
