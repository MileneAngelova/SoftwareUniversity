function listEmployee(array) {
    let list = {};

    for (let name of array) {
        let employeeNumber = name.length;
        list[name] = employeeNumber;
    }

    for (let employee in list) {
        console.log(`Name: ${employee} -- Personal Number: ${list[employee]}`);
    }
}

listEmployee([
        'Samuel Jackson',
        'Will Smith',
        'Bruce Willis',
        'Tom Holland'
    ]
);

