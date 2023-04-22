function attachGradientEvents() {
    let div = document.getElementById('result');
    let gradient = document.getElementById('gradient');
    gradient.addEventListener('mousemove', calc);
    gradient.addEventListener('mouseleave', () => div.textContent = '');

    function calc(event) {
        let position = Math.floor((event.offsetX / (event.target.clientWidth - 1)) * 100);
        div.textContent = `${position}%`;
    }
}