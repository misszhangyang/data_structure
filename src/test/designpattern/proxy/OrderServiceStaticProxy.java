package test.designpattern.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

import test.designpattern.proxy.service.OrderService;


/**
 * 创建切换数据源的动态代理类
 * @author yang
 *
 */
public class OrderServiceStaticProxy implements OrderService{
	
	private SimpleDateFormat simpleDateForMate = new SimpleDateFormat("yyyy");
	
	private OrderService orderService;
	
	public OrderServiceStaticProxy(OrderService orderServie) {
		// TODO Auto-generated constructor stub
		this.orderService = orderServie;
	}
	
	public void before() {
		System.out.println("Proxy before method");
	}
	
	public void after() {
		System.out.println("Proxy after method");
	}

	@Override
	public int createOrder(Order order) {
		// TODO Auto-generated method stub
		before();
		Long time = order.getCreateTime();
		Integer dbRouter = Integer.valueOf(simpleDateForMate.format(new Date(time)));
		System.out.println("静态代理类自动分配到【DB】" + dbRouter + "处的数据源进行数据处理");
		DynamicDataSourcEntry.setSource(dbRouter);
		orderService.createOrder(order);
		after();
		return 0;
	}

}
