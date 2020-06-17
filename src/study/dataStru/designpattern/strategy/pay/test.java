package study.dataStru.designpattern.strategy.pay;

public class test {
	public static void main(String[] args) {
		Order order = new Order("12321312",100,"��һ�ʶ���");
		PayStament ps = order.pay(PayTemplate.UNIONPAY);
		System.out.println(ps.pay(100));
	}

}
