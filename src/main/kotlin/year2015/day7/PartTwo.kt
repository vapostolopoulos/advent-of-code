package year2015.day7

internal fun partTwo(input: List<String>): Int {
  val circuit = mutableMapOf<String, String>()
  input.forEach { line ->
    val (left, right) = line.split(" -> ")
    circuit[right.trim()] = left.trim()
  }

  val visited = mutableMapOf<String, Int>()
  circuit["b"] = evaluate("a", circuit, visited).toString()

  visited.clear()
  return evaluate("a", circuit, visited)
}
