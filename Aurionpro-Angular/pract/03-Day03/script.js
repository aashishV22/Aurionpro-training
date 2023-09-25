
const getTodos=(url)=>
{
    return new Promise((resolve,reject)=>
    {
        const request= new XMLHttpRequest();
        request.addEventListener('readystatechange',(e)=>
        {
            // console.log(request,request.readyState);
            if(request.readyState==4 && request.status==200)
            {
                resolve(JSON.parse  (request.responseText));
            }else if(request.readyState==4){
                reject("could not fetch");
            }
        })  
        request.open('GET',url);
        request.send();
    })
}

url='https://jsonplaceholder.typicode.com/todos'
url1="book.json"

// getTodos(url,(err,data)=>{
//     if(!err){
//         console.log(data);
//         getTodos(url1,(err,data)=>{
//             if(!err){
//                 console.log(data);
//             }
//             else{
//                 console.log(err);
//             }
//         });
    
    
//     }else{
//         console.log(err);
//     }

// })


getTodos(url).then((data)=>{
    console.log(data);
    return getTodos(url1);
}).then((data)=>{
    console.log(data);
})
.catch((err)=>{
    console.log("rejected");
    console.log(err);
})