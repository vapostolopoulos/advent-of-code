package year2015.day11

val next = mapOf(
  'a' to 'b',
  'b' to 'c',
  'c' to 'd',
  'd' to 'e',
  'e' to 'f',
  'f' to 'g',
  'g' to 'h',
  'h' to 'i',
  'i' to 'j',
  'j' to 'k',
  'k' to 'l',
  'l' to 'm',
  'm' to 'n',
  'n' to 'o',
  'o' to 'p',
  'p' to 'r',
  'r' to 's',
  's' to 't',
  't' to 'u',
  'u' to 'v',
  'v' to 'w',
  'w' to 'x',
  'x' to 'y',
  'y' to 'z',
  'z' to 'a'
)

internal fun corporatePolicy(input: String): String {
  var password = StringBuilder(input.trim())
  do {
    password = StringBuilder(increment(password))
  } while (password.isNotValid())
  return password.toString()
}

private fun increment(password: StringBuilder): StringBuilder {
  if (password.toSet() == setOf('z')) {
    return StringBuilder("a".repeat(password.length + 1))
  }
  var result = StringBuilder(password)
  val lastLetterIndex = result.length - 1
  result[lastLetterIndex] = next[result[lastLetterIndex]]!!
  if (result.last() == 'a') {
    result = increment(StringBuilder(result.slice(0..<lastLetterIndex))).append(result[lastLetterIndex])
  }
  return result
}

private fun StringBuilder.isNotValid(): Boolean {
  val password = this.toString()
  return !password.hasThreeSequentialCharacters() || password.containsForbiddenCharacters() || !password.hasDifferentDoubleLetterTwice()
}

private fun String.hasThreeSequentialCharacters(): Boolean =
  windowed(3).any {
    it[1] == next[it[0]] && it[2] == next[it[1]] &&
      it[0] != 'z' && it[1] != 'z' // to avoid sequential wrap around
  }

private fun String.containsForbiddenCharacters(): Boolean =
  listOf('i', 'o', 'l').any { it in this }

private fun String.hasDifferentDoubleLetterTwice(): Boolean {
  var i = 0
  val pairs = mutableSetOf<Char>()
  while (i < this.length - 1) {
    if (this[i] == this[i + 1]) {
      pairs.add(this[i])
      i += 2 // skip to avoid overlap
    } else {
      i += 1
    }
  }
  return pairs.size >= 2
}
