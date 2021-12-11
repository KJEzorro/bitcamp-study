
function calcTotal(hourValue, minValue){
// 시침의 각도를 구하는 함수 -> 입력 시: 12,   출력: 각도
    function calcHour(hour) {
        const result = (360 / 12) * (hour % 12)
        return result
    }

// 분침의 각도를 구하는 함수  '화살표 함수'   매개변수 하나일때는 () 생략 가능
// const calcMin = (min) => {
//     return (360 / 60) * min
// }

    const calcMin = min => (360/60) * min

// 분침이동에 따른 시침의 이동 각도를 구하는 함수
    function getExtra(min){
        return ( (360/12) / 60 ) * min
    }

    const result = (calcHour(hourValue) + getExtra(minValue)) - calcMin(minValue)
    return result < 180 ? result + 360 : result

}
// 12:38

console.log(calcTotal(9, 35))