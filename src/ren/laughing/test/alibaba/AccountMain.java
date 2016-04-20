package ren.laughing.test.alibaba;

public class AccountMain {
	/**
	 * 资金流转方法
	 * 
	 * @param apIn
	 *            转入账户
	 * @param apOut
	 *            转出账户
	 * @param price
	 *            转入金额
	 */
	public static void transfer(Account apIn, Account apOut, double price) {
		AccountProxy ap1 = new AccountProxy(apIn);// 转入账户
		AccountProxy ap2 = new AccountProxy(apOut);// 转出账户
		try {
			ap2.Out(price);
			ap1.In(price);//写在out方法之后，保证资金不足不可转出
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Account ap1 = new Account(20000);
		Account ap2 = new Account(40000);
		transfer(ap1, ap2, 40000);
	}
}
