function solve(arr) {
    let str = '';


    for (let parts of arr) {
        let command = parts.split(' ');
        if (command[0] === 'add') {
            str += command[1];
        } else if (command[0] === 'remove') {
            str -= command[1];
        } else {
            console.log(str);
        }

    }

    function add() {

    }

    function remove() {

    }

    function print() {

    }
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);