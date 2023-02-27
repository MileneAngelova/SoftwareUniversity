function arrayRotation(array, counter) {

    while (counter > 0) {
        let lastNumber = array.shift();
        array.push(lastNumber);

        counter--;
    }
    console.log(array.join(' '));
}

arrayRotation([51, 47, 32, 61, 21], 2);
arrayRotation([32, 21, 61, 1], 4);
arrayRotation([2, 4, 15, 31], 5);