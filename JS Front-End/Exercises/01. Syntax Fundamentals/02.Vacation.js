function solve(countPeople, group, weekDay) {

    let totalPrice = 0;

    if (group === 'Students' && weekDay === 'Friday') {
        totalPrice = countPeople * 8.45;

    } else if (group === 'Students' && weekDay === 'Saturday') {
        totalPrice = countPeople * 9.80;

    } else if (group === 'Students' && weekDay === 'Sunday') {
        totalPrice = countPeople * 10.46;
    }
    if (group === 'Students' && countPeople >= 30) {
        totalPrice -= totalPrice * 0.15
    }

    if (group === 'Business' && countPeople >= 100) {
        countPeople -= 10;
    }

    if (group === 'Business' && weekDay === 'Friday') {
        totalPrice = countPeople * 10.90;

     } else if (group === 'Business' && weekDay === 'Saturday') {
        totalPrice = countPeople * 15.60;

    } else if (group === 'Business' && weekDay === 'Sunday') {
        totalPrice = countPeople * 16;
    }

    if (group === 'Regular' && weekDay === 'Friday') {
        totalPrice = countPeople * 15;

    } else if (group === 'Regular' && weekDay === 'Saturday') {
        totalPrice = countPeople * 20;

    } else if (group === 'Regular' && weekDay === 'Sunday') {
        totalPrice = countPeople * 22.50;
    }
    if (group === 'Regular' && countPeople >= 10 && countPeople <= 20) {
        totalPrice -= totalPrice * 0.05
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}

    solve(30,
        "Students",
        "Sunday"
    );

solve(40,
    "Regular",
    "Saturday"
);