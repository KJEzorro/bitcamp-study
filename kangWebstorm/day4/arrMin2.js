


const arr = [25, 78, 34, 12, 85, 23,14,13,74,2,1]

function getMin()
{
    return Math.min.apply(null, arr);
}

console.log(getMin())