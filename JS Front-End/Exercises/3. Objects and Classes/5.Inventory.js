function heroes(heroArray) {

    let listHeroes = [];

    for (let info of heroArray) {
        let heroInfo = {};

        heroInfo.name = info.split(' / ')[0];
        heroInfo.level = Number(info.split(' / ')[1]);
        heroInfo.items = info.split(' / ')[2];

        listHeroes.push(heroInfo);
        listHeroes.sort((a, b) => a.level - b.level);
    }

    for (let hero of listHeroes) {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items}`);
    }
}

heroes([
        'Batman / 2 / Banana, Gun',
        'Superman / 18 / Sword',
        'Poppy / 28 / Sentinel, Antara'
    ]

);