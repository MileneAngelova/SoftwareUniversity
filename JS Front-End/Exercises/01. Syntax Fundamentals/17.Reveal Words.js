function revealWords(string, text) {
    let words = string.split(', ');

    for (let word of words) {
        let revealWord = '*'.repeat(word.length);
        text = text.replace(revealWord, word);
    }

    console.log(text);
}

revealWords('great',
    'softuni is ***** place for learning new programming languages'
);

revealWords('great, learning',
    'softuni is ***** place for ******** new programming languages'
);