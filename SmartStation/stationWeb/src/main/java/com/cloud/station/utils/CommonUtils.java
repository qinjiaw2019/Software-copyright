package com.cloud.station.utils;

import java.math.BigDecimal;

public class CommonUtils {
	/**
	 * 是否为电话号码
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	public static boolean isTel(String tel) {
		// TODO 尚未实现
		return true;
	}

	/**
	 * 保留n位小数
	 * @param money
	 * @return
	 */
	public static float keepDecimalDigits(float money) {
		//TODO 保留n位小数
		int scale = 2;// 设置位数
		int roundingMode = 4;// 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
		BigDecimal bd = new BigDecimal((double) money);
		bd = bd.setScale(scale, roundingMode);
		money = bd.floatValue();
		return money;
	}
}
