package com.abnamro.interpreter

import java.util.Stack

object HelperFunctions {
     fun getLongVal(stack: Stack<Int>): Long {
        val low = stack.pop().toLong() and 0xFFFFFFFF
        val high = stack.pop().toLong() shl 32
        return high or low
    }

     fun pushLongVal(value :Long, stack: Stack<Int>) {
        val firstpart = (value shr 32).toInt()
        val secondpart = (value and Int.MAX_VALUE.toLong()).toInt()
        stack.push(firstpart)
        stack.push(secondpart)
    }
}