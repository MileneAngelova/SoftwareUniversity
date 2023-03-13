function countOccurrences(array) {

    let neededWords = array.shift().split(' ');
    let resultArray = [];

    for (let word of neededWords) {
        let result = (array.filter(w => w === word));
        resultArray.push(`${word} - ${Number(result.length)}`);
    }

    resultArray.sort((a, b) => {
            let [a1, a2] = a.split(' - ');
            let [b1, b2] = b.split(' - ');
            return b2 - a2;
        }
    );

    for (let element of resultArray) {
        console.log(element);
    }
}

countOccurrences([
    'is the',
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
);