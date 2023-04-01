function getInfo() {

    let busStation = document.getElementById('stopId');
    let INFO = `http://localhost:3030/jsonstore/bus/businfo/${busStation.value}`;
    let stationName = document.getElementById('stopName');
    let busList = document.getElementById('buses');

    fetch(INFO)
        .then(info => info.json())
        .then(info => {
            busStation.value = '';
            stationName.textContent = '';
            busList.textContent = '';
            stationName.textContent = info.name;

            for (let bus in info.buses) {
                let li = document.createElement('li');
                li.textContent = `Bus ${bus} arrives in ${info.buses[bus]} minutes`;
                busList.appendChild(li);
            }
        })

        .catch(() => stationName.textContent = `Error`);
}