import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.product.dao.ProductDAOInterface;
import com.my.product.dao.ProductDAOList;
import com.my.product.dto.Product;

public class ProductUserMy {
	java.util.Scanner sc=new java.util.Scanner(System.in);
	//ProductDAOArray dao=new ProductDAOArray();
	ProductDAOInterface dao=new ProductDAOList(); //리스트
//	ProductDAOInterface dao = new ProductDAOArray(); //배열
	void findAll() {
		System.out.println(">>상품 전체목록<<");
		try {
//			Product[] all1 = dao.selectAll();
			Object obj = dao.selectAll();
			if(obj instanceof Product[]) {
				Product[] all1 = (Product[])obj;
				for(int i =0; i<all1.length; i++) {
					Product p = all1[i];
					System.out.println(p.getProdNo() + ":" + p.getProdName() + ":" + p.getProdPrice());
				}
			}else if (obj instanceof List) {
				List<Product> list = (List) obj;
				for(int i=0; i<list.size(); i++) {
					Product p = list.get(i);
					System.out.println(p.getProdNo() + ":" + p.getProdName() + ":" + p.getProdPrice());
				}
			}
		} catch (FindException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------------");

	}

	
	void findByProdNo() {
		System.out.println(">>상품 번호로 검색<<");
		System.out.print("상품 번호를 입력하시오 : ");
		String s=sc.nextLine();
		Product p = new Product();
		try {
			p = dao.selectByProdNo(s);
			System.out.println(p.getProdNo() +"번호 상품의 상품명:" + p.getProdName() + ", 가격:" + p.getProdPrice());
		} catch (FindException e) {
			System.out.println(e.getMessage());
		}
		
	}

	void add() {
		System.out.println(">>상품 추가<<");
		System.out.print("상품 번호를 입력하시오 : ");
		String prodNo=sc.nextLine();
		System.out.print("상품명을 입력하시오 : ");
		String prodName=sc.nextLine();
		System.out.print("상품 가격을 입력하시오 : ");
		String prodPrice=sc.nextLine();
		Product p=new Product(prodNo, prodName, Integer.parseInt(prodPrice));
		try {
			dao.insert(p);
		} catch (AddException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	void modify() {
		System.out.println(">>상품 수정<<");
		System.out.print("상품 번호를 입력하시오 : ");
		String prodNo=sc.nextLine();
		Product modifiedP = new Product();
		modifiedP.setProdNo(prodNo);

		System.out.print("작업을 선택하세요: 상품명변경-1, 상품가격변경-2");
		String opt=sc.nextLine();

		if(opt.equals("1")) {
			System.out.print("변경할 상품명을 입력하시오 : ");
			String prodName=sc.nextLine();
			if("".equals(prodName)) { //변경안함
				prodName = null;
			}
			modifiedP.setProdName(prodName);
		} else if(opt.equals("2")) {
			System.out.print("변경할 가격을 입력하시오 : ");
			String prodPrice=sc.nextLine();
			if("".equals(prodPrice)) {
				prodPrice = "0";
			}
			modifiedP.setProdPrice(Integer.parseInt(prodPrice));
		}
		try {
			dao.update(modifiedP);
			System.out.println("수정되었습니다");
		} catch (ModifyException e) {
			System.out.println(e.getMessage());
		}


	}
	
	void remove() {
		System.out.println(">>상품 삭제<<");
		System.out.println("상품 번호를 입력하시오 : ");
		String prodNo=sc.nextLine();
		try {
			dao.delete(prodNo);
		} catch (RemoveException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		ProductUserMy user=new ProductUserMy();

		while(true) {
			System.out.println("작업을 선택하세요: 상품전체목록-1, 상품번호로검색-2, 상품추가-3, 수정-4, 삭제-5, 종료-9");
			String opt=user.sc.nextLine();

			if(opt.equals("1")) {
				user.findAll();
			} else if(opt.equals("2")) {
				user.findByProdNo();
			} else if(opt.equals("3")) {
				user.add();
			} else if(opt.equals("4")) {
				user.modify();
			} else if(opt.equals("5")) {
				user.remove();
			} else if(opt.equals("9")) {
				System.out.println("작업이 종료되었습니다");
				break;
			}
			
			System.out.println();
		}
	}

}
