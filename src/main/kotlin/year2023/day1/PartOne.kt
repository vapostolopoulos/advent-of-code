package year2023.day1

internal fun partOne(inputs: List<String>): Int {
  var sum = 0
  inputs.forEach { input ->
    val digits = input.filter { it.isDigit() }
    val calibrationValue = digits.first().toString() + digits.last().toString()
    sum += calibrationValue.toInt()
  }
  return sum;
}
