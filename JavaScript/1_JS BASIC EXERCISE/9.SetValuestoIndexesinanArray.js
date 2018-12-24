function setValue(args) {
    let size = Number(args.shift());
    // let size = Number(args[0]);
    // args.shift();
    console.log(args)
    let arr = [];
    for (let i = 0; i < size; i++) {
        arr[i] = 0;
    }

    for(let i = 0 ; i < args.length; i++){

        let element = args[i].split(' - ');

        arr[Number(element[0])] = Number(element[1]);
    }

    console.log(arr.join('\n'));
}
setValue([
    '3',
    '0 - 5',
    '1 - 6',
    '0 - 7'
]);