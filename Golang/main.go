/*
   Project Title  : Noughts & Crosses
   Version        : 1.0
   Developed By   : Aditya Vikram Singh
*/

package main

import "fmt"

func displayGameBoard(Board []rune) {
	fmt.Println("-------------")
	fmt.Println("|", string(Board[0]), "|", string(Board[1]), "|", string(Board[2]), "|")
	fmt.Println("-------------")
	fmt.Println("|", string(Board[3]), "|", string(Board[4]), "|", string(Board[5]), "|")
	fmt.Println("-------------")
	fmt.Println("|", string(Board[6]), "|", string(Board[7]), "|", string(Board[8]), "|")
	fmt.Println("-------------")
}

func playGame(Board []rune) string {
	var position int
	var playerOneMove bool = true
	for i := 0; i < 9; i++ {
		if winState(Board) != '!' {
			break
		}

		if playerOneMove {
			fmt.Print("Player X's Turn- Enter the move: ")
		} else {
			fmt.Print("Player O's Turn- Enter the move: ")
		}
		fmt.Scan(&position)
		for {
			if !(Board[position-1] == 'X' || Board[position-1] == 'O') {
				break
			}
			fmt.Print("Invalid move! Already occupied space, please try again: ")
			fmt.Scan(&position)
		}
		if playerOneMove {
			Board[position-1] = 'X'
		} else {
			Board[position-1] = 'O'
		}
		displayGameBoard(Board)
		playerOneMove = !playerOneMove
	}
	if winState(Board) != '!' {
		return (string(winState(Board)) + " wins!")
	}
	return "Game drawn!"
}

func winState(Board []rune) rune {
	for i := 0; i < 3; i++ {
		if Board[3*i] == Board[3*i+1] && Board[3*i+1] == Board[3*i+2] {
			return Board[3*i+1]
		}
		if Board[i] == Board[i+3] && Board[i+3] == Board[i+6] {
			return Board[i+3]
		}
		if Board[i] == Board[4] && Board[4] == Board[8-i] {
			return Board[4]
		}
	}
	return '!'
}

func main() {
	var initialBoard = []rune{'1', '2', '3', '4', '5', '6', '7', '8', '9'}
	displayGameBoard(initialBoard)
	fmt.Println(playGame(initialBoard))
}
