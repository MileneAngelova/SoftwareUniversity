function solve() {
    let addBtn = Array.from(document.getElementsByClassName('add-product'));
    addBtn.forEach(button => button.addEventListener('click', addProduct));
    let textArea = document.getElementsByTagName('textarea')[0];

    let checkoutBtn = document.getElementsByClassName('checkout')[0];
    checkoutBtn.addEventListener('click', checkout);

    let products = [];
    let totalPrice = 0;

    function addProduct(e) {
        if (e) {
            e.preventDefault();
        }

        let parentEl = e.currentTarget.parentNode.parentNode;
        let productName = parentEl.children[1].children[0].textContent;
        let productPrice = parentEl.children[3].textContent;

        textArea.textContent += `Added ${productName} for ${productPrice} to the cart.\n`;

        if (!products.includes(productName)) {
            products.push(productName);
        }

        totalPrice += Number(productPrice);
    }

    function checkout(e) {
        if (e) {
            e.preventDefault();
        }
        textArea.textContent += `You bought ${products.join(', ')} for ${totalPrice.toFixed(2)}."`;
        addBtn.forEach(b => b.disabled = true);
        checkoutBtn.disabled = true;
    }
}