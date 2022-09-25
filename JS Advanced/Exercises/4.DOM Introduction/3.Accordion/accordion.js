function toggle() {
    const text = document.getElementById('extra');
    const button = document.getElementsByClassName('button')[0];
    // const button = document.getElementsByTagName('span')[0]; // също работи

    if (button.textContent == 'More') {
        button.textContent = 'Less';
        text.style.display = 'block';
    } else {
        button.textContent = 'More';
        text.style.display = 'none';
    }
}

// function toggle() {
//
//     let button = document.querySelector(".button");
//     let text = document.querySelector("#extra");
//
//     text.style.display = text.style.display == "block" ? "none" : "block";
//     button.textContent = button.textContent == "More" ? "Less" : "More";
// }