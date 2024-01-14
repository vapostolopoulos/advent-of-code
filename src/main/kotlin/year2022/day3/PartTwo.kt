package year2022.day3

internal fun partTwo(input: List<String>): Int {
  val inputInChunksOfThree = input.chunked(3)

  return inputInChunksOfThree.sumOf {
    val commonLetter = findCommonLetter(it)
    calculateLetterPriority(commonLetter)
  }
}

private fun findCommonLetter(chunk: List<String>): Char {
  val firstRucksack = chunk[0].toSet()
  val secondRucksack = chunk[1].toSet()
  val thirdRucksack = chunk[2].toSet()

  return firstRucksack.intersect(secondRucksack).intersect(thirdRucksack).first()
}
