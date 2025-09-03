package com.abnamro.interpreter

import net.bytebuddy.matcher.ElementMatchers.any
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.MapEntry
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InterpreterTest {

    val input = """
    fun add
    arguments=2
    I_LOAD 5
    I_LOAD 8
    I_ADD
    I_PRINT
    INVOKE sub
    """

    @Test
    fun test() {
        val interpreter = Interpreter()
        val res = interpreter.parseRoutine(input)
        assertThat(res).isEqualTo(
            Routine(
                functionName = "add",
                operations = listOf(
                    Instructions.I_Load(5),
                    Instructions.I_Load(8),
                    Instructions.I_Add,
                    Instructions.I_Print,
                    Instructions.Invoke("sub")
                ),
                numArguments = 2
            )
        )
    }

    @Test
    fun test2() {
        val input = """
            fun main
            arguments=0
            I_LOAD 3
            I_LOAD 5
            I_ADD
            I_PRINT
        """.trimIndent()

        val interpreter = Interpreter()
        interpreter.loadRoutines(listOf(input))
        assertThat(interpreter.allRoutines).containsKey("main")
        val routine = interpreter.allRoutines["main"]!!
        interpreter.executeRoutine(routine)
    }
}
