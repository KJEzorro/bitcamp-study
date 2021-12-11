// ca : center area heatmap , pa : penelty area heatmap F : forward, M : midfielder
const heatMap = [
    {ca :  4, pa :  8, category : 'F' },
    {ca :  3, pa : 11, category : 'F' },
    {ca :  2, pa : 18, category : 'F' },
    {ca : 18, pa : 12, category : 'M' },
    {ca : 15, pa :  4, category : 'M' }
]

const target = {ca : 12, pa : 5}

heatMap.sort((a , b) => {
    const distanceA = Math.sqrt(Math.pow(a.ca - target.ca, 2) + Math.pow(a.pa - target.pa, 2))
    const distanceB = Math.sqrt(Math.pow(b.ca - target.ca, 2) + Math.pow(b.pa - target.pa, 2))

    return distanceA - distanceB
})
// 3개의 인덱스를 비교하기 위해 i,
let j = 0

for (let i = 0; i < 3; i++) {

    if(heatMap[i].category.indexOf('F') === 0){
        j++
    }
}
if(j <= 2)
{
    console.log("이 선수는 미드필더 입니다")
}else{
    console.log("이 선수는 포워드 입니다")
}



//console.log(heatMap)



