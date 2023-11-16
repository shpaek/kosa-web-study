<template>
    <div class="productlist">
      <h3>상품목록</h3>
      <div class="product" v-for="(product, index) in list" :key="index" @click="productHandler(product)">
        <!-- :to 속성을 이용하여 동적 링크 생성 -->
        <router-link :to="'/productlist/' + $route.params.currentPage">
        <ul>
          <li><img :src="'../images/' + product.prodNo + '.jpg'"></li>
          <li><span>{{ product.prodName }}</span></li>
        </ul>
      </router-link>
      </div>
  
      <div class="pagegroup">
        <span v-if="pagegroup.startPage > 1" @click="pageClickHandler(pagegroup.startPage - 1)" class="pagination-btn">[PREV]</span>
        <span v-for="i in pagegroup.endPage" :key="i" @click="pageClickHandler(i)" :class="{ active: i === pagegroup.currentPage }" class="pagination-number">{{ i }}</span>
        <span v-if="pagegroup.endPage < pagegroup.totalPage" @click="pageClickHandler(pagegroup.endPage + 1)" class="pagination-btn">[NEXT]</span>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'ProductList',
    data() {
      return {
        list: [],
        pagegroup: {
          startPage: 1,
          endPage: 1,
          currentPage: 1,
          totalPage: 1
        },
        
      };
    },

    methods: {
      productListHandler(cp) {
        const url = `${this.backURL}/productlistjson?currentPage=${cp}`;
  
        axios.get(url)
          .then((response) => {
            this.list = response.data.list;
            this.pagegroup = {
              startPage: response.data.startPage,
              endPage: response.data.endPage,
              currentPage: response.data.currentPage,
              totalPage: response.data.totalPage
            };
          })
          .catch((error) => {
            console.log(error);
            alert(error.message);
          });
      },
  
      productHandler(product) {
        const prodNo = product.prodNo;
        location.href = `${this.backURL}/product.html?prodno=${prodNo}`;
      },
  
      pageClickHandler(page) {
        this.productListHandler(page);
      }
    },
    created() {
      this.productListHandler(1);
    }
  };
  </script>
  
  <style scoped>
  .productlist {
    text-align: center;
    background-color: #f0f0f0;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    position: relative;
  }
  
  .product {
    width: 200px;
    display: inline-block;
    margin: 10px;
    cursor: pointer;
    transition: transform 0.3s ease-in-out;
  }
  
  .product:hover {
    transform: scale(1.1);
  }
  
  .product ul {
    list-style-type: none;
    padding-left: 0;
  }
  
  .product img {
    width: 100%;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  .product span {
    display: inline-block;
    width: 80%;
    text-align: center;
    margin-top: 10px;
    font-weight: bold;
    color: #333;
  }
  
  .pagegroup {
    position: absolute;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    text-align: center;
  }
  
  .pagination-btn {
    cursor: pointer;
    margin-right: 10px;
    font-size: 14px;
    color: #555;
    transition: color 0.3s ease-in-out;
  }
  
  .pagination-btn:hover {
    color: #333;
  }
  
  .pagination-number {
    cursor: pointer;
    margin-right: 10px;
    font-size: 14px;
    color: #888;
    transition: color 0.3s ease-in-out;
  }
  
  .pagination-number:hover {
    color: #333;
  }
  
  .pagegroup span.active {
    font-weight: bold;
    color: #333;
  }
  </style>
  