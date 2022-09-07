function upperCase(someText) {
    let text = String(someText);
    text = someText.toUpperCase().split(' ').join(', ');
    let current = text[0];
    for(let i = 1; i < text.length; i++) {
        current += text[i];
    }
    console.log(current);
}

upperCase('Hi, how are you?');
upperCase('hello');