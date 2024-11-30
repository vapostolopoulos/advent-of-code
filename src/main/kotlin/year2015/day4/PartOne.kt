package year2015.day4

private const val FIVE_ZEROES = "00000"

internal fun partOne(input: String): Int =
  generateSequence(0) { number ->
    number + 1
  }.first { number ->
    md5Hash(input + number).take(5) == FIVE_ZEROES
  }
