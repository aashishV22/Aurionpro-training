const Board=require("./Board")

class Player
{
    constructor(symbol,name){
        this.symbol=symbol;
        this.name=name;
    }

//   Passing the 0th cell and replacing Z with player's symbol
    markCell(cellObj){
        cellObj.mark=this.symbol;

        // cellObj.mark(this.symbol)

    }
}
module.exports= Player