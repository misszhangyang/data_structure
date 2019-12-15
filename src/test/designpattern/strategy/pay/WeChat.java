package test.designpattern.strategy.pay;

public class WeChat extends PayStament{

	@Override
	public String getName() {
		return "Œ¢–≈÷ß∏∂";
	}

	@Override
	public double queryBalace() {
		return 490;
	}

}
