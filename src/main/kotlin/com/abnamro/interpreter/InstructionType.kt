package com.abnamro.interpreter

import java.util.Stack

interface InstructionType{
    fun stackEffect(): Int
    fun execute(frame: StackFrame)
}





