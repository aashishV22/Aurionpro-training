class Employee
{
    constructor(firstName,lastName,employeeID,fullName,salary,annualSalary,
        designation,department,setDateOfJoining,dateOfResignation,totalExperience, contactNo,
        personalEmailId,workEmailId, dateOfBirth, age, address,city,country,
        officeADDRESS,officeCITY,officeCOUNTRY,reporting_Officer,subbordinates){
            this.firstName=firstName;
            this.lastName=lastName;
            this.employeeID=employeeID;
            this.fullName=fullName;
            this.salary=salary
            this.annualSalary=annualSalary;
            this.designation=designation;
            this.department=department
            this.dateOfJoining=setDateOfJoining;
            this.dateOfResignation=null;
            this.totalExperience=totalExperience;
            this.contactNo=contactNo;
            this.personalEmailId=personalEmailId;
            this.workEmailId=workEmailId;
            this.dateOfBirth=dateOfBirth;
            this.age=age;
            this.address=address;
            this.city=city;
            this.country=country;
            this.officeADDRESS=officeADDRESS;
            this.officeCITY=officeCITY;
            this.officeCOUNTRY=officeCOUNTRY;
            this.reporting_Officer=reporting_Officer;
            this.subbordinates=subbordinates;
        }
        static setReportingOfficer=null

        static newEmployee(firstName,lastName,employeeID,salary,
            designation,department,dateOfJoining, contactNo,
            personalEmailId,workEmailId, dateOfBirth, address,city,country,
            officeADDRESS,officeCITY,officeCOUNTRY)
        {
            if(typeof firstName!="string"){
                console.log("Invalid First name");
            }
            if(typeof lastName!="string"){
                console.log("Invalid Last name");
            }
            if(typeof employeeID!="number"){
                console.log("Invalid Employee ID");
            }
            if(typeof salary!="number"){
                console.log("Invalid amount");
            }
            if(typeof designation!="string"){
                console.log("Invalid Designation");
            }
            if(typeof department!="string"){
                console.log("Invalid department");
            }
            let setDateOfJoining=new Date(dateOfJoining)
            if(setDateOfJoining=="Invalid Date"){
                console.log("Invalid Date");
            }
            if(typeof contactNo!="number"){
                console.log("Invalid contact number");
            }
            if(contactNo.toString().length>10){
                console.log("Contact number is greater then 10");
            }
            if(contactNo.toString().length<10){
                console.log("Contact number is lesser then 10");
            }
            let date=new Date(dateOfBirth)
            if(date=="Invalid Date"){
                console.log("Invalid Date");
            }
            let subbordinates=[]
            if(!Array.isArray(subbordinates)){
                console.log("subbortinates is not an array");
            }
            // for(let i=0;i<subbordinates.length;i++){
            //     if(obj.constructor==Employee){
            //         this.subbordinates.push(obj);
            //         return "subordinate is assigned"
            //     }
            //     else{
            //         return "Invalid input"
            //     }
            // }
            let setPersonalEmailId=Employee.validateEmail(personalEmailId)
            let setWorkEmailId=Employee.validateEmail(workEmailId)
             if (typeof setPersonalEmailId != "string") {
            return "Invalid Personal Email"
            }
            if (typeof setWorkEmailId != "string") {
                return "Invalid Personal Email"
                }


            let fullName=Employee.calculateFullName(firstName,lastName);
            let age=Employee.calculateAge(date);
            let annualSalary=Employee.annualSalary(salary);
            // let FormattedDateOfJoining = Employee.formattedDate(setDateOfJoining)
            // let [totalExperience,dateOfResignation]=Employee.experience(joinDate)
            

            return new Employee(firstName,lastName,employeeID,fullName,salary,annualSalary,
                designation,department,setDateOfJoining,this.dateOfResignation,this.totalExperience, 
                contactNo,
                setPersonalEmailId,setWorkEmailId, dateOfBirth, age, address,city,country,
                officeADDRESS,officeCITY,officeCOUNTRY,Employee.setReportingOfficer,subbordinates)
        }

        static formattedDate(Date){
            return Date.getDate() + "/" + (Date.getMonth() + 1) + "/" + Date.getFullYear()
        }
        static validateEmail(email) {
            var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
            if (validRegex.test(email)) {
                return email
            }
            return false
        }

        static annualSalary(salary)
        {
            let annualSalary=salary*12
            return annualSalary
        }

        static calculateFullName(firstName,lastName)
        {
            let fullName=firstName+" "+lastName;
            return fullName
        }
        static calculateAge(date)
        {
            let birthYear=date.getFullYear()
            let currentYear=2023
            let age=currentYear-birthYear
            return  age
        }
         static experience=(dateOfJoining,dateOfResignation)=>
        {   
            return Math.floor((dateOfResignation.getTime() - dateOfJoining.getTime()) / (1000 * 60 * 60 * 24))
        }
        setDateOfResignation() {
            this.dateOfResignation=new Date()
            this.totalExperience=Employee.experience(this.dateOfJoining,this.dateOfResignation)
            this.dateOfJoining = Employee.formattedDate(this.dateOfJoining)
            this.dateOfResignation = Employee.formattedDate(this.dateOfResignation)
            return "Date of resignation :"+this.dateOfResignation
        };
    
        setManager(obj){
            if(obj.constructor==Employee){
                this.reporting_Officer=obj;
                return "Reporting officer is assigned"
            }
            else{
                return "Invalid input"
            }
        };
        setSubordinate(obj){
            if(obj.constructor==Employee){
                this.subbordinates.push(obj);
                return "subordinate is assigned"
            }
            else{
                return "Invalid input"
            }
        }
}
let Rohit=Employee.newEmployee("Rohit","Chibramanyam",4033,75343,"Sr.Manager","Cash Management","10/02/2012",1234567890,"rohit@gmail.com","rohit.chib@aurionpro.com","01/02/1992","kranti kunj,secor-1","Kamothe","India","Syneria park","Rabale","India")


let employee1=Employee.newEmployee("Aashish","verma",6033,32343,"Trainee Engineer","Cash Management","10/02/2019",1234567890,"aashish@gmail.com","aashish.verma@aurionpro.com","01/02/2002","Shanti kunj,secor-19","Kamothe","India","Syneria park","Rabale","India")

let subordinate1=Employee.newEmployee("Aashish","verma",6033,32343,"Trainee Engineer","Cash Management","10/02/2019",1234567890,"aashish@gmail.com","aashish.verma@aurionpro.com","01/02/2002","Shanti kunj,secor-19","Kamothe","India","Syneria park","Rabale","India")


console.log(employee1);
//(employee1.setDateOfResignation());
employee1.reporting_Officer = Rohit
console.log(employee1);
employee1.setSubordinate(subordinate1)
console.log(employee1);