function sum(num1, num2, num3) {
    let result = 0;
    let addition = num1 + num2;
    function subtract() {
        result = addition - num3;
    }
    subtract();
    return result;
}

console.log(
sum(23,
    6,
    10
));
console.log(
sum(1,
    17,
    30

));
console.log(
sum(42,
    58,
    100

));