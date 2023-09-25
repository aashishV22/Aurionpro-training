const Contact=require("./Contact")
const contactInfo=require("./contactInfo");
const UnauthorizedError = require("./error/UnauthorizedError");
const notFoundError = require("./error/notFoundError");
const validationError = require("./error/validationError");


class User{
    static ID=0
    static allUser=[]
    constructor(name,gender,age,isAdmin)
    {
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.isAdmin=isAdmin;
        this.ID=User.ID++;
        this.contacts=[]
    }
    static newAdmin(name,gender,age){
        return new User(name,gender,age,true)
    }


    createUser(name,gender,age)
    {
        try{
            if(!this.isAdmin)               {throw new UnauthorizedError("Not Authorized")}
            if(typeof name !="string")      { throw new validationError("Name should be string")}
            if(typeof gender !="string")    { throw new validationError("Gender should be string")}
            if(gender.toLowerCase()!="male" && gender.toLowerCase()!="female")      {throw new validationError("Gender should be male or female ")}
            if(typeof age !="number"){throw new validationError("Age should be number")}
            let newUser= new User(name,gender,age,false)
            User.allUser.push(newUser)
            return newUser    
        }catch(e){
            console.log(e);
        }
    }

    getAllUsers()
    {   
        try
        {
            if(!this.isAdmin)   {throw new UnauthorizedError("User not Authorized")}
            return User.allUser
        }catch(e)
        {
            console.log(e); 
        }
    }

    findUser(ID)
    {
        try
        {
            if(!this.isAdmin)   {throw new UnauthorizedError ("Users are not Authotized")}
            for (let indexOfUser = 0; indexOfUser<User.allUser.length; indexOfUser++) 
            {
                if(User.allUser[indexOfUser].ID==ID){
                    return indexOfUser
                } 
            }
            throw new notFoundError("USer-ID not found")
        }catch(e)
        {    throw  e    }
    }

    updateUser(ID,parameter,newValue)
    {   
        try
        {
            if(typeof ID!="number")     {throw new validationError("ID should be a valid number")}
            if(!this.isAdmin)           {throw new UnauthorizedError ("Users are not Authotized")}
            let indexOfUser=this.findUser(ID)
            switch(parameter)
            {
                case "name":
                    if(typeof newValue!="string")   {throw validationError("Enter a string value")}
                    User.allUser[indexOfUser].name=newValue;
                    return User.allUser[indexOfUser]
                case "gender":
                    if(typeof newValue!="string")   {throw new validationError("Enter a valid gender")}
                    if(gender.toLowerCase()!="male" && gender.toLowerCase()!="female"){throw new validationError("Gender should be male or female ")}
                    User.allUser[indexOfUser].gender=newValue;
                    return User.allUser[indexOfUser]
                case "age":
                    if(typeof newValue!="number ")  {throw new validationError("Enter should be a valid number")}
                    User.allUser[indexOfUser].age=newValue;
                    return User.allUser[indexOfUser]
                default:
                    throw new notFoundError("Invalid Parameter");
            }
        }catch(e)
            {
                console.log(e);
            }
    }

    deleteUser(ID)
    {
        try
        {
            if(typeof ID!="number"){throw  new validationError("ID should be a valid number")}
            if(!this.isAdmin){throw new UnauthorizedError ("USer is Not Authorized")}
            let indexOfUser=this.findUser(ID)
            User.allUser.splice(indexOfUser,1);
            return User.allUser
        }catch(e)
            {   console.log(e);     }
    }

    //---------To read only one user ELSE -  User.allUser
    readUser(ID)
    {
        try
        {
            if(typeof ID!="number")     {throw  new validationError("ID should be a valid number")}
            if(!this.isAdmin)           {throw new UnauthorizedError ("USer is Not Authorized")}
            let indexOfUser=this.findUser(ID)
            return User.allUser[indexOfUser]
        }catch(e)
            {  console.log(e);     }
    }


    static validateNumber(contactNumber) 
    {
        var re = /^(\d{3})[- ]?(\d{3})[- ]?(\d{4})$/
        return re.test(contactNumber)
    }

//>>>>>>>>Creating Contact 
    createContact(contactName,contactNumber)
    {   try
        {
            if(this.isAdmin)                        {throw new UnauthorizedError("Admins Cannot create a contact ")}
            if(typeof contactName!="string")        {throw new validationError("Enter a valid contact name")}
            if(typeof contactNumber!="number")      {throw new validationError("Enter contact number in 1234567890 format (NOT in STRING FORMAT )")}
            if(!User.validateNumber(contactNumber)) {throw new validationError("Error:- Number should be of 10 digits (ex- 1234567890)")}
            
            let contactObject=new Contact(contactName,contactNumber)
            this.contacts.push(contactObject)
            return contactObject
        }catch(e){
         console.log(e);   
        }
    }
//>>>>>>>>>>Getting all contact
    getAllContacts()
    {
        try
        {
            if(this.isAdmin)    {throw new UnauthorizedError("Admins Cannot create a contact ")}
            return this.contacts;
        }catch(e){
            console.log(e);
        }
    }
// # makes a member of class private
    findContact(ID)
    {   
        try
        {
            for (let indexOfContact = 0; indexOfContact <this.contacts.length; indexOfContact++) {
                if(this.contacts[indexOfContact].contactID==ID){
                    return indexOfContact
                } 
            }
            // return [-1,false]
            throw new notFoundError("COntact-id not found")    
        }catch(e)
            {
                throw e
            }
    }

    readContact(ID)
    {
        try
        {
            if(typeof ID!="number")       {throw new validationError("ID should be a valid number")}
            if(this.isAdmin)              {throw new UnauthorizedError("Admin is Not Authorized")}
            let indexOfContact=this.findContact(ID)
            return this.contacts[indexOfContact]
        }catch(e){
            console.log(e);
        }
    }

    updateContact(ID,parameter,newValue)
    {
        try
        {
            if(typeof ID!="number")      {throw new validationError("ID should be a valid number")}
            if(this.isAdmin)             {throw new UnauthorizedError("Admin is Not Authorized")}
            let indexOfContact=this.findContact(ID)
            return this.contacts[indexOfContact].updateContact(parameter,newValue)
        }catch(e){
            console.log(e);
        }
    }

    deleteContact(ID)
    {
        try
        {
            if(typeof ID!="number")         {throw new validationError("ID should be a valid number")}
            if(this.isAdmin)                {throw new UnauthorizedError("Admin is Not Authorized")}
            let indexOfContact=this.findContact(ID)
            console.log("Contact Deleted:-",this.contacts[indexOfContact]);
            this.contacts.splice(indexOfContact,1);
            return this.contacts
        }catch(e){  console.log(e)   }
    }

    createrContactInfo(contactID,contactCountry,contactType){
        try{
            if(this.isAdmin)                    {throw new UnauthorizedError("Admin is Not Authorized")}
            if(typeof contactCountry!="string") {throw new validationError ("Enter a valid countary name")}
            if(typeof contactType!="string")    {throw new validationError ("Enter a valid contact type (work or home)")}
            if(typeof contactID !="number")     { throw new validationError("contactId should be a valid number")}
            let indexOfContact=this.findContact(contactID)
            // if(!isUserExist){return "User not found"}   
            return  this.contacts[indexOfContact].createrContactInfo(contactCountry,contactType)
        }  catch(e){
            console.log(e);
        }
    }

    updateContactDetails(contactID,contactDetailsID,parameter,newValue)
    {   try
        {  
            if(this.isAdmin)                        {throw new UnauthorizedError("admin is not authorized")}
            if(typeof contactID!="number")          {throw new notFoundError("ContactID should be a number")}
            if(typeof contactDetailsID!="number")   {throw new notFoundError("ContactDetailsID should be a number")}
            let indexOfContact=this.findContact(contactID)  
            // console.log(this.contacts[indexOfContact]);
            return this.contacts[indexOfContact].updateContactInfos(contactDetailsID,parameter,newValue)
        }
        catch(e)
        {
            console.log(e);
        }
    }

    readSingleContactDetails(contactID,contactDetailsID)
    {
        try{
            if(this.isAdmin){throw new UnauthorizedError("admin is not authorized")}
            if  (typeof contactID!="number")        {throw new notFoundError("ContactID should be a number")}
            if(typeof contactDetailsID!="number")   {throw new notFoundError("ContactDetailsID should be a number")}
            let indexOfContact=this.findContact(contactID)
            return this.contacts[indexOfContact].readContactInfos(contactDetailsID)
        }catch(e)
            {
                console.log(e)
            }
    }

    readAllContactDetails(contactID)
    {
        try
        {
            if(this.isAdmin)                {throw new UnauthorizedError("admin is not authorized")}
            if(typeof contactID!="number")  {throw new notFoundError("ContactID should be a number")}
            let indexOfContact=this.findContact(contactID)
            return this.contacts[indexOfContact].contactDetails
        }catch(e){
            console.log(e);
        }
    }

    deleteContactDetails(contactID,contactDetailsID)
    {
        try
        {
            if(this.isAdmin)                        {throw new UnauthorizedError( "Admin is Not Authorized")}
            if(typeof contactID!="number")          {throw new validationError("ID should be a valid number")}
            if(typeof contactDetailsID!="number")   {throw new validationError("ContactDetails-ID should be a number")}
            let indexOfContact=this.findContact(contactID)
            // if(!isUserExist){return "User not found"}  
            this.contacts[indexOfContact].deleteContactDetails(contactDetailsID)
            return this.contacts[indexOfContact].contactDetails
        }
        catch(e){
            console.log("inside Deleting contact details error section");
            console.log(e);
        }
    }

}



let adminUser=User.newAdmin("Aashish","male",38)

//let staff1=User.newUser("yash",)
let staff1=adminUser.createUser("Vedang","male",77)
let staff2=adminUser.createUser("Tanish","male",77)
let staff3=adminUser.createUser("Bhavesh","male",77)
console.log(adminUser.updateUser(8,"name","siddhant"));
// console.log(adminUser.deleteUser(1));
// console.log(adminUser.getAllUsers());

//<<<<<<<<<<<<<<<<<<<<<<< Creating contacts>>>>>>>>>>>>>>>>>
{   
    // creating contacts
    staff1.createContact("vedangs contact 1",1234567890)    //Contact ID-0
    staff1.createContact("vedangs contact 2",1234567890)    //Contact ID-1
    staff1.createContact("vedangs contact 3",1234567890)    //Contact ID-2

    staff2.createContact("Tanish's contact 1",1234567890)   //Contact ID-3
    staff2.createContact("Tanish's contact 2",1234567890)   //Contact ID-4
    staff2.createContact("Tanish's contact 3",1234567890)   //Contact ID-5
    staff2.createContact("Tanish's contact 4",1234567890)   //Contact ID-6
    staff2.createContact("Tanish's contact 5",1234567890)   //Contact ID-7

    staff3.createContact("Bhavesh's contact 1",1234567890)  //Contact ID-8
    staff3.createContact("Bhavesh's contact 2",1234567890)  //Contact ID-9
    staff3.createContact("Bhavesh's contact 3",1234567890)  //Contact ID-10
    staff3.createContact("Bhavesh's contact 4",1234567890)  //Contact ID-11
    staff3.createContact("Bhavesh's contact 5",1234567890)  //Contact ID-12
    staff3.createContact("Bhavesh's contact 6",1234567890)  //Contact ID-13
    staff3.createContact("Tanish",1234567890)
}

// <<<<<<<<<<<<<<<<<<<<<<< Reading a contact by ID>>>>>>>>>>>>>
{
// console.log(staff3.readContact(14));
// console.log( User.allUser);


}

// <<<<<<<<<<<<<<<<<<<<<<<<<Updating contacts>>>>>>>>>>>>>>>>>>>>
{
//  staff3.updateContact(13,"contactNumber",8652695916);
//  console.log(staff3.readContact(13));
}

//<<<<<<<<<<<<<<<<<<<<<<< Deleteing a contact>>>>>>>>>>>>>>>>>>>>>>>>
{
     // console.log(staff3.deleteContact(13));
}

//<<<<<<<<<<<<<<<<<<<<<<<< Creating a contactInfo >>>>>>>>>>>>>>>>>>>
(staff1.createrContactInfo(0,"India","Freind"));    ///contactDetailsID- 0
(staff2.createrContactInfo(3,"India","Freind"));    ///contactDetailsID- 1
(staff3.createrContactInfo(9,"India","Freind"));     ///contactDetailsID-2
(staff1.createrContactInfo(1,"India","Freind"));     ///contactDetailsID-3
(staff2.createrContactInfo(3,"India","Freind"));     ///contactDetailsID-4
(staff3.createrContactInfo(9,"India","Freind"));    ///contactDetailsID-5
(staff1.createrContactInfo(0,"India","work"));     ///contactDetailsID-6
(staff2.createrContactInfo(7,"India","Freind"));     ///contactDetailsID-7
(staff3.createrContactInfo(9,"India","Freind"));    ///contactDetailsID-8
(staff2.createrContactInfo(4,"India","Freind"));     ///contactDetailsID-9

//<<<<<<<<<<<<<<<<<<<<<<<<< Reading Contact details>>>>>>>>>>>>>>>>>>>
{
// console.log(staff1.readAllContactDetails(0));         //(reading Contact details of staff1.ID=0)
//console.log(staff1.readSingleContactDetails(0,6));    //(reading Contact details of staff1.ID=0 and with contactDetailsID=6)
// console.log(staff1.readContact(0));
}

//<<<<<<<<<<<<<<<<<<<<<<<<<<<Updating Contact details>>>>>>>>>>>>>>>>
{
    
// ("Previous",staff1.readSingleContactDetails(0,6));
("---------------------------------------");
console.log("After Updating",staff1.updateContactDetails(0 ,6,"contactCountry",434));
// console.log(staff1.readContact(0));
}

//<<<<<<<<<<<<<<<<<<<<<<< Deleting Contact Details>>>>>>>>>>>>>>>>>>>>>
{
// console.log("----------------------------------");
// console.log("After deleting", staff1.deleteContactDetails(0,6));
// console.log(staff1.readContact(0));

}
module.exports=User