package study.dataStru.designpattern.strategy.pay;

import java.util.Date;


/*
 * ���׳���ģ��
 */
public abstract class PayStament {

	public abstract String getName();
	
	public abstract double queryBalace();
	
	public PatState pay(double moent) {
		if(queryBalace() < moent) {
			System.out.println("���㣬�˴ν����޷����");
		}
		System.out.println("���׽��Ϊ" + moent + " ���Ϊ:" + (queryBalace() - moent));
		return new PatState(moent,"�������",new Date());
	}
	
}
