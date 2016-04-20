package ren.laughing.test.alibaba;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	/**
	 * 推荐方法
	 * @param consume 消费金额
	 * @param coupons 用户拥有的优惠券
	 * @param postage 邮费
	 * @return
	 */
	public static String recommend(int consume, Map<String, Coupon> coupons,int postage) {
		if (consume < 100) {
			return "消费金额低于100元，无优惠券可用,应付款为" + (consume + postage);
		} else {
			Iterator<String> it = coupons.keySet().iterator();
			int discount = consume;// 使用优惠券后价格
			String name = null;// 使用的优惠券
			while (it.hasNext()) {
				Coupon coupon = coupons.get(it.next());
				if (consume > coupon.getLimit()) {// 判断能否使用该优惠券
					if (discount >= (consume + postage - coupon.getPrice())) {// 选择最优优惠券
						discount = consume + postage - coupon.getPrice();
						name = coupon.getName();
					}
				}
			}
			return "使用的优惠券是" + name + ",优惠后价格为" + discount;
		}
	}

	public static void main(String[] args) {
		Coupon coupon1 = new Coupon("满100包邮", 15, 100);
		Coupon coupon2 = new Coupon("满100减10", 10, 100);
		Coupon coupon3 = new Coupon("满300减20", 20, 300);
		Map<String, Coupon> coupons = new HashMap<String, Coupon>();
		coupons.put("满100包邮", coupon1);
		coupons.put("满100减10", coupon2);
		coupons.put("满300减20", coupon3);
		System.out.println(recommend(150, coupons,15));//此处假定邮费为15元
	}
}
