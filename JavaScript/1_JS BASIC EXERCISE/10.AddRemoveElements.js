function solve(args) {

    let arr = [];
    for(let i = 0 ; i<args.length ; i++){

        let element = args[i].split(' ');
        if(element[0] === 'add'){
         arr.push(element[1]);
        }
        if(element[0] === 'remove'){
            arr.splice(Number(element[1]),1);
            // arr.pop()
        }

    }
    for(let j=0 ; j<arr.length; j++){
        console.log(arr[j])
    }
    // console.log(element.join(' ',arr));
}
solve(['add 3', 'add 5','remove 1','add 2']);