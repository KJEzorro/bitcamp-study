const readline = require('readline-sync')

const Hour1 = readline.question("Hour: ")
const Min1 = readline.question("Min: ")

console.log(Hour1)
console.log(Min1)

// 시침의 각도
let hourD = (360 / 12) * Hour1

// 분침의 각도
const minD = (360 / 60) * Min1

// 분에 따른 시침의 추가적인 이동
const extra = (30 / 60) * Min1

// hourD = hourD + extra
hourD += extra

const gap = hourD - minD

if(0 > gap && gap < 180) {
    console.log(360-(gap * -1))
    return
}
console.log(gap)


