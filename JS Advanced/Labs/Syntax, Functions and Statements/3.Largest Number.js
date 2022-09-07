// function largestNumber(x, y, z) {
//     let result;
//     if (x > y && x > z) {
//         result = x;
//     } 
//     else if (y > x && y > z) {
//         result = y;
//     }
//     else if (z > x && z > y) {
//         result = z;
//      }
//     console.log(`The largest number is ${result}.`);
// }
function maxNumber(...params) {
    console.log(`The largest number is ${Math.max(...params)}.`);
}
maxNumber(5, -3, 16);
maxNumber(-3, -5, -22.5);