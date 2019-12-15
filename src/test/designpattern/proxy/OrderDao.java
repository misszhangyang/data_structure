package test.designpattern.proxy;

/**
 * 订单入库的实际操作类
 * @author yang
 *
 */
public class OrderDao {

	public int insertOrder(Order order) {
		System.out.println("OrderDao 创建 order成功时间是：" + order.getCreateTime());
		return 1;
	}
}
