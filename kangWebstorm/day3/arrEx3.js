// 계속 써먹어야 하는 변수는 바깥쪽에 선언
// 잠깐 써먹는 변수는 안쪽에 선언

const arr = [54, 22, 14, 64, 95, 85]



// 평균 -> 모든 점수의 합(sum) / 개수
// forloof 안에 변수 선언하면 계속 선언되는 꼴이므로 바깥에 선언해야 한다. 그리고 scope 문제
let sum = 0
for (let i = 0; i < arr.length; i++) {
    sum += arr[i]
}
console.log(`sum: ${sum}`)
// tofixed() 고정 소수점 표기
let avg = (sum / arr.length).toFixed(3)
console.log(`AVG: ${avg}`)

// 1. 최고점수를 잡고 비교 2. 첫번째 배열 점수와 비교
// 최저
let min = 101
for (let i = 0; i < arr.length; i++) {
    const score = arr[i]
    // 만일 score가 min보다 작다면, swap

    if(score < min) {
        min = score
    }
}
console.log(`MIN: ${min}`)

// 최고
let max = -1
for (let i = 0; i < arr.length; i++) {
    const score = arr[i]
    // 만일 score가 min보다 작다면, swap

    if(score > max) {
        max = score
    }
}
console.log(`MAX: ${max}`)

