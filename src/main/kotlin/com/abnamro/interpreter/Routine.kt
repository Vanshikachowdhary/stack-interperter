package com.abnamro.interpreter


//Create a class called Routine that contains a function-name, list of all operations,
// the required stack size, number of local variables and number of arguments (this represents a function)

data class Routine(
    val functionName: String,
    val operations: List<InstructionType>,
    val numArguments: Int,
//    val numLocalVariables: Int,
)
