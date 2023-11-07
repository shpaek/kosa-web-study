//$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
$(()=>{
    console.log(location.search) //?prodno=C0001
    const queryStr = location.search.substr(1) //prodno=C0001
    $.ajax({
        url : $backURL + "/productjson",
        method : 'get',
        data : queryStr,
        success : (responseJSONObj)=>{
            if(responseJSONObj.msg!=undefined){ //상품검색 실패인 경우
                alert(responseJSONObj.msg)
            }else{ //상품검색이 성공인 경우
                $('div.product>img').attr('src', `../images/${responseJSONObj.prodNo}.jpg`)
                $('div.product>div>ul>li>span.prodname').html(responseJSONObj.prodName)
                $('div.product>div>ul>li>span.prodno').html(responseJSONObj.prodNo)
                $('div.product>div>ul>li>span.prodprice').html(responseJSONObj.prodPrice)
            }
        },
        error: (jqxhr)=>{
            console.log(jqxhr.state()) //rejected
            console.log(jqxhr.status) //500
        }
    })

    //----장바구니넣기 버튼객체에서 클릭이벤트가 발생했을 때 할 일 START----
    $('div.product>div>ul>li>button').click(()=>{
        const prodno = $('div.product span.prodno').html() //상품번호값
        const quantity = $('div.product input.quantity').val() //수량값
        $.ajax({
            xhrFields: {
                withCredentials: true
             },
            url: $backURL + '/addcart',//'http://localhost:8888/back/addcart',
            method : 'get',
            data : `prodNo=${prodno}&quantity=${quantity}`,
            success: ()=>{

            },
            error : (jqxhr)=>{
                alert(jqxhr.status)
            }   

        })
    })
    //----장바구니넣기 버튼객체에서 클릭이벤트가 발생했을 때 할 일 END----

})