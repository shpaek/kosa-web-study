$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
function ajaxHandler(method, u, target) {
    console.log(u)
    //***
    // $.ajax({
    //     url: u,
    //     method: method,
    //     success: (responseText)=>{
    //         //요청이 성공하고 성공적으로 응답이 되었을 때 할 일
    //         target.html(responseText)
    //     },
    //     error: ()=>{
    //         alert('응답실패')
    //     }
    // })

    //축약
    if (method == 'GET') {
        target.load(u, function (response, status, xhr) {
            if (status == "error") {
                alert(xhr.status + xhr.statusText)
            }
        })
    }
}
//window.addEventListener('load', () => {
// $(document).ready()
$(() => {
    const loginedId = localStorage.getItem("loginedId")
    const $img = $('nav>ul>li>img.profile')
    $img.parent().hide()
    if (loginedId == null) { //로그인이 안 된 경우
        //로그인, 가입메뉴 보여주기 / 자소서, 프로필이미지, 로그아웃메뉴 안 보여주기
        $('nav>ul>li>a.login').parent().show()
        $('nav>ul>li>a.signup').parent().show()
        $('nav>ul>li>a.intro').parent().hide()
        $('nav>ul>li>a.logout').parent().hide()
    } else { //로그인 된 경우
        //자소서, 프로필이미지, 로그아웃메뉴 보여주기 / 로그인, 가입메뉴 안 보여주기
        $('nav>ul>li>a.login').parent().hide()
        $('nav>ul>li>a.signup').parent().hide()
        $('nav>ul>li>a.intro').parent().show()
        $('nav>ul>li>a.logout').parent().show()
        $.ajax({
            xhrFields: {
                responseType: "blob",
            },
            url: $backURL + '/download',
            data: 'id=' + loginedId + "&opt=profile",
            success: (responseData) => {
                if (responseData.size > 0) {
                    const url = URL.createObjectURL(responseData)
                    $img.attr('src', url)
                    $img.parent().show()
                }
            },
            error: (jqxhr) => {

            }
        })
    }

    //DOM트리에서 section객체찾기
    //const sectionObj = document.querySelector('section')
    const $sectionObj = $('section')

    //DOM트리에서 nav>ul>li>a객체들 찾기
    //const menus = document.querySelectorAll('nav>ul>li>a')
    const $menus = $('nav>ul>li>a')


    $menus.click((e) => {
        //alert('메뉴클릭됨')
        console.log(e.target.className)
        //menu
        switch (e.target.className) {
            case 'login':
                ajaxHandler('GET', './login.html', $sectionObj)
                break
            case 'signup':
                ajaxHandler('GET', './signup.html', $sectionObj)
                break
            case 'logout':
                $.ajax({
                    xhrFields: {
                        withCredentials: true
                    },
                    url: $backURL+"/logout",
                    method: "GET",
                    success: () => {
                        localStorage.removeItem('loginedId')
                        location.href = './main.html'
                    }
                })
                break
            case 'productlist':
                ajaxHandler('GET', './productlist.html', $sectionObj)
                //ajaxHandler('GET', 'http://localhost:8888/back/productlistjson', $sectionObj)
                break
            case 'cartlist':
                ajaxHandler('GET', './cartlist.html', $sectionObj)
                break
            case 'orderlist':
                ajaxHandler('GET', './orderlist.html', $sectionObj)
                break
            case 'intro':
                location.href = $backURL + '/download?id=' + loginedId + '&opt=intro'
                break
        }
        e.preventDefault()
    })
    //----메뉴객체에서 클릭이벤트가 발생했을 때 할 일 END----

    //----로고img객체에서 클릭이벤트가 발생했을 때 할 일 START----
    //main.html URL이동
    $('header>img').click(() => {
        location.href = './main.html'
    })
    //----로고img객체에서 클릭이벤트가 발생했을 때 할 일 END----
})