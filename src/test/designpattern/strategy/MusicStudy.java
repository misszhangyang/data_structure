package test.designpattern.strategy;

import test.designpattern.strategy.study.ICourse;

public class MusicStudy implements ICourse{
	
	private String music;
	
	public MusicStudy(String muis) {
		this.music = muis;
	}

	@Override
	public void study(String course) {
		// TODO Auto-generated method stub
		System.out.println("音乐课程开始学习----" + course);
	}

}
