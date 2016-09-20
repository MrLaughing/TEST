package ren.laughing.test.problem;
/**
 * 场景类
 * @author Laughing
 * @time 2015年12月20日
 */
public class Client {
	public static void main(String[] args) {
		RealFactory realFactory=new RealFactory();
		//利用工厂实现类和传入参数 创建YellowMan对象
		YellowMan yellowMan= realFactory.createFactory(YellowMan.class);
		yellowMan.say();
		yellowMan.skin();///公共方法
	}
}
