function hashTag(text) {

    let words = text.split(' ');

    for (let word of words) {
        if (word.length > 1 && word.startsWith('#')) {
            console.log(word.substring(1, word.length));
        }
    }
}

hashTag('Nowadays everyone uses # to tag a #special word in #socialMedia');