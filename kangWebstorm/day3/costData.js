
const olArr = [
    {  month: 1, total:  90}, { month: 2, total:  87}, { month: 3, total: 140},
    {  month: 4, total: 120}, { month: 5, total: 130}, { month: 6, total: 150},
    {  month: 7, total: 180}, { month: 8, total: 240}, { month: 9, total: 200},
    {  month:10, total: 180}, { month:11, total: 140}, { month:12, total: 190}
]
let tempArr = []
for (let i = 0; i < olArr.length; i++) {
    tempArr.push(olArr[i].total)
}
//console.log(tempArr)

//분기별 평균값
//for (let i = 0; i < 3; i = i + 3) {
let i = 0
while(i<12){
    let temp1avg = (tempArr[i] + tempArr[i+1] + tempArr[i+2] / 3).toFixed(2)
    console.log(temp1avg)
    i = i + 3
}