const BaseError = require("./BaseError");

class validationError extends BaseError
{
    constructor(specificMessage){
        super("Invalid Input",400,specificMessage)
    }
}

module.exports=validationError