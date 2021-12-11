
// do-while - while의 검사식이 false가 될 때 까지 do(지정된 구문)을 실행한다.
// 0부터 100 까지 누적 합 계산
let result = 0
let i = 0

do {
    i = i + 1
    result = result + i
} while (i < 100)

console.log(result)

