function shopping(items) {

    let list = items.shift().split('!');
    let command = items.shift();

    while (command !== 'Go Shopping!') {

        for (let token of items) {

            let instruction = token.split(' ')[0];

            let item = token.split(' ')[1];
            let itemIndex = list.indexOf(item);

            if (instruction === 'Urgent') {
                if (!list.includes(item)) {
                    list.unshift(item);
                }
            } else if (instruction === 'Unnecessary') {
                if (list.includes(item)) {
                    list.splice(itemIndex, 1);
                }
            } else if (instruction === 'Correct') {
                if (list.includes(item)) {
                    let newItem = token.split(' ')[2];
                    list[itemIndex] = newItem;
                }
            } else if (instruction === 'Rearrange') {
                if (list.includes(item)) {
                    list.splice(itemIndex, 1);
                    list.push(item);
                }
            }
        }
        command = items.shift();
    }
    console.log(list.join(', '));
}

shopping(["Milk!Pepper!Salt!Water!Banana",
    "Urgent Salt",
    "Unnecessary Water",
    "Correct Pepper Onion",
    "Rearrange Salt",
    "Urgent Watermelon",
    "Correct Milk Potatoes",
    "Go Shopping!"]
);