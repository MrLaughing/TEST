package ren.laughing.test.alibaba;

public class AccountMain {
	public void transfer(Account apIn,Account apOut, double price){
		AccountProxy ap1 = new AccountProxy(apIn);//转入账户 
		AccountProxy ap2 = new AccountProxy(apOut);//转出账户
	}
	public static void main(String[] args) {
		Account ap1 = new Account(20000);
		Account ap2 = new Account(40000);
		
	}
}
