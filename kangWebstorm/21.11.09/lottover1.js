
// 로또 번호 담을 빈 배열 생성
const arr = []

// 무한 반복문
while(true) {

    // 숫자를 생성 1 - 45 사이의 숫자생성
    const num = parseInt((Math.random() * 45) + 1)

    // 중복검사. -1이라면 중복이 되지 않았다는것.
    const index = arr.indexOf(num)
    console.log(`NUM: ${num}   INDEX: ${index}`)
    if(index >= 0) {
        continue
    }
    // 뽑힌 로또 번호 배열의 길이
    const newLength = arr.push(num)

    // 배열의 길이가 6이면 break로 반복문을 빠져나간다.
    if (newLength === 6) {
        break
    }
}

console.log(arr)
