package study.dataStru.designpattern.strategy;

/**
 * ����ģʽ����ʵ��
 * �乾ѧԺ��Ҫ��չ���ֿγ̻�����˫11����618���и��ֲ�ͬ���Żݻ����
 * ��������Ҫ����һ���γ�ѧϰ�Ľӿڣ��������Ŀγ���Ҫʵ������γ̣�Ȼ��
 * �ں�����ҵ�񳡾��У����������ֲ�ͬ�Ŀγ̻��������Ҫ�������߼������ֿ������⶯�ù�ȥԭ���Ĵ���
 * ��ʱ����ʹ�õ���ģʽ��Ϲ���ģʽ����ö�ٵ�������ʵ��
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
        
        //�����ӹ���ģʽʵ�ֵĲ���ģʽ���ṩ�γ�ѧϰ��ʵ��
        t.studyCouse = new StudyCourse(SingleStudy.getInstance("english"));
        t.studyCouse.study("english");
	}

}
