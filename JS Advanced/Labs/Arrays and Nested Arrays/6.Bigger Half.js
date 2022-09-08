function printHalf(array) {
    const newArray = [];
    array.sort((a, b) => a - b);

   
    // newArray.push(array.slice(Math.floor(array.length / 2), array.length));
    for (let i = Math.floor(array.length / 2); i < array.length; i++) {
        newArray.push(array[i]);
    }
    return newArray;
}

console.log(printHalf([4, 7, 2, 5]));
console.log(printHalf([3, 19, 14, 7, 2, 19, 6]));