function shopping(input) {

   let list = input.shift().split('!');

    for (let token of input) {
        let command = token.split(' ')[0];
        let item = token.split(' ')[1];

        if (command === 'Urgent' && !list.includes(item)) {
            list.unshift(item);
        } else if (command === 'Unnecessary' && list.includes(item)) {
            list.splice((list.indexOf(item)), 1);
        } else if (command === 'Correct' && list.includes(item)) {
            let newItem = token.split(' ')[2];
            list[list.indexOf(item)] = newItem;
        } else if (command === 'Rearrange' && list.includes(item)) {
            list.splice(list.indexOf(item), 1);
            list.push(item);
        } else if (token === 'Go Shopping!') {
            console.log(list.join(', '));
            break;
        }
    }
}

shopping(["Milk!Pepper!Salt!Grapes!Banana",
    "Urgent Salary",
    "Unnecessary Banana",
    "Correct Pepper Onion",
    "Urgent Banana",
    "Correct Tomatoes Potatoes",
    "Rearrange Onion",
    "Go Shopping!",
    "Urgent Watermelon"]
);
