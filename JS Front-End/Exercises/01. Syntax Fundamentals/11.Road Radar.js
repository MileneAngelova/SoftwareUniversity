function roadRadar(speed, area) {
    let limit = 0;
    let status = '';

    if (area === 'motorway') {
        limit = 130;
    } else if (area === 'interstate') {
        limit = 90;
    } else if (area === 'city') {
        limit = 50;
    } else if (area === 'residential') {
        limit = 20;
    }

   let difference = speed - limit;

     if (speed > limit && speed <= (limit + 20)) {
            status = 'speeding';

        } else if (speed > limit && speed <= (limit + 40)) {
            status = 'excessive speeding';

        } else if (speed > (limit + 40)) {
            status = 'reckless driving';
        }

        if (speed <= limit) {
            console.log(`Driving ${speed} km/h in a ${limit} zone`);
        } else {
            console.log(`The speed is ${difference} km/h faster than the allowed speed of ${limit} - ${status}`);
        }
}

roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway');
