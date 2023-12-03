package year2023.day2

internal fun partOne(games: List<String>): Int {
  var sum = 0
  games.forEach {
    val splitGameInput = it.split(":", ";")
    val gameId = splitGameInput[0].split(" ")[1].toInt()
    val cubesPerSet = getCubesPerSet(splitGameInput.subList(1, splitGameInput.size))
    if (validateCubes(cubesPerSet)) {
      sum += gameId
    }
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

private fun validateCubes(cubesPerSet: List<Map<String, Int>>): Boolean {
  cubesPerSet.forEach {
    if (!validateColouredCubes(it)) {
      return false
    }
  }
  return true
}

private fun validateColouredCubes(colouredCubesInSet: Map<String, Int>): Boolean {
  val colouredCubesTotal = mapOf(
    "red" to 12,
    "green" to 13,
    "blue" to 14,
  )
  colouredCubesInSet.forEach { (color, amount) ->
    if (amount > (colouredCubesTotal[color] ?: 0)) {
      return false
    }
  }
  return true
}
