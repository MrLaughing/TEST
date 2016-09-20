package ren.laughing.test.problem;
/**
 * 抽象工厂类
 * @author Laugh
 *
 */
public abstract class Factory {
	//抽象方法，工厂产生类T
	public abstract <T extends Human> T createFactory(Class<T> t);
	
}
