package year2022.day2

private val symbolMeaning = mapOf(
  "A" to "Rock",
  "B" to "Paper",
  "C" to "Scissors",
  "X" to "Rock",
  "Y" to "Paper",
  "Z" to "Scissors",
)

private const val ROCK_SCORE = 1
private const val PAPER_SCORE = 2
private const val SCISSORS_SCORE = 3
private const val LOSE_SCORE = 0
private const val DRAW_SCORE = 3
private const val WIN_SCORE = 6

internal fun partOne(rounds: List<String>): Int {
  var sum = 0
  rounds.forEach { round ->
    val splitRound = round.split(" ")
    val opponentSymbol = splitRound[0]
    val yourSymbol = splitRound[1]
    val symbolScore = getSymbolCount(yourSymbol)
    val roundScore = getRoundScore(opponentSymbol, yourSymbol)
    sum += symbolScore + roundScore
  }
  return sum
}

private fun getSymbolCount(yourSymbol: String): Int =
  when (symbolMeaning[yourSymbol]) {
    "Rock" -> ROCK_SCORE
    "Paper" -> PAPER_SCORE
    "Scissors" -> SCISSORS_SCORE
    else -> throw Exception("Unknown symbol")
  }

private fun getRoundScore(opponentSymbol: String, yourSymbol: String): Int {
  return when (symbolMeaning[yourSymbol]) {
    "Rock" -> determineScoreWhenRock(opponentSymbol)
    "Paper" -> determineScoreWhenPaper(opponentSymbol)
    "Scissors" -> determineScoreWhenScissors(opponentSymbol)
    else -> throw Exception("Unknown symbol")
  }
}

private fun determineScoreWhenRock(opponentSymbol: String): Int =
  when (symbolMeaning[opponentSymbol]) {
    "Paper" -> LOSE_SCORE
    "Scissors" -> WIN_SCORE
    else -> DRAW_SCORE
  }

private fun determineScoreWhenPaper(opponentSymbol: String): Int =
  when (symbolMeaning[opponentSymbol]) {
    "Rock" -> WIN_SCORE
    "Scissors" -> LOSE_SCORE
    else -> DRAW_SCORE
  }

private fun determineScoreWhenScissors(opponentSymbol: String): Int =
  when (symbolMeaning[opponentSymbol]) {
    "Rock" -> LOSE_SCORE
    "Paper" -> WIN_SCORE
    else -> DRAW_SCORE
  }
