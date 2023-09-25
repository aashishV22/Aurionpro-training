const Contact=require("./Contact");
const notFoundError = require("./error/notFoundError");
const validationError = require("./error/validationError");

class contactInfo
{
    static contactDetailsID=0;
    constructor(contactCountry,contactType){
        this.contactCountry=contactCountry;
        this.contactType=contactType;
        this.contactDetailsID=contactInfo.contactDetailsID++;
    }

    updateContactDetails(parameter,newValue)
    {
        
        try
        {
            switch(parameter)
            {
                case "contactCountry":
                    if(typeof newValue!="string")           {throw new validationError("Enter a valid countary name")}
                    this.contactCountry=newValue
                    return this
                case "contactType":
                    if(typeof newValue!="string")           {throw new validationError( "Enter a valid contact Type")}
                    this.contactType=newValue    
                    return this 
                default:
                    throw new notFoundError("The parameter shold be valid")
            }
        }
        catch(e){
                throw e
            }   
    }

}

module.exports=contactInfo