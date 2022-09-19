function extractText() {
    const rows = Array.from(document.querySelectorAll('li'));
    const text = rows.map(e => e.textContent).join('\n');

    document.getElementById('result').value = text;
}