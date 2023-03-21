function lockedProfile() {
    let button = Array.from(document.querySelectorAll('.profile button'));

    for (let info of button) {
        info.addEventListener('click', showInfo);
    }

    function showInfo(e) {
        let user = e.target.parentElement;
        let locked = user.querySelector('input[value="unlock"]').checked;

        if (locked) {
            let hidden = Array.from(user.querySelectorAll('div')).find(div => div.id.includes('HiddenFields'));
            if (e.target.textContent === 'Show more') {
                hidden.style.display = 'block';
                e.target.textContent = 'Hide it';
            } else {
                hidden.style.display = 'none';
                e.target.textContent = 'Show more';
            }
        }
    }
}