//Cnstructor only assigns value  but cannot iterate

class Student{
    constructor(firstName,lastName,fullName,rollNumber,marks,dOb,avgMarks,grades,avgGrades,age)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.fullName=fullName;
        this.rollNumber=rollNumber;
        this.marks=marks;
        this.dOb=dOb;
        this.avgMarks=avgMarks;
        this.grades=grades;
        this.avgGrades=avgGrades;
        this.age=age;
    }

    static newStudent(firstName,lastName,rollNumber,marks,dOb)
    {   
        let date=new Date(dOb)
        if(typeof firstName!="string"){
            console.log("Invalid First name");
        }
        if(typeof lastName!="string"){
            console.log("Invalid Last name");
        }
        if(typeof rollNumber!="number"){
            console.log("Invalid Roll Number");
        }
        if(!Array.isArray(marks)){
            console.log("Marks is not an array");
        }
        for(let i=0;i<marks.length;i++){
            if(typeof marks[i]!="number"){
                console.log(marks[i]+" is not a number");
            }
        }
        // if(Student.prototype.toString.call(dOb)!="[object Date]"){
        //     console.log("Invalid date");
        // }
        if(date=="Invalid Date"){
            console.log("Invalid Date");
        }
        let fullName=Student.calculateFullName(firstName,lastName)
        let avgMarks=Student.calculateAvgMarks(marks)
        let grades= Student.calculateGrades(marks);
        let avgGrades=Student.calculateAvgGrades(avgMarks);
        let age=Student.calculateAge(date)
        return new Student(firstName,lastName,fullName,rollNumber,marks,dOb,avgMarks,grades,avgGrades,age)
    }
    static calculateFullName(firstName,lastName){
        let fullName=firstName+" "+lastName;
        //console.log(fullName);
        return fullName
    }
    static calculateAvgMarks(marks){
        let sum=0;
            for(let i=0;i<marks.length;i++){
                sum+=marks[i]
            }
           return sum/marks.length;
    }
    
    static calculateGrades(marks){
        let gradeArray=[]
            for(let i=0;i<marks.length;i++){
                if(marks[i]>=8){
                    gradeArray.push('A')
                }
                if(marks[i]>=5 && marks[i]<8){
                    gradeArray.push("B")
                }
                if(marks[i]>=2 && marks[i]<5){
                    gradeArray.push("C")
                }
                if(marks[i]>=0 && marks[i]<2){
                    gradeArray.push("F")
                }
            }
            return gradeArray
    }
    static calculateAvgGrades(avgMarks){
        if(avgMarks>=8){
            return 'A'
        }
        if(avgMarks>=5 && avgMarks<8){
            return "B"
        }
        if(avgMarks>=2 && avgMarks<5){
            return "C"
        }
        if(avgMarks>=0 && avgMarks<2){
            return "F"
        }
    }
    static calculateAge(date){
            let birthYear=date.getFullYear()
            let currentYear=2023
            let age=currentYear-birthYear
            return  age
    }
}

let s1=Student.newStudent("Aashish","verma",32,[3,4,5,6,1,4,7],"01/04/2002")
console.log(s1);
console.log(s1.age);
