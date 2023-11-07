//$backURL = 'http://192.168.1.20:8888/backspringconfiguration';
    $(() => {
        //DOM트리에서 section객체찾기
        //alert("login용 window load eventhandler")
        const savedId = localStorage.getItem('savedId')
        //console.log(savedId) //null
        if (savedId != null) {
            $('input[name=id]').val(savedId)
        }

        //DOM트리에서 form객체찾기
        //----form객체에서 submit이벤트가 발생했을 때 할 일 START----
        $('form').submit((e) => {

            //alert("ajax-0")
            //checkbox객체의 checked속성값확인
            if ($('input[type=checkbox]').prop('checked')) {
                localStorage.setItem('savedId', $('input[name=id]').val())
            } else {
                localStorage.removeItem('savedId')
            }

            //alert("ajax-1")
            const idValue = $('input[name=id]').val()
            //alert("ajax-2" + idValue)
            const pwdValue = $('input[name=pwd]').val()
            //alert("ajax-3" + pwdValue)
            //const data = 'id=' + idValue + 'pwd=' + pwdValue
            const data = `id=${idValue}&pwd=${pwdValue}`
            //alert("ajax-4" + data)

            $.ajax({
                xhrFields:{
                    withCredentials: true
                },
                url: $backURL + "/login",
                method: "POST",
                data: data,
                // beforeSend: function (xhr) {
                //     xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
                // },
                success: (responseJSONObj) => {
                    //요청이 성공하고 성공적으로 응답이 되었을 때 할 일
                    //alert(responseText)
                    if(responseJSONObj.status == 0){ //로그인이 실패한 경우
                        alert(responseJSONObj.msg)
                    }else if(responseJSONObj.status == 1){ //로그인이 성공한 경우
                        localStorage.setItem("loginedId", idValue)
                        location.href="./main.html"
                    }
                },
                error: (jqXHR, textStatus) => {
                    //응답, 요청에 오류가 있는 경우
                    alert(jqXHR.readyState + ":" + jqXHR.status + ":" + jqXHR.statusText)
                }
            })
            //alert("ajax-5")
            e.preventDefault()
        })
        //----form객체에서 submit이벤트가 발생했을 때 할 일 END----

    })