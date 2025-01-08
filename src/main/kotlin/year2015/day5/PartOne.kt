package year2015.day5

private const val VOWELS = "aeiou"
private val ILLEGAL_STRINGS = listOf("ab", "cd", "pq", "xy")

internal fun partOne(input: List<String>): Int =
  input.count { it.isNice() }

private fun String.isNice(): Boolean =
  hasThreeVowels() && hasDoubleLetter() && !containsForbiddenStrings()

private fun String.hasThreeVowels(): Boolean =
  count { it in VOWELS } >= 3

private fun String.hasDoubleLetter(): Boolean =
  zipWithNext().any { it.first == it.second }

private fun String.containsForbiddenStrings(): Boolean =
  ILLEGAL_STRINGS.any { it in this }
