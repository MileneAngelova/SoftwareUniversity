function dayOfWeek(someText) {
    let dayNumber;
    if (someText == 'Monday') {
        console.log(1)
    } else if (someText === 'Tuesday') {
        console.log(2)
    } else if (someText === 'Wednesday') {
        console.log(3)
    } else if (someText === 'Thursday') {
        console.log(4)
    } else if (someText === 'Friday') {
        console.log(5)
    } else if (someText === 'Saturday') {
        console.log(6)
    } else if (someText === 'Sunday') {
        console.log(7)
    } else {
        console.log('error')
    }
}

dayOfWeek('Monday');
dayOfWeek('Saturday');




