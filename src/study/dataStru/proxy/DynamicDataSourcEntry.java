package study.dataStru.proxy;

/**
 * ������ʹ�þ�̬������Ҫ��ɵĹ����ǣ�������ݴ���ʱ���Զ�������ݽ��зֿ⣬���ݿ���ԭ��
 * �����޸�ԭ��д�õĴ����߼���ͨ�������������ɡ��ȴ�������Դ·�ɶ���
 * ʹ��ThreadLocal�ĵ���ʵ�� DynamicDataSourcEntry
 * @author yang
 *
 */
public class DynamicDataSourcEntry {
	
	public final static String DEFAULT_SOURCE = null;
	
	public final static ThreadLocal<String> local = new ThreadLocal<String>();
	
	private DynamicDataSourcEntry() {
		
	}
	
	/**
	 * �������Դ
	 */
	public static void clear() {
		local.remove();
	}
	
	/**
	 * ��ȡ��ǰ����ʹ�õ�����Դ������
	 * @return
	 */
	public static String getName() {
		return local.get();
	}
	
	/**
	 * ��ԭ��ǰ�л�������Դ
	 */
	public static void restore() {
		local.set(DEFAULT_SOURCE);
	}
	
	/**
	 * ������֪����Դ������
	 * @param source
	 */
	public static void setName(String source) {
		local.set(source);
	}

	/**
	 * ������ݶ�̬��������Դ
	 * @param year
	 */
	public static void setSource(int year) {
		local.set("DB_" + year);
	}
}
