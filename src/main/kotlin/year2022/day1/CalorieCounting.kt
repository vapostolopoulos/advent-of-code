package year2022.day1

import java.io.File

private const val FILE = "src/main/kotlin/year2022/day1/puzzle.input"

fun main() {
  val input = File(FILE).readLines().plus("")

  println("Part One: ${partOne(input)}")

  println("Part Two: ${partTwo(input)}")
}
