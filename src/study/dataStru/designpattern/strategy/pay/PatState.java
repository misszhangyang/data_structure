package study.dataStru.designpattern.strategy.pay;

import java.util.Date;

/**
 * ֧��ʵ���ഴ��
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
		return "PatState [��Ӧ��pid=" + pid + ", ��Ϣ��msg=" + msg + ", ��������date=" + date + "]";
	}

}
