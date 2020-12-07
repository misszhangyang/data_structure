package study.dataStru.designpattern.strategy.pay;

import java.util.HashMap;

/**
 * ֧��ģ���࣬����ģʽ = ����ģʽ + ����ģʽ
 * @author yang
 *
 */
public class PayTemplate {
	
	public static final String ALIBABA = "aliba";
	public static final String WECHART = "weChart";
	public static final String UNIONPAY = "unionPay";
	public static final String DELAULT = "unionPay";

	private PayTemplate() {}
	
	private static HashMap<String,PayStament> payMap = new HashMap<String,PayStament>();
	
	private static PayStament NO_PAY  = new AliPay();
	
	static {
		payMap.put(ALIBABA, new AliPay());
		payMap.put(WECHART, new WeChat());
		payMap.put(UNIONPAY, new UnionPay());
	}
	
	public static PayStament getInstance(String pay) {
		if(!payMap.containsKey(pay)) {
			return payMap.get(DELAULT);
		}
		return payMap.get(pay);
	}
	

}
