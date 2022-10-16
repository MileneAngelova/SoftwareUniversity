const {expect} = require('chai');
const {createCalculator} = require('./7.Add Subtract');

describe('Add, subtract, get', () => {
    let instance = null;
    beforeEach(() => {
        instance = createCalculator();
    });

    it('Starts empty', () => {
        expect(instance.get()).to.equal(0);
    });

    it('If all methods exists', () => {
        expect(instance).to.has.ownProperty('add');
        expect(instance).to.has.ownProperty('subtract');
        expect(instance).to.has.ownProperty('get');
    });

    it('Adds single number', () => {
        instance.add(1);
        expect(instance.get()).to.equal(1);
    });

    it("Adds multiple numbers", () => {
        instance.add(1);
        instance.add(2);
        expect(instance.get()).to.equal(3);
    });

    it('Subtracts single number', () => {
        instance.subtract(1);
        expect(instance.get()).to.equal(-1);
    });

    it("Subtracts multiple numbers", () => {
        instance.subtract(1);
        instance.subtract(2);
        expect(instance.get()).to.equal(-3);
    });

    it("Add and subtract numbers", () => {
        instance.add(1);
        instance.subtract(2);
        expect(instance.get()).to.equal(-1);
    });

    it('Works with numbers as string', () => {
        instance.add('1');
        instance.add('2');
        instance.subtract('4');
        expect(instance.get()).to.equal(-1);
    });
});