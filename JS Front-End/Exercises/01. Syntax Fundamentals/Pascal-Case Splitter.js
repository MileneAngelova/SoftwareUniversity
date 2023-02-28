function pascalCase(string) {

    // let expression = string.replace(/([A-Z][a-z])/g,' ,$1');
   string = string.matchAll('[A-Z][a-z]*');
    let expression = [];

    for (let word of string) {
        expression.push(word);
    }
    console.log(expression.join(', '));
}

pascalCase('SplitMeIfYouCanHaHaYouCantOrYouCan');
pascalCase('HoldTheDoor');
pascalCase('ThisIsSoAnnoyingToDo');