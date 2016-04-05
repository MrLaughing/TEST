package com.laughing.test;
/**
 * 工厂实现类
 * 若是简单工厂模式，则没有抽象工厂类，createFactory方法添加static关键字
 * T为Human的具体实现类
 * @author Laugh
 *
 */
public class RealFactory extends Factory {
	//重写抽象方法
	@Override
	public <T extends Human> T createFactory(Class<T> t) {
		Human human=null;
		//反射创建对象
		try {
			human=(Human) Class.forName(t.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) human;
	}

}
