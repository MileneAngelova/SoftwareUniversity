function colorize() {
   const row = document.getElementsByTagName('tr');

   for (let i = 1; i < row.length; i += 2) {
      row[i].style.background = 'Teal';
   }
}