const Board=require("./Board")
const Player=require("./Player")

class Game{
   constructor(board,players){
        this.players=players;
        this.board=board;
        this.turn=0;
        this.isGameEnded=false;
    }
    static newGame(player0Name,player1Name){
        if(typeof player0Name!="string"){
            return "Invalid name format"
        }
        if(typeof player1Name!="string"){
            return "Invalid name format"
        }
        let board=new Board
        let player0=new Player("X",player0Name)
        let player1=new Player("O",player1Name)

        return new Game(board,[player0,player1])
    }
    play(cellNumber){

        if(this.isGameEnded){
            this.board.resetBoard()
            this.isGameEnded=false
            this.turn=0;
            console.log("New Game started");
        }
        if(typeof cellNumber!="number"){
            return "Enter a valid cell number"
        }
        if(cellNumber>8){
            return "Cell number cannot be greater than 8"
        }
        if(cellNumber<0){
            return "Cell number cannot be less than 0"
        }


        // if(this.board.cells[cellNumber]!="Z"){
        //     return "Cell is not Empty"
        // }
// .......................................................
        // if(!this.board.cells[cellNumber].isMarked()){
        //     return "Cell is not empty"
        // }      
// If there is any change is board contructor cells name to any other then we have yo change it everywhere in Board.js and in this file
//.............................................................
        if(!this.board.isCellMarked(cellNumber))
            {
                return "Cell is already marked"
            }
//......Setting player 1 and player 2        
        let currentPlayer
        if(this.turn%2==0){
            currentPlayer=this.players[0]
        }else{
            currentPlayer=this.players[1]
        }
        let cellObj=this.board.getCellObj(cellNumber)
        currentPlayer.markCell(cellObj)
        this.turn++;

        let [symbolOfWinner,gameStatus]=this.board.analyseResult()
        if(gameStatus=="")
            {
                console.log("Continue playing")
                return this.board
            }
        if(gameStatus=="draw"){
            this.isGameEnded=true
            console.log("Game Ended as Draw\nFinal Board is :-");
            return this.board
        }
        if(symbolOfWinner==this.players[0].symbol){
            this.isGameEnded=true
            console.log(this.players[0].name+" is Winner\nGame Ended this is the Final Board:-");
            return this.board
        }
        this.isGameEnded=true;
        console.log(this.players[1].name+" is Winner\nGame Ended this is the Final Board:-");
        return this.board
    }
}



module.exports=Game;