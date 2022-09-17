function population(input) {

    const info = {};

    for (const town of input) {
        const tokens = town.split('<->');
        const townName = tokens[0];
        let population = Number(tokens[1]);

        if (info[townName] != undefined) {
            population += info[townName];
        }

        info[townName] = population;
    }

    for (const town in info) {
        console.log(`${town}: ${info[town]}`);

    }
}

population(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
);
population(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
);
