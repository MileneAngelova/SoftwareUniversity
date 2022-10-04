function solve() {

    let [input, output] = Array.from(document.querySelectorAll('textarea'));
    let tbody = document.querySelector('tbody');
    let [genButton, buyButton] = Array.from(document.querySelectorAll('button'));
    const items = [];

    genButton.addEventListener('click', generate);
    buyButton.addEventListener('click', buy);

    function generate() {
        let data = JSON.parse(input.value);

        for (let item of data) {
            let row = document.createElement('tr');

            let col1 = createColumn('img', item.img);        //  Img col
            row.appendChild(col1);

            let col2 = createColumn('p', item.name);         //  Name col
            row.appendChild(col2);

            let col3 = createColumn('p', item.price);        //  Price col
            row.appendChild(col3);

            let col4 = createColumn('p', item.decFactor);    //  Decoration col
            row.appendChild(col4);

            let col5 = document.createElement('td');      // Input column
            let checkBox = document.createElement('input');
            checkBox.type = 'checkbox';
            col5.appendChild(checkBox);
            row.appendChild(col5);

            tbody.appendChild(row);
            items.push({
                ...item,
                isChecked
            });

            function isChecked() {
                return checkBox.checked;
            }
        }
    }

    function buy() {
        let list = [];
        let total = 0;
        let decoration = 0;

        const bought = items.filter(i => i.isChecked());

        for (let item of bought) {
            list.push(item.name);
            total += Number(item.price);
            decoration += Number(item.decFactor);
        }

        decoration /= bought.length;
        output.value = [
            `Bought furniture: ${list.join(', ')}`,
            `Total price: ${total.toFixed(2)}`,
            `Average decoration factor: ${decoration}`
        ].join('\n');

    }

    function createColumn(type, content) {
        let result = document.createElement('td');
        let inner;
        if (type === 'img') {
            inner = document.createElement('img');
            inner.src = content;

        } else {
            inner = document.createElement('p');
            inner.textContent = content;
        }
        result.appendChild(inner);
        return result;
    }
}