<template lang="html">
    <section>
      <form class="signup" @submit.prevent="signupFormSubmitHandler">
        <label for="i">아이디: </label>
        <input type="text" name="id" id="i" required
        v-model = "c.id"
        @focus="idFocusHandler()">
        <button type="button" class="check-duplicate" @click="btDupchkClickHandler">중복확인</button>
        <br>
        <label for="p">비밀번호: </label>
        <input type="password" name="pwd" id="p" required
        v-model="c.pwd"
        ref="p">
        <br>
        <label for="pwd1">비밀번호1: </label>
        <input type="password" id="pwd1" required
        v-model="pwd1">
        <br>
        <label for="n">이름: </label>
        <input type="text" name="name" id="n" required
        v-model="c.name">
        <br>
        <label for="f1">프로필: </label>
        <input type="file" name="f1" id="f1">
        <div>
          <img class="profile">
        </div>
        <br>
        <label for="f2">자기소개서: </label>
        <input type="file" name="f2" id="f2">
        <button type="submit" :class="[isBtSignup? 'btSignupShow':'btSignupHide', 'submit-button']">가입하기</button>
      </form>
    </section>
  </template>
  
  <script>
  import axios from 'axios'
  
  export default {
    name: 'Signup',
    data() {
      return {
        // id: '',
        // pwd: '',
        pwd1: '',
        // name: '',
        isBtSignup: false, // 가입버튼 보여주기 여부
        c: {
        id: '',
        pwd: '',
        name: '',
        }
      }
    },
    methods: {
      idFocusHandler() {
        this.isBtSignup = false
      },
  
      btDupchkClickHandler() {
        const url = `${this.backURL}/iddupchk?id=${this.c.id}`

        axios.get(url, { withCredentials: true })
          .then((response) => {
            if(response.data.status == 1){
                console.log(response)
                alert("중복확인 완료")
                this.isBtSignup = true
            }else if(response.data.status == 0){
                alert("이미 사용중인 아이디입니다")
            }
          })
          .catch((error) => {
            console.log(error)
            alert(error.message);
          });
      },

      signupFormSubmitHandler(){
        if(this.c.pwd != this.pwd1){
            alert('비밀번호를 다시 입력하세요')
            const pwdObj = this.$refs.p //비번

            pwdObj.focus()
            pwdObj.select()
        }else{
            const url = `${this.backURL}/signup`
            const data = this.c
            axios
            .post(url, data)
            .then(response=>{
                alert("결과:" + response.data.msg)
                if(response.data.status ==1){
                    location.href = '/'
                }
            })
            .catch((error) => {
            console.log(error)
            alert(error.message);
          });
        }
      }
    }
  }
  </script>
  
  <style scoped>
  section {
    width: 100%;
    height: 800px;
    padding-top: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  form.signup {
    max-width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  form.signup label {
    display: block;
    margin-bottom: 5px;
    font-size: 16px;
    color: #333;
  }
  
  form.signup input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
    border: 1px solid #ddd;
    border-radius: 3px;
    font-size: 14px;
  }
  
  form.signup .check-duplicate,
  form.signup button.submit-button {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
    cursor: pointer;
  }
  
  form.signup .check-duplicate {
    background-color: #ff8c00;
    color: white;
    border: none;
    border-radius: 3px;
  }
  
  form.signup .check-duplicate:hover {
    background-color: #ff6f00;
  }
  
  form.signup button.submit-button {
    background-color: #355536;
    color: white;
    border: none;
    border-radius: 3px;
  }
  
  form.signup button.submit-button:hover {
    background-color: #45a049;
  }
  
  .btSignupShow {
    display: block;
  }
  
  .btSignupHide {
    display: none;
  }
  </style>
  