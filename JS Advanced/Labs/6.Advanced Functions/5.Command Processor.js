function solution() {
    let state = '';

    function append(str) {
        state += str;
    }

    function removeStart(n) {
        state = state.slice(n);
    }

    function removeEnd(n) {
        state = state.slice(0, -n);
    }

    function print() {
        console.log(state);
    }

    // append('hello');
    // append('again');
    // removeStart(3);
    // removeEnd(4);
    // print();
    return {
        append,
        removeStart,
        removeEnd,
        print
    };
}

// solve();

// let obj = solution();
let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();



// obj.append('hello');
// obj.append('again');
// obj.removeStart(3);
// obj.removeEnd(4);
// obj.print();

// obj.append('123');
// obj.append('45');
// obj.removeStart(2);
// obj.removeEnd(1);
// obj.print();