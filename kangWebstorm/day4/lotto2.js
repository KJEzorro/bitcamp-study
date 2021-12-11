
function lotto2() {
    const arr = []

    while (true) {

        const num = parseInt((Math.random() * 45) + 1)
        const index = arr.indexOf(num)

        if (index >= 0) {
            continue
        }
        const newLength = arr.push(num)

        if (newLength === 6) {
            break
        }
    }
    const arrSort = arr.sort((a, b) => a - b)
    console.log(arrSort)
}

lotto2()