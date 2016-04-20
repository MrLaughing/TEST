package ren.laughing.test.alibaba;
/**
 * 转账
 * @author Laughing_Lz
 * @time 2016年4月20日
 */
public class Account {
	private double chargeBalance;//账户剩余金额
	
	public Account() {
		super();
	}
	public Account(double chargeBalance) {
		super();
		this.chargeBalance = chargeBalance;
	}
	/**
	 * 转入金额
	 * @param price
	 */
	public void transferIn(double price){
		this.chargeBalance = chargeBalance + price;
	}
	/**
	 * 转出金额
	 * @param price
	 * @throws Exception
	 */
	public void transferOut(double price) throws Exception{
		if(chargeBalance - price < 0){
			throw new Exception("剩余金额不足，不能转出！");
		}else{
			this.chargeBalance = chargeBalance - price;
		}
	}
}
