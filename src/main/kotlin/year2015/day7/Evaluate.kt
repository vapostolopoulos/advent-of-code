package year2015.day7

internal fun evaluate(wire: String, circuit: MutableMap<String, String>, visited: MutableMap<String, Int>): Int {
  if (wire.toIntOrNull() != null) {
    return wire.toInt()
  }

  if (visited.containsKey(wire)) {
    return visited[wire]!!
  }

  val instruction = circuit[wire]!!
  val result = when {
    instruction.contains("AND") -> {
      val (a, _, b) = instruction.split(" ")
      evaluate(a, circuit, visited) and evaluate(b, circuit, visited)
    }

    instruction.contains("OR") -> {
      val (a, _, b) = instruction.split(" ")
      evaluate(a, circuit, visited) or evaluate(b, circuit, visited)
    }

    instruction.contains("LSHIFT") -> {
      val (a, _, b) = instruction.split(" ")
      evaluate(a, circuit, visited) shl (b.toInt())
    }

    instruction.contains("RSHIFT") -> {
      val (a, _, b) = instruction.split(" ")
      evaluate(a, circuit, visited) shr (b.toInt())
    }

    instruction.contains("NOT") -> {
      val (_, a) = instruction.split(" ")
      evaluate(a, circuit, visited).inv()
    }

    else -> evaluate(instruction, circuit, visited)
  }

  visited[wire] = result
  return result
}
