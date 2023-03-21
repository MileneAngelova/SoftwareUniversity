function create(words) {

    let parent = document.getElementById('content');

    for (let word of words) {
        let div = document.createElement('div');
        let p = document.createElement('p');

        p.textContent = word;
        p.style.display = 'none';
        div.appendChild(p);
        parent.appendChild(div);

        div.addEventListener('click', display);
        function display() {
            p.style.display = '';
        }
    }
}