package year2015.day10

internal fun lookAndSay(input: String, n: Int): Int {
  var result = input.trim()
  repeat(n) {
    result = lookAndSay(result)
  }
  return result.length
}

private fun lookAndSay(input: String): String {
  val result = StringBuilder()
  var count = 1
  for (i in 1..<input.length) {
    if (input[i] == input[i - 1]) {
      count++
    } else {
      result.append(count).append(input[i - 1])
      count = 1
    }
  }
  result.append(count).append(input.last())
  return result.toString()
}
