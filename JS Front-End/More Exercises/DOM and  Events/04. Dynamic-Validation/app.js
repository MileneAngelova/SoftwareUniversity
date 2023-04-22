function validate() {
    let input = document.getElementById('email');
    input.addEventListener("change", validate);

    function validate() {
        let email = input.value;
        let pattern = /[a-z]+[0-9]*@[a-z]+\.[a-z]+/gm;
        email.match(pattern);
        if (email.match(pattern)) {
            input.classList.remove('error');
        } else {
            input.classList = 'error';
            input.value = '';
        }
    }
}