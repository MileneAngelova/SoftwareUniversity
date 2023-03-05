function factorial(num1, num2) {
    let firstFactorial = 1;
    let secondFactorial = 1;

    for (let i = 1; i <= num1; i++) {
        firstFactorial *= i;
    }
    for (let i = 1; i <= num2; i++) {
      secondFactorial *= i;
    }

    console.log((firstFactorial / secondFactorial).toFixed(2));
}

factorial(6, 2);