function daysInMonth(month, year) {
    console.log(new Date(year, month, 0).getDate());
}

daysInMonth(6, 2022);
daysInMonth(2, 2021);
daysInMonth(8, 2020);

