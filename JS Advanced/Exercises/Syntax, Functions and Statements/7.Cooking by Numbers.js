function action(start, operation1, operation2, operation3, operation4, operation5) {
    let number = Number(start);
    let actionList = [operation1, operation2, operation3, operation4, operation5];

    for (let i = 0; i < actionList.length; i++) {

        if (actionList[i] == 'chop') {
            number = number / 2;
        } else if (actionList[i] == 'dice') {
            number = Math.sqrt(number);
        } else if (actionList[i] == 'spice') {
            number = number + 1;
        } else if (actionList[i] == 'bake') {
            number = number * 3;
        } else if (actionList[i] == 'fillet') {
            number = number - number * 0.2;
        }
        console.log(number);
    }
}

action('32', 'chop', 'chop', 'chop', 'chop', 'chop');
action('9', 'dice', 'spice', 'chop', 'bake', 'fillet');