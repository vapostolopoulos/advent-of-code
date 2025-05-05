package year2015.day11

import java.io.File

private const val FILE = "src/main/kotlin/year2015/day11/puzzle.input"

fun main() {
  val input = File(FILE).readText()

  println("Part One: ${corporatePolicy(input)}")
  println("Part Two: ${corporatePolicy(corporatePolicy(input))}")
}
