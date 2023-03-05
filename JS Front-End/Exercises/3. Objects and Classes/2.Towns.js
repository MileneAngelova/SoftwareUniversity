function towns(list) {

    let townList = {};

    for (let token of list) {
        let town = token.split(' | ')[0];
        let latitude = Number(token.split(' | ')[1]).toFixed(2);
        let longitude = Number(token.split(' | ')[2]).toFixed(2);

        townList['town'] = town;
        townList['latitude'] = latitude;
        townList['longitude'] = longitude;
    console.log(townList);
    }
}

towns(['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']
);