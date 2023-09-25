class Cell{
    constructor(){
        this.mark="Z";
    }
    isEmpty(){
        return this.mark=="Z"
    }

    mark(symbol){
        this.mark=symbol
    }
}
module.exports=Cell;