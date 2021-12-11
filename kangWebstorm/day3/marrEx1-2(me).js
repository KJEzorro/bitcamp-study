
const arr =  [
    [90, 87,140],  // [{ month:1, total: 90}, { month:2, total: 87}, { month:3, total: 140},] <- 이런식으로 변환
    [120,130,150],
    [180,240,200],
    [180,140,190]
]

// 가장 매출이 좋았던 분기
// 각 분기별로 매출 평균을 만든다.
const pArr = []

for (let i = 0; i < arr.length; i++) {
    const temArr = arr[i]
    console.log(temArr)

    let sum = 0
    for (let j = 0; j < temArr.length; j++) {
        sum += temArr[j]
        console.log(sum)
    }
    const tempAvg = (sum/temArr.length).toFixed(2)
    pArr.push(parseInt(tempAvg))
}
console.log(pArr)



let max = 0
let period = 0
for (let i = 0; i < pArr.length; i++) {
    if(pArr[i] > max) {
        max = pArr[i]
        period = i
    }

}
console.log(`최고 분기 평균 매출액: ${max}`)
console.log(`${period + 1} 분기 입니다.`)
