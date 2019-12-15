package test.designpattern.strategy.pay;

import java.util.Date;


/*
 * 交易抽象模板
 */
public abstract class PayStament {

	public abstract String getName();
	
	public abstract double queryBalace();
	
	public PatState pay(double moent) {
		if(queryBalace() < moent) {
			System.out.println("余额不足，此次交易无法完成");
		}
		System.out.println("交易金额为" + moent + " 余额为:" + (queryBalace() - moent));
		return new PatState(moent,"交易完成",new Date());
	}
	
}
