package year2015.day9

internal fun distancesAndCitiesFrom(input: List<String>): Pair<Map<Pair<String, String>, Int>, Set<String>> {
  val distances = mutableMapOf<Pair<String, String>, Int>()
  val cities = mutableSetOf<String>()

  input.forEach { line ->
    val (cityA, _, cityB, _, distance) = line.split(" ")
    distances[cityA to cityB] = distance.toInt()
    distances[cityB to cityA] = distance.toInt()
    cities.add(cityA)
    cities.add(cityB)
  }
  return distances to cities
}

internal fun Set<String>.permutations(): Set<List<String>> {
  if (isEmpty()) return setOf(emptyList())
  return flatMap { element ->
    (this - element).permutations().map { listOf(element) + it }
  }.toSet()
}

internal fun allPossibleRoutesFrom(permutations: Set<List<String>>): Array<List<Pair<String, String>>> =
  permutations.map { permutation ->
    permutation.zipWithNext()
  }.toTypedArray()
