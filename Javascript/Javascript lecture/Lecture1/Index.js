   // const c=7
// console.log("the is constatnt ",c)
// var a
// console.log(a);
// a="aashish";
// console.log("This is var:",a)

// let b="Verma";
// console.log("This is let: Verma")

// {
//     let b="G"
//     console.log(b)
// }
// console.log(b)


// {
//     let a="A"
//     console.log(a)
// }
// console.log(a,typeof a)
// let x=3
// console.log(x,typeof x)
// let y=true
// console.log(y,typeof y)
// let z
// console.log(z,typeof z)
// let g=null
// console.log(g,typeof g)


//  arrayOne=[1,2,3,4,5]
// // let arrayTwo=[6,7,8,9,10]

// // console.log(arrayOne==arrayTwo);
// // console.log(arrayOne[0]);
// // console.log(arrayTwo[0]);
// // arrayOne=arrayTwo
// // console.log(arrayOne[0]);
// // console.log(arrayTwo[0]);


//>>>>>>>>>>>>Functions
// let num1=2
// let num2=4
// let addition=(num1,num2)=>{
//     return num1+num2
//     console.log("Addition:",num1+num2);
// }
// let subtraction=()=>{
//     console.log("Subtraction:",num2-num1);
// }

// let globalFunction=(operation,num1,num2)=>{
//     return operation(num1,num2);
// }
// console.log(globalFunction(addition,num1,num2))


// let num1=2
// let num2=5
// let addition=(num1,num2)=>
//    {
//       return num1+num2
//    }
// let subtraction=()=>
//   {
//       console.log("Subtraction:",num2-num1);
//    }

// let functionGenerator=(operation)=>
// {
//    switch(operation)
//    {
//       case "addition":return["Addition: ",addition]
//       case "subtraction": return["Subtraction: ",subtraction]
//       default: return["Invalid",null]
//    }
// }

// let[x,add]=functionGenerator("addition");
// console.log(add(x,num1,num2));


//............object literals
// const myObj={
//    fName:"Aashish",
//    xyz: function(a,b)
//          {
//             return (a+b)
//          }(2,3),

//    abc: function(a,b)
//       {
//          return a+b
//       },

//    mno: function(a,b)
//          {
//             return function(c,d)
//             {
//                return c*d;
//             }
//          }(2,3)
// }
// console.log(myObj.xyz);
// console.log(myObj.abc);
// console.log(myObj.mno);



let myOb1={
   fName:"aashish",
}

let myOb2={
   fName:"ved",
}
let temp=myOb1
myOb1=myOb2
myOb2=temp
console.log(myOb1);
console.log(myOb2);


