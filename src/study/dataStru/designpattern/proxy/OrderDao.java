package study.dataStru.designpattern.proxy;

/**
 * ��������ʵ�ʲ�����
 * @author yang
 *
 */
public class OrderDao {

	public int insertOrder(Order order) {
		System.out.println("OrderDao ���� order�ɹ�ʱ���ǣ�" + order.getCreateTime());
		return 1;
	}
}
