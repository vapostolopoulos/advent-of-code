package year2023.day4

import kotlin.math.pow

internal fun partOne(inputs: List<String>): Int {
  var sum = 0
  inputs.forEach { row ->
    val splitRow = row.split(":", "|")
    val winningNumbers = getNumbersFromRow(splitRow[1])
    val yourNumbers = getNumbersFromRow(splitRow[2])
    val matches = getMatches(yourNumbers, winningNumbers)
    val points = calculatePoints(matches)
    sum += points
  }

  return sum;
}

private fun getNumbersFromRow(row: String) =
  row.trim().split(" ").filter { it != "" }.map { it.toInt() }

private fun getMatches(yourNumbers: List<Int>, winningNumbers: List<Int>) =
  yourNumbers.fold(0) { acc, number ->
    if (winningNumbers.contains(number)) {
      acc + 1
    } else {
      acc
    }
  }

private fun calculatePoints(number: Int) =
  (2.toDouble().pow(number - 1)).toInt()
