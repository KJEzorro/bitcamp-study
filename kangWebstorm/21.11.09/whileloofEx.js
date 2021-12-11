

// whileloof - uncounted loof
// hello523이 나오면 무한루프 빠져나오기

let i = 1;

while(true){
    const helloloof = (`hello${i}`)
    console.log(`hello${i}`)
    i++
    if(helloloof === 'hello523'){
        break
    }

}