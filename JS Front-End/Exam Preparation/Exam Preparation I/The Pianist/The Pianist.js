function pianist(array) {
    // First way

    let command = Number(array.shift());
    let output = [];

    for (let info of array) {
        let pieces = {};
        while (command > 0) {
            pieces.name = (info.split('|')[0]);      //  pieces.name = info.split('|').shift()
            pieces.composer = (info.split('|')[1]);  //  pieces.composer = info.split('|').shift();
            pieces.key = (info.split('|')[2]);       //  pieces.key = info.split('|').shift();

            output.push(pieces);
            command--;
            break;
        }
        let token = info.split('|')[0];
        let name = info.split('|')[1];
        let composer = info.split('|')[2];
        let key = info.split('|')[3];

        if (token === 'Add') {
            if (!output.includes(output.find(p => p.name === name))) {
                pieces.name = name;
                pieces.composer = composer;
                pieces.key = key;
                output.push(pieces);

                console.log(`${name} by ${composer} in ${key} added to the collection!`);
            } else {
                console.log(`${name} is already in the collection!`);
            }
        } else if (token === 'Remove') {

            if (output.includes(output.find(p => p.name === name))) {
                output.splice(output.findIndex(p => {
                    return p.name === name;
                }), 1);
                console.log(`Successfully removed ${name}!`);
            } else {
                console.log(`Invalid operation! ${name} does not exist in the collection."`);
            }
        } else if (token === 'ChangeKey') {
            key = info.split('|')[2];
            for (let piece of output) {
                if (piece.name === name) {
                    piece.key = key;
                    console.log(`Changed the key of ${name} to ${key}!`);
                }
            }
            if (!output.includes(output.find(p => p.name === name))) {
                console.log(`Invalid operation! ${name} does not exist in the collection.`);
            }
        }
    }
    for (let piece of output) {

        console.log(`${piece.name} -> Composer: ${piece.composer}, Key: ${piece.key}`);
    }



 // Second way

    // let rows = Number(input.shift());
    //
    // let piecesMap = {};
    //
    // // Add to map
    // for (let index = 0; index < rows; index++) {
    //     let [ piece, composer, key ] = input.shift().split('|');
    //
    //     piecesMap[piece] = { composer, key };
    // }
    //
    // // Parse commands
    // input.forEach(line => {
    //     let tokens = line.split('|');
    //     let command = tokens.shift();
    //
    //     if (command === 'Add') {
    //         let [ piece, composer, key ] = tokens;
    //
    //         if (!piecesMap.hasOwnProperty(piece)) {
    //             piecesMap[piece] = { composer, key };
    //             console.log(`${piece} by ${composer} in ${key} added to the collection!`);
    //         } else {
    //             console.log(`${piece} is already in the collection!`);
    //         }
    //     } else if (command === 'Remove') {
    //         let piece = tokens.shift();
    //
    //         if (!piecesMap.hasOwnProperty(piece)) {
    //             console.log(`Invalid operation! ${piece} does not exist in the collection.`);
    //         } else {
    //             delete piecesMap[piece];
    //             console.log(`Successfully removed ${piece}!`);
    //         }
    //     } else if (command === 'ChangeKey') {
    //         let [ piece, newKey ] = tokens;
    //
    //         if (!piecesMap.hasOwnProperty(piece)) {
    //             console.log(`Invalid operation! ${piece} does not exist in the collection.`);
    //         } else {
    //             piecesMap[piece].key = newKey;
    //             console.log(`Changed the key of ${piece} to ${newKey}!`);
    //         }
    //     }
    // });
    //
    // let entries = Object.entries(piecesMap);
    //
    // for (const [ piece, info ] of entries) {
    //     console.log(`${piece} -> Composer: ${info.composer}, Key: ${info.key}`);
    // }


}


pianist([
        '4',
        'Eine kleine Nachtmusik|Mozart|G Major',
        'La Campanella|Liszt|G# Minor',
        'The Marriage of Figaro|Mozart|G Major',
        'Hungarian Dance No.5|Brahms|G Minor',
        'Add|Spring|Vivaldi|E Major',
        'Remove|The Marriage of Figaro',
        'Remove|Turkish March',
        'ChangeKey|Spring|C Major',
        'Add|Nocturne|Chopin|C# Minor',
        'Stop'
    ]

);