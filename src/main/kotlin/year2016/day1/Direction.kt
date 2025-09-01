package year2016.day1

import year2016.day1.Direction.EAST
import year2016.day1.Direction.NORTH
import year2016.day1.Direction.SOUTH
import year2016.day1.Direction.WEST

enum class Direction {
  NORTH, SOUTH, EAST, WEST
}

internal val turnLeft = mapOf(
  NORTH to WEST,
  WEST to SOUTH,
  SOUTH to EAST,
  EAST to NORTH,
)

internal val turnRight = mapOf(
  NORTH to EAST,
  EAST to SOUTH,
  SOUTH to WEST,
  WEST to NORTH,
)
