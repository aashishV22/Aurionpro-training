const BaseError = require("./BaseError");

class notFoundError extends BaseError{
    constructor(specificMessage){
        super("Not Found",404,specificMessage)
    }

}

module.exports=notFoundError