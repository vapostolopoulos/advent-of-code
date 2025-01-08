package year2015.day5

import java.io.File

private const val FILE = "src/main/kotlin/year2015/day5/puzzle.input"

fun main() {
  val input = File(FILE).readLines()

  println("Part One: ${partOne(input)}")
}
