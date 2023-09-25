
const myFunc=(callbackFunc)=>
{
    console.log("hello js");
    let num=10;
    callbackFunc(num);
}

myFunc(function(value){
    console.log(value); 
});

let players=["aashish","vedang","Tanish"];

// const printPlayers=(players,index)=>{
//     console.log(players,index);
// };

// players.forEach(printPlayers)

// players.forEach((player,index)=>{
//     console.log(player,index)
// })

const ul=document.querySelector('ul');
console.log(ul);
let html=``;
players.forEach((player,index)=>{
    html+=`<li>${player},${index}</li>`;
})

// class Student{
//     constructor(srNumber,name,percentage,hobbies){

//     }
// }

ul.innerHTML=html
console.log(html);

let student={
    id:12121,
    name:"Aashish",
    percentage:87,
    hobbies:["sleeping","tain travelling"],
    login: function(){
        console.log("Student logged in");
    },
    logOut: function(){
        console.log("Student logged out");
    },
    printHobbies: function(){
       this.hobbies.forEach((hobbie)=>console.log(hobbie))
        // console.log(this.hobbies);
    },

}


console.log(student['id']);
student.printHobbies();

const h1=document.querySelector('h1')
h1.innerHTML+=" modified";

const h2=document.querySelector('#header')
h2.innerText+=" new modified";

const h3=document.querySelectorAll('.yo')
h3.forEach((element)=>{
  element.innerHTML+=" done"  
})

// let student2={
//     id:3232,
//     name:"aashish",
//     percentage:76,

// }
// const olNew=document.querySelector('ol')
// olNew.innerText+= student2
// let txt=``
// for(let x in student2)
// {
//     txt +=  student[x] +"-"   ;
// }


// olNew.innerHTML=txt;



let Students=[
    {id:3232,   name:"aashish", percentage:56,},
    {id:323,   name:"Vedang", percentage:66,},
    {id:324,   name:"Tanish", percentage:75,},
    {id:325,   name:"Siddhant", percentage:86,},
    {id:322,   name:"Ujwal", percentage:66,},

]

const olNew=document.querySelector('table')
let txt=``;
for(let i=0;i<Students.length;i++){
    txt+= `<tr><td> ${Students[i].id} <td> ${Students[i].name} </td> <td> ${Students[i].percentage} </td>  </td></tr>`
}


olNew.innerHTML=txt;


// let Students=[
//     {id:3232,   name:"aashish", percentage:56,},
//     {id:323,   name:"Vedang", percentage:66,},
//     {id:324,   name:"Tanish", percentage:75,},
//     {id:325,   name:"Siddhant", percentage:86,},
//     {id:322,   name:"Ujwal", percentage:66,},
// ];

// let html = "<table><tr><th>ID</th><th>Name</th><th>Percentage</th></tr>";

// for (let i = 0; i < Students.length; i++) {
//     html += "<tr>";
//     html += "<td>" + Students[i].id + "</td>";
//     html += "<td>" + Students[i].name + "</td>";
//     html += "<td>" + Students[i].percentage + "</td>";
//     html += "</tr>";
// }

// html += "</table>";

// document.write(html);









