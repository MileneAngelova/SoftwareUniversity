function substring (input, expretion) {
    let text = expretion.toLowerCase().split(' ');

    for (let word of text) {
        if (word === input) {
            console.log(word);
            break;
        }
    }
    if (!text.includes(input)) {
        console.log(`${input} not found!`);
    }
}

substring('javascript',
    'JavaScript is the best programming language');

substring('python',
    'JavaScript is the best programming language');