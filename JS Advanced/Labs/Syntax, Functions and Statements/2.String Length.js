function sumLength(str1, str2, str3) {
  let sum = str1.length + str2.length + str3.length;
  console.log(sum);
  console.log(Math.floor(sum / 3));
}

sumLength('chocolate', 'ice cream', 'cake');
sumLength('pasta', '5', '22.3');
