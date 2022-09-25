function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let table = document.querySelectorAll('tbody tr');
        let inputText = document.getElementById('searchField');

        for (let row of table) {
            row.classList.remove('select');
            if (row.innerHTML.includes(inputText.value) && inputText.value !== '') {
                row.className = 'select';
            }
                    }
        inputText.value = '';
    }
}