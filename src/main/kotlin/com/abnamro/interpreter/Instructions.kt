package com.abnamro.interpreter

import com.abnamro.interpreter.HelperFunctions.getLongVal
import com.abnamro.interpreter.HelperFunctions.pushLongVal

class Instructions {

    data class Invoke(val functionName: String) : InstructionType {
        override fun stackEffect() = 0
        override fun execute(frame: StackFrame){}
    }

    object I_Equals : InstructionType {
        override fun stackEffect() = 1
        override fun execute(frame: StackFrame) {
            val res = frame.operandStack.pop() == frame.operandStack.pop()
            frame.operandStack.add(if (res) 1 else 0)
        }
    }

    data class I_Load(val value: Int) : InstructionType {
        override fun stackEffect() = 1
        override fun execute(frame: StackFrame) {
            frame.operandStack.add(value)
        }
    }

    data class L_Load(val value: Long) : InstructionType {
        override fun stackEffect() = 2
        override fun execute(frame: StackFrame) {
            pushLongVal(value, frame.operandStack)
        }
    }

    object I_Add : InstructionType {
        override fun stackEffect() = -1
        override fun execute(frame: StackFrame) {
            frame.operandStack.push(frame.operandStack.pop() + frame.operandStack.pop())
        }
    }

    object L_Add : InstructionType {
        override fun stackEffect() = -2
        override fun execute(frame: StackFrame) {
            val b = getLongVal(frame.operandStack)
            val a = getLongVal(frame.operandStack)
            val result = a + b
            pushLongVal(result, frame.operandStack)
        }
    }

    object I_Subtract : InstructionType {
        override fun stackEffect() = -1
        override fun execute(frame: StackFrame) {
            frame.operandStack.push(frame.operandStack.pop() - frame.operandStack.pop())
        }
    }

    object L_Subtract : InstructionType {
        override fun stackEffect() = -2
        override fun execute(frame: StackFrame) {
            val b = getLongVal(frame.operandStack)
            val a = getLongVal(frame.operandStack)
            val result = b - a
            pushLongVal(result, frame.operandStack)
        }
    }

    object I_Print : InstructionType {
        override fun stackEffect() = -1
        override fun execute(frame: StackFrame) = println(frame.operandStack.pop())
    }

    object L_Print : InstructionType {
        override fun stackEffect(): Int = -2
        override fun execute(frame: StackFrame) {
            println(getLongVal(frame.operandStack))
        }
    }
}
