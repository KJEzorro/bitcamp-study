
const readline1 = require('readline-sync')
const readline2 = require('readline-sync')

console.log("r1")
const r1 = readline1.prompt()

console.log("r2")
const r2 = readline2.prompt()

const r1ar = (Math.pow(r1,2)) * Math.PI
const r2ar = (Math.pow(r2,2)) * Math.PI

const gap = r1ar - r2ar

console.log(gap)


// console.log("ODD EVEN")
// const answer = readLine.prompt()

// console.log(answer)

// console.log(Math.PI)

// const num = (Math.pow(2,4))

// console.log(num)

