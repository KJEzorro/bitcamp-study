// 배열을 주면 max값을 찾아내는 함수 만들기


const arr = [25, 78, 34, 12, 85, 23,14,13,74,2]
//
// let max = arr.reduce(function(a, b) {
//     return Math.max(a, b)
// })
// console.log(max)

function arrMax( arr ) {
    const sortArr = arr.sort((a, b) => a - b)
    const result = sortArr.pop()
    return result
}

console.log(arrMax(arr))