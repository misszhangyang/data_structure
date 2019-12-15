package test.designpattern.strategy;

import test.designpattern.strategy.study.ICourse;

public class EnglishStudy implements ICourse{
	
    private String music;
	
	public EnglishStudy(String muis) {
		this.music = muis;
	}

	@Override
	public void study(String course) {
		// TODO Auto-generated method stub
		System.out.println("英语课程开始学习---" + course);
	}

}
