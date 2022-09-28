function addItem() {

    let input = document.getElementById('newItemText');
    let output = document.getElementById('items');

    let li = document.createElement('li');
    li.textContent = input.value;

    output.appendChild(li);
    let a = document.createElement('a');
    a.textContent = '[Delete]';
    a.href = '#';
    li.appendChild(a);
    input.value = '';
    a.addEventListener('click', deleteElement)

    function deleteElement(event) {
        // event.onclick = li.remove();  // works
        event.target.parentElement.remove();
    }
}