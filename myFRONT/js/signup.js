//$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
// window.addEventListener('load', ()=> {
$(() => {
    //DOM트리에서 가입하기버튼객체찾기
    // const btSignupObj = document.querySelector('form.signup>button[type=submit]')
    const $btSignupObj = $('form.signup>button[type=submit]')
    //DOM트리에서 id입력란객체찾기
    // document.getElementById('i')
    // document.querySelector('#i')
    // const idObj = document.querySelector('form.signup>input[name=id]')
    const $idObj = $('form.signup>input[name=id]')
    //----id입력란객체에서 focus이벤트 발생했을 때 할 일 START----
    // idObj.addEventListener('focus', ()=>{
    //     btSignupObj.style.display = 'none'
    // })
    $idObj.focus(() => {
        $btSignupObj.hide()
    })
    //----id입력란객체에서 focus이벤트 발생했을 때 할 일 END----

    //DOM트리에서 중복확인버튼객체찾기
    // const btDupchkObj = document.querySelector('form.signup>button[type=button]')
    const $btDupchkObj = $('form.signup>button[type=button]')

    //----중복확인버튼객체에서 클릭이벤트 발생했을때 할 일 START----
    // btDupchkObj.addEventListener('click', ()=>{
    $btDupchkObj.click(() => {
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: $backURL+"/iddupchk",
            method: 'get',
            data: `id=${$idObj.val()}`,
            // success: (responseJSONObj) => {
            //     // if('admin' == idObj.value){
            //     if (responseJSONObj.status == 1) {
            //         alert('사용가능한 아이디입니다')
            //         // btSignupObj.style.display = 'inline-block'
            //         $btSignupObj.show()
            //     } else {
            //         alert('이미 사용중인 아이디입니다')
            //         $idObj.select();
            //     }
            // },
            success: ()=>{
                $btSignupObj.show()
            },
            error: (jqXHR) => {
                //응답, 요청에 오류가 있는 경우
                alert(jqXHR.responseText)
                $idObj.select();
            }
        })
    })
    //----중복확인버튼객체에서 클릭이벤트 발생했을때 할 일 END----


    //DOM트리에서 폼객체 찾기
    // const formObj = document.querySelector('form.signup')
    const $formObj = $('form.signup')

    //----폼객체에서 submit이벤트 발생했을때 할 일 START----
    // formObj.addEventListener('submit', (e)=>{
    $formObj.submit((e) => {
        const $pwdArr = $('form.signup>input[type=password]') //비밀번호 입력란 객체
        const $nameObj = $('form.signup>input[type=name]') //이름입력란 객체
        if ($pwdArr.eq(0).val() != $pwdArr.eq(1).val()) {
            alert('비밀번호를 다시 입력하세요')
            $pwdArr.eq(0).focus()
            $pwdArr.eq(0).select()

        } else {
            const fd = new FormData(e.target);
            // console.log($('form').serialize())
            $.ajax({
                xhrFields: {
                    withCredentials: true
                },
                url: $backURL+'/signup',
                method: 'post',
                data: //`id=${idObj.val()}&pwd=${pwdArr.eq(0).val()}&name=${$nameObj.val()}`,
                    //{id: idObj.val(), pwd:pwdArr.eq(0).val(), name: $nameObj.val()},
                    // $('form').serialize(),
                    fd,
                contentType: false, // ajax 이용시 파일 첨부에 필요한 property
                processData: false, // ajax 이용시 파일 첨부에 필요한 property
                success: (responseJSONObj) => {
                    alert(responseJSONObj.msg);
                    if (responseJSONObj.status == 1) {
                        location.href = './main.html'
                    }
                },
                error: (jqXHR) => {
                    //응답, 요청에 오류가 있는 경우
                    alert(jqXHR.status)
                    //alert(responseJSONObj.msg);
                }
            })
        }

        //e.preventDefault()
        //기본이벤트핸들러를 막는 것과 같은 효과
        return false
    })
    //----폼객체에서 submit이벤트 발생했을때 할 일 END----

    //----파일업로드용 테스트 폼객체에서 submit이벤트 발생했을때 할 일 START----
    const $uploadForm = $('form.form1')
    $uploadForm.submit((e)=>{
        const fd = new FormData(e.target)
        fd.forEach((value, key)=>{
            console.log(key)
            console.log(value)
            console.log("-----------")
        })

        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: $backURL+'/upload',
            method: 'post',
            contentType: false, //파일첨부
            processData: false, //파일첨부용 프로퍼티
            data: fd, //"t=tValue&"
            success: (responseJSONObj)=>{
                alert(responseJSONObj.msg);
            },
            error: (responseJSONObj)=>{
                responseJSONObj.msg
            }
        })
        return false
    })
    //----파일업로드용 테스트 폼객체에서 submit이벤트 발생했을때 할 일 END----

    //----파일다운로드 테스트 버튼에서 클릭이벤트 발생했을때 할 일 START----
    $('div.download>button').click(()=>{
        const $img = $('div.download>img')
        $.ajax({
            xhrFields: {
                responseType: "blob",
            },
            url: $backURL+'/download',
            data: 'id=010',
            success: (responseData)=>{
                const url = URL.createObjectURL(responseData)
                $img.attr('src', url)
            }
        })
        
    })
    //----파일다운로드 테스트 버튼에서 클릭이벤트 발생했을때 할 일 END----

    //----프로필 input객체에서 체인지이벤트 발생했을때 할 일 START----
    $('form.signup>input[name=f1]').change((e)=>{
        console.log(e.target.files[0])
        const url = URL.createObjectURL(e.target.files[0])
        $('form.signup img.profile').attr('src', url)
    })
    //----프로필 input객체에서 체인지이벤트 발생했을때 할 일 END----
})