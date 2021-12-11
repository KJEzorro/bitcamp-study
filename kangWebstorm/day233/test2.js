
// 1ft당 3.5$
// 300 * 200
const perFeet = 3.5

const width = 300
const height = 200

// 창문 = 가로 * 2, 세로 * 2 => 전체 샷시 길이
const totalLength = (width * 2) + (height * 2)

// 길이(cm) => ft 변환
const totalFeet = Math.ceil(totalLength / 30.48)

console.log(totalFeet)

// 가격 계산 (업자가 m단위로밖에 안판다)

const totalPay = totalFeet * perFeet


console.log(`총${totalPay} 달러입니다.`)