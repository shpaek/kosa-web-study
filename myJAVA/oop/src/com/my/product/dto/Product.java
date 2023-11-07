package com.my.product.dto;

import java.util.Objects;

public class Product {
	private String prodNo;
	private String prodName;
	private int prodPrice;
	
	public Product(){} //사용자정의 생성자. 다른 생성자가 있으므로 반드시 직접 만들어줘야 함
	
	public Product(String prodNo, String prodName){
//		this.prodNo = prodNo;
//		this.prodName = prodName;
		this(prodNo, prodName, 0); //this 생성자 호출은 반드시 생성자의 첫머리에 와야 함
	}
	//오버로드
	public Product(String prodNo, String prodName, int prodPrice){
		if(prodNo.length() != 5) {
			System.out.println("상품번호는 5자리이어야합니다");
			
		}else {
			this.prodNo = prodNo;
			this.prodName = prodName;
			this.prodPrice = prodPrice;
		}
	}
	
	public void setProdNo(String prodNo) {
		if(prodNo.length() != 5) {
			System.out.println("상품번호는 5자리이어야합니다");
			return;
		}
		this.prodNo = prodNo;
	}
	public String getProdNo() {
		//return "prodNo의 암호화";
		return prodNo;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public int getProdPrice() {
		return prodPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}
	
// 이클립스 생성 기능 사용
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return Objects.equals(prodNo, other.prodNo);
//	}



//	public boolean equals(Object obj) {}
	//오버로드
//	public boolean equals(Product p) {
//		return this.prodNo.equals(p.prodNo);
//	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Product) {
			Product product = (Product)obj;
			if(this.prodNo.equals(product.prodNo)) {
				return true;
			}
		}
		return false;
	}
	
	




}
