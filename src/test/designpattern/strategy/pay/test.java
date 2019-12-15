package test.designpattern.strategy.pay;

public class test {
	public static void main(String[] args) {
		Order order = new Order("12321312",100,"µÚÒ»±Ê¶©µ¥");
		PayStament ps = order.pay(PayTemplate.UNIONPAY);
		System.out.println(ps.pay(100));
	}

}
