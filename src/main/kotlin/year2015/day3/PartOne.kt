package year2015.day3

internal fun partOne(input: String): Int {
  val visitedHouses = mutableSetOf<Pair<Int, Int>>()
  var x = 0
  var y = 0

  visitedHouses.add(Pair(x, y))

  input.forEach { direction ->
    when (direction) {
      '^' -> y++
      'v' -> y--
      '>' -> x++
      '<' -> x--
    }

    visitedHouses.add(Pair(x, y))
  }

  return visitedHouses.size
}
