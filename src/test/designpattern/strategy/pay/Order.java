package test.designpattern.strategy.pay;

public class Order {
	
	private String uid;
	private double pay;
	private Object obj;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Order(String uid, double pay, Object obj) {
		super();
		this.uid = uid;
		this.pay = pay;
		this.obj = obj;
	}
	
	public PayStament pay() {
		return pay(PayTemplate.DELAULT);
	}
	
	public PayStament pay(String key) {
		PayStament ps = PayTemplate.getInstance(key);
		System.out.println("订单开始支付-----" + this.uid);
		System.out.println("订单支付详情是------" + this.pay);
		return ps;
	}
	
	

}
