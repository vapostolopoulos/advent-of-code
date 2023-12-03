package year2022.day1

internal fun partTwo(input: List<String>) =
  getCaloriesPerElf(input).sorted().takeLast(3).sum()
