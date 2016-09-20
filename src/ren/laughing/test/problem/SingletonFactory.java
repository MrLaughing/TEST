package ren.laughing.test.problem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 负责生产单例的工厂类（反射）
 * @author Laughing
 * @time 2015年12月21日
 */
public class SingletonFactory {
	private  static Singleton singleton;
	//静态块，类首次加载时执行，且只执行一次
	static{
		try {
			Class c=Class.forName(Singleton.class.getName());
			//拿到无参构造器
			Constructor constructor=c.getDeclaredConstructor(c);
			//设置无参构造器可访问
			constructor.setAccessible(true);
			//用构造器产生实例对象
			singleton=(Singleton) constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//返回在static静态块中已经创建的实例对象
	public static Singleton getSingleton(){
		return singleton;
	}
}
