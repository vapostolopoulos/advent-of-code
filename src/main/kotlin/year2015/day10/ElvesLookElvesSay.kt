package year2015.day10

import java.io.File

private const val FILE = "src/main/kotlin/year2015/day10/puzzle.input"

fun main() {
  val input = File(FILE).readText()

  println("Part One: ${lookAndSay(input, 40)}")
  println("Part Two: ${lookAndSay(input, 50)}")
}
