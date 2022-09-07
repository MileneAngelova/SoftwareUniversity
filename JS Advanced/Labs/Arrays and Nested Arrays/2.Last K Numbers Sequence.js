function sum (n1, n2) {
    const array = [1];
    let arrayLength = n1;
    let nextElement = 0;

    while (n1 > 0) {
        let sum;
   
        for (let i = 1; i < arrayLength; i++) {
            if(i <= 0) {
                nextElement = i;
                sum = i;
             } else { 
                sum = i + (i - 1) + (i - 2);
             }
        array.push(nextElement);
        n1--;
    }
}
    console.log(array);
}

sum(6, 3);