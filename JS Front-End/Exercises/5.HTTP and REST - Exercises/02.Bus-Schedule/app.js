function solve() {

    let display = document.getElementsByClassName('info')[0];
    let departBtn = document.getElementById('depart');
    let arriveBtn = document.getElementById('arrive');
    let stationName = 'Depot';
    let nextStationId = 'depot';

    function depart() {
        let INFO = `http://localhost:3030/jsonstore/bus/schedule/${nextStationId}`;
        fetch(INFO).then(info => info.json())
            .then(info => {
                    stationName = info.name;
                    display.textContent = `Next Stop ${stationName}`;
                    nextStationId = info.next;

                    departBtn.disabled = true;
                    arriveBtn.disabled = false;
            });
    }
    async function arrive() {
        display.textContent = `Arriving at ${stationName}`;
        departBtn.disabled = false;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();