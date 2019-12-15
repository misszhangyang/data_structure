package test.designpattern.proxy;

/**
 * 用静态代理的方式实现订单新增
 * @author yang
 * @Date  12-08 思路分析：
 * 1 创建订单实体类 = 》 创建下发实际操作数据库的实体类  =》 service层接口隔离  =》 接口实现 
 *    =》 动态依据订单创建时间按照年份进行分库 =》 创建切换数据源的代理类
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
