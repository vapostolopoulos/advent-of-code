package year2015.day5

internal fun partTwo(input: List<String>): Int =
  input.count { it.isNice() }

private fun String.isNice(): Boolean =
  hasPairThatAppearsTwiceWithNoOverlap() && hasRepeatingLetterWithOneLetterBetween()

private fun String.hasPairThatAppearsTwiceWithNoOverlap(): Boolean =
  (0..<length - 1).any { i ->
    val pair = substring(i, i + 2)
    substring(i + 2).contains(pair)
  }

private fun String.hasRepeatingLetterWithOneLetterBetween(): Boolean =
  windowed(3).any { it[0] == it[2] }
