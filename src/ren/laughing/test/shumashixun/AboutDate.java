package ren.laughing.test.shumashixun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于获取某月份的第一天和最后一天
 * 
 * @author Laughing_Lz
 * @time 2016年9月29日
 */
public class AboutDate {
	/**
	 * 以传入日期起，获取i个月后的第一天
	 * 
	 * @param strDate
	 * @param i
	 * @return
	 * @throws ParseException
	 */
	public String getFirstDayOfMonth(String strDate, int i) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(strDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);// 添加i个月份
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置cal为当前日期的第一天
		String firstDayOfMonth = sdf.format(cal.getTime());
		return firstDayOfMonth;
	}

	/**
	 * 以传入日期起，获取i个月后的最后一天
	 * 
	 * @param strDate
	 * @param i
	 * @return
	 * @throws ParseException
	 */
	public String getLastDayOfMonth(String strDate, int i) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(strDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i + 1);// cal月份加1
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置cal为当前月份的第一天
		cal.add(Calendar.DATE, -1);// cal日期加(-1)天
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	public static void main(String[] args) throws ParseException {
		String strDate = "2016-09-28";
		String result1 = new AboutDate().getFirstDayOfMonth(strDate, 0);
		System.out.println(result1);
		String result2 = new AboutDate().getLastDayOfMonth(strDate, -2);
		System.out.println(result2);
	}
}
