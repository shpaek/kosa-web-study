<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
* {
     box-sizing: border-box;
 }

 header {
     display: inline-block;
     width: 10%;
     height: 80px;
     line-height: 80px;
     /* float: left;  */
 }

 header>img {
     width: 100%;
     max-width: 75px;
 }

 nav {
     display: inline-block;
     width: 80%;
     height: 80px;
     margin-left: 100px;

     /* float: left;  */
     overflow: auto;
     background-color: yellow;
     text-align: center;
     /* vertical-align: top; */

 }

 nav>ul {
     list-style-type: none;
     padding-left: 0px;
 }

 nav>ul>li {
     display: inline-block;
     margin: 10px;
 }

 nav>ul>li>a {
     text-decoration: none;
 }

 nav>ul>li>a:hover {
     background-color: #1e3932;
     color: #fff;
     text-decoration: underline;
 }
</style>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
function ajaxHandler(method, u, target) {
    console.log(u)
    // $.ajax({
    //     url:u,
    //     method: method,
    //     success: (responseText)=>{
    //         target.html(responseText) 
    //     },
    //     error: ()=>{
    //         alert('응답실패')
    //     }
    // })
    if(method == 'GET'){
        target.load(u,  function( response, status, xhr ) {
            if ( status == "error" ) {
                alert(xhr.status + xhr.statusText)
            }
        })
    }
}
$(() => {
    //DOM트리에서 section객체찾기
    const sectionObj = document.querySelector('section')
    const $sectionObj = $('section')
    console.log("---자바스크립트객체---")
    console.log(sectionObj)

    console.log("---jQuery객체---")
    console.log($sectionObj)
    console.log(sectionObj === $sectionObj)
    console.log(sectionObj === $sectionObj.get(0))

    //DOM트리에서 nav>ul>li>a객체들 찾기
    const menus = document.querySelectorAll('nav>ul>li>a')
    const $menus = $('nav>ul>li>a')

    //----메뉴객체에서 클릭이벤트가 발생했을 때 할 일 START----      
    $menus.click((e) => {
        // alert('메뉴클릭됨')
        console.log(e.target.className)
        //menu
        switch (e.target.className) {
            case 'login':
                // location.href = 'http://www.naver.com'
                ajaxHandler('GET', "./login.html", $sectionObj)
                break
            case 'signup':
                ajaxHandler('GET', "./signup.html", $sectionObj)
                break
            case 'logout': break
            case 'productlist':
                //ajaxHandler('GET', "./productlist.html", $sectionObj)
                ajaxHandler('GET', "./productlist", $sectionObj)
                break
            case 'cartlist': break
            case 'orderlist': break
        }
        e.preventDefault()
    })
    //----메뉴객체에서 클릭이벤트가 발생했을 때 할 일 END----
})

</script>
<header>
   <img src="./images/logo.png" alt="로고">
</header>
<nav>
    <!--메뉴들-->
    <ul>
        <li><a href="#" class="login">로그인</a></li>
        <li><a href="#" class="signup">가입</a></li>
        <li><a href="#" class="logout">로그아웃</a></li>
        <li><a href="#" class="productlist">상품목록</a></li>
        <li><a href="#" class="cartlist">장바구니목록</a></li>
        <li><a href="#" class="orderlist">주문목록</a></li>
    </ul>
</nav>