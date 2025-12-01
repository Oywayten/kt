package vitaliy.grab

fun defragment(array: Array<String?>) {
    var first = 0
    var second = 0

    fun swapIfNeed() {
        if (array[first] == null
            && array[second] != null
        ) {
            val tmp = array[first]
            array[first] = array[second]
            array[second] = tmp
        }
    }

    while (second < array.size) {
        if (second <= first
            || array[second] == null
        ) {
            second++
        } else if (array[first] != null) {
            first++
        } else {
            swapIfNeed()
        }
    }
}
