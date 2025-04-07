package year2015.day6

data class Directions(
  val action: Action,
  val from: Pair<Int, Int>,
  val to: Pair<Int, Int>,
)

enum class Action {
  TOGGLE,
  ON,
  OFF,
}

internal fun String.directions(): Directions {
  val actionFromTo = this.replace("turn ", "").replace("through ", "").split(" ")
  val action = Action.valueOf(actionFromTo[0].uppercase())
  val fromAsList = actionFromTo[1].split(",").map { it.toInt() }
  val toAsList = actionFromTo[2].split(",").map { it.toInt() }
  val from = Pair(fromAsList[0], fromAsList[1])
  val to = Pair(toAsList[0], toAsList[1])
  return Directions(action, from, to)
}
