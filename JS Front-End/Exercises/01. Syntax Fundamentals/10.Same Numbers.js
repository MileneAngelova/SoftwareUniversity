function sameNumbers(number) {
    let lastDigit = 0;
    let sum = 0;
    let areEqual = true;

    while (number > 0) {
        lastDigit = number % 10;
        sum += lastDigit;

        number = Math.floor(number / 10);

        if (number !== 0 && lastDigit !== (number % 10)) {
           areEqual = false;
        }
    }
    console.log(areEqual);
    console.log(sum);
}

sameNumbers(123);
// sameNumbers(1234);