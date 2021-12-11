
const pointArr = [
    {name: 'A' , xpos: 3 , ypos: 10 },  // 객체 리터럴
    {name: 'B' , xpos: 7 , ypos:  6 },
    {name: 'C' , xpos: 3 , ypos:  2 },
    {name: 'D' , xpos: 6 , ypos:  2 },
]

// for (let i = 0; i < pointArr.length; i++) {
//     const pointArrElement = pointArr[i]
//     console.log(pointArrElement)
// }
// 아래 코드와 같다. (아래가 편하다)
// 제곱 = Math.pow()
// 루트 = Math.sqrt()


const target = {xpos:6, ypos:3}


// 람다식을 이용한 거리계산 후 가장 가까운 위치 나타내기
pointArr.sort((a,b) => {
    const distanceA = Math.sqrt(Math.pow(a.xpos - target.xpos,2) + Math.pow(a.ypos - target.ypos,2))
    const distanceB = Math.sqrt(Math.pow(b.xpos - target.xpos,2) + Math.pow(b.ypos - target.ypos,2))

    return distanceA - distanceB
})

console.log(pointArr)

