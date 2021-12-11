// 클로저 개념 ( 클로저는 돼지저금통이다 )
// total은 지역변수여서 piggySave를 호출하면 사라져야하지만 사라지지않는다.
// add라는 함수가 total이라는 지역변수를 끌어쓰고 있다(사용하고있다) , 물고 안놔주고 있다.
// 그래서 total 지역변수가 사라지지 않는다. 물고 안놔준다는 개념????
// 감춰져있는 참조값????
// 사라져야하지만 add함수에 묶여있어 사라지지못하는 느낌????
// 이런 현상을 클로저라 한다.


function piggySave() {
    let total = 0

    return function add(money){
        total += money
        console.log(total)
    }
}

const p1 = piggySave()

p1(100)
p1(500)
p1(1200)
console.log("__________________________")


const p2 = piggySave()

p1(11300)
p1(5534200)
p1(120120)
console.log("__________________________")
