window.addEventListener('load', function(){
    const model = {message: 'WELCOME'}
    const demo1 = document.querySelector("#demo1")
    const demo2 = document.querySelector("#demo2")
    const inputObj = document.querySelector('input')
    const data = new Proxy(model, {
        get: function(target, key){
            alert('get')
            if(!target[key]) throw new Error(`존재하지 않는 속성${key}입니다`)
            return target[key]
        },
        set : function(target, key, value){
            alert('set')
            target[key] = value  
            demo1.innerHTML = value
            demo2.innerHTML += '<br>' +value
        }
    })

    demo1.innerHTML = data.message //Proxy의 get함수가 자동호출됨
    demo2.innerHTML = data.message 
    inputObj.addEventListener('keyup', function(e){                
        data.message =  e.target.value      //Proxy의 set함수가 자동호출됨  
    })
})