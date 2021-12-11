

function makeLottoNum(){ //로또번호 무작위로 생성 함수

    const arr = []

    for (let i = 0; i < 6; i++) {
        const tempNum = parseInt((Math.random() * 45) + 1)
        // arr안에 tempNum이 있다면
        if ( arr.indexOf(tempNum) >= 0 ) {
            console.log("중복")
            i--
            continue
        }
        arr.push(tempNum)
    }
    return arr
}
