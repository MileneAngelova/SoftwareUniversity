function validate() {
    let email = document.getElementById('email');
    email.addEventListener('change', validate);

    function validate(e) {
        e.target.classList.add('error');
        const pattern = /^[a-z]+@[a-z]+\.[a-z]+$/;

        if (!pattern.test(e.target.value)) {
            e.target.classList.add('error');
        } else {
            e.target.classList.remove('error');
        }
    }
}