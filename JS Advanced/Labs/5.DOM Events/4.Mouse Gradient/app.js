function attachGradientEvents() {
    let result = document.getElementById('result');
    let gradient = document.getElementById('gradient');
    gradient.addEventListener('mousemove', count);

    function count(event) {
          result.textContent = Math.floor(event.offsetX / gradient.clientWidth * 100) + '%';
    }
}