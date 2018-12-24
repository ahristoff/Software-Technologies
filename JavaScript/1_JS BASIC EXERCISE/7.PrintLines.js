// function solve(args) {
//
//    while (args==='stop'){
//
//
//        console.log
//    }
//
// }
function solve(args) {

    for(let i =0; i<args.length;i++){
        if(args[i]!=='Stop'){
            console.log(args[i]);
        }else{
            return
        }
    }

}

solve([3,
    6,
    5,
    4,
    'Stop',
    10,
    12,
])