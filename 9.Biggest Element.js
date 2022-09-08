function biggestElement(matrix) {
    let biggest = [];

    for (const row of matrix) {
        row.sort((x, y) => y - x);
        biggest.push(row[0]);
    }
    biggest.sort((a, b) => b - a);
    return biggest[0];
}


console.log(biggestElement([[20, 50, 10],
[8, 33, 145]]
));

console.log(biggestElement([[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]
   ));