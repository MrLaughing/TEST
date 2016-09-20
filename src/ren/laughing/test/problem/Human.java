package ren.laughing.test.problem;
/**
 * 抽象POJO类 abstract类 也可以写接口
 * @author Laugh
 *
 */
public abstract class Human {
	//抽象方法，一定会执行。
	public abstract void say();
	//公共方法
	public void skin(){
		System.out.println("公共方法,只要是Human都可以调用");
	}
}
