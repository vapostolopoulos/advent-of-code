package year2015.day3

internal fun partTwo(input: String): Int {
    val visitedHouses = mutableSetOf<Pair<Int, Int>>()
    var santaX = 0
    var santaY = 0
    var roboSantaX = 0
    var roboSantaY = 0

    visitedHouses.add(Pair(santaX, santaY))

    input.forEachIndexed { index, direction ->
        if (index % 2 == 0) {
            when (direction) {
                '^' -> santaY++
                'v' -> santaY--
                '>' -> santaX++
                '<' -> santaX--
            }

            visitedHouses.add(Pair(santaX, santaY))
        } else {
            when (direction) {
                '^' -> roboSantaY++
                'v' -> roboSantaY--
                '>' -> roboSantaX++
                '<' -> roboSantaX--
            }

            visitedHouses.add(Pair(roboSantaX, roboSantaY))
        }
    }

    return visitedHouses.size
}
