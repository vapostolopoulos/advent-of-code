package year2015.day6

import year2015.day6.Action.OFF
import year2015.day6.Action.ON
import year2015.day6.Action.TOGGLE

internal fun partOne(input: List<String>): Int {
  val grid = Array(1000) { Array(1000) { 0 } }
  input.forEach { line ->
    val directions = line.directions()
    for (i in directions.from.first..directions.to.first) {
      for (j in directions.from.second..directions.to.second) {
        when (directions.action) {
          TOGGLE -> if (grid[i][j] == 0) grid[i][j] = 1 else grid[i][j] = 0
          ON -> grid[i][j] = 1
          OFF -> grid[i][j] = 0
        }
      }
    }
  }
  return grid.sumOf { row -> row.sum() }
}
