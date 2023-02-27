function listOfNames(array) {
    // return [...array]
    //     .sort((a, b) => a.localeCompare(b))
    //     .map((name, index) => `${index + 1}.${name}`)
    //     .join('\n');

    let newArray = [];
    for (const name of array) {
       newArray.push(name);
    }

   return newArray.sort((a, b) => a.localeCompare(b))
        .map((name, index) => `${index +1}.${name}`)
       .join('\n');
}

console.log(listOfNames(["John", "Bob", "Christina", "Ema"]));