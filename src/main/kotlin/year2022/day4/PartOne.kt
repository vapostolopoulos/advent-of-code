package year2022.day4

private const val ZERO = 0
private const val ONE = 1

internal fun partOne(input: List<String>): Int =
  input.sumOf {
    val numbers = splitInputToNumbers(it)
    if (oneSequenceContainsTheOther(numbers))
      ONE
    else
      ZERO
  }

private fun splitInputToNumbers(row: String): List<Int> =
  row.split(",").flatMap { it.split("-") }.map { it.toInt() }

private fun oneSequenceContainsTheOther(numbers: List<Int>) =
  (numbers[0] >= numbers[2] && numbers[1] <= numbers[3]) || (numbers[2] >= numbers[0] && numbers[3] <= numbers[1])

