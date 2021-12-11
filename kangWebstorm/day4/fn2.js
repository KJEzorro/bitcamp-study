//
//
// function printNums(start, end) {
//
//     for (let i = start; i <= end; i++) {
//         console.log(i)
//     }
//
// }
// const result = printNums(1,10)
// console.log(result)

// 매개변수가 없으면 "111"이나 "222"같이 기본값설정한 값으로 나온다.
function printNames(str1, str2 = "111", str3 = "222") {
    console.log(str1)
    console.log(str2)
    console.log(str3)
}

// printNames()
// printNames("AAA")
// printNames("AAA","BBB")
// printNames("AAA","BBB","CCC")


function  calc(a, b, fn){
    console.log("A: " + a)
    console.log("B: " + b)

    const result = fn(a + 1, b + 1)

    return result

}

console.log(calc(10, 20, (x,y) => x + y))
console.log(calc(10, 20, (x,y) => x - y))
console.log(calc(10, 20, (x,y) => x * y))