function buyFruit (fruit, grams, price) {
let kg = grams / 1000;
let sum = price * kg;

console.log(`I need $${sum.toFixed(2)} to buy ${kg.toFixed(2)} kilograms ${fruit}.`);
}

buyFruit('orange', 2500, 1.80);
buyFruit('apple', 1563, 2.35);