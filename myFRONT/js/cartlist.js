//$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
$(()=>{
    $.ajax({
        xhrFields:{
            withCredentials: true
        },
        url: $backURL + "/cartlist",
        method: "get",
        //data:,
        success:(responseJSONObj)=>{

            const $originTrObj = $('div.cartlist>table>thead>tr')
            const $tbodyObj = $('div.cartlist>table>tbody')
            responseJSONObj.forEach(element => {
                const p = element.product
                const q = element.quantity

            // console.log(p, q)

            const $copyTrObj = $originTrObj.clone()
            $copyTrObj.empty()

            const $prodNoTdObj = $('<td>')
            $prodNoTdObj.append(p.prodNo)
            $copyTrObj.append($prodNoTdObj)

            const $prodNameTdObj = $('<td>')
            $prodNameTdObj.append(p.prodName)
            $copyTrObj.append($prodNameTdObj)

            const $prodPriceTdObj = $('<td>')
            totalPrice = p.prodPrice * q
            $prodPriceTdObj.append(p.prodPrice)
            $copyTrObj.append($prodPriceTdObj)

            const $prodQuantityTdObj = $('<td>')
            $prodQuantityTdObj.append(q)
            $copyTrObj.append($prodQuantityTdObj)

            $tbodyObj.append($copyTrObj)
        });
        },
        error: (jqxhr) =>{
            alert(jqxhr.status)
        }
    })

    //----주문하기 버튼객체에서 클릭이벤트가 발생했을 때 할 일 START----
    $('div.cartlist>button').click(()=>{
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: $backURL + '/addorder',
            method : 'get',
            success: (responseJSONObj)=>{
                if(responseJSONObj.status == 0){ //주문실패
                    alert(responseJSONObj.msg)
                }else{
                    $('nav>ul>li>a.orderlist').click()
                }
            }
        })
    })
    //----주문하기 버튼객체에서 클릭이벤트가 발생했을 때 할 일 END----


})