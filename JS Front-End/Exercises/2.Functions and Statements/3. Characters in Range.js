function charInRange(char1, char2) {
    let start = char1.charCodeAt(0);
    let end = char2.charCodeAt(0);
    let symbols = [];

    if (start > end) {
        start = char2.charCodeAt(0);
        end = char1.charCodeAt(0);
    }

    for (let i = start + 1; i < end; i++) {
        symbols.push(String.fromCharCode(i));
    }
        console.log(symbols.join(' '));
}

charInRange('C',
    '#'
);