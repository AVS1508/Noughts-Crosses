# Project Title  : Noughts & Crosses
# Version        : 1.0
# Developed By   : Aditya Vikram Singh


def displayGameBoard(Board):
    print("-------------")
    print("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |")
    print("-------------")
    print("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |")
    print("-------------")
    print("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |")
    print("-------------")


def playGame(Board):
    position = -1
    playerOneMove = True
    for i in range(9):
        if winState(Board) != "!":
            break
        print(
            "Player " + ("X" if (playerOneMove) else "O") + "'s Turn- Enter the move: "
        )
        position = int(input())
        while Board[position - 1] == "X" or Board[position - 1] == "O":
            print("Invalid move! Already occupied space, please try again: ")
            position = int(input())
        Board[position - 1] = "X" if (playerOneMove) else "O"
        displayGameBoard(Board)
        playerOneMove = not playerOneMove
    if winState(Board) != "!":
        return winState(Board) + " wins!"
    else:
        return "Game drawn!"


def winState(Board):
    for i in range(3):
        if Board[3 * i] == Board[3 * i + 1] and Board[3 * i + 1] == Board[3 * i + 2]:
            return Board[3 * i + 1]
        if Board[i] == Board[i + 3] and Board[i + 3] == Board[i + 6]:
            return Board[i + 3]
        if Board[i] == Board[4] and Board[4] == Board[8 - i]:
            return Board[4]
    return "!"


def main():
    initialBoard = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
    displayGameBoard(initialBoard)
    print(playGame(initialBoard))


if __name__ == "__main__":
    main()
