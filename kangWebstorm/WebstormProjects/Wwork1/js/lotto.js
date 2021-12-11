
console.log("lotto...................")
console.log("lotto...................")
console.log("lotto...................")
console.log("lotto...................")

const btn = document.getElementById("btn")

console.log(btn)

btn.addEventListener("click",(event) => {
    console.log(event)

    const target = document.getElementById("resultDiv")

    const balls = makeLottoNum()

    //clear all <h3> tags
    target.innerHTML =''

    let str =''

    for (const num of balls) {

        str += `<h3>${num}</h3>`

        target.innerHTML = str
        const tag = document.createElement("h3")
        const textNode = document.createTextNode(num)
        tag.appendChild(textNode)
        target.appendChild(tag)
    }


}, false)


function makeLottoNum(){

    const arr = []

    for (let i = 0; i < 6; i++) {
        const tempNum = parseInt(Math.random() * 45) + 1
        //arr안에 tempNum이 있다면
        if( arr.indexOf(tempNum) >= 0 ){
            console.log("중복")
            i--
            continue
        }
        arr.push(tempNum)
    }

    // arr.sort(function(a,b) {
    //     return a -b
    // })

    arr.sort((a,b) => a - b )

    return arr

}







