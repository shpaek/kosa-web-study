<template lang="">
    <div class="productlist">
        <h3>상품목록</h3>
        <ProductItem :p="p"  
            v-if="pageGroup" 
            v-for="p in pageGroup.list" 
            :key="p.prodNo"/>
        <PageGroup
            v-if="pageGroup" :pg="pageGroup" 
            :path="/productlist/"
            :currentPage="$route.params.currentPage?$route.params.currentPage: 1"
            :start="pageGroup.startPage" 
            :end="pageGroup.endPage"
            :total="pageGroup.totalPage"
        />
    </div>
</template>
<script>
import ProductItem from './ProductItem.vue'
import PageGroup from './PageGroup.vue'
import axios from 'axios'
export default {
    name: 'ProductList',
    components: { ProductItem, PageGroup },
    data() {
        return {
            currentPage: 1,
            pageGroup: null,
        }
    },
    methods: {
        //----페이지그룹의 페이지(ex: [1] [2] [NEXT])객체가 클릭되었을 때 할 일 START----   
        axiosHandler() {
            const url = `${this.backURL}/productlistjson?currentPage=${this.currentPage}`
            axios.get(url)
            .then(response=>{
                this.pageGroup = response.data
                /*
                {
    "list": [
        {
            "prodNo": "D0001",
            "prodName": "요거트",
            "prodPrice": 3000
        },
        {
            "prodNo": "D0002",
            "prodName": "블랙티",
            "prodPrice": 3000
        },
        {
            "prodNo": "D0003",
            "prodName": "딸기주스",
            "prodPrice": 1000
        }
    ],
    "totalCnt": 11,
    "currentPage": 2,
    "totalPage": 4,
    "startPage": 1,
    "endPage": 2
}*/
            })
        }
        //----페이지그룹의 페이지(ex: [1] [2] [NEXT])객체가 클릭되었을 때 할 일 END----
    },
    watch: {
        //----라우터값이 변경되었을 때 할 일 START----
        $route(newRoute, oldRoute) {
            console.log("라우터값이 변경" + newRoute.path + "," + oldRoute.path)
            if (newRoute.params.currentPage) {
                this.currentPage = newRoute.params.currentPage
            } else {
                this.currentPage = 1
            }
            this.axiosHandler(this.currentPage)
        }
        //----라우터값이 변경되었을 때 할 일 END----     
    },
    created() {
        console.log('created productlist')
        if (this.$route.params.currentPage) {
            this.currentPage = this.$route.params.currentPage
        }
        this.axiosHandler(this.currentPage)
    }
}
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