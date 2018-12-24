function solve(args) {

    for(let i=0;i < args.length;i++){
        let result = args[i].split(' -> ')
       let obj={
            name : result[0],
            age : result[1],
            Grade : result[2]
        };

        console.log(`Name: ${obj.name}`)
        console.log(`Age: ${obj.age}`)
        console.log(`Grade: ${obj.Grade}`)
    }

}
solve(['Pesho -> 13 -> 6.00', 'Ivan -> 12 -> 5.57','Toni -> 13 -> 4.90']);