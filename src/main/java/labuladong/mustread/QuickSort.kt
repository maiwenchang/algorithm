import java.util.*

fun main() {
    println(Date().toString())

    val array = arrayOf(2, 6, 1, 4, 7, 3, 5,1,2,3,4,5,6,7)
    array.println()
    quickSort(array, 0, array.size - 1)
    array.println()
}

/**
 * 快速排序
 */
fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val position = partitionFromMiddle(array, start, end)
    quickSort(array, start, position)
    quickSort(array, position + 1, end)
}

/**
 * 取最后一个元素作为基准
 */
fun partition(array: Array<Int>, start: Int, end: Int): Int {
    val pivot = array[end]
    var i = start

    for (j in start..end) {
        println("compare $j $end")
        if (array[j] < pivot) {
            array.swap(j, i)
            println("swap j = $j, i = $i")
            array.println()
            i++
        }
    }

    array.swap(i, end)
    println("swap i = $i, end = $end")
    array.println()
    println("partition = $i")
    return i
}

/**
 * 取中间元素作为基准
 */
fun partitionFromMiddle(array: Array<Int>, start: Int, end: Int): Int {
    val middle = (start + end) / 2
    val pivot = array[middle]
    var i = start
    var j = end
    do {
        while (array[i] < pivot) {
            i++
        }
        while (array[j] > pivot) {
            j--
        }
        if (i >= j) {
            return j
        }
        array.swap(i, j)
        println("swap i = $i, j = $j, pivot = $pivot")
        array.println()
        i++
        j--
    } while (true)
}

