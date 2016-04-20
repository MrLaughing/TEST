package ren.laughing.test.alibaba;
/**
 * 账户代理
 * @author Laughing_Lz
 * @time 2016年4月20日
 */
public class AccountProxy {
	private Account account;
	
	public AccountProxy() {
		super();
	}
	public AccountProxy(Account account) {
		super();
		this.account = account;
	}
	public void In(double price){
		account.transferIn(price);
	}
	public void Out(double price) throws Exception{
		account.transferOut(price);
	}
}
