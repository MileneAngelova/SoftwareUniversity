function assembles(input) {
    const small = {
        power: 90,
        volume: 1800
    }
    const normal = {
        power: 120,
        volume: 2400
    }
    const monster = {
        power: 200,
        volume: 3500
    }

    const car = {};

    car.model = input.model;

    if (input.power <= 90) {
        car.engine = small;
    } else if (input.power > 90 && input.power <= 120) {
        car.engine = normal;
    } else if (input.power > 120  && input.power <= 200) {
        car.engine = monster;
    }

    car.carriage = { type: input.carriage, color: input.color };

    if (input.wheelsize % 2 == 0) {
        car.wheels = [input.wheelsize - 1, input.wheelsize - 1, input.wheelsize - 1, input.wheelsize - 1];
    } else {
        car.wheels = [input.wheelsize, input.wheelsize, input.wheelsize, input.wheelsize];
    }

    return car;
}


console.log(assembles({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}
));

console.log(assembles({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
}
));