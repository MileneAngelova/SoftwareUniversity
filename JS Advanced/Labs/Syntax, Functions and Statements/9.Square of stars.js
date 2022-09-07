function square(number) {
    let symbol ='*';
    for (let i = 0; i < number; i++) {
        for (let j = 0; j < number; j++) {
          
            console.log(symbol.repeat(number).split('').join(' '));
        }
    }
}
square(3);

// function square(number) {
//     let delimiter = '*';
//     let result = new Array(number);
//     for (let i = 0; i < number; i++) {
//         result[i] = delimiter.repeat(number).split('').join(' ')
//         console.log(result.join("\n"));
//     }
// }

// square(3);
// square(5);
// square(7);