function cityRecord(city, population, treasury) {
    const info = {
        name: city,
        population: population,
        treasury: treasury
    }
    return info;
}

console.log(cityRecord('Tortuga',
7000,
15000
));
console.log(cityRecord('Santo Domingo',
12000,
23500
));

