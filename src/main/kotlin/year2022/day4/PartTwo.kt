package year2022.day4

internal fun partTwo(input: List<String>): Int =
  input.sumOf {
    val (sequence1, sequence2) = splitInputToPairOfSequences(it)
    if (oneSequenceOverlapsWithTheOther(sequence1, sequence2))
      ONE
    else
      ZERO
  }

private fun splitInputToPairOfSequences(row: String): Pair<Set<Int>, Set<Int>> {
  val numbers = splitInputToNumbers(row)
  val sequence1 = (numbers[0]..numbers[1]).toSet()
  val sequence2 = (numbers[2]..numbers[3]).toSet()
  return Pair(sequence1, sequence2)
}

private fun oneSequenceOverlapsWithTheOther(sequence1: Set<Int>, sequence2: Set<Int>) =
  sequence1.intersect(sequence2).isNotEmpty()


