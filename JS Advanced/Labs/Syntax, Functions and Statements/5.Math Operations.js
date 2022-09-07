function operation(x, y, symbol) {
    let result;

    if (symbol == '+') {
        result = x + y;
    }
    else if (symbol == '-') {
        result = x - y;
    }
    else if (symbol == '*') {
        result = x * y;
    }
    else if (symbol == '/') {
        result = x / y;
    }
    else if (symbol == '%') {
        result = x % y;
    }
    else if (symbol == '**') {
        result = x ** y;
    }
    console.log(result);
}

operation(5, 6, '+');
operation(3, 5.5, '*');