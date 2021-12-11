// 배열을 주면 min값을 찾아내는 함수 만들기


const arr = [25, 78, 34, 12, 85, 23,14,13,74,2]

function arrMin( arr ) {
    const sortArr = arr.sort((a, b) => a - b)
    const result = sortArr.shift()
    return result
}

console.log(arrMin(arr))