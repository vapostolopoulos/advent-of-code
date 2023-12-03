package year2023.day1

internal fun partTwo(inputs: List<String>): Int {
  var sum = 0
  inputs.forEach { input ->
    val transformedInput = input.transform()
    val digits = transformedInput.filter { it.isDigit() }
    val calibrationValue = digits.first().toString() + digits.last().toString()
    sum += calibrationValue.toInt()
  }
  return sum;
}

private fun String.transform(): String {
  var result = ""
  for (i in 1..this.length) {
    result += this.subSequence(i - 1, i).toString()
    result = result.replaceSpelledDigits()
  }
  return result
}

private fun String.replaceSpelledDigits() =
  this.replace("one", "1e")
    .replace("two", "2o")
    .replace("three", "3e")
    .replace("four", "4r")
    .replace("five", "5e")
    .replace("six", "6x")
    .replace("seven", "7n")
    .replace("eight", "8t")
    .replace("nine", "9e")
