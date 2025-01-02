package year2015.day3

import java.io.File

private const val FILE = "src/main/kotlin/year2015/day3/puzzle.input"

fun main() {
  val input = File(FILE).readText()

  println("Part One: ${partOne(input)}")

  println("Part Two: ${partTwo(input)}")
}
