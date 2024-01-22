package year2015.day2

internal fun partOne(input: List<String>): Int =
  input.sumOf { line ->
    val dimensions = getDimensions(line)
    val l = dimensions[0]
    val w = dimensions[1]
    val h = dimensions[2]

    val side1 = l * w
    val side2 = w * h
    val side3 = h * l

    val smallestSide = minOf(side1, side2, side3)

    2 * side1 + 2 * side2 + 2 * side3 + smallestSide
  }

internal fun getDimensions(line: String) =
  line.split("x").map { it.toInt() }
