package year2015.day9

import java.io.File

private const val FILE = "src/main/kotlin/year2015/day9/puzzle.input"

fun main() {
  val input = File(FILE).readLines()

  println("Part One: ${partOne(input)}")
  println("Part Two: ${partTwo(input)}")
}
