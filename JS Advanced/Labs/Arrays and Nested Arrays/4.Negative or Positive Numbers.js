function arrange(input) {
    let number;
    const array = [];

    for (let i = 0; i < input.length; i++) {
        number = input[i];
        if (number >= 0) {
            array.push(number);
        } else {
            array.unshift(number);
        }
    }
    // for (let i = 0; i < array.length; i++) {
    //     console.log(array[i]);
    // }
// -------------------------------------
    // for(let num of array) {
    //     console.log(num);
    // }

    console.log(array.join('\n'));
}

arrange([7, -2, 8, 9]);
arrange([3, -2, 0, -1]);