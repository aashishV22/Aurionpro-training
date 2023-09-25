const Game=require("./Game")

let g1=Game.newGame("Aashish","Vedang")
let g2=Game.newGame("Ash","Veng")
console.log(g1.play(0)); //x
console.log(g1.play(5));//o
console.log(g1.play(1));//x
console.log(g1.play(4));//o
console.log(g1.play(2));//x
console.log(g2.play(2)); //x
console.log(g2.play(1));//o
console.log(g2.play(4));//x

console.log(g1.play(7));//x

console.log(g1.play(5));//o