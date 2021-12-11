// 배열 반복해서 출력

const arr = ["메멘토", "데몰리션맨", "어벤저스", "조커"]
for (let i = 0; i < arr.length; i++) {
    // arr[i]의 값이 "어벤저스"와 같다면 데이터 읽지말고 건너뛰고
    // 다시 for문으로 돌아간다.
    // if(arr[i] === "어벤저스") {
    //     continue
    // }

    // arr[i]의 값이 "어벤저스"와 같다면 데이터 읽지 않고
    // for문을 벗어난다.
    if(arr[i] === "어벤저스") {
        break
    }
    console.log(`인덱스: ${i}  영화이름: ${arr[i]}`)
}

