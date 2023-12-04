package year2022.day2

private val symbolMeaning = mapOf(
  "A" to "Rock",
  "B" to "Paper",
  "C" to "Scissors",
  "X" to "Lose",
  "Y" to "Draw",
  "Z" to "Win",
)

private const val ROCK_SCORE = 1
private const val PAPER_SCORE = 2
private const val SCISSORS_SCORE = 3
private const val LOSE_SCORE = 0
private const val DRAW_SCORE = 3
private const val WIN_SCORE = 6

internal fun partTwo(rounds: List<String>): Int {
  var sum = 0
  rounds.forEach { round ->
    val splitRound = round.split(" ")
    val opponentSymbol = splitRound[0]
    val roundSymbol = splitRound[1]
    val roundScore = getRoundScore(opponentSymbol, roundSymbol)
    sum += roundScore
  }
  return sum
}

private fun getRoundScore(opponentSymbol: String, roundSymbol: String): Int {
  return when (symbolMeaning[opponentSymbol]) {
    "Rock" -> determineScoreWhenRock(roundSymbol)
    "Paper" -> determineScoreWhenPaper(roundSymbol)
    "Scissors" -> determineScoreWhenScissors(roundSymbol)
    else -> throw Exception("Unknown symbol")
  }
}

private fun determineScoreWhenRock(roundSymbol: String): Int =
  when (symbolMeaning[roundSymbol]) {
    "Lose" -> SCISSORS_SCORE + LOSE_SCORE
    "Win" -> PAPER_SCORE + WIN_SCORE
    else -> ROCK_SCORE + DRAW_SCORE
  }

private fun determineScoreWhenPaper(roundSymbol: String): Int =
  when (symbolMeaning[roundSymbol]) {
    "Lose" -> ROCK_SCORE + LOSE_SCORE
    "Win" -> SCISSORS_SCORE + WIN_SCORE
    else -> PAPER_SCORE + DRAW_SCORE
  }

private fun determineScoreWhenScissors(roundSymbol: String): Int =
  when (symbolMeaning[roundSymbol]) {
    "Lose" -> PAPER_SCORE + LOSE_SCORE
    "Win" -> ROCK_SCORE + WIN_SCORE
    else -> SCISSORS_SCORE + DRAW_SCORE
  }
