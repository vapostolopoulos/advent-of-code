package year2023.day2

internal fun partTwo(games: List<String>): Int {
  var sum = 0
  games.forEach {
    val splitGameInput = it.split(":", ";")
    val cubesPerSet = getCubesPerSet(splitGameInput.subList(1, splitGameInput.size))
    val minimumCubesOfGame = calculateMinimumCubesOfGame(cubesPerSet)
    val power = getPowerOfSet(minimumCubesOfGame)
    sum += power
  }
  return sum
}

private fun getCubesPerSet(splitGameInput: List<String>): List<Map<String, Int>> {
  val rawCubesPerSet = splitGameInput.map { it.trim().replace(",", "").split(" ") }

  return transformCubesPerSet(rawCubesPerSet)
}

private fun transformCubesPerSet(rawCubesPerSet: List<List<String>>): List<Map<String, Int>> {
  val cubesPerSet = mutableListOf<Map<String, Int>>()

  rawCubesPerSet.forEach { setOfCube ->
    val colouredCubesPerGame = mutableMapOf<String, Int>()
    for (i in 1..setOfCube.size step 2) {
      val color = setOfCube[i]
      val amount = setOfCube[i - 1].toInt()
      colouredCubesPerGame[color] = amount
    }
    cubesPerSet.add(colouredCubesPerGame)
  }

  return cubesPerSet
}

private fun calculateMinimumCubesOfGame(cubesPerSet: List<Map<String, Int>>): Map<String, Int> {
  val minimumColoredCubes = mutableMapOf(
    "red" to 0,
    "green" to 0,
    "blue" to 0,
  )
  cubesPerSet.forEach {
    it.forEach { (color, amount) ->
      if (amount > (minimumColoredCubes[color] ?: 0)) {
        minimumColoredCubes[color] = amount
      }
    }
  }
  return minimumColoredCubes
}

private fun getPowerOfSet(minimumCubesOfGame: Map<String, Int>) =
  minimumCubesOfGame.values.reduce { power, value -> power * value }
