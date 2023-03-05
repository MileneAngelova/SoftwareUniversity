function perfectNumber(number) {
    let output = '';
    let sum = 0;
    for (let i = 1; i < number ; i++) {
        if (number % i === 0) {
            sum += i;
        }
    }

        if (number === sum) {
            output = 'We have a perfect number!';
        } else {
            output = "It's not so perfect.";
        }

    console.log(output);
}

perfectNumber(1236498);
