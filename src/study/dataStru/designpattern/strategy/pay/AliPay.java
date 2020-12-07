package study.dataStru.designpattern.strategy.pay;

public class AliPay extends PayStament{

	@Override
	public String getName() {
		return "֧����";
	}

	@Override
	public double queryBalace() {
		return 800;
	}

}
