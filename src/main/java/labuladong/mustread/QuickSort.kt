import java.util.*

fun main() {
    println(Date().toString())

    val array = arrayOf(2, 6, 1, 4, 7, 3, 5, 1, 2, 3, 4, 5, 6, 7)
    array.println()
    quickSort(array, 0, array.size - 1)
    array.println()
}

/**
 * 取第一个元素为基准
 */
fun quickSortFromStart(array: Array<Int>, left: Int, right: Int, pivotPosition: Int) {
    if (left >= right) {
        return
    }
    val position = partitionFromPosition(array, left, right, pivotPosition)
    quickSortFromStart(array, left, position - 1, left)
    quickSortFromStart(array, position + 1, right, position + 1)
//    array.println()
}

/**
 * 取n个元素为基准
 * @param pivotPosition
 */
fun partitionFromPosition(array: Array<Int>, left: Int, right: Int, pivotPosition: Int): Int {
    val pivotValue = array[pivotPosition]
    var pivotOffset = left
    array.swap(pivotPosition, right)
    for (i in left until right) {
        if (array[i] <= pivotValue) {
            array.swap(pivotOffset, i)
            pivotOffset++
        }
    }
    array.swap(pivotOffset, right)
    return pivotOffset
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
//        println("swap i = $i, j = $j, pivot = $pivot")
//        array.println()
        i++
        j--
    } while (true)
}


/**
 * 三路快排
 */
fun quickSortThreePart(array: Array<Int>, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val position = partitionOfThreeDivision(array, left, right)
    quickSortThreePart(array, left, position[0])
    quickSortThreePart(array, position[1], right)
}

fun partitionOfThreeDivision(array: Array<Int>, left: Int, right: Int): IntArray {
    val position = IntArray(2)
    val pivotValue = array[left]
    var pLeft = left + 1
    var pRight = right
    var index = left + 1
    do {
        val current = array[index]
        if (current == pivotValue) {
            index++
        } else if (current > pivotValue) {
            array.swap(index, pRight)
            pRight--
        } else {
            array.swap(index, pLeft)
            pLeft++
            index++
        }
    } while (index < pRight)
    array.swap(left, --pLeft)

    position[0] = --pLeft
    position[1] = pRight
    return position
}

