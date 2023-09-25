//Promise

const getData=()=>{
    return new Promise((resolve,reject)=>{
        resolve("Promise resolved");
        rejected("Promise rejected");
    });
};

getData().then((data)=>{
    console.log(data);
}).catch((err)=>{
    console.log(err);
})