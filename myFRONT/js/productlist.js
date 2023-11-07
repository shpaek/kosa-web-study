//$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
$(() => {
    function ajaxHandler(cp){
     $.ajax({
         url: $backURL+'/productlistjson',
         method: 'get',
         data: `currentPage=${cp}`,
         success: (responseJSONObj) => {

             const totalCnt = responseJSONObj.totalCnt
             const list = responseJSONObj.list
             //원본 product객체찾기
             const $originProduct = $('div.productlist>div.product').first()
             //$originProduct.parent().children().not($originProduct)
             $originProduct.siblings().remove() //productlist영역 초기화
             $originProduct.show()
             
             $(list).each((index, p) => {
                 //복제본 product객체생성
                 const $copyProduct = $originProduct.clone()
                 const prodNo = p.prodNo //상품번호
                 const prodName = p.prodName //상품이름
                 $copyProduct.find("ul>li>img").attr('src', '../images/' + prodNo + '.jpg').attr("alt", prodName)
                 $copyProduct.find("ul>li>span").html(prodName)
                 //복제본객체를 .productlist객체의 자식으로 추가
                 $('div.productlist').append($copyProduct)
             })
             $originProduct.hide()

             //페이지그룹
             const $divPageGroup = $('div.pagegroup')
             //페이지그룹영역 초기화
             $divPageGroup.empty() 

             const startPage = responseJSONObj.startPage //시작페이지
             const endPage = responseJSONObj.endPage //끝페이지

             if(startPage > 1){
                 let page = `[<span class="pg${startPage - 1}">PREV</span>]&nbsp;&nbsp;&nbsp;`
                 $divPageGroup.html($divPageGroup.html()+page)
             }
             
             for(let i=startPage; i<=endPage; i++){
                 let page = `[<span class="pg${i}">${i}</span>]&nbsp;&nbsp;&nbsp;`
                 $divPageGroup.html($divPageGroup.html()+page)
             }

             if(endPage != responseJSONObj.totalPage){
                 let page = `[<span class="pg${endPage + 1}">NEXT</span>]`
                 $divPageGroup.html($divPageGroup.html()+page)
             }
         },
         error: () => {

         }
     })
    }

     ajaxHandler(1)

     $('div.pagegroup').on('click', 'span', (e) => {
         //alert($(e.target).html() + ": " + $(e.target).attr('class') + "페이지가 클릭되었습니다")
         const pg = $(e.target).attr('class')
         const currentPage = pg.substr(2)
         ajaxHandler(currentPage)
     })

     $('div.productlist').on('click', 'div.product', (e)=>{
         //alert('클릭되었습니다')
         //alert($(e.target).attr('src').lastIndexOf('.'))
         const src = $(e.target).attr('src')
         const prodNo = src.substring(src.lastIndexOf('/')+1, src.lastIndexOf('.'))
         //alert(prodNo)
         location.href = `./product.html?prodno=${prodNo}`
     })
 })