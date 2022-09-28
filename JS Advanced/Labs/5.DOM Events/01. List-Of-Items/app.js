function addItem() {
    let input = document.getElementById('newItemText');
    let output = document.getElementById('items');

    let li = document.createElement('li');
    li.textContent = input.value;

    output.appendChild(li);
    input.value = '';
}