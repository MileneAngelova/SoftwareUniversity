function editElement(text, matcher, replacer) {
    let newText = text.textContent;
    text.textContent = newText.split(matcher).join(replacer);
}