package study.dataStru.designpattern.strategy;

import study.dataStru.designpattern.strategy.study.ICourse;

public class MusicStudy implements ICourse{
	
	private String music;
	
	public MusicStudy(String muis) {
		this.music = muis;
	}

	@Override
	public void study(String course) {
		// TODO Auto-generated method stub
		System.out.println("���ֿγ̿�ʼѧϰ----" + course);
	}

}
