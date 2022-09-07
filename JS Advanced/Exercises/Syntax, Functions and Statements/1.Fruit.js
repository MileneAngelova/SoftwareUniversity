function totalSum(fruit, grams, pricePerKilo) {
    let kg = (grams / 1000).toFixed(2);
    let sum = (kg * pricePerKilo).toFixed(2);
    console.log(`I need $${sum} to buy ${kg} kilograms ${fruit}.`);
}

totalSum('orange', 2500, 1.80);
totalSum('apple', 1563, 2.35);