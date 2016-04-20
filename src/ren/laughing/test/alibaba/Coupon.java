package ren.laughing.test.alibaba;
/**
 * 优惠券
 * @author Laughing_Lz
 * @time 2016年4月20日
 */
public class Coupon {
	private String name;//优惠券名称
	private int price;//优惠金额
	private int limit;//限制使用金额条件
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Coupon() {
		super();
	}
	public Coupon(String name, int price, int limit) {
		super();
		this.name = name;
		this.price = price;
		this.limit = limit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
