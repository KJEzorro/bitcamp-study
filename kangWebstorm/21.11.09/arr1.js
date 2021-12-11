

// 배열 생성 방법

// 빈 배열 생성
const arr = []
console.log(arr)
// 배열 생성 -> 자바와 달리 어떤 타입의 값도 저장이 가능하다.
const arr1 = [1,2,3,4,5,6]
console.log(arr1[0])
console.log(arr1[1])
console.log(arr1[2])
console.log(arr1[3])
console.log(arr1[4])


// 배열의 추가, 삭제, 변경 등등
const arr2 = ['사자', '호랑이', '하마']

// 배열 길이 읽어오기
console.log(`배열 길이: ${arr2.length}`)

// 배열 끝에 추가
const arrpush = arr2.push('치타')
console.log(`arrpush의 길이 반환 ${arrpush}`)
console.log(arr2) // [ '사자', '호랑이', '하마', '치타' ]

// 배열 끝에서부터 제거
const arrpop = arr2.pop()
console.log(arrpop) // 제거된 요소를 출력
console.log(arr2)   // 제거 된 후의 배열을 출력

// 배열 안 항목의 인덱스(위치)찾기 찾고자 하는 값이 없으면 -1을 반환
// 예를 들어 호랑이를 찾는다는 가정
const arrindexOf = arr2.indexOf('호랑이')
console.log(arrindexOf)  // 찾는 값의 인덱스를 반환
console.log(arr2)

// 배열에서 인덱스 위치에 있는 항목 제거
// splice(제거하고자 하는 인덱스 위치, 위치부터 몇개를 제거할것인지)
const arrsplice = arr2.splice(1,1)
console.log(arrsplice) // 제거된 배열의 값 반환
console.log(arr2)      // ['사자', '하마']