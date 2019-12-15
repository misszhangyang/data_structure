package test.designpattern.strategy;

/**
 * 策略模式代码实现
 * 咪咕学院需要开展各种课程活动，针对双11或则618会有各种不同的优惠活动举行
 * 所以我们要定义一个课程学习的接口，各类具体的课程需要实现这个课程，然后
 * 在后来的业务场景中，会新增各种不同的课程活动，我们需要将这块的逻辑单独分开，避免动用过去原来的代码
 * 此时可以使用单例模式结合工厂模式创建枚举单例类来实现
 * @author yang
 *
 */
public class test {
	
	private StudyCourse studyCouse;
	
	public void study(String icourse) {
		if("music".equals(icourse)) {
			studyCouse = new StudyCourse(new MusicStudy("music"));
		}else if("english".equals(icourse)) {
			studyCouse = new StudyCourse(new EnglishStudy("english"));
		}
	}
	
	public static void main(String[] args) {
        test t = new test();
        t.study("music");
        t.studyCouse.study("music");
        
        //单例加工厂模式实现的策略模式来提供课程学习的实现
        t.studyCouse = new StudyCourse(SingleStudy.getInstance("english"));
        t.studyCouse.study("english");
	}

}
