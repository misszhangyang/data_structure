package test.proxy;

import test.proxy.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;
	
	/**
	 * 如果是使用spring框架管理是自动初始化orderDao对象的，
	 * 但是在这里我们为了使用方便直接在构造器中进行初始化操作
	 */
	public OrderServiceImpl() {
		orderDao = new OrderDao();
	}

	@Override
	public int createOrder(Order order) {
		System.out.println("order订单开始使用orderDao实例去创建");
		return orderDao.insertOrder(order);
	}

}
