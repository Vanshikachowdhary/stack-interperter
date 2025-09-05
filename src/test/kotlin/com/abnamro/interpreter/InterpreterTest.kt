package com.abnamro.interpreter

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun test3() {
        val input = """
            fun sum
            arguments=0
            I_LOAD 3
            I_LOAD 5
            I_ADD
            I_PRINT
        """.trimIndent()


        val mainMethodBytecode = """
            fun main
            arguments=0
            I_LOAD 7
            I_LOAD 7
            I_ADD
            INVOKE sum
            I_ADD
            """.trimIndent()

        val interpreter = Interpreter()
        interpreter.loadRoutines(listOf(input, mainMethodBytecode))
        assertThat(interpreter.allRoutines).containsKey("main")
        val routine = interpreter.allRoutines["main"]!!
        val res = interpreter.executeRoutine(routine)
        println(res)
    }

    @Test
    fun test4() {
        val input = """
            fun addition
            arguments=2
            I_ADD
            I_RETURN
        """.trimIndent()

        val mainMethodBytecode = """
            fun main
            arguments=0
            I_LOAD 7
            I_LOAD 13
            INVOKE addition
            """.trimIndent()

        val interpreter = Interpreter()
        interpreter.loadRoutines(listOf(input, mainMethodBytecode))
        val routine = interpreter.allRoutines["main"]!!

        interpreter.executeRoutine(routine)

        assertThat(interpreter.allRoutines).containsKey("main")
        assertThat(interpreter.allRoutines).containsKey("addition")
        assertThat(interpreter.callStack.size).isEqualTo(1)
        assertThat(interpreter.callStack.peek().operandStack.peek()).isEqualTo(20)

    }
}
