package test.designpattern.strategy.pay;

public class UnionPay extends PayStament{

	@Override
	public String getName() {
		return "ÒøÁªÖ§¸¶";
	}

	@Override
	public double queryBalace() {
		return 890;
	}

}
