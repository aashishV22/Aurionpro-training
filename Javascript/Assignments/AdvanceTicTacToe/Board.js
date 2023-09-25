const Cell=require("./Cell")
class Board
{
    constructor()
    {
        this.cells=
        [
        new Cell(),         new Cell(),        new Cell(),
        new Cell(),         new Cell(),        new Cell(),
        new Cell(),         new Cell(),        new Cell(),
        ]
    }//  9 objects of cell class
    isCellMarked(cellNumber){
        return this.cells[cellNumber].isEmpty();
    }

//      returns positon and its value  ex. play(0) it will give 0th position ofthis.cells not inside the 0th positon
    getCellObj(cellNumber){
        return this.cells[cellNumber]
    }

    analyseResult()
    {
        if(this.cells[0].mark==this.cells[1].mark &&
           this.cells[2].mark==this.cells[1].mark &&
           !this.cells[0].isEmpty()     )
        {
            return [this.cells[0].mark,"Winner"]
        }
        if(this.cells[3].mark==this.cells[4].mark &&
            this.cells[5].mark==this.cells[4].mark &&
            !this.cells[3].isEmpty()     )
         {
             return [this.cells[3].mark,"Winner"]
         }
         if(this.cells[6].mark==this.cells[7].mark &&
            this.cells[8].mark==this.cells[7].mark &&
            !this.cells[6].isEmpty()     )
         {
             return [this.cells[0].mark,"Winner"]
         }
         if(this.boardFull()){
            return ["","draw"]
         }

        return ["",""]
    }

    boardFull()
    {
        if(
            !this.cells[0].isEmpty() && !this.cells[1].isEmpty() && !this.cells[2].isEmpty() &&
            !this.cells[3].isEmpty() && !this.cells[4].isEmpty() && !this.cells[5].isEmpty() &&
            !this.cells[6].isEmpty() && !this.cells[7].isEmpty() && !this.cells[8].isEmpty()  
        )
    return true
    }

    printBoard(){
        console.log(this.cells);
    }
    resetBoard(){
        let length=9;
        for(let i=0;i<length;i++){
        this.cells[i].mark="Z"
    }
    }

}
module.exports=Board;