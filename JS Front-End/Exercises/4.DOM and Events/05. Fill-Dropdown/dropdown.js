function addItem() {

    let newText = document.getElementById('newItemText').value;
    let newValue = document.getElementById('newItemValue').value;
    let option = document.createElement('option');
    option.textContent = newText;
    option.value = newValue;

    let menu = document.getElementById('menu');
    menu.appendChild(option);

   document.getElementById('newItemText').value = '';
   document.getElementById('newItemValue').value = '';

}