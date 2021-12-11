

const arr = [25, 78, 34, 12, 85, 23,1,14,13,74,2]

function arrMin3 ( arr ) {
    let min = 101
    for (let i = 0; i < arr.length; i++) {
        const score = arr[i]
        // 만일 score가 min보다 작다면, swap

        if (score < min) {
            min = score
        }
    }
    return min
}

console.log(arrMin3(arr))