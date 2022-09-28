function deleteByEmail() {
    // let input = document.querySelector('input[name="email"]');
    let input = Array.from(document.getElementsByName('email'))[0];
    let table = Array.from(document.querySelectorAll('tbody tr'));
    let result = document.getElementById('result');

    for (let row of table) {
        if (row.children[1].textContent === input.value) {
            row.remove();
            // row.parentElement.removeChild(row); // works correctly
            result.textContent = 'Deleted.';
            return;
        } else {
            result.textContent = 'Not found.';
        }
    }
}