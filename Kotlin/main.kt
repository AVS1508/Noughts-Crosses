/*
    Project Title  : Noughts & Crosses
    Version        : 1.0
    Developed By   : Aditya Vikram Singh
*/

class NoughtsCrosses {
    fun displayGameBoard(Board: CharArray) {
        println("-------------")
        println("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |")
        println("-------------")
        println("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |")
        println("-------------")
        println("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |")
        println("-------------")
    }

    fun playGame(Board: CharArray): String {
        var position: Int
        var playerOneMove: Boolean = true
        for (i in 0..8) {
            if (winState(Board) != '!') {
                break
            }
            print("Player " + (if (playerOneMove) "X" else "O") + "'s Turn- Enter the move: ")
            position = readLine()!!.toInt()
            while (Board[position - 1] == 'X' || Board[position - 1] == 'O') {
                print("Invalid move! Already occupied space, please try again: ")
                position = readLine()!!.toInt()
            }
            Board[position - 1] = if (playerOneMove) 'X' else 'O'
            displayGameBoard(Board)
            playerOneMove = !playerOneMove
        }
        if (winState(Board) != '!') {
            return (winState(Board).toString() + " wins!")
        } else {
            return "Game drawn!"
        }
    }

    fun winState(Board: CharArray): Char {
        for (i in 0..2) {
            if (Board[3 * i] == Board[3 * i + 1] && Board[3 * i + 1] == Board[3 * i + 2]) {
                return Board[3 * i + 1]
            }
            if (Board[i] == Board[i + 3] && Board[i + 3] == Board[i + 6]) {
                return Board[i + 3]
            }
            if (Board[i] == Board[4] && Board[4] == Board[8 - i]) {
                return Board[4]
            }
        }
        return '!'
    }
}

fun main(args: Array<String>) {
    var initialBoard: CharArray = arrayOf<Char>('1', '2', '3', '4', '5', '6', '7', '8', '9').toCharArray()
    var NoughtsCrossesGame = NoughtsCrosses()
    NoughtsCrossesGame.displayGameBoard(initialBoard)
    println(NoughtsCrossesGame.playGame(initialBoard))
}
