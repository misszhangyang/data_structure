package study.dataStru.designpattern.strategy;

import java.util.HashMap;

import study.dataStru.designpattern.strategy.study.ICourse;

/**
 * ʹ�õ���ģʽ�͹���ģʽ���²���ģʽ
 * @author yang
 *
 */
public class SingleStudy {
	
	private SingleStudy() {}
	
	private static HashMap<String,ICourse> studyMap = new HashMap<String,ICourse>();
	
	private static ICourse nonCoue = new EnglishStudy("english");
	
	static {
		studyMap.put(Study.English, new EnglishStudy("emglish"));
		studyMap.put(Study.Music, new MusicStudy("music"));
	}
	
	public static ICourse getInstance(String course) {
		ICourse icouse = studyMap.get(course);
		return icouse == null ? nonCoue : icouse;
	}
	
	private static interface Study{
		String English = "english";
		String Music = "music";
	}

}
