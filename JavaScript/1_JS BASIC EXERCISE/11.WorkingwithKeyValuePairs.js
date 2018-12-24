function solve(args) {
    let size = args[args.length - 1];
    args.pop();

    let dict = new Map();

    for (let i = 0; i < args.length; i++) {
        let curentElement = args[i].split(' ');
        dict.set(curentElement[0], curentElement[1]);
    }

    if (dict.has(size)) {
        console.log(dict.get(size));
    } else {
        console.log("None");
    }

}

solve(['3 test', '3 test1', '4 test2', '4 test3', '4 test5', '4']);
// solve(['key value', 'key eulav','test test','key']);