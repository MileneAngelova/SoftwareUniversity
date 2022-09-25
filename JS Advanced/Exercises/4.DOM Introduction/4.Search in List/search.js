function search() {
    // let townList = document.querySelectorAll('li');  // it works as the same way
    let townList = document.getElementsByTagName('li');
    let search = document.getElementById('searchText').value;
    let result = document.getElementById('result');
    let counter = 0;

    for (let town of townList) {
        let text = town.textContent;

        if (!text.match(search) || search === '') {
            town.style.fontWeight = 'normal';
            town.style.textDecoration = 'none';

        } else {
            counter++;
            town.style.fontWeight = 'bold';
            town.style.textDecoration = 'underline';
        }
        result.textContent = `${counter} matches found`;
    }
}
