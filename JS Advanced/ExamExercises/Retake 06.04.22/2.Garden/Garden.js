class Garden {

    constructor(spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
        this.plants = [];
        this.storage = [];
    }

    addPlant(plantName, spaceRequired) {

        if (this.spaceAvailable < spaceRequired) {
            throw new Error('Not enough space in the garden.')
        }
        let plant = {
            plantName,
            spaceRequired,
            ripe: false,
            quantity: 0
        }
        this.plants.push(plant);
        this.spaceAvailable -= spaceRequired;

        return `The ${plant.plantName} has been successfully planted in the garden.`

    }

    ripenPlant(plantName, quantity) {

        let ripePlant = this.plants.find(p => p.plantName === plantName);
        if (ripePlant === undefined) {
            throw new Error(`There is no ${plantName} in the garden.`);
        }
        if (ripePlant.ripe) {
            throw new Error(`The ${plantName} is already ripe.`);
        }
        if (quantity <= 0) {
            throw new Error('The quantity cannot be zero or negative.');
        }

        ripePlant.ripe = true;
        ripePlant.quantity += quantity;

        if (quantity === 1) {
            return `${quantity} ${plantName} has successfully ripened.`;
        } else {
            return `${quantity} ${plantName}s have successfully ripened.`;
        }

    }

    harvestPlant(plantName) {

        let plantIndex = this.plants.findIndex(p => p.plantName === plantName);

        if (plantIndex === -1) {
            throw new Error(`There is no ${plantName} in the garden.`);
        }
        let plant = this.plants[plantIndex];

        if (plant.ripe === false) {
            throw new Error(`The ${plantName} cannot be harvested before it is ripe.`);
        }

        this.plants.splice(plantIndex, 1);
        this.storage.push({
            plantName,
            quantity: plant.quantity
        });
        this.spaceAvailable += plant.spaceRequired;

        return `The ${plantName} has been successfully harvested`;
    }

    generateReport() {
        let plantAsString = this.plants.map(p => p.plantName).sort((a, b) => a.localeCompare(b));
        let plantsRow = `Plants in the garden: ${plantAsString.join(', ')}`;

        let storageRow = 'Plants in storage: The storage is empty.';

        if (this.storage.length > 0) {
            let storageAsString = this.storage.map(p => `${p.plantName} (${p.quantity})`);
            storageRow = `Plants in storage: ${storageAsString.join(', ')}`;
        }

        return [
            `The garden has ${this.spaceAvailable} free space left.`,
            plantsRow,
            storageRow,
        ].join('\n');
    }
}

const myGarden = new Garden(250);
// console.log(myGarden.addPlant("apple", 20));
// console.log(myGarden.addPlant("orange", 200));
// console.log(myGarden.addPlant("raspberry", 10));
// console.log(myGarden.ripenPlant("apple", 10));
// console.log(myGarden.ripenPlant("orange", 1));
// console.log(myGarden.harvestPlant("apple"));
console.log(myGarden.harvestPlant("raspberry"));
console.log(myGarden.harvestPlant("olive"));








