package vitaliy.grab.oop

class ValidateInput(private val out: Output, private val `in`: Input) : Input {
    override fun askStr(question: String?): String? {
        return `in`.askStr(question)
    }

    override fun askInt(question: String?): Int {
        var invalid = true
        var value = -1
        do {
            try {
                value = `in`.askInt(question)
                invalid = false
            } catch (_: NumberFormatException) {
                out.println("Please enter valid data again")
            }
        } while (invalid)
        return value
    }
}
