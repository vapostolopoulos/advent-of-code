package year2022.day2

import java.io.File

private const val FILE = "src/main/kotlin/year2022/day2/puzzle.input"

fun main() {
  val input = File(FILE).readLines()

  println("Part One: ${partOne(input)}")

  println("Part Two: ${partTwo(input)}")
}
