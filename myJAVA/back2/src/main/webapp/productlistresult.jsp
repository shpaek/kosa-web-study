<%@page import="com.my.util.PageGroup"%>
<%@page import="com.my.product.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productlistresult.jsp</title>
<style>
div.product{
    width:200px;
    display:inline-block;
}
div.product>ul {
    list-style-type: none;
    padding-left: 0px;
}
div.product>ul>li>img{
    /* width:100px;                 */
    width:80%;
}
div.product>ul>li>span{
    display: inline-block;
    width: 80%;
    text-align: center;
}
.productlist>h3{
    width:200px;
    margin: 10px auto;
    text-align: right;
    background: yellow;
}

.productlist>.pagegroup>span.nocurr:hover{
	background: yellow;
}
.productlist>.pagegroup>span.curr{
	text-decoration: none; 
}
.productlist>.pagegroup>span.nocurr{
	text-decoration: underline;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
$(()=>{
	$('.productlist>.pagegroup>span.nocurr').click((e)=>{
		//alert($(e.target).html() + ": " + $(e.target).attr('class')  +"페이지가 클릭되었습니다")
		const pg = $(e.target).attr('class').split(' ')[1]
		
		//const pg = $(e.target).attr('class') //nocurr pg1, nocurr pg2, ...
		const currentPage = pg.substr(2)     //1, 2, ...
		const url = './productlist?currentPage='+currentPage
		const $section = $('section')
		console.log($section)
		if($section.length != 0){ //section용 jquery객체 존재 여부는 length로 비교
			$section.load(url)
		}else{
			$('body').load(url)
		}
	})
})
</script>
</head>
<body>
<div class="productlist">
  <h3>상품목록</h3>
<%
PageGroup<Product> pg = (PageGroup)request.getAttribute("pb");
//List<Product> list = (List)request.getAttribute("list");
List<Product> list = pg.getList();
for(Product p: list){ 
%>
	<div class="product">
       <ul>
           <li><img src="./images/<%=p.getProdNo()%>.jpg" alt="<%=p.getProdName()%>"></li>
           <li><span><%=p.getProdName()%></span></li>
       </ul>
    </div>
<%} %>
    <div class="pagegroup">
<%
int startPage = pg.getStartPage();
int endPage = pg.getEndPage();
int totalPage = pg.getTotalPage();
int currentPage = pg.getCurrentPage();
if(startPage == 0){
	return;
}

if(startPage > 1){
%>[<span class="nocurr pg<%=startPage-1%>">PREV</span>]&nbsp;&nbsp;&nbsp;	
<%}

for(int i=startPage; i<=endPage; i++){
	if(i == currentPage){
%>[<span class="curr pg<%=i%>"><%=i%></span>]&nbsp;&nbsp;&nbsp;	
<%
	}else{
%>[<span class="nocurr pg<%=i%>"><%=i%></span>]&nbsp;&nbsp;&nbsp;		
<%		
	}
}

if(endPage != totalPage){ //endPage < totalPage
%>[<span class="nocurr pg<%=endPage+1%>">NEXT</span>]	
<%}
%>
    </div>
</div>
</body>
</html>