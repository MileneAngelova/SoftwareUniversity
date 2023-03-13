function oddOccurrences(input) {

    let string = input.split(' ');
    let output = {};

    for (let part of string) {
        part = part.toLowerCase();
        if (!output.hasOwnProperty(part)) {
            output[part] = 1;
        } else {
            output[part]++;
        }
    }

    let outputLine = '';
    for (let key in output) {
        if (output[key] % 2 !== 0) {
            outputLine += key + ' ';
        }
    }
    console.log(outputLine);
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');

