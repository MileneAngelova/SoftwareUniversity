function extract(content) {
    let element = document.getElementById('content');
    let text = element.textContent
    let pattern = /(?<=\()[A-Za-z\s]+(?=\))/gm;
    let matcher = text.match(pattern);

    console.log(matcher.join('; '));

}

extract();