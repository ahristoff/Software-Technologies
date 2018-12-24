function solve(args) {

    let obj = {};
    for (let input of args) {
        let info = input.split(' -> ');
        if(info[0] !== 'age' && info[0] !== 'grade') {
            obj[info[0]] = info[1];
        }else{
            obj[info[0]] = Number(info[1]);
        }
    }

    let result = JSON.stringify(obj);
    console.log(result);

}

solve([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'
]);