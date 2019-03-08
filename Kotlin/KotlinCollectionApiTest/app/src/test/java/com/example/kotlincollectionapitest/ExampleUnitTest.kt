package com.example.kotlincollectionapitest

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun all() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(true, fruitList.all { it.length >= 5 })
        assertEquals(false, fruitList.all { it.contains("apple") })
    }

    @Test
    fun any() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(true, fruitList.any { it.length >= 10 })
        assertEquals(true, fruitList.any { it.contains("apple") })
    }

    @Test
    fun none() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(true, fruitList.none { it.length < 5 })
        assertEquals(true, fruitList.none { it.contains("watermelon") })
    }

    @Test
    fun find() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals("pineapple", fruitList.find { it.contains("apple") })
        assertEquals("apple", fruitList.findLast { it.contains("apple") })
    }

    @Test
    fun count() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(2, fruitList.count { it.contains("apple") })
    }

    @Test
    fun map() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(110, numberList.map { it * 2 }.sum())
    }

    @Test
    fun flatMap() {
        val numberList = listOf(2, 5, 11)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), numberList.flatMap { (it / 2 until it) })
    }

    @Test
    fun filter() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(listOf("pineapple", "apple"), fruitList.filter { it.contains("apple") })
    }

    @Test
    fun asSequence() {
        val numberList = listOf(1, 2, 3, 4, 5)
        numberList.filter{ println("first no asSequence $it");it%2==0}.map { println("second no asSequence $it"); it*2  }.toList()
        numberList.asSequence().filter{ println("first no result $it");it%2==0}.map { println("second no result $it"); it*2 }
        print(numberList.asSequence().filter{ println("first asSequence $it");it%2==0}.map { println("second asSequence $it"); it*2  }.toList())

        val numbers = generateSequence(0) { it + 1 }
        val numbersTo10 = numbers.takeWhile { print(it);it <= 10 }
        println("before sum")
        println(numbersTo10.sum())
    }

    @Test
    fun zip() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        val priceList = listOf(1500,1000,2000,700,500,10000)
        assertEquals(listOf(
            "strawberry is 1500won",
            "grape is 1000won",
            "pineapple is 2000won",
            "banana is 700won",
            "apple is 500won"
        ),
            fruitList.zip(priceList).map { "${it.first} is ${it.second}won" })
        //Pair<String,Int>
    }

    @Test
    fun groupBy() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals(mapOf(
            10 to listOf("strawberry"), 5 to listOf("grape", "apple"), 9 to listOf("pineapple"),
            6 to listOf("banana")
        ), fruitList.groupBy { it.length })
        //Map<Int,List<String>>
    }

    @Test
    fun distinct() {
        val numberList = listOf(1, 2, 3, 4, 5,1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), numberList)
        assertEquals(listOf(1, 2, 3, 4, 5), numberList.distinct())
        assertEquals(listOf(1, 2, 4), numberList.distinctBy { it / 2 })
    }

    @Test
    fun take() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(listOf(1, 2, 3, 4, 5), numberList.take(5))
        assertEquals(listOf(6, 7, 8, 9, 10), numberList.takeLast(5))
        assertEquals(listOf(1, 2, 3), numberList.takeWhile { it / 4 == 0 })
        assertEquals(listOf(8, 9, 10), numberList.takeLastWhile { it / 4 > 1 })
    }

    @Test
    fun drop() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(listOf(6, 7, 8, 9, 10), numberList.drop(5))
        assertEquals(listOf(1, 2, 3, 4, 5), numberList.dropLast(5))
        assertEquals(listOf(6, 7, 8, 9, 10), numberList.dropWhile { it / 6 == 0 })
        assertEquals(listOf(1, 2, 3, 4, 5), numberList.dropLastWhile { it / 3 > 1 })
    }

    @Test
    fun firstAndLast() {
        val fruitList = listOf("strawberry", "grape", "pineapple", "banana", "apple")
        assertEquals("strawberry", fruitList.first())
        assertEquals("apple", fruitList.last())
    }

    @Test
    fun max() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val fruitList = listOf("strawberry", "grape", "pineapple", "plum","banana", "apple")
        assertEquals(10, numberList.max())
        assertEquals("strawberry", fruitList.max())
        assertEquals("strawberry", fruitList.maxBy { it.length })
    }

    @Test
    fun min() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val fruitList = listOf("strawberry", "grape", "pineapple", "plum","banana", "apple")
        assertEquals(1, numberList.min())
        assertEquals("apple", fruitList.min())
        assertEquals("plum", fruitList.minBy { it.length })
    }

    @Test
    fun average() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(5.5, numberList.average())
    }

    @Test
    fun joinToString() {
        val fruitList = listOf("strawberry", "grape", "pineapple","banana", "apple")
        assertEquals("strawberry, grape, pineapple, banana, apple", fruitList.joinToString())
        assertEquals("strawberry grape pineapple banana apple", fruitList.joinToString(" "))
        assertEquals(
            "strawb!!rry, grap!!, pin!!appl!!, banana, appl!!",
            fruitList.joinToString { it.replace("e", "!!") })
    }
}
