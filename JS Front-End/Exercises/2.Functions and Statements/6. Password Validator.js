function validator(password) {
    let matcher = '\\w+\\d{2,}';

    if (password.length < 6 || password.length > 10) {
        console.log('Password must be between 6 and 10 characters');
    }

    if (password.match(matcher)) {
        console.log('Password is valid');
    }

    if (password.match('\\W') || password.includes('_')) {
            console.log('Password must consist only of letters and digits');
        }

        if (!containsDigits()) {
            console.log('Password must have at least 2 digits');
        }

    function containsDigits() {
        return /\d{2,}/.test(password);
    }
    containsDigits();
}

validator(' ');
// validator('MyPass123');
// validator('Pa1_$ss');/**/