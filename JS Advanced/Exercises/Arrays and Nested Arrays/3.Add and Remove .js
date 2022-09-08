function addRemove(command) {
    let array = [];

    for(let i = 0; i < command.length; i++) {
        if (command[i] == 'add') {
            array.push(i + 1);
        } else if (command[i] == 'remove') {
                        array.pop();
        } 
    }
    if (array.length == 0) {
        console.log('Empty');
    }
    console.log(array.join('\n'));
}
addRemove(['add', 
'add', 
'add', 
'add']
);

addRemove(['add', 
'add', 
'remove', 
'add', 
'add']
);

addRemove(['remove', 
'remove', 
'remove']
);