package year2015.day5

internal fun partTwo(input: List<String>): Int =
  input.count { it.isNice() }

private fun String.isNice(): Boolean =
  pairOfAnyTwoLettersAppearsTwiceNoOverlap() && letterRepeatsWithExactlyOneLetterBetween()

private fun String.pairOfAnyTwoLettersAppearsTwiceNoOverlap(): Boolean {
  val allPossiblePairsList = this.zipWithNext()
  for (i in 0..<allPossiblePairsList.size - 1) {
    for (j in (i + 1)..<(allPossiblePairsList.size)) {
      if (allPossiblePairsList[i] == allPossiblePairsList[j] && (j != i + 1)) {
        return true
      }
    }
  }
  return false
}

private fun String.letterRepeatsWithExactlyOneLetterBetween(): Boolean {
  val allPossiblePairsList = this.zipWithNext()
  for (i in 0..<allPossiblePairsList.size - 1) {
    if (allPossiblePairsList[i].first == allPossiblePairsList[i + 1].second) {
      return true
    }
  }
  return false
}
