package test.designpattern.strategy.pay;

public class AliPay extends PayStament{

	@Override
	public String getName() {
		return "Ö§¸¶±¦";
	}

	@Override
	public double queryBalace() {
		return 800;
	}

}
