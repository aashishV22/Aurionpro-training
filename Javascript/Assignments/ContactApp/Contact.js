const contactInfo=require("./contactInfo");
const notFoundError = require("./error/notFoundError");

class Contact{
    static ID=0
    constructor(contactName,contactNumber){
        this.contactName=contactName;
        this.contactNumber=contactNumber;
        this.contactID=Contact.ID++;
        this.contactDetails=[]
    }

    validateNumber(contactNumber) 
    {
        var re = /^(\d{3})[- ]?(\d{3})[- ]?(\d{4})$/
        return re.test(contactNumber)
    }

    updateContact(parameter,newValue)
    {
        try
        {  
            switch(parameter)
            {  
                case "contactName":
                    if(typeof newValue!="string")       {throw new validationError("Enter a valid contact name")}
                    return this.contactName=newValue;
                
                case "contactNumber":
                    if(typeof newValue!="number")      {throw new validationError("Enter contact number in 1234567890 format (NOT in STRING FORMAT )")} 
                    if(!this.validateNumber(newValue)) {throw new validationError("Error:- Number should be of 10 digits (ex- 1234567890)")}     
                    return this.contactNumber=newValue;

                default:
                    throw new notFoundError("Enter a valid parameter")
            }    
        }catch(e)
        {   throw e }
    }

    createrContactInfo(contactCountry,contactType){ 
        let contactInfoObject=new contactInfo(contactCountry,contactType)
        this.contactDetails.push(contactInfoObject)
        return contactInfoObject
    }

    updateContactInfos(contactDetailsID,parameter,newValue)
    {   try
        {
            for(let i=0;i<this.contactDetails.length;i++)
            {
                if(this.contactDetails[i].contactDetailsID==contactDetailsID)
                {
                    // console.log(this.contactDetails[i].contactDetailsID,contactDetailsID);
                    return this.contactDetails[i].updateContactDetails(parameter,newValue)
                }        
            }
            throw  new notFoundError("ContactDetails ID not found")
        }catch(e){
            throw e
        }
    }

    readContactInfos(contactDetailsID){
        try
        {
            for(let i=0;i<this.contactDetails.length;i++){
                if(this.contactDetails[i].contactDetailsID==contactDetailsID){
                    return this.contactDetails[i]
                }
                if(this.contactDetails.length==0){throw new notFoundError ("There is no contact details in this contactID")}
            }
        }catch(e){throw e}
    }

    deleteContactDetails(contactDetailsID)
    {
        try{
                for(let i=0;i<this.contactDetails.length;i++)
                {
                    if(this.contactDetails[i].contactDetailsID==contactDetailsID){
                        console.log("Contact Deleted is :-");
                        console.log(this.contactDetails[i]);
                        this.contactDetails.splice(i,1)
                        return this.contactDetails
                    }
                    if(this.contactDetails.length==0){throw new notFoundError ("There is no contact details in this contactID")}      
                }
                throw new notFoundError("contact details id not found")
        }catch(e)
        {
            throw e
        }
    }
}


module.exports=Contact