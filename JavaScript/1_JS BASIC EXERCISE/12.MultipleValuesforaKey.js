function solve(args) {
    let size = args[args.length-1];
    args.pop();


    let obj ={};
    for (let i = 0; i < args.length; i++) {
        let curentElement = args[i].split(' ');
        obj[i] = {
            key : curentElement[0],
            value : curentElement[1]
        };


    }
    let count = 0;
    for (let i = 0 ; i < args.length ; i++){

        if(obj[i].key == size){
            console.log(obj[i].value);
        }else{
            count++;
        };

    }
    if(count===args.length){
        console.log('None');
    }
}
// solve(['3 test', '3 test1','4 test2','4 test3', '4 test5', '5']);
solve(['key value', 'key eulav','test tset', 'key']);