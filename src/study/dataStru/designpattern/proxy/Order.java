package study.dataStru.designpattern.proxy;

/**
 * �þ�̬����ķ�ʽʵ�ֶ�������
 * @author yang
 * @Date  12-08 ˼·������
 * 1 ��������ʵ���� = �� �����·�ʵ�ʲ������ݿ��ʵ����  =�� service��ӿڸ���  =�� �ӿ�ʵ�� 
 *    =�� ��̬���ݶ�������ʱ�䰴����ݽ��зֿ� =�� �����л�����Դ�Ĵ�����
 */
public class Order {
	
	private Object orderInfo;
	private long createTime;
	private String id;
	public Object getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Object orderInfo) {
		this.orderInfo = orderInfo;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

} 
