function movies(array) {

    let listMovies = [];

    for (let tokens of array) {

        let title = tokens.split('addMovie ')[1];

        if (title !== undefined) {
            listMovies.push({name: title});

        } else if (tokens.includes('directedBy')) {
            let name = tokens.split('directedBy ')[0].trim();
            let movieInfo = listMovies.find(m => m.name === name);

            if (movieInfo) {
                movieInfo.director = tokens.split('directedBy ')[1].trim();
            }

        } else if (tokens.includes('onDate')) {
            let name = tokens.split('onDate ')[0].trim();
            let movieInfo = listMovies.find(m => m.name === name);

            if (movieInfo) {
                movieInfo.date = tokens.split('onDate ')[1].trim();
            }
        }
    }
        for (let info of listMovies) {
            if (info.name && info.director && info.date) {
                console.log(JSON.stringify(info));
            }
        }
}

movies([
        'addMovie The Avengers',
        'addMovie Superman',
        'The Avengers directedBy Anthony Russo',
        'The Avengers onDate 30.07.2010',
        'Captain America onDate 30.07.2010',
        'Captain America directedBy Joe Russo'
    ]

);