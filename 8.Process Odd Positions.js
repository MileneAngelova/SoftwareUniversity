function doubledOddPositions(input) {
    const array = [];
    for (let i = 0; i < input.length; i++) {
        if (i % 2 != 0) {
            array.push(input[i] * 2);
        }
    }
    return array.reverse().join(' ');
}
console.log(doubledOddPositions([10, 15, 20, 25]));
console.log(doubledOddPositions([3, 0, 10, 4, 7, 3]));