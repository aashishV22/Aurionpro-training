const BaseError=require("./BaseError")

class UnauthorizedError extends BaseError
{
    constructor(specificMessage)
    {
        super("Unauthorized Acces",401,specificMessage)
    }
}

module.exports=UnauthorizedError