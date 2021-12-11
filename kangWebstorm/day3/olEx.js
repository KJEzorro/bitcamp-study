// 1. 각 분기별로 매출 평균을 만든다.
// 2. 가장 매출이 좋았던 분기


const parr = []

const olArr = [
    [{ month: 1, total:  90}, { month: 2, total:  87}, { month: 3, total: 140}],
    [{ month: 4, total: 120}, { month: 5, total: 130}, { month: 6, total: 150}],
    [{ month: 7, total: 180}, { month: 8, total: 240}, { month: 9, total: 200}],
    [{ month:10, total: 180}, { month:11, total: 140}, { month:12, total: 190}]
]



// 분기별 총합
for (let i = 0; i < olArr.length; i++) {
    const temArr = olArr[i]

    let sum = 0
    for (let j = 0; j < temArr.length; j++) {
        sum += temArr[j].total

    }
    console.log(`${i+1}분기 총합:${sum}`)
    const tempAvg = (sum/temArr.length).toFixed(2)
    parr.push(parseInt(tempAvg))
}

console.log("----------------")

// 분기별 평균
for (let i = 0; i < parr.length; i++) {
    console.log(`${i+1}분기 평균: ${parr[i]}`)
}
console.log("----------------")

// 분기중 최대값
let max = 0
let quarter = 0
let maxMonth = 0
for (let i = 0; i < olArr.length; i++) {
    const temArr = olArr[i]
    for (let j = 0; j < temArr.length; j++) {
        let mTotal = temArr[j].total
        if (mTotal > max) {
            max = mTotal
            quarter = i
            maxMonth = temArr[j].month
        }
    }
}

console.log(`분기중 최대값: ${quarter + 1}분기 ${maxMonth}월 ${max}`)
console.log("----------------")

// 분기중 최소값
let min = max
let quarter2 = 0
let minMonth = 0
for (let i = 0; i < olArr.length; i++) {
    const temArr = olArr[i]
    for (let j = 0; j < temArr.length; j++) {
        let mTotal = temArr[j].total
        if (mTotal < min) {
            min = mTotal
            quarter2 = i
            minMonth = temArr[j].month
        }
    }
}
console.log(`분기중 최소값: ${quarter2 + 1}분기 ${minMonth}월 ${min}`)
console.log("----------------")

