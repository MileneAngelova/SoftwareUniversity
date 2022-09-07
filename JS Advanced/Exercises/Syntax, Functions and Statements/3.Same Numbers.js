function sameNumber(input) {

    let number = String(input);
    isSame = true;
    let sum = 0;
    let firstDigit = number[0];

    for (let i = 0; i < number.length; i++) {
        let currentDigit = Number(number[i]);
        sum += currentDigit;

        if (firstDigit != currentDigit) {
            isSame = false;
        }
    }
    console.log(isSame);
    console.log(sum);
}

sameNumber(2222222);
sameNumber(1234);

