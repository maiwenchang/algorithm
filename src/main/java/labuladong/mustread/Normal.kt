/**
 * 基本算法
 */

fun main() {

    //test swap function
    val array = arrayOf(1, 2)
    array.println()
    array.swap(0, 1)
    array.println()

}

fun <T> Array<T>.swap(i: Int, j: Int) {
    if (i == j) {
        return
    }
    with(this[i]) {
        this@swap[i] = this@swap[j]
        this@swap[j] = this
    }
}

fun <T> Array<T>.println() {
    println(this.joinToString(","))
}


