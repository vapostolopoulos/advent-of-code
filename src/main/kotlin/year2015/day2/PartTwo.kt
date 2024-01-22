package year2015.day2

internal fun partTwo(input: List<String>): Int =
  input.sumOf { line ->
    val dimensions = getDimensions(line)

    val shortestDistance = dimensions.sorted().take(2).sumOf { it * 2 }
    val bow = dimensions.reduce { acc, i -> acc * i }

    shortestDistance + bow
  }
