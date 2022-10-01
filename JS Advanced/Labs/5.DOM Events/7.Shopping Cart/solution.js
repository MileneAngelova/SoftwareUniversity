function solve() {
    document.getElementsByClassName('shopping-cart')[0].addEventListener('click', onClick);
    let cart = document.getElementsByTagName('textarea')[0];

    let products = [];
    let totalPrice = 0;
    let areAdded = false;
    let isCheckout = false;


    function onClick(event) {

        if (areAdded) {
            return;
        }

        if (event.target.tagName === 'BUTTON' && event.target.classList.contains('add-product')) {
            let article = event.target.parentElement.parentElement;
            let name = article.querySelector('.product-title').textContent;
            let price = Number(article.querySelector('.product-line-price').textContent);

            products.push(name);
            // products.push(price);
            cart.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
            totalPrice += price;
        }

        let articles = new Set();
        products.forEach(p => articles.add(p))
        document.getElementsByClassName('checkout')[0].addEventListener('click', finish);
    }

    function finish() {
        if (isCheckout) {
            return;
        }
        let articles = new Set();
        products.forEach(p => articles.add(p));
        document.getElementsByClassName('checkout')[0].addEventListener('click', finish);

        cart.value += `You bought ${new Array(...articles).join(', ')} for ${totalPrice.toFixed(2)}.`;
        areAdded = true;
        isCheckout = true;
    }
}