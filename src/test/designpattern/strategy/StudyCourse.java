package test.designpattern.strategy;

import test.designpattern.strategy.study.ICourse;

/**
 * 具体课程学习类
 * @author yang
 *
 */
public class StudyCourse {

	private ICourse couse;
	
	public StudyCourse(ICourse couse) {
		this.couse = couse;
	}
	
	public void study(String icourse) {
		this.couse.study(icourse);
	}
	
}
