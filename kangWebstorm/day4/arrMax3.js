

const arr = [25, 78, 34, 12, 85, 23,14,13,74,2,1]

function arrMax3(arr) {
    let max = -1
    for (let i = 0; i < arr.length; i++) {
        const score = arr[i]
        // 만일 score가 min보다 작다면, swap

        if (score > max) {
            max = score
        }
    }
    return max
}

console.log(arrMax3(arr))