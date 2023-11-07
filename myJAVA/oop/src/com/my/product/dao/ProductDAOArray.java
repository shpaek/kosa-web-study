package com.my.product.dao;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductDAOArray implements ProductDAOInterface{
	private Product[] products = new Product[5];
	private int totalCnt; //상품수 0으로 자동초기화

	public void insert(Product product)  throws AddException{
		for(int i=0; i<totalCnt; i++) {
			if(products[i].getProdNo().equals( product.getProdNo() )) {
				throw new AddException("이미 존재하는 상품입니다");
			}
		}	  
		try {
			products[totalCnt] = product;
			totalCnt++; //GOOD CODE
			//		  products[totalCnt++] = product; //BAD CODE
		}catch(ArrayIndexOutOfBoundsException e) {
			//		  System.out.println("저장소가 꽉찼습니다. 저장된 상품수:" + totalCnt);
			throw new AddException("저장소가 꽉찼습니다. 저장된 상품수:" + totalCnt);
		}
	}


	public Product selectByProdNo(String prodNo) throws FindException{
		for(int i=0; i<totalCnt; i++) {
			Product savedP = products[i]; //이미저장된 상품
			if(savedP.getProdNo().equals(prodNo)) {
				return savedP;
			}
		}
		//return null;
		throw new FindException("상품이 없습니다");
	}


	public Object selectAll() throws FindException{
		if(totalCnt == 0) {
			//return null;
			throw new FindException("상품이 한개도 없습니다");
		}
		Product []all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++) {
			all[i] = products[i];
		}
		return all;
	}

	@Override
	public void update(Product p) throws ModifyException{
		for(int i=0; i<totalCnt; i++) {
			Product savedP = products[i]; //이미저장된 상품
			if(p.getProdNo().equals(savedP.getProdNo())) {
				if(p.getProdName() != null) {
					savedP.setProdName(p.getProdName());
				}if(p.getProdPrice() == 0) {
					savedP.setProdPrice(p.getProdPrice());
				}
				return;
			}
		}
		throw new ModifyException("유효한 상품명 또는 가격을 입력하세요");
	}

	@Override
	public void delete(String prodNo) throws RemoveException{
		for(int i=0; i<totalCnt; i++) {
			Product savedP = products[i]; //이미저장된 상품
			if(savedP.getProdNo().equals(prodNo)) {
				for(int j=i; j<totalCnt-1; j++) {
					products[j] = products[j+1];
				}
				products[totalCnt-1] = null;
				totalCnt--;
				return;
			}

		}throw new RemoveException("삭제할 상품이 없습니다");
			
		
	}
	
}
