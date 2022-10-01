function focused() {
    let sections = document.getElementsByTagName('input');

    for (let section of sections) {
        section.addEventListener('focus', colorize);
        section.addEventListener('blur', noColor);
    }

    function colorize(event) {
        event.target.parentElement.classList.add('focused');
    }

    function noColor(event) {
        event.target.parentElement.classList.remove('focused');
    }
}