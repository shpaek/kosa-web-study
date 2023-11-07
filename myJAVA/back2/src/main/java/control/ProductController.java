package control;

import com.my.product.service.ProductService;

public abstract class ProductController implements Controller {
	protected ProductService service;
	public ProductController() {
		service = ProductService.getInstance();
	}

}
