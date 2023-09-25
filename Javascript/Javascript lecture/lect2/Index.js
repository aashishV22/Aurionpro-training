let addition=(...n)=>{
    let sum=0;
    for(let i=0;i<n.length;i++){
        if(typeof n[i]=="number"){  
            sum+=n[i];
            // x="addition:"
        }
        else{
            let x="error"
            return [x,null]
        }
    }
    return ["addition",sum];
}

let subtraction=(...n)=>{
    let subtraction=0;
    for(let i=0;i<n.length;i++){
        if(typeof n[i]=="number")
        {  
            subtraction=n[i]-subtraction;
       }
        else{
            let x="error"
            return [x,null]
        }
    }
    return ["subtraction",subtraction];
}

let multiplication=(...n)=>{
    let totalMultiplication=1;
    for(let i=0;i<n.length;i++){
        totalMultiplication=totalMultiplication*n[i];
    }
    return totalMultiplication;
}
let functionGenerator=(operation)=>
{
   switch(operation)
   {
      case "addition":return ["Addition:",addition]
      case "subtraction": return ["Subtraction",subtraction]
      case "multiplication": return multiplication
      default: return function(){
        "invalid operation entered"
      }
   }
}
let a=[1,2,3,4,5];
let [x,add]=functionGenerator("subtraction");
console.log(x, add(...a));
