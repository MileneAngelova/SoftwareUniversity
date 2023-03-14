function piccolo(carsArray) {

    let parkIn = [];

    for (let info of carsArray) {
        let parkStatus = info.split(', ')[0];
        let carNumber = info.split(' ')[1];

        if (parkStatus === 'IN' && !parkIn.includes(carNumber)) {
            parkIn.push(carNumber);
        } else if (parkStatus === 'OUT' && parkIn.includes(carNumber)) {
                parkIn.splice(parkIn.indexOf(carNumber), 1);
        }
    }

    if (parkIn.length === 0) {
        console.log('Parking Lot is Empty');
    } else {
        console.log(parkIn.sort((a, b) => a.localeCompare(b)).join('\n'));
    }
}

piccolo(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']
);