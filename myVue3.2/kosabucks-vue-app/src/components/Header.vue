<template lang="">
    <header> <!--<div class="head"-->
        <img src="/images/logo.png" alt="로고" @click="logoClickHandler">
    </header>
    <nav>
        <!--메뉴들-->
        <ul>
            <!-- 부트스트랩 라이브러리 사용할 경우 -->
            <!-- <li><router-link class="nav-link" to="/login">로그인</router-link></li> -->
            
            <li v-if="loginedId == ''">
                <router-link to="/login">로그인</router-link>
            </li>
            <li v-if="loginedId == ''">
                <router-link to="/signup">가입</router-link>
            </li>
            <template v-if="loginedId != ''">
                <li><a href="#" class="intro">자기소개서</a></li>
                <li><img class="profile" v-bind:src="profile"></li>
            <li>
                <a href="#" @click="logoutClickHandler()">{{loginedId}}님 로그아웃</a>
            </li>
        </template>
        
            <li>
                <router-link to="/productlist">상품목록</router-link>
            </li>
        

            <!-- <li><a href="#" class="login">로그인</a></li>
            <li><a href="#" class="signup">가입</a></li>
            <li><a href="#" class="intro">자기소개서</a></li>
            <li><img class="profile"></li>
            <li><a href="#" class="logout">로그아웃</a></li>
            <li><a href="#" class="productlist">상품목록</a></li>
            <li><a href="#" class="cartlist">장바구니목록</a></li>
            <li><a href="#" class="orderlist">주문목록</a></li> -->
        </ul>
    </nav>
</template>
<script>
import axios from 'axios'

export default {
    name: 'Header',
    data() {
        return {
            loginedId: '',
        }
    },
    created() {
        const loginedId = localStorage.getItem('loginedId')
        if (loginedId != null) {
            this.loginedId = loginedId
        }
    },
    methods: {
        // ----로고img객체에서 클릭이벤트가 발생했을 때 할 일 START----
        logoClickHandler() {
            location.href = '/'
        },
        // ----로고img객체에서 클릭이벤트가 발생했을 때 할 일 END----


        logoutClickHandler() {
            const url = `${this.backURL}/logout`
            axios.get(url, { withCredentials: true })
                .then(() => {
                    localStorage.removeItem('loginedId')
                    location.href = '/'
                })
        }
    }

}
</script>
<style scoped>
* {
    box-sizing: border-box;
}

header {
    width: 10%;
    height: auto;
    line-height: 80px;
    float: left;
    background-color: transparent;
    margin: 0 auto;
}

header>img {
    height: 75px;
    top: 30px;
    width: 75px;
    position: absolute;
    z-index: 2;
}

nav {
    height: 120px;
    width: 100%;
    background-color: rgb(243, 242, 235);
    float: right;
    text-align: center;
    z-index: 1;
}

nav>ul {
    padding: 0;
    margin: 0;
    width: auto;
}

nav>ul>li {
    display: inline-block;
    list-style: none;
    margin: 50px 30px;
}

nav>ul>li>a {
    text-decoration: none;
    color: black;
}

nav>ul>li>a:hover {
    background-color: #21473e;
    color: #fff;
    text-decoration: underline;
}

nav>ul>li>img.profile {
    height: 50px;
}
</style>