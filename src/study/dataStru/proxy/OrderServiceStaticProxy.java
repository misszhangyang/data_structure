package study.dataStru.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

import study.dataStru.proxy.service.OrderService;

/**
 * �����л�����Դ�Ķ�̬������
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

	@Override
	public int createOrder(Order order) {
		// TODO Auto-generated method stub
		before();
		Long time = order.getCreateTime();
		Integer dbRouter = Integer.valueOf(simpleDateForMate.format(new Date(time)));
		System.out.println("��̬�������Զ����䵽��DB��" + dbRouter + "��������Դ�������ݴ���");
		DynamicDataSourcEntry.setSource(dbRouter);
		orderService.createOrder(order);
		after();
		return 0;
	}
	
	public void before() {
		System.out.println("Proxy before method");
	}
	
	public void after() {
		System.out.println("Proxy after method");
	}

}
