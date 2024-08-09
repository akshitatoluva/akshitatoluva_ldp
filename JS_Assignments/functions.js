//function that takes another function as an argument.

function calculator(sum,a,b){
    return sum(a,b);
}
function sum(a,b){
    return a+b;
}
console.log(calculator(sum,10,20));

//Arrow function
let get_initials=(first,last) => {
    return first[0] + last[0];
}
//console.log(get_initials("Akshita","Toluva"));
console.log(get_initials("Roger","Waters"));