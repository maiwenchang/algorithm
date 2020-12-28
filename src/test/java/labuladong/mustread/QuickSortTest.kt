package labuladong.mustread

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import println
import quickSort
import quickSortFromStart

class QuickSortTest {

    @Test
    fun should_sort_when_quickSortFromStart_given_array() {

        val array = arrayOf(2, 6, 1, 4, 7, 3, 5, 1, 2, 3, 4, 5, 6, 7)
        array.println()

        quickSortFromStart(array, 0, array.size - 1, 0)

        val expect = arrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7)
        Assertions.assertArrayEquals(expect, array)
    }

    @Test
    fun should_sort_when_quickSort_given_array() {

        val array = arrayOf(2, 6, 1, 4, 7, 3, 5, 1, 2, 3, 4, 5, 6, 7)
        array.println()

        quickSort(array, 0, array.size - 1)

        val expect = arrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7)
        Assertions.assertArrayEquals(expect, array)
    }
}