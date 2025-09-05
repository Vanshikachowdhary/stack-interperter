package com.abnamro.interpreter

import java.util.Stack


//Create a StackFrame class, this should hold local variables, operand stack,
//and a variable for the method invocation completion (see https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html)

//Create a class called Routine that contains a function-name, list of all operations,
// the required stack size, number of local variables and number of arguments (this represents a function)

//Fix your fibonacci function (we made some changes that doesn't give the right
//Execute the following command on the class file: javap -v -p Demo.class
//Implement all operations mentioned under "public int fibonacci(int);"
//Update the interpreter, it should:
//Parse a piece of bytecode into a Routine
//Store all routines in a Map<String, Routine>
//When interpreter starts executing a Routine, it should create a StackFrame for it
//It can use the map to find the code of any other routine
//BONUS: try to execute the bytecode output of the javap command. OR: write your own bytecode for two methods, a main method and the fibonacci.

class StackFrame (
    val routine: Routine,
    val operandStack: Stack<Int> = Stack(),
    val localVariables: MutableList<Int> = mutableListOf(),
    var returnVal: Int = 0
)


//routine(helper class) -> which contains all instruction ->
// calls interpreter to execute-> return value to stackframe ->
