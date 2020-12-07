package study.dataStru.proxy;

import study.dataStru.proxy.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;
	
	/**
	 * �����ʹ��spring��ܹ������Զ���ʼ��orderDao����ģ�
	 * ��������������Ϊ��ʹ�÷���ֱ���ڹ������н��г�ʼ������
	 */
	public OrderServiceImpl() {
		orderDao = new OrderDao();
	}

	@Override
	public int createOrder(Order order) {
		System.out.println("order������ʼʹ��orderDaoʵ��ȥ����");
		return orderDao.insertOrder(order);
	}

}
