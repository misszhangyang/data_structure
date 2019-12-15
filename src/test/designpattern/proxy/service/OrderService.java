package test.designpattern.proxy.service;

import test.designpattern.proxy.Order;

/**
 * 创建订单的接口
 * @author yang
 *
 */
public interface OrderService {
	
	public int createOrder(Order order);

}
