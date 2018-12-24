function solve(args) {
    let num = args.map(Number)
    if (num[0]<=num[1]){
        console.log(num[0]*num[1])
    }else{
        console.log(num[0]/num[1])
    }

}
solve(['4','3'])