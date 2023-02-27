function printElement(array, step) {

    let newArray = [];

    for (let i = 0; i <= array.length - 1; i += step) {
        let current = array[i];
        newArray.push(current);
    }
   return newArray;
}

printElement(['5',
        '20',
        '31',
        '4',
        '20'],
    2
);
printElement(['dsa',
        'asd',
        'test',
        'tset'],
    2
);
printElement(['1',
        '2',
        '3',
        '4',
        '5'],
    6
);