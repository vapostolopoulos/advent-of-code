package year2015.day4

import java.security.MessageDigest

fun main() {
  val input = "iwrupvqb"

  println("Part One: ${partOne(input)}")

  println("Part Two: ${partTwo(input)}")
}

internal fun md5Hash(input: String): String {
  val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray())
  return bytes.joinToString("") { "%02x".format(it) }
}
