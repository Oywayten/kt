package oywayten.oop

class EmailService {

    fun emailTo(message: Message): String {
        return with(StringBuilder()) {
            append("Subject: ")
            append(message.emailSubject)
            append(" ")
            append("Body: ")
            append("Hello, ")
            append(message.receiverName)
            append(" ")
            append("You win!")
            toString()
        }
    }
}