
let guessNumber=()=> 
{
    let isGameEnded=false
    let answer = Math.floor((Math.random() * 100) + 1);
    let i=1
    let input=parseInt(prompt("Turn:"+ i +" \n Guess the number from 1 to 100"))
    if(typeof input!="number"){
        alert("Enter a valid number")
    }
    while(!isGameEnded)
    {   if(input<=0 || input>101 || typeof input!="number")
        {
            alert("Enter a valid number")
            i--;
        }
        if(input<answer)
        {   
            i++;
            input=parseInt(prompt("Turn:"+ i +" \n Your guessed number "+ input+" is low , Re-enter a higher number: "));
        }
        else if(input>answer)
        {
            i++;
            input=parseInt(prompt("Turn:"+ i +" \n Your guessed number "+ input+" is high , Re-enter a lower number: "));
        }
        else if(input==answer)
        {   
        isGameEnded=true
        //alert("Total Turns:"+ i +" \n Your guessed number "+ input+" is correct ");
        let rePlay=prompt("Total Turns:"+ i +" \n Your guessed number "+ input+" is correct \nDo you want to replay or end? ");
        console.log(rePlay.toUpperCase())
        if(rePlay.toUpperCase()=="REPLAY"){
            console.log("Game replayed");
            guessNumber()
        }
        if(rePlay.toUpperCase()=="END"){
            alert("Game Ended")
            console.log("Game ended");
            }
        }
    }
  }

guessNumber();