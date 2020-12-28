import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt

/*斐波那契数列*/
fun main() {

    for (i in -1..92L) {
        println(fib(i))
    }
}

fun fib(N: Long): Long {
    if (N < 1) {
        return 0
    }
    if (N == 1L || N == 2L) {
        return 1
    }
    var pre = 1L
    var curr = 1L
    for (i in 3..N) {
        val sum = pre + curr
        pre = curr
        curr = sum
    }
    return curr
}

/**
 * 公式法,使用黄金分割率计算第 N 个斐波那契数。
 * 使用黄金分割比,我们可以只能用常数时间和常数空间得到斐波那契数。
 */
fun fib(N: Int): Long {
    val goldenRatio: Double = (1 + sqrt(5.0)) / 2
    return (goldenRatio.pow(N) / sqrt(5.0)).roundToLong()
}