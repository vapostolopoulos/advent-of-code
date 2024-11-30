package year2015.day4

private const val SIX_ZEROES = "000000"

internal fun partTwo(input: String): Int =
  generateSequence(0) { number ->
    number + 1
  }.first { number ->
    md5Hash(input + number).take(6) == SIX_ZEROES
  }
