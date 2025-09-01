package year2016.day1

import year2016.day1.Direction.EAST
import year2016.day1.Direction.NORTH
import year2016.day1.Direction.SOUTH
import year2016.day1.Direction.WEST
import kotlin.math.abs

internal fun partOne(input: String): Int {
  var x = 0
  var y = 0
  var direction = NORTH
  val instructions = input.split(", ")
  for (instruction in instructions) {
    val turn = instruction[0]
    val move = instruction.substring(1).trim().toInt()
    when (turn) {
      'L' -> direction = turnLeft[direction]!!
      'R' -> direction = turnRight[direction]!!
    }
    when (direction) {
      NORTH -> y += move
      SOUTH -> y -= move
      EAST -> x += move
      WEST -> x -= move
    }
  }
  return abs(x) + abs(y)
}
