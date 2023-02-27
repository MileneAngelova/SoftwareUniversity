function sortNumbers(array) {
    array.sort((a, b) => a - b);

    let result = [];
    let step = 0;

    while (array.length > 0) {
        if (step % 2 === 0) {
            result.push(array.shift());
        } else {
            result.push(array.pop());
        }

        step++;
    }
    return result;
}

console.log(
    sortNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56])
);