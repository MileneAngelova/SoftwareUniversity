function toggle() {

   let extraText = document.getElementById('extra');
   let button = document.getElementsByClassName('button')[0];

   if (button.textContent === 'More') {
      extraText.style.display = 'block';
      button.textContent = 'Less';
   } else {
      extraText.style.display = 'none';
      button.textContent = 'More';
   }
}

toggle();