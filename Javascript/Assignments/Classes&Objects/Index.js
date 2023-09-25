class Student{
    constructor(rollNo,marks,firstName,lastName,birthDate){
        this.roll=rollNo;
        this.marks=marks,
        this.firstName=firstName,
        this.lastName=lastName,
        this.birthDate=birthDate,
        this.avgMarks= function(this.marks){
            let sum=0;
            for(let i=0;i<this.marks.length;i++){
                sum+=this.marks[i]
            }
           return sum/this.marks.length;
        }(this.marks),
        this.grade=()=>{
            let gradeArray=[]
            for(let i=0;i<this.marks.length;i++){
                if(this.marks[i]>=8){
                    gradeArray.push('A')
                }
                if(this.marks[i]>=5 && this.marks[i]<8){
                    gradeArray.push("B")
                }
                if(this.marks[i]>=2 && this.marks[i]<5){
                    gradeArray.push("C")
                }
                if(this.marks[i]>=0 && this.marks[i]<2){
                    gradeArray.push("F")
                }
            }
            return gradeArray
        }
        this.finalGrade=()=>{
            console.log(this.avgMarks());
            if(this.avgMarks()>=8){
                return 'A'
            }
            if(this.avgMarks()>=5 && this.avgMarks()<8){
                return "B"
            }
            if(this.avgMarks()>=2 && this.avgMarks()<5){
                return "C"
            }
            if(this.avgMarks()>=0 && this.avgMarks()<2){
                return "F"
            }

        }
        this.age=()=>{
            let dateOfBirth=new Date(this.birthDate)
            let birthYear=dateOfBirth.getFullYear()
            console.log("Birth year is "+birthYear);
            let currentYear=2023
            let age=currentYear-birthYear
            return  age
        }

    }
    getFullName=()=>{
        return (this.firstName+" "+this.lastName);
    }


}

let s1=new Student(32,[3,5,2,9,0],"Aashish","Verma","01/22/2002")
console.log(s1);

let s2=new Student(32,[3,5,6,8,10],"Vedang","Badawe")
console.log(s2);

// let temp;
// temp=s1.firstName;
// s1.firstName=s2.firstName;
// s2.firstName=temp
console.log("Student 1: "+s1.getFullName());
console.log("Student 2: "+s2.getFullName());
console.log("Average marks of student 1 = "+s1.avgMarks);
console.log("Grades of Student 1: "+s1.grade());
console.log("Age of Student 1:  "+s1.age());
console.log("Final Grade of Student 1 : "+s1.finalGrade());

