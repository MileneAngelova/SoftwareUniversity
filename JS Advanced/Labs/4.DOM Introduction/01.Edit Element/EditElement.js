function editElement(input, matcher, replacer) {
    input.textContent = input.textContent.split(matcher).join(replacer);
}