package year2015.day1

internal fun partOne(input: String): Int {
  var floor = 0

  input.forEach {
    when (it) {
      '(' -> floor++
      ')' -> floor--
    }
  }

  return floor
}
