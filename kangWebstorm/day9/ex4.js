

const storeService = (function () {

    let storeArr = []

    function loadData(url, callback) {
        fetch(url)
            .then(  response => response.json())
            .then(  data => {
                // console.log(data)
                storeArr = data
                callback(data)
            })
    }

    function getDataByIndex(index) {

        return storeArr[index]

    }

    return {loadData, getDataByIndex}

})()