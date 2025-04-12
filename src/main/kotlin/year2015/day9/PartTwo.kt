package year2015.day9

internal fun partTwo(input: List<String>): Int {
  val (distances, cities) = distancesAndCitiesFrom(input)
  val permutations = cities.permutations()
  val routes = allPossibleRoutesFrom(permutations)

  return routes.maxOf { route ->
    route.sumOf { distances[it]!! }
  }
}
