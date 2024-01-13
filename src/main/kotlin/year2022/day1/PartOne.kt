package year2022.day1

internal fun partOne(input: List<String>) =
  getCaloriesPerElf(input).max()

internal fun getCaloriesPerElf(input: List<String>): List<Int> {
  val caloriesPerElf = mutableListOf<Int>()
  var sum = 0
  input.forEach { row ->
    if (row == "" || row == input.last()) {
      caloriesPerElf.add(sum)
      sum = 0
      return@forEach
    }
    sum += row.toInt()
  }

  return caloriesPerElf
}

