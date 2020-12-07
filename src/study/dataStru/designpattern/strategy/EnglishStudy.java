package study.dataStru.designpattern.strategy;

import study.dataStru.designpattern.strategy.study.ICourse;

public class EnglishStudy implements ICourse{
	
    private String music;
	
	public EnglishStudy(String muis) {
		this.music = muis;
	}

	@Override
	public void study(String course) {
		// TODO Auto-generated method stub
		System.out.println("Ӣ��γ̿�ʼѧϰ---" + course);
	}

}
