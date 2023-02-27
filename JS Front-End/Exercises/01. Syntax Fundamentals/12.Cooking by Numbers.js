function cookingNumbers(first, second, third, fourth, fiveth, sixth) {
    let number = Number(first);
    let operations = [second, third, fourth, fiveth, sixth];

    for (const operation of operations) {
        if (operation === 'chop') {
            number = number / 2;
            console.log(number);

        } else if(operation === 'dice') {
            number = Math.sqrt(number);
            console.log(number);

        } else if(operation === 'spice') {
            number = number + 1;
            console.log(number);

        } else if(operation === 'bake') {
            number = number * 3;
            console.log(number);

        } else if(operation === 'fillet') {
            number -= number * 0.2;
            console.log(number);
        }
    }
}

cookingNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');

