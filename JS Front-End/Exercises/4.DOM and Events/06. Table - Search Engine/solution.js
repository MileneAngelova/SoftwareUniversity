function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let search = document.getElementById('searchField');
        let table = document.querySelectorAll('tbody tr');

        for (let row of table) {
            row.classList.remove('select');
            if (row.innerHTML.includes(search.value) && search.value !== '') {
                row.className = 'select';
            }
        }
        search.value = '';
    }
}