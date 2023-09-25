//Await

const getData=async ()=>{
    const response=await fetch('https://jsonplaceholder.typicode.com/todoss')
    const data=await response.json()
    return data

}

getData().then((data)=>{
    console.log(data);
}).catch((err)=>{
    console.log("error happend");
})