const { expect } = require('chai');
const {isSymmetric} = require('./symmetry');

describe ('Symmetry checker', () => {
    it('works with a symmetric array of numbers', () => {
        expect(isSymmetric([1, 2, 3, 2, 1])).to.be.true;
    });

    it('returns false if the array of numbers is not symmetric', () => {
        expect(isSymmetric([1, 2, 3])).to.be.false;
    });

    it('returns false for non-array', () => {
        expect(isSymmetric(2, 3, 2)).to.be.false;
    });

    it('returns true for symmetric array of strings', () => {
        expect(isSymmetric(['2', '3', '3', '2'])).to.be.true;
    });

    it('returns false for string parameters', () => {
        expect(isSymmetric('2 3 3 2')).to.be.false;
    });

    it('returns false for different types of parameters', () => {
        expect(isSymmetric(['2', '3', '3', 2])).to.be.false;
    });
});