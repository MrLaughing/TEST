package ren.laughing.test.huayu;
/**
 * 测试final方法
 * 运行成功，返回为子类方法结果。
 * 原因：final修饰的方法，可以被继承，不可被重写。
 * 这里父类方法声明为private，私有，不可被子类访问。因此子类方法和父类方法无关。
 * （假如父类方法声明为public，编译错误，因为final方法不可被重写！）
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
class TestFinalFather {
	private final void finalFunction(int n) {
		System.out.println("打印Father方法");
	}
}

public class TestFinal extends TestFinalFather {
	public final void finalFunction(int n) {
		System.out.println("打印当前类方法");
	}

	public static void main(String[] args) {
		new TestFinal().finalFunction(1);
	}
}
