function calories(array) {

    const object = {};

    for (let i = 0; i < array.length - 1; i++) {

        if (i % 2 == 0) {
            object[array[i]] = Number(array[i + 1]);
        }
    }

    console.log(object);
}

calories(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
calories(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);