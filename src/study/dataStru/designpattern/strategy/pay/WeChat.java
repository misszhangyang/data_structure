package study.dataStru.designpattern.strategy.pay;

public class WeChat extends PayStament{

	@Override
	public String getName() {
		return "΢��֧��";
	}

	@Override
	public double queryBalace() {
		return 490;
	}

}
