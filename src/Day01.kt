var map = mapOf(
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9'
)

fun getDigits1(line: String): Int {
    var firstDigit = '0'
    var lastDigit = '0'

    for (char in line) {
        if (char.isDigit()) {
            if (firstDigit == '0') {
                firstDigit = char
            }

            lastDigit = char
        }
    }

    return String().plus(firstDigit).plus(lastDigit).toInt()
}

fun getDigits2(line: String): Int {
    var firstDigit = '0'
    var lastDigit = '0'

    for (i in line.indices) {
        val currentChar = line[i]

        if (currentChar.isDigit()) {
            if (firstDigit == '0') {
                firstDigit = currentChar
            }

            lastDigit = currentChar
        } else {
            val lineStartingFrom = line.substring(i, line.length)

            for (digit in map.keys) {
                if (lineStartingFrom.startsWith(digit)) {
                    if (firstDigit == '0') {
                        firstDigit = map[digit]!!
                    }

                    lastDigit = map[digit]!!
                }
            }
        }
    }

    return String().plus(firstDigit).plus(lastDigit).toInt()
}

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0

        for (line in input) {
            total += getDigits1(line)
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0

        for (line in input) {
            total += getDigits2(line)
        }

        return total
    }

    val input = readInput("day1_input")

    part1(input).println()
    part2(input).println()
}