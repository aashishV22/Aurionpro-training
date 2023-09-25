class User
{
    static userID=0
    static allUsers=[]
    constructor(name,contactNumber,isAdmin)
    {
        this.name=name;
        this.contactNumber=contactNumber;
        this.isAdmin=isAdmin;
        this.userID=User.userID++;
        this.accounts=[];
    }

    static validateNumber(contactNumber) 
    {
        var re = /^(\d{3})[- ]?(\d{3})[- ]?(\d{4})$/
        return re.test(contactNumber)
    }

    static newAdmin(name,contactNumber)
    {
        try
        {
            if(typeof name!="string")   {throw new Error("Name should be aplhabets")}
            if(typeof contactNumber!="number")      {throw new validationError("Enter contact number in 1234567890 format (NOT in STRING FORMAT )")}
            if(!User.validateNumber(contactNumber)) {throw new validationError("Error:- Number should be of 10 digits (ex- 1234567890)")}
            return new User(name,contactNumber,true)
        }   catch(e)                    {  console.log(e.message)  }

    }

    createUser(name,contactNumber){
        try
        {
            if(!this.isAdmin)           {throw new Error("Only admin can create users")}
            if(typeof name!="string")   {throw new Error("Name should be aplhabets")}
            if(typeof contactNumber!="number")      {throw new validationError("Enter contact number in 1234567890 format (NOT in STRING FORMAT )")}
            if(!User.validateNumber(contactNumber)) {throw new validationError("Error:- Number should be of 10 digits (ex- 1234567890)")}
            let newCustomer= new User(name,contactNumber,false)
            User.allUsers.push(newCustomer)
            return new User(newCustomer)
        }   catch(e)                    {  console.log(e.message)  }
    }

    findUserId(userID)
    {
        try
        {
            if(!this.isAdmin)           {throw new Error("Only admin can create users")}
            for (let indexOfUser = 0; indexOfUser<User.allUsers.length; indexOfUser++) 
            {
                if(User.allUsers[indexOfUser].userID==userID){
                    return indexOfUser
                } 
            }
            throw new   Error("USer-ID not found")

        }catch(e)
        {          console.log(e);                 }
    }

    updateUser(userID,parameter,newValue)
    {
        try{
            if(!this.isAdmin)                     {throw new Error("Only admin can create users")}
            if(typeof userID!="number")           {throw new Error("userID should be a number")}
            let indexOfUser=this.findUserId(userID)
            switch(parameter)
            {
                case "name":
                    if(typeof newValue!="string")   {throw validationError("Enter a string value")}
                    User.allUsers[indexOfUser].name=newValue;
                    return User.allUsers[indexOfUser]
                case "contactNumber":
                    if(typeof contactNumber!="number")      {throw new validationError("Enter contact number in 1234567890 format (NOT in STRING FORMAT )")}
                    if(!User.validateNumber(contactNumber)) {throw new validationError("Error:- Number should be of 10 digits (ex- 1234567890)")}
                    User.allUsers[indexOfUser].contactNumber =newValue;
                    return User.allUsers[indexOfUser]
            
                default:
                    throw new Error("Invalid Parameter");
            }

        }catch(e){
            console.log(e);
        }
    }

    deleteUser(userID)
    {
        try
        {
            if(!this.isAdmin)                     {throw new Error("Only admin can create users")}
            if(typeof userID!="number")           {throw new Error("userID should be a number")}
            let indexOfUser=this.findUserId(userID)
            User.allUsers.splice(indexOfUser,1);
            return User.allUsers

        }catch(e)
        {
            
        }

    }

    readUSer(userID)
    {
        try
        {
            if(!this.isAdmin)                     {throw new Error("Only admin can create users")}
            if(typeof userID!="number")           {throw new Error("userID should be a number")}
            let indexOfUser=this.findUserId(userID)
            return User.allUsers[indexOfUser]
        }catch(e)
        {                           }
    }

}


let adminUser=User.newAdmin("Aashish",1234567890)
let customer1=adminUser.createUser("vedang",1234567890);
adminUser.updateUser(1,"name","tanish");
// adminUser.deleteUser(1)
