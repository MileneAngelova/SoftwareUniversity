function printSum (firstNumber, secondNumber) {
    let sum = 0;
    let output = '';
    // let output = [];
    for (let i = firstNumber; i <= secondNumber; i++){
        // output.push(i);
        output += i + ' ';
        sum += i;
    }
    // console.log(output.join(" "));
    console.log(output.trim());
    console.log(`Sum: ${sum}`);
}

printSum(5, 10);
printSum(0, 26);
printSum(50, 60);