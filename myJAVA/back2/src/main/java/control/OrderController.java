package control;

import com.my.order.service.OrderService;

public abstract class OrderController implements Controller {
	protected OrderService service;
	public OrderController() {
		service = OrderService.getInstance();
	}

}
