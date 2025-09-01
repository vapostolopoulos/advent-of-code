package year2016.day1

import year2016.day1.Direction.EAST
import year2016.day1.Direction.NORTH
import year2016.day1.Direction.SOUTH
import year2016.day1.Direction.WEST
import kotlin.math.abs

internal fun partTwo(input: String): Int {
  var x = 0
  var y = 0
  var direction = NORTH
  val visited = mutableSetOf<Pair<Int, Int>>()
  visited.add(Pair(x, y))
  val instructions = input.split(", ")
  for (instruction in instructions) {
    val turn = instruction[0]
    val move = instruction.substring(1).trim().toInt()
    when (turn) {
      'L' -> direction = turnLeft[direction]!!
      'R' -> direction = turnRight[direction]!!
    }
    when (direction) {
      NORTH -> {
        for (i in 0..<move) {
          y += 1
          if (visited.contains(Pair(x, y))) {
            return abs(x) + abs(y)
          }
          visited.add(Pair(x, y))
        }
      }

      SOUTH -> {
        for (i in 0..<move) {
          y -= 1
          if (visited.contains(Pair(x, y))) {
            return abs(x) + abs(y)
          }
          visited.add(Pair(x, y))
        }
      }

      EAST -> {
        for (i in 0..<move) {
          x += 1
          if (visited.contains(Pair(x, y))) {
            return abs(x) + abs(y)
          }
          visited.add(Pair(x, y))
        }
      }

      WEST -> {
        for (i in 0..<move) {
          x -= 1
          if (visited.contains(Pair(x, y))) {
            return abs(x) + abs(y)
          }
          visited.add(Pair(x, y))
        }
      }
    }
  }

  return -1
}
