function sum (input) {
    let first = [...input].shift();
    let last = [...input].pop();
    let sum = Number(first) + Number(last);
    console.log(sum);
}
sum(['20', '30', '40']);
sum(['5', '10']);