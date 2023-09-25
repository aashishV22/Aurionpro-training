    let isGameOver = false;
let board = ["O", "O", "O", "z", "z", "z", "z", "z", "z", "z"];

let playTicTacToe = (cellNumber, symbol) => {
    if (board[cellNumber] == "z" && cellNumber < 9) {
        board[cellNumber] = symbol;
    }
    else if (symbol != "X" && symbol != "O") {
        console.log("Invalid Symbol");
    }
    else if (cellNumber >= 9) {
        console.log("Invalid cellNumber ");
    }
    else {
        console.log("Place is occupied");
    }
    if (
        (board[0] == board[1] && board[1] == board[2] && (board[1] == symbol)) ||
        (board[3] == board[4] && board[4] == board[5] && (board[4] == symbol)) ||
        (board[6] == board[7] && board[7] == board[8] && (board[7] == symbol)) ||
        (board[0] == board[1] && board[1] == board[2] && (board[1] == symbol)) ||
        (board[1] == board[4] && board[4] == board[7] && (board[4] == symbol)) ||
        (board[2] == board[5] && board[5] == board[8] && (board[5] == symbol)) ||
        (board[0] == board[4] && board[4] == board[8] && (board[4] == symbol)) ||
        (board[2] == board[4] && board[4] == board[6] && (board[4] == symbol))
    ) {
        console.log("Winner is " + symbol);
        console.log("Game Over");
        console.log(board);
        board = ["z", "z", "z", "z", "z", "z", "z", "z", "z"];

    }
    else if (
            board[0] != "z" &&
            board[1] != "z" &&
            board[2] != "z" &&
            board[3] != "z" &&
            board[4] != "z" &&
            board[5] != "z" &&
            board[6] != "z" &&
            board[7] != "z" &&
            board[8] != "z") 
        {
            console.log("Draw");
        }
        return board;

    }