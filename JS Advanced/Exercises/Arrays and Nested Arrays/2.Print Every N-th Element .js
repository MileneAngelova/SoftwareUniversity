// function nthElement(array, number) {
//     return array.filter((x, i) => i % number == 0);
// }

function nthElement(array, number) {
for(let i = 0; i < array.length; i += number) {
    return array[i];
}
}



console.log(nthElement(['5', 
'20', 
'31', 
'4', 
'20'], 
2
));
console.log(nthElement(['dsa',
'asd', 
'test', 
'tset'], 
2
));
console.log(nthElement(['1', 
'2',
'3', 
'4', 
'5'], 
6
));