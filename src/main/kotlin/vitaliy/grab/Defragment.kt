package vitaliy.grab

fun defragment(array: Array<String?>) {
    var pointer1 = 0
    var pointer2 = 0

    fun swapIfNeed() {
        if (array[pointer1] == null
            && array[pointer2] != null
        ) {
            val tmp = array[pointer1]
            array[pointer1] = array[pointer2]
            array[pointer2] = tmp
        }
    }

    while (pointer2 < array.size) {
        if (pointer2 <= pointer1
            || array[pointer2] == null
        ) {
            pointer2++
        } else if (array[pointer1] != null) {
            pointer1++
        } else {
            swapIfNeed()
        }
    }
}
