const storeService = (function(){

    const urlArr = ['http://192.168.0.195:5555/w22/1team.json','http://192.168.0.215:5555/w22/2team.json','http://192.168.0.188:5555/w22/3team.json']

    let storeArr = []

    function loadJson(index, callback){

        $.getJSON(urlArr[index], function(data){
            storeArr = data
            callback(data)
        })

    }

    function getStore(sno){
        return storeArr.filter(s => s.sno === sno)[0]
    }

    return {loadJson, getStore}

})()