const buttonRef = document.querySelector('button')
const ulRef=document.querySelector('ul');
const inpRef=document.querySelector('input');

// buttonRef.addEventListener('click',(e)=>{
//     ulRef.innerHTML+=`<li>new player</li>`
// })

buttonRef.addEventListener('click',(e)=>{
    const name=inpRef.value;
    console.log(name);
    if(name.length!=0)
    {
        const li=document.createElement('li');
        // li.innerText=name;
        // console.log(li);
        // ulRef.appendChild(li);
        ulRef.innerHTML+=`<li>${name}</li>`
        inpRef.value='';

        //To delete on clicking
    //     const liAllRef=document.querySelectorAll('li');
    //     liAllRef.forEach(li=>{
    //      console.log(li.innerText);
    //     li.addEventListener('click',(e)=>{
    //     console.log(e.innerText);
    //     e.target.remove();
    // })
// })
    }
})


// const liAllRef=document.querySelectorAll('li');
// liAllRef.forEach(li=>{
//     // console.log(li.innerText);
//     li.addEventListener('click',(e)=>{
//         // console.log(e.innerText);
//         e.target.remove();
//     })
// })


// Using bubble 
ulRef.addEventListener('click',(e)=>{
    if(e.target.tagName!=="UL")
    e.target.remove();
})


const list=[
    {
        name:'Netflix',
        price:900,
        status:true,
    },
    {
        name:'Hotstar',
        price:600,
        status:true,
    },{
        name:'SonyLiv',
        price:360,
        status:false,
    },{
        name:'Voot',
        price:400,
        status:true,
    },{
        name:'JioCinema',
        price:500,
        status:false,
    },
]

const  subscribedList=list.filter((list)=>{
    // if(list.status==true){
    //     subscribedList+=list;
    // }
    return list.status;
})
console.log(subscribedList);

//MAP

const price=[32323,3232,3678,9076,865,5446,764];
const discountedPrice=price.map((price)=>{
    return price-price*0.2;
})
console.log(discountedPrice);

const productList=[
    {
        productID:4323,
        productName:"ParleG",
        productPrice:300
    },
    {
        productID:4363,
        productName:"Sampuu",
        productPrice:700
    },
    {
        productID:4328,
        productName:"Flour",
        productPrice:900
    },
    {
        productID:4321,
        productName:"Maggie",
        productPrice:500
    },
    {
        productID:4361,
        productName:"Dettol",
        productPrice:400
    },

]

const discountedProduct=productList
    // .filter(list=>{
    //    return  list.productPrice>=500
    // })
    .map(list=>{
        list.productPrice>=500
        return{
            productID:list.productID,
            productName:list.productName,
            productPrice:list.productPrice-(list.productPrice*0.2),
        }
        
    })

console.log(discountedProduct);
console.log(productList);
const result =discountedProduct.reduce((sum,product)=>{
    return product.productPrice+sum;
},0);
console.log(result);

const marks=[23,2,43,56,34,7,12,0]
marks.sort((v1,v2)=>{
    return v1-v2;
})
console.log(marks);
