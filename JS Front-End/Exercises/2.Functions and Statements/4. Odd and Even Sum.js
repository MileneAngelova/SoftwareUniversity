function sum(number) {
    let evenSum = 0;
    let oddSum = 0;

    while (number > 0) {
        let digit = number % 10;

        if (digit % 2 === 0) {
            evenSum += digit
        } else {
            oddSum += digit;
        }

        number = Math.floor(number / 10);
    }
    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

sum(1000435);
sum(3495892137259234);