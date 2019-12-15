package test.designpattern.proxy;

/**
 * 接下来使用静态代理，主要完成的功能是：依据年份创建时间自动按照年份进行分库，依据开闭原则
 * 我们修改原来写好的代码逻辑，通过代理对象来完成。先创建数据源路由对象，
 * 使用ThreadLocal的单例实现 DynamicDataSourcEntry
 * @author yang
 *
 */
public class DynamicDataSourcEntry {
	
	public final static String DEFAULT_SOURCE = null;
	
	public final static ThreadLocal<String> local = new ThreadLocal<String>();
	
	private DynamicDataSourcEntry() {
		
	}
	
	/**
	 * 清空数据源
	 */
	public static void clear() {
		local.remove();
	}
	
	/**
	 * 获取当前正在使用的数据源的名称
	 * @return
	 */
	public static String getName() {
		return local.get();
	}
	
	/**
	 * 还原当前切换的数据源
	 */
	public static void restore() {
		local.set(DEFAULT_SOURCE);
	}
	
	/**
	 * 设置已知数据源的名称
	 * @param source
	 */
	public static void setName(String source) {
		local.set(source);
	}

	/**
	 * 依据年份动态设置数据源
	 * @param year
	 */
	public static void setSource(int year) {
		local.set("DB_" + year);
	}
}
