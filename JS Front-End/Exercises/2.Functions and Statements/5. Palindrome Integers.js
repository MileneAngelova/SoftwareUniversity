function palindrome(array) {

    let reversed = 0;

    for (let number of array) {
        let reversed = parseFloat(
            number.toString().split('')
                .reverse().join(''));
        if (number === reversed) {
            console.log('true');
        } else {
            console.log(false);
        }
    }
}

    palindrome([123, 323, 421, 121]);

palindrome([32,2,232,1010]);