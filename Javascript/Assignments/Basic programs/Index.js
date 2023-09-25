////.......Sum of first n-elemts of fibonacci series...........
let sumOfFibonacci=(number)=>
{
    let firstNumber=0;
    let secondNumber=1;
    let i;
    let nextNumber=0;
    let toatalSum=1;
    for (i=2 ; i<number; i++)
    {
        nextNumber = firstNumber + secondNumber;
        toatalSum=toatalSum+nextNumber;
        firstNumber= secondNumber;
        secondNumber= nextNumber;
    }
    console.log("Sum of Fibonacci series is "+toatalSum);
}

//............A number is prime or not................
let primeOrNot=(number)=>
{
    let isPrime=true
    if(number==2)
    {
         isPrime=true
    }
    if(number==1)
    {
        isPrime=false;
    }
    for(let i=0;i<number;i++){
        if(number%i==0){
                isPrime=false;
            }
        else{
            isPrime=true;
        }
    }
    if(isPrime==true){
        console.log(number+" is a prime number");
    } else{
        console.log(number+" is not prime");
    }
}

//primeOrNot(3);

//program to find the count of even odd and zero

let countEvenOddZero = (array) => {
    let evenNumberCount = 0
    let oddNumberCount = 0
    let zerosInArray = 0
     for(i=0;i<array.length;i++)
     {
        if(array[i]%2==0 && array[i]!=0)
        {
            evenNumberCount++
        }else if(array[i]%2==1)
            {
                oddNumberCount++
            }
        if(array[i]==0)
            {
                zerosInArray++
            }
     }
     console.log("Count of even numbers:"+evenNumberCount , "\nCount of odd numbers:"+ oddNumberCount ,"\nCount of Zeros in array:" +zerosInArray);
}

// let arr = [2 , 3 , 0 , 8 , 7 , 0, 6 , 0 , 0 , 0 , 3]
// countEvenOddZero(arr)

let functionGenerator=(operation)=>
{
   switch(operation)
   {
      case "sumOfFibonacci":return["",sumOfFibonacci]
      case "primeOrNot": return["Prime or not Function:\n",primeOrNot]
      case "countEvenOddZero": return["Count number of even,odds and zeros function:\n",countEvenOddZero]
      default: return["Invalid",null]
   }
}

let[x,func]=functionGenerator("sumOfFibonacci");
func(5);



let[y,prime]=functionGenerator("primeOrNot");
prime(5);


let[z,count]=functionGenerator("countEvenOddZero");
let arr = [1,2 ,32,543,45,   0 , 0 , 0 , 3]
count(arr);