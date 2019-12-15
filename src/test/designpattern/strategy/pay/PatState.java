package test.designpattern.strategy.pay;

import java.util.Date;

/**
 * 支付实体类创建
 * @author yang
 *
 */
public class PatState {
	
	private double pid;
	private String msg;
    private Date date;
    
    public PatState(double pid,String msg,Date date) {
    	this.pid = pid;
    	this.msg = msg;
    	this.date = date;
    }
    
	public String toString() {
		return "PatState [对应的pid=" + pid + ", 消息是msg=" + msg + ", 交易日期date=" + date + "]";
	}

}
