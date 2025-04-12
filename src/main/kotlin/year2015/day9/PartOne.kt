package year2015.day9

internal fun partOne(input: List<String>): Int {
  val (distances, cities) = distancesAndCitiesFrom(input)
  val permutations = cities.permutations()
  val routes = allPossibleRoutesFrom(permutations)

  return routes.minOf { route ->
    route.sumOf { distances[it]!! }
  }
}
