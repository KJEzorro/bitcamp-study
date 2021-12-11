// 2020 분기별 매출
// 업종 카페

// 가장 매출이 좋았던 분기
// 각 분기별로 매출 평균
// 그 중에서 최대 평균을 찾는다.
// 평균을 저장하는 배열을 만든다.


// 최고 매출 월

//2020년도 분기별 매출
const arr = [
    [90, 87, 140,],
    [120, 130, 150],
    [180, 240, 200],
    [180, 140, 190]
]

//가장 매출이 좋았던 분기
//각 분기별 매출 평균을 만든다.

// 분기별 평균 변수 선언
const parr = []

for (let i = 0; i < arr.length; i++) {
    const tempArr = arr[i]
    console.log(tempArr)

    let sum = 0

    for (let j = 0; j < tempArr.length; j++) {
        sum += tempArr[j]
    }
    const tempAvg = (sum/tempArr.length).toFixed(2)
    console.log(tempAvg)
    parr.push(parseFloat(tempAvg))
}

console.log(parr)
//배열의 평균

//그 중(분기) 최대 평균을 찾는다
//최대 매출 금액 찾기
let max = 0
let period = 0

for (let i = 0; i < parr.length; i++) {

    if(parr[i] > max){
        max = parr[i]
        period = i + 1
    }
}
console.log("max: " + max)
console.log("period: " + period + " 분기입니다.")

//최고 매출 월


