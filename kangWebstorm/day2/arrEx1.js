// const는 내용이 아닌 리모컨을 고정한다.

const arr = ['타노스', '아이언맨', '블랙 위도우']

console.log(arr.length)

console.log(arr[0])
console.log(arr[1])
console.log(arr[2])
// console.log(arr[3]) // undefined not error

// 맨 마지막 추가
const changedLength = arr.push('블랙팬서')

// push후 변수는 최종 길이를 반환한다.
console.log(changedLength)

// 배열 안 항목의 인덱스 찾기 = indexOf() -> 배열 안 항목의 찾고자하는 값이 없으면 -1을 반환한다.
// console.log(arr.indexOf('캡틴 아메리카'))

console.log(arr)

// 인덱스 위치에 있는 항목 제거하기 = splice(시작위치, 지울 갯수)
const arrSplice = arr.splice(1, 1)
console.log(`스플라이스: ${arrSplice}`)
console.log(arr)


// break를 입력하게되면 for loof를 벗어난다.
// continue를 입력하게되면 해당되는 값을 건너뛰고 다음번부터 읽어온다.
for(let i = 0; i < arr.length; i++) {
    if(arr[i] === '블랙 위도우'){
        continue
    }
    console.log(i)
    console.log(arr[i])
}

console.log("--------------------------")