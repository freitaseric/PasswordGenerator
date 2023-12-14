import kotlin.random.Random

fun main() {
    val pass = PasswordGenerator().gen(3, 16)

    println(pass)
}

class PasswordGenerator() {
    companion object {
        private val characters = listOf("abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "1234567890", "!@#$%&*_+-=~^/?;:.,<>\'\"")
    }

    fun gen(temp: Int, length: Int = 8): String {
        validateTemperature(temp)
        validateLength(length)

        val availableChars = getAvaliableCharacters(temp)
        val password = createPassword(availableChars, length)

        return password
    }

    private fun createPassword(chars: String, length: Int): String {
        var result = ""

        for (i in 0 until length) {
            val rand = Random.nextInt(0, chars.length)

            result += chars[rand]
        }

        return result
    }
    private fun getAvaliableCharacters(temp: Int): String {
        var result = ""

        for (chars in characters) {
            if (characters.indexOf(chars) <= temp) {
                result += chars
            }
        }

        return result
    }

    private fun validateTemperature(temp: Int): Boolean {
        if (temp > 3 || temp < 0) {
            throw IllegalArgumentException("This temperature ($temp) is invalid.")
        }

        return true
    }
    private fun validateLength(length: Int): Boolean {
        if (length < 4) {
            throw IllegalArgumentException("This length ($length) is short.")
        }

        return true
    }
}
