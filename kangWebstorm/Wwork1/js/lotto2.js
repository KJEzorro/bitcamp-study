
function makeLottoNum(){

    const arr = []

    for (let i = 0; i < 6; i++) {
        const tempNum = parseInt(Math.random() * 45) + 1
        //arr안에 tempNum이 있다면
        if( arr.indexOf(tempNum) >= 0 ){
            console.log("중복")
            i--
            continue
        }
        arr.push(tempNum)
    }

    // arr.sort(function(a,b) {
    //     return a -b
    // })

    arr.sort((a,b) => a - b )

    return arr

}







