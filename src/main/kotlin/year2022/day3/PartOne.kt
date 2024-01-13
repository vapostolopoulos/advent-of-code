package year2022.day3

internal fun partOne(input: List<String>): Int =
  input.sumOf {
    val firstCompartment = it.slice(0..it.length / 2)
    val secondCompartment = it.slice(it.length / 2..<it.length)
    val commonLetter = findCommonLetter(firstCompartment, secondCompartment)

    calculateLetterPriority(commonLetter)
  }

private fun findCommonLetter(first: String, second: String): Char =
  first.toSet().intersect(second.toSet()).first()

private fun calculateLetterPriority(char: Char): Int =
  if (char.isLowerCase())
    char.code - 96
  else
    char.code - 38
