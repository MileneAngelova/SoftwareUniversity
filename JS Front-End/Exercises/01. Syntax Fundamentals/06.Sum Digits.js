function sumDigits (number) {
    let result = 0;
    let currentDigit = 0;

    while (number > 0) {
        currentDigit = number % 10;
        result += currentDigit;

        number = Math.floor(number / 10);
    }

    console.log(result);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);