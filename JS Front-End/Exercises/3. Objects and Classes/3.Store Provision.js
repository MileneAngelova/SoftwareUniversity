function storeProvision(firstArray, secondArray) {

    let stock = {};
    let product = '';
    let quantity = 0;

    for (let i = 0; i < firstArray.length; i++) {

        if (i % 2 === 0) {
            product = firstArray[i];
            quantity = Number(firstArray[i + 1]);
            stock[product] = quantity;
        }
    }

    for (let i = 0; i < secondArray.length; i++) {

        if (i % 2 === 0) {
            product = secondArray[i];
            quantity = Number(secondArray[i + 1]);

            if (stock[product] === undefined) {
                stock[product] = quantity;
            } else {
                stock[product] += quantity;
            }
        }
    }

    for (let product in stock) {
    console.log(`${product} -> ${stock[product]}`);
    }
}

storeProvision([
        'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
        'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
);