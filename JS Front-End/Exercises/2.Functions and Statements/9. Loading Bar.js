function loadingBar(number) {
    let percent = number / 10;
    let symbol = '%'.repeat(percent);
    let loadingSymbol = '.'.repeat(10 - percent);

    if (number < 100) {
    console.log(`${number}% [${symbol}${loadingSymbol}]`);
    console.log('Still loading...');
    } else {
        console.log('100% Complete!');
        console.log('[%%%%%%%%%%]');
    }
}
loadingBar(90);