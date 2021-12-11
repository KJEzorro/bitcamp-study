
// lotto 함수 호출하면 랜덤 번호 6개 나오게 저장.


function lotto() {
    const numArr = []
    for (let i = 1; i <= 45; i++) {
        numArr.push(i)
    }
    for (let i = 0; i < 6; i++) {
        const idx = parseInt(Math.random() * numArr.length)
        console.log(numArr.splice(idx, 1))

    }
}
lotto()
console.log("________________________")
lotto()
console.log("________________________")
lotto()
console.log("________________________")