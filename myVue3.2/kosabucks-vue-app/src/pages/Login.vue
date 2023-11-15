<template lang="">

      <form @submit.prevent="loginFormSubmitHandler" class="login-form">
        <label for="i">아이디: </label><input type="text" name="id" id="i" v-model="id">
        <br>
        <label for="p">비밀번호: </label><input type="password" name="pwd" id="p" v-model="pwd">
        <br>
        <input type="checkbox" v-model="checked">아이디 저장
        <button>로그인</button>
      </form>

  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: "Login",
    data() {
      return {
        id: '',
        pwd: '',
        checked: true,
      }
    },
    methods: {
      loginFormSubmitHandler() {
        const url = `${this.backURL}/login`
        const data = `id=${this.id}&pwd=${this.pwd}`
  
        if (this.checked) {
          localStorage.setItem('savedId', this.id)
        } else {
          localStorage.removeItem('savedId')
        }
  
        axios.post(url, data, { withCredentials: true })
          .then((response) => {
            const responseData = response.data;
  
            if (responseData.status == 0) {
              alert(responseData.msg);
            } else if (responseData.status == 1) {
              localStorage.setItem("loginedId", this.id);
              location.href = "/";
            }
          })
          .catch((error) => {
            console.log(error)
            alert(error.message);
          });
      },
    },
    created() {
      const savedId = localStorage.getItem('savedId')
      if (savedId != null) {
        this.id = savedId
      }
    }
  }
  </script>
  
  <style scoped>

  
  .login-form {
    max-width: 300px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .login-form label {
    display: block;
    margin-bottom: 5px;
  }
  
  .login-form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
  }
  
  .login-form button {
    width: 100%;
    padding: 10px;
    background-color: #355536;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
  }
  
  .login-form button:hover {
    background-color: #45a049;
  }
  
  .login-form input[type="checkbox"] {
    margin-right: 5px;
  }
  </style>
  