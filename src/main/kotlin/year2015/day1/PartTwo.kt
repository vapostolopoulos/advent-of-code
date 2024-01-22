package year2015.day1

internal fun partTwo(input: String): Int {
  var floor = 0

  input.forEachIndexed { index, char ->
    when (char) {
      '(' -> floor++
      ')' -> floor--
    }
    if (floor == -1) return index + 1
  }

  return -1
}
