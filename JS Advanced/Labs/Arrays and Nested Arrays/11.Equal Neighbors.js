function neighbors(matrix) {

    let pairs = 0

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {

            if ((col + 1 < matrix[row].length)
                && (matrix[row][col] === matrix[row][col + 1])) {
                pairs++;
            }

            if ((row + 1 < matrix.length)
                && (matrix[row][col] === matrix[row + 1][col])) {
                pairs++;
            }
        }
    }

    return pairs;
}

console.log(neighbors([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']]
));

console.log(neighbors([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]
));